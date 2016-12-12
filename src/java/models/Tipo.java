/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import com.google.gson.*;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author IlmerMOliveira
 */

public class Tipo {
 @Expose   private int id;
 @Expose   private String name;
 @Expose   public ArrayList<String> pokemons;

 
 public Tipo(){
 
 id = 0;
 name = null;
 pokemons = new ArrayList<>();
 
 }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<String> pokemons) {
        this.pokemons = pokemons;
    }
    
    
    
    @Override
    public String toString(){
     //   return "\nID: "+ id + "\nName: "+ name + "\nHeight: "+"\nWeight: "+"\nTypes: " + types + "\nAbilities: "+abilities;
        return "\nID: "+ id + "\nName: "+ name + "\nPokemons: "+pokemons.toString()+"\n";
    }
    
    
    
}
