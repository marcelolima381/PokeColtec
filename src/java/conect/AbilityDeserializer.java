/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import models.*;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.AbstractDocument.Content;

/**
 *
 * @author IlmerMOliveira
 */
public class AbilityDeserializer implements JsonDeserializer<Ability>{

    @Override
    public Ability deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
      //   System.out.println("Entrei no deserialize");
      //  System.out.println(je);
        final JsonObject jsonObject = je.getAsJsonObject();

        final JsonElement jsonName = jsonObject.get("name");
        final String name = jsonName.getAsString();

        final int id = jsonObject.get("id").getAsInt();
        

        final JsonArray jsonPokemonsArray = jsonObject.get("pokemon").getAsJsonArray();
     //   System.out.println("VETOR DOS POKEMONS: "+jsonPokemonsArray);
        
        final String[] pokes = new String[jsonPokemonsArray.size()];
        
         ArrayList<String> n = new ArrayList<>();//ArrayList que vai pra estrutura
       
        for (int i = 0; i < pokes.length; i++) {
          // System.out.println(jsonPokemonsArray.get(i));
           
           Gson gson = new GsonBuilder().create();
           AbilAbs a = gson.fromJson(jsonPokemonsArray.get(i), AbilAbs.class);
          // System.out.println(t.toString());

           n.add(a.pokemon.getName());
            
           
        }


        final Ability abil = new Ability();
        abil.setId(id);
        abil.setName(name);
             
        abil.setPokemons(n);
       
        
        
        return abil;
    }
    
}
