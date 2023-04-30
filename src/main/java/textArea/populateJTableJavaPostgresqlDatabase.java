package textArea;

import test.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Authentic
*/
public class populateJTableJavaPostgresqlDatabase extends javax.swing.JFrame {
   PreparedStatement pst = null;
   ResultSet rst = null;
   Connection connDbc = null;
   databaseConnection dbc = new databaseConnection();
   public populateJTableJavaPostgresqlDatabase() {
       initComponents();
       connDbc = dbc.databaseConn();
       populateJtable();
   }

  public void populateJtable() {

       try {
           String sqlSelectDataFromDatabase = "select * from customers limit 10";
           pst = connDbc.prepareStatement(sqlSelectDataFromDatabase);
           rst = pst.executeQuery();

           while(rst.next()) {
               String copanyname = rst.getString("CompanyName");
               String ContactName = rst.getString("ContactName");
               String ContactTitle = rst.getString("ContactTitle");
               String Address = rst.getString("Address");

               DefaultTableModel dftable = (DefaultTableModel) jTablePopulateData.getModel();
               Object[] obj = {copanyname,ContactName,ContactTitle,Address};
               dftable.addRow(obj);
                   }

       } catch (SQLException ex) {
           Logger.getLogger(populateJTableJavaPostgresqlDatabase.class.getName()).log(Level.SEVERE, null, ex);
       }

  }
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       jScrollPane1 = new javax.swing.JScrollPane();
       jTablePopulateData = new javax.swing.JTable();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jTablePopulateData.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Title 1", "Title 2", "Title 3", "Title 4"
           }
       ));
       jScrollPane1.setViewportView(jTablePopulateData);

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(19, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(0, 25, Short.MAX_VALUE))
       );

       pack();
   }// </editor-fold>                        

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(populateJTableJavaPostgresqlDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(populateJTableJavaPostgresqlDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(populateJTableJavaPostgresqlDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(populateJTableJavaPostgresqlDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new populateJTableJavaPostgresqlDatabase().setVisible(true);
           }
       });
   }

   // Variables declaration - do not modify                     
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTablePopulateData;
   // End of variables declaration                   
}