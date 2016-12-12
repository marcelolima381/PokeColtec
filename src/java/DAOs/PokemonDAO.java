/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import com.google.gson.JsonArray;
import conect.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Pokemon;

/**
 *
 * @author strudel
 */
public class PokemonDAO implements DefaultDAO{

    public JsonArray jsonA;
    private Connection con;
    
    
    public PokemonDAO() throws SQLException{
        this.con = new ConnectionFactory().getConnection(); 
    }
    
    @Override
    public void insert(Object ob) throws SQLException, IllegalArgumentException {
       try  {
            this.verificarTipo(ob);
            Pokemon pokemon = (Pokemon)ob;
            
            String insert = "INSERT INTO pokemon (id,name,height,weight,hp,attack,defense) VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setInt(1,pokemon.getId());
            stmt.setString(2, pokemon.getName());
            stmt.setInt(3, pokemon.getHeight());
            stmt.setInt(4, pokemon.getWeight());
            stmt.setInt(5, pokemon.getHp());
            stmt.setInt(6, pokemon.getAttack());
            stmt.setInt(7, pokemon.getDefense());
            
            
            stmt.execute();
            stmt.close();
        
       } catch (SQLException e) {
        throw new RuntimeException(e);

        }
       
    }

    @Override
    public void delete(Object ob) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        
        this.verificarTipo(ob);
        Pokemon pokemon = (Pokemon)ob;
        
        String delete = "DELETE FROM pokemon WHERE id = ?";

        PreparedStatement stmt = connection.prepareStatement(delete);
        
        stmt.setInt(1, pokemon.getId());
        
        stmt.execute();
        stmt.close();
        connection.close();
    }

    @Override
    public void deleteAll() throws SQLException {
     Connection connection = ConnectionFactory.getConnection();
        
        String delete = "DELETE FROM pokemon";
        
        PreparedStatement stmt = connection.prepareStatement(delete);
        
        stmt.execute();
        stmt.close();
        connection.close();   
    }

    @Override
    public void update(Object ob) throws SQLException {
             
        
    }

    @Override
    public Object getById(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        
        String select = "SELECT * FROM pokemon WHERE id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(select);        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        rs.next();        
        Pokemon pokemon = new Pokemon();
        pokemon.setId(rs.getInt("id"));
        pokemon.setName(rs.getString("name"));
        pokemon.setWeight(rs.getInt("weight"));
        pokemon.setHeight(rs.getInt("height"));
        pokemon.setHp(rs.getInt("hp"));
        pokemon.setAttack(rs.getInt("attack"));
        pokemon.setDefense(rs.getInt("defense"));
        
                
        stmt.close();
        connection.close();

        return pokemon;
    }

    @Override
    public List getByName(String name) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
            
        String select = "SELECT * FROM pokemon WHERE name LIKE ?";
        
        PreparedStatement stmt = connection.prepareStatement(select);
        stmt.setString(1, "%" + name + "%");
        
        System.out.println(stmt);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Pokemon> pokemons = new ArrayList<Pokemon>();
        
        while(rs.next()){
            Pokemon pokemon = new Pokemon();

            pokemon.setId(rs.getInt("id"));
            pokemon.setName(rs.getString("name"));
            pokemon.setWeight(rs.getInt("weight"));
            pokemon.setHeight(rs.getInt("height"));
            pokemon.setHp(rs.getInt("hp"));
            pokemon.setAttack(rs.getInt("attack"));
            pokemon.setDefense(rs.getInt("defense"));
            
            
            pokemons.add(pokemon);
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return pokemons;
    }

    @Override
    public List getAll() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        
        String select = "SELECT * FROM pokemon";
        
        PreparedStatement stmt = connection.prepareStatement(select);        
        ResultSet rs = stmt.executeQuery();
        
        List<Pokemon> pokemons = new ArrayList<Pokemon>();
        
        
        while(rs.next()){
            Pokemon pokemon = new Pokemon();
            
            pokemon.setId(rs.getInt("id"));
            pokemon.setName(rs.getString("name"));
            pokemon.setWeight(rs.getInt("weight"));
            pokemon.setHeight(rs.getInt("height"));
            pokemon.setHp(rs.getInt("hp"));
            pokemon.setAttack(rs.getInt("attack"));
            pokemon.setDefense(rs.getInt("defense"));
            
            pokemons.add(pokemon);
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return pokemons;
    }

   
    
    @Override
    public void verificarTipo(Object ob) throws IllegalArgumentException {
         if(!(ob instanceof Pokemon)){
           throw  new IllegalArgumentException();
        }
    }
    
}
