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
public class TipoAbs {
   public int slot;
   public PokeAbs pokemon;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

/*    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    */
    
    @Override
    public String toString(){
        return "\nName: "+pokemon.getName() + "\nURL: "+pokemon.getUrl() + "\n";
    }
    
}
