/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect;
import com.google.gson.*;

import com.google.gson.*;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import models.*;
//import org.json.JSONArray;
//import org.json.JSONObject;

/**
 *
 * @author IlmerMOliveira
 */
public class pegaJson {
    
    public static String getData(String input) throws Exception {

        // FOR DEBUGGING System.out.printf("\nopening connection to URL");
        URL url = new URL(input);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setRequestProperty("User-Agent", "java-test");
        connection.setRequestProperty("Accept", "application/json");

        //get data from connection
        //FOR DEBUGGING: System.out.printf("\nreading connection");
        DataInputStream in = new DataInputStream(connection.getInputStream());

        BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
        String line;
        StringBuffer result = new StringBuffer();

        while ((line = buffer.readLine()) != null) {
            result.append(line);
            result.append('\r');
        }

        return result.toString();

    }
    
    
  public static Pokemon loadPokemonFromJSONGson(String jsonString) {
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    Pokemon pk = gson.fromJson(jsonString, Pokemon.class);
    return pk;
  }
 
   public static Tipo loadTypeFromJSONGson(String jsonString) {
    
    Gson gson1 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    Tipo t = gson1.fromJson(jsonString, Tipo.class);
             
    return t;
  }
   
  public static Ability loadAbilityFromJSONGson(String jsonString) {
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();


    Ability a = gson.fromJson(jsonString, Ability.class);
    return a;
  }
   
   public static TipoAbs loadTipoAbsFromJSONGson(String jsonString) {
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    TipoAbs t = gson.fromJson(jsonString, TipoAbs.class);
    return t;
  } 
   
   
  
  
}
