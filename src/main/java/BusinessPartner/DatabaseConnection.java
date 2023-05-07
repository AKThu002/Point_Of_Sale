package BusinessPartner;

import Branch.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DatabaseConnection {
   Connection Conn = null;
   String url = "jdbc:postgresql://localhost/POS";
   String user = "postgres";
   String password = "postgre";
   public Connection databaseConn() {

       try {
           Conn = DriverManager.getConnection(url, user, password);

       } catch (SQLException ex) {
           Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
        return Conn;
   }

//   public static void main(String[] args) {
//   DatabaseConnection connDatabase = new DatabaseConnection();
//   connDatabase.databaseConn();
//   }
   
}