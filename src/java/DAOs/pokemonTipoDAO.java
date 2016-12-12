/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import conect.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.PokeTipo;
import models.Pokemon;
import models.Tipo;

/**
 *
 * @author strudel
 */
public class pokemonTipoDAO implements DefaultDAO{
  
    @Override
    public void insert(Object ob) throws SQLException, IllegalArgumentException {
      Connection connection = ConnectionFactory.getConnection();
             
        this.verificarTipo(ob);            
        PokeTipo pokemon = (PokeTipo)ob;
           
       
        
        String insert = "INSERT INTO pokemonTipo (tipo_id, pokemon_id) VALUES(?,?)";        
        PreparedStatement stmt = connection.prepareStatement(insert);
                               
      //  for(int i = 0 ; i < tipoString.size(); i++){
           // tipos = dao.getByName(tipoString.get(i));
         //   tipo = tipos.get(0);
            stmt.setInt(1, pokemon.getTipoID());
            stmt.setInt(2, pokemon.getPokemonID());
//            stmt.setInt(3, i);
            stmt.execute();    
      //  }
        stmt.close();
        connection.close();
    }

    @Override
    public void delete(Object ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        
        String select = "SELECT * FROM pokemonTipo";
        
        PreparedStatement stmt = connection.prepareStatement(select);        
        ResultSet rs = stmt.executeQuery();
        
        List<PokeTipo> pokemons = new ArrayList<PokeTipo>();
        
        
        while(rs.next()){
            PokeTipo pokemon = new PokeTipo();
            
            pokemon.setPokemonID(rs.getInt("pokemon_id"));
            pokemon.setTipoID(rs.getInt("tipo_id"));
            
            pokemons.add(pokemon);
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return pokemons;
    }

    @Override
    public void verificarTipo(Object ob) throws IllegalArgumentException {
        if(!(ob instanceof PokeTipo)){
           throw  new IllegalArgumentException();
        }
    }
}
