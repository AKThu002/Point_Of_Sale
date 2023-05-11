package orderDetail;

import CompanyData.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class databaseConnection {
   Connection Conn = null;
   String url = "jdbc:postgresql://localhost/POS_DB";
   String user = "postgres";
   String password = "postgre";
   public Connection databaseConn() {

       try {
           Conn = DriverManager.getConnection(url, user, password);

           JOptionPane.showMessageDialog(null, "Connected");

       } catch (SQLException ex) {
           Logger.getLogger(databaseConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
        return Conn;
   }

   public static void main(String[] args) {
   databaseConnection connDatabase = new databaseConnection();
   connDatabase.databaseConn();
   }
   
}