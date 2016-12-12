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
import models.PokeGolpe;
import models.PokeTipo;
import models.Pokemon;
import models.Tipo;

/**
 *
 * @author strudel
 */
public class pokemonGolpeDAO implements DefaultDAO {

    @Override /////hmmmm vc é golpe
    public void insert(Object ob) throws SQLException, IllegalArgumentException {
        Connection connection = ConnectionFactory.getConnection();
             
        this.verificarTipo(ob);            
        PokeGolpe pokemon = (PokeGolpe)ob;
                
        String insert = "INSERT INTO pokemonGolpe (pokemon,golpe_id) VALUES(?,?)";        
        PreparedStatement stmt = connection.prepareStatement(insert);
                               
       // for(int i = 0 ; i < golpeString.size(); i++){
         //   tipos = dao.getByName(golpeString.get(i));
         //   tipo = tipos.get(0);
            stmt.setInt(1, pokemon.getPokemon());
            stmt.setInt(2, pokemon.getGolpe_id());
          //  stmt.setInt(3, i);
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
        
        String select = "SELECT * FROM pokemonGolpe";
        
        PreparedStatement stmt = connection.prepareStatement(select);        
        ResultSet rs = stmt.executeQuery();
        
        List<PokeGolpe> pokemons = new ArrayList<PokeGolpe>();
        
        
        while(rs.next()){
            PokeGolpe pokemon = new PokeGolpe();
            
            pokemon.setPokemon(rs.getInt("pokemon"));
            pokemon.setGolpe_id(rs.getInt("golpe_id"));
            
            pokemons.add(pokemon);
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return pokemons;
    }

    @Override
    public void verificarTipo(Object ob) throws IllegalArgumentException {
        if(!(ob instanceof PokeGolpe)){
           throw  new IllegalArgumentException();
        }
    }
    
}
