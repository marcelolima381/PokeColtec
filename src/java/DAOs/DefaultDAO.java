/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author strudel
 */
public interface DefaultDAO {
     public void insert(Object ob) throws SQLException,IllegalArgumentException;
    
    public void delete(Object ob) throws SQLException;
    
    public void deleteAll() throws SQLException;
    
    public void update(Object ob) throws SQLException;
    
    public Object getById(int id) throws SQLException;
    
    public List getByName(String name) throws SQLException;
    
    public List getAll() throws SQLException;
    
    public abstract void verificarTipo(Object ob) throws IllegalArgumentException;
}
