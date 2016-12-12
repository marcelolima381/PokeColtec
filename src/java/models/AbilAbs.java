/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author IlmerMOliveira
 */
public class AbilAbs {
   public int slot;
   public Boolean is_hidden;
   public PokeAbs pokemon;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

     @Override
    public String toString(){
        return "\nName: "+pokemon.getName() + "\nURL: "+pokemon.getUrl() + "\n";
    }

}
