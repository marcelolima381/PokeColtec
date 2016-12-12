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
public class Ability {
 @Expose  private int id;
 @Expose  private String name;
 @Expose  private String effect_entries;
 @Expose  public ArrayList<String> pokemons;

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

    public String getEffect_entries() {
        return effect_entries;
    }

    public void setEffect_entries(String effect_entries) {
        this.effect_entries = effect_entries;
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
        return "\nID: "+ id + "\nName: "+ name + "\nPokemons: "+pokemons+"\n"+ "\n";
    }

}
