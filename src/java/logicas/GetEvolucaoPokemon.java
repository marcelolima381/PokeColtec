/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicas;

import DAOs.AbilityDAO;
import DAOs.PokemonDAO;
import DAOs.TipoDAO;
import DAOs.evolutionPokemonDAO;
import DAOs.pokemonGolpeDAO;
import DAOs.pokemonTipoDAO;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Ability;
import models.PokeEvol;
import models.PokeGolpe;
import models.PokeTipo;
import models.Pokemon;
import models.Tipo;

/**
 *
 * @author IlmerMOliveira
 */
public class GetEvolucaoPokemon implements Logica{

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        System.out.println("A ORDEM FOI DADA");
        
        PokemonDAO pokeDao = new PokemonDAO();
        evolutionPokemonDAO evolve= new evolutionPokemonDAO();
        PokeEvol evolucc = new PokeEvol();
       ///Até aqui OK
        
       String pedido = req.getParameter("id");
       System.out.println("Pedi a evolucao do pokemon de numero: "+ pedido);
       int idPedido = Integer.parseInt(pedido);
       
      evolucc =  evolve.getEvolucao((Pokemon) pokeDao.getById(idPedido));
        
        System.out.println("Vamos pegar a EVOLUÇÃO");
        
                                
       
       
    
      
  
      ///coloca os tipos no pokemon
   
         
            
        Gson gson3 = new Gson();
        String json = gson3.toJson(evolucc);////<- O que o postman tá vendo
              
        
        System.out.println(json);  
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(json);
    }
    
}
