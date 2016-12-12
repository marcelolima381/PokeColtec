/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
/**
 *
 * @author strudel
 */
public class ConnectionFactory {
  

    private static final String user = "daw-aluno7";
    private static final String password = "ilmer";
    private static final String dataBase = "daw-aluno7";
    private static final String address = "150.164.102.160/";
//    private static final String user = "daw-aluno10";
//    private static final String password = "daw-aluno10";
//    private static final String dataBase = "daw-aluno10";
//    private static final String address = "150.164.102.160/";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://150.164.102.160/daw-aluno7", "daw-aluno7", "ilmer");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
