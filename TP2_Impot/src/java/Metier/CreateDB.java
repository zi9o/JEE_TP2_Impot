/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author zakaria
 */
public class CreateDB
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    // load the sqlite-JDBC driver using the current class loader
    Class.forName("org.sqlite.JDBC");

    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:dbimpot.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      statement.executeUpdate("drop table if exists impot;");
      
      statement.executeUpdate("create table impot(id INTEGER PRIMARY KEY AUTOINCREMENT,champ1 REAL , champ2 REAL , champ3 REAL)");
      //System.out.println("fine");
      statement.executeUpdate("insert into impot(champ1,champ2,champ3) values(12620.0,0,0)");
      statement.executeUpdate("insert into impot(champ1,champ2,champ3) values(13190.0,0.05,631)");
      statement.executeUpdate("insert into impot(champ1,champ2,champ3) values(15640.0,0.1,1290.5)");
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
  }
}