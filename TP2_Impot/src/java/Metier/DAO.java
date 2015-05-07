/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author zakaria
 */
public class DAO 
{
    private Connection cnx=null;
    private String pilote="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/dbimpot";
    private String login="root";
    private String passwd="";
    private String message;
    public DAO()
    {
        try
        {
            Class.forName(pilote);
            // Pilote OK
            this.cnx= DriverManager.getConnection(url, login, passwd);
            message="Connexion établie";
            //Connexion reussite
        }
        catch(SQLException|ClassNotFoundException e)
        {
            System.out.println(e);
            message=e.getMessage();
        }
        
    }

    public Connection getCnx() 
    {
        return cnx;
    }

    public String getMessage() {
        return message;
    }
}
