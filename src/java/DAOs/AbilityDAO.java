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
import models.Ability;

/**
 *
 * @author strudel
 */
public class AbilityDAO implements DefaultDAO{

    @Override
    public void insert(Object ob) throws SQLException, IllegalArgumentException {
        Connection connection = ConnectionFactory.getConnection();
             
        this.verificarTipo(ob);            
        Ability abil = (Ability)ob;

        String insert = "INSERT INTO ability (id,name) VALUES(?,?)";
        
        PreparedStatement stmt = connection.prepareStatement(insert);
        stmt.setInt(1,abil.getId());        
        stmt.setString(2, abil.getName());
        
        stmt.execute();
        stmt.close();
        connection.close();
    }

    @Override
    public void delete(Object ob) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        
        this.verificarTipo(ob);
        Ability abil = (Ability)ob;
        
        String delete = "DELETE FROM ability WHERE id = ?";

        PreparedStatement stmt = connection.prepareStatement(delete);
        
        stmt.setInt(1, abil.getId());
        
        stmt.execute();
        stmt.close();
        connection.close();
    }

    @Override
    public void deleteAll() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        
        String delete = "DELETE FROM ability";
        
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
        
        String select = "SELECT * FROM ability WHERE id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(select);        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        rs.next();        
        Ability abil = new Ability();
        abil.setId(rs.getInt("id"));
        abil.setName(rs.getString("name"));        
        
                
        stmt.close();
        connection.close();

        return abil;
    }

    @Override
    public List getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll() throws SQLException {
       Connection connection = ConnectionFactory.getConnection();
        
        String select = "SELECT * FROM ability";
        
        PreparedStatement stmt = connection.prepareStatement(select);        
        ResultSet rs = stmt.executeQuery();
        
        List<Ability> Golpes = new ArrayList<Ability>();
        
        
        while(rs.next()){
            Ability abil = new Ability();
            
            abil.setId(rs.getInt("id"));
            abil.setName(rs.getString("name"));
            
            Golpes.add(abil);
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return Golpes;
    }

    @Override
    public void verificarTipo(Object ob) throws IllegalArgumentException {
        if(!(ob instanceof Ability)){
           throw  new IllegalArgumentException();
        }
    }
    
}
