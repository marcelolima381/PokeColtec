/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedexfinal;


import DAOs.AbilityDAO;
import DAOs.PokemonDAO;
import DAOs.TipoDAO;
import DAOs.jsonReservDAO;
import DAOs.pokemonGolpeDAO;
import DAOs.pokemonTipoDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import models.*;
import conect.*;
import java.lang.String;
import static conect.pegaJson.loadAbilityFromJSONGson;
import static conect.pegaJson.loadPokemonFromJSONGson;
import static conect.pegaJson.loadTypeFromJSONGson;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author IlmerMOliveira
 */
public class PokedexFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       PokemonDAO pokeDao = new PokemonDAO();
       AbilityDAO abilDAO = new AbilityDAO();
       
       pokemonGolpeDAO pkGolpe = new pokemonGolpeDAO();
       
       List<Ability> abilities = new ArrayList<>();
       List<Pokemon> pokemons = new ArrayList<>();
       
       pokemons = pokeDao.getAll();
       System.out.println(pokemons);
    GsonBuilder gsonBuilder2 = new GsonBuilder();
    gsonBuilder2.registerTypeAdapter(Ability.class, new AbilityDeserializer());
    Gson gson2 = gsonBuilder2.create();  
        
    //System.out.println("HABILIDADES\n\n");
      for(int i=1;i<=191;i++){ //Existem 191 habilidades catalogadas
        // Ability a = new Ability();
         String jsao;
         String jsao2;
         jsao = "http://www.pokeapi.co/api/v2/ability/"+i+"/";
        
         jsao2 = pegaJson.getData(jsao);
        
        Ability abil = gson2.fromJson(jsao2, Ability.class);
        abilities.add(abil);
        abilDAO.insert(abil);
       // System.out.println(abil.toString());
        System.out.println(( (i*100)/191) + "% concluídos");
     }

     System.out.println("Habilidades Concluídas!");
       System.out.println(abilities);
     
    for(int j=0;j<pokemons.size();j++){ 
     Pokemon provisorio = pokemons.get(j);
    // System.out.println(provisorio.getName());
        for(int i=0;i<191;i++){
        Ability provisoria = abilities.get(i);
       
        
        for(int k=0;k<provisoria.pokemons.size();k++){
          //  System.out.println(provisoria.pokemons.get(k) + " -----> " + provisorio.getName());
            if(provisoria.pokemons.get(k).equals(provisorio.getName())){
                //System.out.println(provisoria.pokemons.get(k) + " -----> " + provisorio.getName());
                
                PokeGolpe pkG = new PokeGolpe();
                pkG.setGolpe_id(provisoria.getId());
                pkG.setPokemon(provisorio.getId());
                
                pkGolpe.insert(pkG);
            
            }
              
        }
      }
        System.out.println(( (j*100)/150) + "% do pokemons concluídos");
    }    
     
    }
     
 }
    
    
    
    

