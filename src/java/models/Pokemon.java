/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import models.*;
import conect.*;
import static conect.pegaJson.*;
import com.google.gson.*;
import com.google.gson.annotations.Expose;

/**
 *
 * @author IlmerMOliveira
 */
public class Pokemon {
    
    
    @Expose private int id;
    @Expose private String name;
    @Expose private int height;
    @Expose private int weight;
    private int hp;
    private int attack;
    private int defense;
    private int evolution;
    private String imgURL;
    public ArrayList<String> types;
    public ArrayList<String> abilities;

    
   /* public Pokemon(){
    
    types = new ArrayList<>();
    
    }*/
    
    
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<String> getTypes() {
        return types;
   }

  public void setTypes(ArrayList<String> types) {
      this.types = types;
   }

    public ArrayList<String> getAbilities() {
       return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getEvolution() {
        return evolution;
    }

    public void setEvolution(int evolution) {
        this.evolution = evolution;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    
    
    
    @Override
    public String toString(){
     //   return "\nID: "+ id + "\nName: "+ name + "\nHeight: "+"\nWeight: "+"\nTypes: " + types + "\nAbilities: "+abilities;
        return "\nID: "+ id + "\nName: "+ name + "\nHeight: "+height +"\nWeight: "+weight+ "\nAttack: "+ attack +"\nDefense: " + defense + "\n"+"Types: "+types + "\nHabilidades: "+abilities;
    }
    
    
}
