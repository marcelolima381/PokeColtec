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
import models.Tipo;

/**
 *
 * @author strudel
 */
public class TipoDAO implements DefaultDAO{

    @Override
    public void insert(Object ob) throws SQLException, IllegalArgumentException {
        Connection connection = ConnectionFactory.getConnection();
             
        this.verificarTipo(ob);            
        Tipo tipo = (Tipo)ob;

        String insert = "INSERT INTO tipo (id,name) VALUES(?,?)";
        
        PreparedStatement stmt = connection.prepareStatement(insert);
        stmt.setInt(1,tipo.getId());        
        stmt.setString(2, tipo.getName());
        
        stmt.execute();
        stmt.close();
        connection.close();
    }

    @Override
    public void delete(Object ob) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        
        this.verificarTipo(ob);
        Tipo tipo = (Tipo)ob;
        
        String delete = "DELETE FROM tipo WHERE id = ?";

        PreparedStatement stmt = connection.prepareStatement(delete);
        
        stmt.setInt(1, tipo.getId());
        
        stmt.execute();
        stmt.close();
        connection.close();
    }

    @Override
    public void deleteAll() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        
        String delete = "DELETE FROM tipo";
        
        PreparedStatement stmt = connection.prepareStatement(delete);
        
        stmt.execute();
        stmt.close();
        connection.close();
    }

    @Override
    public void update(Object ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getById(int id) throws SQLException {
         Connection connection = ConnectionFactory.getConnection();
        
        String select = "SELECT * FROM tipo WHERE id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(select);        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        rs.next();        
        Tipo tipo = new Tipo();
        tipo.setId(rs.getInt("id"));
        tipo.setName(rs.getString("name"));        
        
                
        stmt.close();
        connection.close();

        return tipo;
    }

    @Override
    public List getByName(String name) throws SQLException {
         Connection connection = ConnectionFactory.getConnection();
            
        String select = "SELECT * FROM tipo WHERE name LIKE ?";
        
        PreparedStatement stmt = connection.prepareStatement(select);
        stmt.setString(1,  name );
        
        System.out.println(stmt);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Tipo> tipos = new ArrayList<Tipo>();
        
        while(rs.next()){
            Tipo tipo = new Tipo();
            
            tipo.setId(rs.getInt("id"));
            tipo.setName(rs.getString("name"));          
            
            
            tipos.add(tipo);
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return tipos;
    }

    @Override
    public List getAll() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        
        String select = "SELECT * FROM tipo";
        
        PreparedStatement stmt = connection.prepareStatement(select);        
        ResultSet rs = stmt.executeQuery();
        
        List<Tipo> tipos = new ArrayList<Tipo>();
        
        
        while(rs.next()){
            Tipo tipo = new Tipo();
            
            tipo.setId(rs.getInt("id"));
            tipo.setName(rs.getString("name"));          
            
            tipos.add(tipo);
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return tipos;
    }

    @Override
    public void verificarTipo(Object ob) throws IllegalArgumentException {
        if(!(ob instanceof Tipo)){
           throw  new IllegalArgumentException();
        }
    }
    
}
