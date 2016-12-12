/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicas;

import DAOs.PokemonDAO;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Pokemon;

/**
 *
 * @author IlmerMOliveira
 */
public class AlteraPokemon implements Logica{

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
     System.out.println("VOU TENTAR ALTERAR O POKEMON!!!!");
           
      Pokemon pokemon = new Pokemon();
      pokemon.abilities = new ArrayList<>();
      pokemon.types = new ArrayList<>();
      PokemonDAO pokeDAO = new PokemonDAO();  
      
      String id = req.getParameter("id");
      String name = req.getParameter("name");
      String hp = req.getParameter("hp");
      String attack = req.getParameter("attack");
      String defense = req.getParameter("defense");
      String weight = req.getParameter("weight");
      String height = req.getParameter("height");
      String imgURL = req.getParameter("imgURL");
      String evolution = req.getParameter("evolution");
      String[] types = req.getParameterValues("types");
      String[] abilities = req.getParameterValues("abilities");
      
      System.out.println(id + "\n" + name + "\n" + hp + "\n" + attack + "\n" + defense + "\n" + weight + "\n" + height + "\n" + imgURL + "\n" + evolution + "\n" + types + "\n" + abilities + "\n");
      
     

     //  System.out.println("Não deu erro nos caras de cima");
      
      
        
     
       pokemon.setId(Integer.parseInt(id));
       pokemon.setName(name);
       pokemon.setHp(Integer.parseInt(hp));
       pokemon.setAttack(Integer.parseInt(attack));
       pokemon.setDefense(Integer.parseInt(defense)); 
       pokemon.setHeight(Integer.parseInt(height));
       pokemon.setWeight(Integer.parseInt(weight));
       pokemon.setImgURL(imgURL);
       pokemon.setEvolution(Integer.parseInt(evolution));
       
       pokeDAO.delete(pokemon);//remove pokemon antigo
       
       System.out.println("Nuu so faltas os tipos e as habilidades");
       
       for(int i=0;i<types.length;i++){
           pokemon.types.add(types[i]);
       }
      
        for(int i=0;i<abilities.length;i++){
           pokemon.abilities.add(abilities[i]);
       }
       
       
       pokeDAO.insert(pokemon);//Coloca pokemon novo
       
        Gson gson3 = new Gson();
        String json = gson3.toJson(pokemon);////<- O que o postman tá vendo
        
        
        
        //System.out.println(json);  
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(json);

    }
    
}
