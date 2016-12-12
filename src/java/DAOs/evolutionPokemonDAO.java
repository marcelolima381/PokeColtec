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
import models.PokeEvol;
import models.Pokemon;

/**
 *
 * @author strudel
 */
public class evolutionPokemonDAO implements DefaultDAO{

     public PokeEvol getEvolucao(Pokemon pokemon) throws SQLException {
         PokemonDAO pkD = new PokemonDAO();
         
        Connection connection = ConnectionFactory.getConnection();

        String select = "SELECT * FROM evolutionPokemon WHERE pokemon_id = ?";
        
        System.out.println("VAMOS VER ATÉ ONDE OS CARAS VÃO");
        PreparedStatement stmt = connection.prepareStatement(select);
        stmt.setInt(1, pokemon.getId());

       
       ResultSet rs = stmt.executeQuery();
        
        rs.next();        
        PokeEvol evolucao = new PokeEvol();
        
        int idE = rs.getInt("evolution_pokemon_id");
        Pokemon poke = new Pokemon();
        poke = (Pokemon) pkD.getById(idE);
        
        System.out.println("Eu quero aquele cara ali: "+poke.getName());
        
        evolucao.setId(idE);
       evolucao.setName(poke.getName());
        
       if (evolucao.getId() < 10) {
                  evolucao.setImgurl("https://assets.pokemon.com/assets/cms2/img/pokedex/full/00"+evolucao.getId()+".png");
              }
              else if(pokemon.getId() >= 10 && pokemon.getId() < 100) {
                  evolucao.setImgurl("https://assets.pokemon.com/assets/cms2/img/pokedex/full/0"+evolucao.getId()+".png");
              }
              else {
                  evolucao.setImgurl("https://assets.pokemon.com/assets/cms2/img/pokedex/full/"+evolucao.getId()+".png");
              }
        
       
       System.out.println(evolucao.toString());
       
        stmt.close();
        connection.close();

        return evolucao;
    }

   /* public Pokemon getVersaoAnterior(Pokemon pokemon) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        String select = "SELECT * FROM evolutionPokemon WHERE evolution_pokemon_id = ?";

        PreparedStatement stmt = connection.prepareStatement(select);
        stmt.setInt(1, pokemon.getId());

        ResultSet rs = stmt.executeQuery();

        Pokemon aux = null;

        if (rs.next()) {
            aux = (Pokemon) new PokemonDAO().getById(rs.getInt("pokemon_id"));
        }

        rs.close();
        stmt.close();
        connection.close();

        return aux;
    }*/
    
    
    
    @Override
    public void insert(Object ob) throws SQLException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verificarTipo(Object ob) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
