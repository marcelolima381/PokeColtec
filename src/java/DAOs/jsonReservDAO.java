/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import conect.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Pokemon;
import models.Tipo;
import models.jsonReserver;

/**
 *
 * @author Maria
 */
public class jsonReservDAO {

    private Connection con;
    
    
    public jsonReservDAO() throws SQLException{
        this.con = new ConnectionFactory().getConnection(); 
    }
    
    public void insert(JsonElement ob) throws SQLException, IllegalArgumentException {
         try  {
           // this.verificarTipo(ob);
           // jsonReserver pokemon = (jsonReserver)ob;
            
            Gson gsonT = new Gson();
            String textoS = gsonT.fromJson(ob, String.class);
           
            String insert = "INSERT INTO jsonReserve (objeto) VALUES(?)";
                //vamo ver
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setString(1,textoS);
            
            
            stmt.execute();
            stmt.close();
        
       } catch (SQLException e) {
        throw new RuntimeException(e);

        }
    }

  //  @Override
    public void delete(Object ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 //   @Override
    public void deleteAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 //   @Override
    public void update(Object ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
    public Object getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 //   @Override
    public List getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 //   @Override
    public List getAll() throws SQLException {
       Connection connection = ConnectionFactory.getConnection();
        
        String select = "SELECT * FROM jsonReserve";
        
        PreparedStatement stmt = connection.prepareStatement(select);        
        ResultSet rs = stmt.executeQuery();
        
        List<jsonReserver> pokemons = new ArrayList<jsonReserver>();
        
        
        while(rs.next()){
            jsonReserver pokemon = new jsonReserver();
            
            pokemon.setObjeto(rs.getString("objeto"));
            
            
            pokemons.add(pokemon);
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return pokemons;
    }

  //  @Override
    public void verificarTipo(Object ob) throws IllegalArgumentException {
        if(!(ob instanceof String)){
           throw  new IllegalArgumentException();
        }
    }
    
}
