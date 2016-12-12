/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect;

import DAOs.AbilityDAO;
import DAOs.PokemonDAO;
import DAOs.TipoDAO;
import DAOs.pokemonTipoDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Ability;
import models.Pokemon;
import models.Tipo;

/**
 *
 * @author Maria
 */
public class popula {
    public JsonArray jsonA;
    
    public void executa() throws Exception{
       ArrayList<Pokemon> pokemons;
       ArrayList<Tipo> tipos;
       ArrayList<Ability> abilities;
       JsonArray pokemonsJson;
       ArrayList<String> pokeJsonString;
       
       PokemonDAO pokeDao = new PokemonDAO();
       TipoDAO tipodao = new TipoDAO();
       AbilityDAO abilDAO = new AbilityDAO();
       pokemonTipoDAO pkTdao = new pokemonTipoDAO();
       
       
       pokeJsonString = new ArrayList<>();
       abilities = new ArrayList<>();
       tipos = new ArrayList<>();
       pokemons = new ArrayList<>();
              
             
       
    GsonBuilder gsonBuilder2 = new GsonBuilder();
    gsonBuilder2.registerTypeAdapter(Ability.class, new AbilityDeserializer());
    Gson gson2 = gsonBuilder2.create();  
        
  
     
     

    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Tipo.class, new TypeDeserializer());
    Gson gson = gsonBuilder.create();
    
  //  System.out.println("TIPOS\n\n");
    for(int i=1;i<=18;i++){//Existem 18 tipos de pokemon
       //  Tipo t = new Tipo();
         String jsao;
         String jsao2;
         jsao = "http://www.pokeapi.co/api/v2/type/"+i+"/";
        
         jsao2 = pegaJson.getData(jsao);
       //  t = loadTypeFromJSONGson(jsao2);
         Tipo tipo = gson.fromJson(jsao2, Tipo.class);
         tipos.add(tipo);
         tipodao.insert(tipo);
    //   System.out.println(tipo.toString());
      System.out.println(( (i*100)/18) + "% concluídos");      
        }
        System.out.println("Tipos Concluídos!");
        
        
        
        
        
        pokemons = (ArrayList<Pokemon>) pokeDao.getAll();
        
        
   
////DEFININDO OS TIPOS/////
   for(int i=0;i<150;i++){
        Pokemon prov = new Pokemon();
        prov = pokemons.get(i);
        prov.types = new ArrayList<>();
        for(int j=0;j<18;j++){///For dos tipos
          
            
            String nome = pokemons.get(i).getName();
            String tip = tipos.get(j).getName();
            System.out.println("TIPO:>>>>>>>" + tip);
          //  System.out.println(nome+ " -> "+tip);
        
            for(int k=0;k<tipos.get(j).getPokemons().size();k++){
              Boolean pertence = tipos.get(j).getPokemons().get(k).equals(nome) && !pokemons.get(k).types.contains(tipos.get(j).getName());
              System.out.println("Searching...");
                if(pertence){
                    prov.types.add(tip);
                    pkTdao.insert(prov);
                    System.out.println(nome + " -> " + tipos.get(j).getName());
                }              
              
            }
        }
        pokemons.set(i, prov);
     }
    

      for(int i=0;i<pokemons.size();i++){
        Pokemon temporario = new Pokemon();        
        temporario = pokemons.get(i);
        
        if (pokemons.get(i).getId() < 10) {
                  temporario.setImgURL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"+pokemons.get(i).getId()+".png");
              }
              else if(pokemons.get(i).getId() >= 10 && pokemons.get(i).getId() < 100) {
                  temporario.setImgURL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"+pokemons.get(i).getId()+".png");
              }
              else {
                  temporario.setImgURL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/"+pokemons.get(i).getId()+".png");
              }
             
                    
          
        pokemons.set(i, temporario);
      }
   
     
  ///////TRANSFORMANDO OS POKEMONS EM JSON
    
        Gson gson3 = new Gson();
        JsonElement element = gson.toJsonTree(pokemons, new TypeToken<List<Pokemon>>() {}.getType());      
    
        if (! element.isJsonArray()) {
        // fail appropriately
            throw new Exception();
        }

        JsonArray jsonArray = element.getAsJsonArray();
    
    
    
    
    }
     public JsonArray getJsonPoke() throws SQLException {
    
    return this.jsonA;
    }
    
}
