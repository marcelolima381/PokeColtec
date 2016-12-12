/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicas;

import DAOs.AbilityDAO;
import DAOs.PokemonDAO;
import DAOs.TipoDAO;
import DAOs.pokemonGolpeDAO;
import DAOs.pokemonTipoDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conect.TypeDeserializer;
import conect.pegaJson;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Ability;
import models.PokeGolpe;
import models.PokeTipo;
import models.Pokemon;
import models.Tipo;

/**
 *
 * @author Maria
 */
public class GetPokemonById implements Logica{

    @Override //req é url de request, preciso achar o id
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        PokemonDAO pokeDao = new PokemonDAO();
        pokemonTipoDAO ptDAO = new pokemonTipoDAO();
        TipoDAO tipodao = new TipoDAO();
        pokemonGolpeDAO pgDAO = new pokemonGolpeDAO();
        AbilityDAO abilitydao = new AbilityDAO();
        
       ///Até aqui OK
        
        List<PokeTipo> PT = ptDAO.getAll();//13
        List<PokeGolpe> PG = pgDAO.getAll();
        
        System.out.println("Listas 100% topper");
        
        Pokemon pokemon = new Pokemon();
        
                         
        
       String pedido = req.getParameter("id");
       System.out.println(pedido);
       int idPedido = Integer.parseInt(pedido);
       
    
       
      pokemon = (Pokemon) pokeDao.getById(idPedido);
  
      ///coloca os tipos no pokemon
       pokemon.types = new ArrayList<>();
            
            for(int j=0;j<PT.size();j++){
                if(PT.get(j).getPokemonID()==pokemon.getId()){
                    Tipo tip = (Tipo) tipodao.getById(PT.get(j).getTipoID());
                    pokemon.types.add(tip.getName());
                }
            }
            System.out.println("Coloquei os tipos");
            
         pokemon.abilities = new ArrayList<>();
            
            for(int j=0;j<PG.size();j++){
                if(PG.get(j).getPokemon()==pokemon.getId()){
                    Ability abil = (Ability) abilitydao.getById(PG.get(j).getGolpe_id());
                    pokemon.abilities.add(abil.getName());
                }
            }
           System.out.println("Coloquei as habilidades");
            
            if (pokemon.getId() < 10) {
                  pokemon.setImgURL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"+pokemon.getId()+".png");
              }
              else if(pokemon.getId() >= 10 && pokemon.getId() < 100) {
                  pokemon.setImgURL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"+pokemon.getId()+".png");
              }
              else {
                  pokemon.setImgURL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/"+pokemon.getId()+".png");
              }
         
            
        Gson gson3 = new Gson();
        String json = gson3.toJson(pokemon);////<- O que o postman tá vendo
        
        
        
        //System.out.println(json);  
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(json);
    }
    
}
