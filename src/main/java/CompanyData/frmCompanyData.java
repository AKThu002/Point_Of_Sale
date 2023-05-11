/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CompanyData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmCompanyData extends javax.swing.JFrame {

    //connecting to database
    private final String url = "jdbc:postgresql://localhost/POS_DB";
    private final String user = "postgres";
    private final String password = "postgre";

    private String Query;

    private String getFirstCompanySQL;
    private String getLastCompanySQL;
    private String getPrevCompanySQL;
    private String getNextCompanySQL;
    
    private String Com_ID;
    private String Com_Name;
    
    ResultSet result = null;
    PreparedStatement pst;
    
    databaseConnection dbc = new databaseConnection();
    Connection connDbc = null;
    /**
     * Creates new form NewJFrame
     */
    public frmCompanyData() {
        initComponents();
        connDbc = dbc.databaseConn();
        getallData();
    }

    public void clearTable()
{
    DefaultTableModel dm = (DefaultTableModel) tbl_Comp.getModel();
    dm.getDataVector().removeAllElements();
    revalidate();
}
    private void getallData(){
    try  {

           String sqlSelectDataFromDatabase = "Select \"COM_ID\", \"COM_NAME\" from \"COM_TBL\"";
           pst = connDbc.prepareStatement(sqlSelectDataFromDatabase);
           result = pst.executeQuery();
           clearTable(); // To Clear Existing Data
           while(result.next()) {
               String Companyname = result.getString("COM_ID");
               String CompanyID = result.getString("COM_NAME");
           

               DefaultTableModel dftable = (DefaultTableModel) tbl_Comp.getModel();
               Object[] obj = {Companyname,CompanyID};
               dftable.addRow(obj);
                   }
             } catch (SQLException e) {
                 printSQLException(e);
       }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_company = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_Save = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Comp = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbl_CompID = new javax.swing.JLabel();
        lbl_CompName = new javax.swing.JLabel();
        txt_CompID = new javax.swing.JTextField();
        txt_CompName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        lbl_company.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_company.setText("Company");

        btn_Save.setText("Save");
        btn_Save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_exit.setText("Exit");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        btn_del.setText("Delete");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_del)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exit)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btn_del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_Comp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company ID", "Company Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_Comp);
        if (tbl_Comp.getColumnModel().getColumnCount() > 0) {
            tbl_Comp.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_Comp.getColumnModel().getColumn(1).setPreferredWidth(366);
        }

        lbl_CompID.setText("ID");

        lbl_CompName.setText("Name");

        txt_CompID.setEditable(false);
        txt_CompID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txt_CompName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_CompName)
                    .addComponent(lbl_CompID))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_CompID, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txt_CompName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_CompID)
                    .addComponent(txt_CompID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_CompName)
                    .addComponent(txt_CompName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_company)
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_company)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        this.clear(evt);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        try {
            ExecuteQuery("S");
            if(txt_CompName.getText().isEmpty()){
                JOptionPane.showMessageDialog(btn_Save, "Company Name can't be empty!", "Warning", 2);
            }else {
                JOptionPane.showMessageDialog(btn_Save, "Successfully Saved", "Success",1);
            }
            this.clear(evt);
        } catch (SQLException e) {
            printSQLException(e);
        }
        getallData();
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            ExecuteQuery("U");
        } catch (SQLException e) {
            printSQLException(e);
        }
        getallData();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        getFirstCompanySQL = "SELECT \"COM_ID\", \"COM_NAME\"FROM \"COM_TBL\"order by \"COM_ID\" asc limit 1;";

        try{
            GetQuery(getFirstCompanySQL);
            txt_CompID.setText(Com_ID);
            txt_CompName.setText(Com_Name);
        }catch(SQLException e){
            printSQLException(e);
        }
        
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        getLastCompanySQL = "SELECT \"COM_ID\", \"COM_NAME\"FROM \"COM_TBL\"order by \"COM_ID\" desc limit 1;";
        
        try{
            GetQuery(getLastCompanySQL);
            txt_CompID.setText(Com_ID);
            txt_CompName.setText(Com_Name);
        }catch(SQLException e){
            printSQLException(e);
        }
        
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        try{
            if (!txt_CompID.getText().isEmpty()){
                getNextCompanySQL = "SELECT \"COM_ID\", \"COM_NAME\" FROM \"COM_TBL\" where \"COM_ID\" = "
                            + (Integer.valueOf(txt_CompID.getText()) + 1)  +";";
            } else {
                getNextCompanySQL = "SELECT \"COM_ID\", \"COM_NAME\" FROM \"COM_TBL\" where \"COM_ID\" = 1;";
            }
            GetQuery(getNextCompanySQL);
            txt_CompID.setText(Com_ID);
            txt_CompName.setText(Com_Name);
        }catch(SQLException e){
            printSQLException(e);
        }
        
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        try{
            if (!txt_CompID.getText().isEmpty()){
                getPrevCompanySQL = "SELECT \"COM_ID\", \"COM_NAME\" FROM \"COM_TBL\" where \"COM_ID\" = "
                            + (Integer.valueOf(txt_CompID.getText()) - 1)  +";";
                GetQuery(getPrevCompanySQL);
            } else {
                getLastCompanySQL = "SELECT \"COM_ID\", \"COM_NAME\"FROM \"COM_TBL\"order by \"COM_ID\" desc limit 1;";
                GetQuery(getLastCompanySQL);
            }
            txt_CompID.setText(Com_ID);
            txt_CompName.setText(Com_Name);
        }catch(SQLException e){
            printSQLException(e);
        }
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        try {
            ExecuteQuery("D");
            this.clear(evt);
        } catch (SQLException e) {
            printSQLException(e);
        }
        getallData();
    }//GEN-LAST:event_btn_delActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
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
            java.util.logging.Logger.getLogger(frmCompanyData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCompanyData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCompanyData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCompanyData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCompanyData CData = new frmCompanyData();
                CData.setVisible(true);
                CData.setTitle("Company Data");                
            }
            
        });
    }

    //execute query
    public void ExecuteQuery(String query) throws SQLException {

        System.out.println(query);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            if(query == "S"){
                
                Query=" INSERT INTO \"COM_TBL\" (\"COM_ID\", \"COM_NAME\") VALUES ("
                        + txt_CompID.getText() + ", '" + txt_CompName.getText() + "');";
                
            }else if(query=="U"){
                
                Query="UPDATE \"COM_TBL\" SET \"COM_NAME\"= '"
                        + txt_CompName.getText() + "' WHERE \"COM_ID\"="+ txt_CompID.getText() + "; ";
                
            }else if(query=="D"){
                
                Query="DELETE FROM \"COM_TBL\" WHERE \"COM_ID\" = " + txt_CompID.getText() + ";";
                
            }
            statement.execute(Query);
            connection.close();
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }
    }

    //get query
    public void GetQuery(String query) throws SQLException {

        System.out.println(query);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();){
        
            // Step 3: Get the query
            result = statement.executeQuery(query);
            if (result.next()) {
                Com_ID = result.getString("COM_ID");
                Com_Name = result.getString("COM_NAME");
                System.out.println(result.getString("COM_ID"));
                System.out.println(result.getString("COM_NAME"));
            }
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }
    }

    //Exception handling
    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    private void clear(java.awt.event.ActionEvent evt) {
        btn_lastActionPerformed(evt);
        if(txt_CompID.getText().isEmpty()){
            txt_CompID.setText("1");
        } else { 
            txt_CompID.setText(String.valueOf(Integer.valueOf(txt_CompID.getText()) + 1 ));
        }
        txt_CompName.setText("");
    }
    
//    private int lastID(){
//        getLastCompanySQL = "SELECT \"COM_ID\", \"COM_NAME\"FROM \"COM_TBL\"order by \"COM_ID\" desc limit 1;";
//
//        try{
//            GetQuery(getLastCompanySQL);
//        }catch(SQLException e){
//            printSQLException(e);
//        }
//        return Integer.valueOf(Com_ID);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Save;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_update;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_CompID;
    private javax.swing.JLabel lbl_CompName;
    private javax.swing.JLabel lbl_company;
    private javax.swing.JTable tbl_Comp;
    private javax.swing.JTextField txt_CompID;
    private javax.swing.JTextField txt_CompName;
    // End of variables declaration//GEN-END:variables
}
