/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blooddonation;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Anon
 */
public class Patient extends javax.swing.JFrame {

      boolean  found = false; 
      int blood = 0;
      
    public Patient() {
        initComponents();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(this);
        setTitle("Patient");

        try {
             FetchList();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

     void FetchList ()  throws SQLException{
     
        DBCon.StartCon();
        ResultSet resultSet =  DBCon.Select("Select BloodBank_Name From bloodbank");
               
        while (resultSet.next()){
            String itemCode = resultSet.getString("BloodBank_Name");
            cbxBank.addItem(itemCode); 
        }   
        cbxBank.setSelectedIndex(0);
        resultSet.close();
        DBCon.EndCon();
    }
     
     void FetchBankAmount(String BankName,String Type ){
          String BloodType = "";
          switch (Type) {
              case "A+":
                  BloodType = "BloodBank_AP";
                  break;
              case "A-":
                  BloodType = "BloodBank_AN";
                  break;
              case "B+":
                  BloodType = "BloodBank_BP";
                  break;
              case "B-":
                  BloodType = "BloodBank_BN";
                  break;
              case "AB+":
                  BloodType = "BloodBank_ABP";
                  break;
              case "AB-":
                  BloodType = "BloodBank_ABN";
                  break;
              case "O+":
                  BloodType = "BloodBank_OP";
                  break;
              case "O-":
                  BloodType = "BloodBank_ON";
                  break;
              default:
                  BloodType = "";
                  break;
          }
         
         
         try{
        DBCon.StartCon();
        ResultSet resultSet =  DBCon.Select("SELECT "+BloodType+" AS RESULT FROM bloodbank Where BloodBank_Name = '"+BankName+"'");
        if (resultSet.next()){
           txtBAvailable.setText(resultSet.getString("RESULT"));
        }
        resultSet.close();
        DBCon.EndCon();
        }catch(SQLException ex){
          System.err.println(ex.getMessage());
        }
     }
     
    void UpdateBloodBank(String BankName,String Type,int blood ){
        String BloodType = "";
          switch (Type) {
              case "A+":
                  BloodType = "BloodBank_AP";
                  break;
              case "A-":
                  BloodType = "BloodBank_AN";
                  break;
              case "B+":
                  BloodType = "BloodBank_BP";
                  break;
              case "B-":
                  BloodType = "BloodBank_BN";
                  break;
              case "AB+":
                  BloodType = "BloodBank_ABP";
                  break;
              case "AB-":
                  BloodType = "BloodBank_ABN";
                  break;
              case "O+":
                  BloodType = "BloodBank_OP";
                  break;
              case "O-":
                  BloodType = "BloodBank_ON";
                  break;
              default:
                  BloodType = "";
                  break;
          }
          try{
            DBCon.StartCon();
            ResultSet resultSet =  DBCon.Select("SELECT "+BloodType+" AS RESULT FROM bloodbank WHERE BloodBank_Name = '"+BankName+"'");
            if(resultSet.next()){
                int BloodTotal = resultSet.getInt("RESULT") - blood;
                DBCon.Update("UPDATE bloodbank set "+BloodType+" = '"+BloodTotal+"' WHERE BloodBank_Name = '"+BankName+"'");
            }
            DBCon.EndCon();
              }catch(SQLException ex){
          System.err.println(ex.getMessage());
      }
    }
     void SelectAutoBlood(int Blood,String Type ){
          String BloodType = "";
          switch (Type) {
              case "A+":
                  BloodType = "BloodBank_AP";
                  break;
              case "A-":
                  BloodType = "BloodBank_AN";
                  break;
              case "B+":
                  BloodType = "BloodBank_BP";
                  break;
              case "B-":
                  BloodType = "BloodBank_BN";
                  break;
              case "AB+":
                  BloodType = "BloodBank_ABP";
                  break;
              case "AB-":
                  BloodType = "BloodBank_ABN";
                  break;
              case "O+":
                  BloodType = "BloodBank_OP";
                  break;
              case "O-":
                  BloodType = "BloodBank_ON";
                  break;
              default:
                  BloodType = "";
                  break;
          }
        try{
            DBCon.StartCon();
            ResultSet resultSet =  DBCon.Select("SELECT BloodBank_Name AS RESULT from bloodbank where " + BloodType + " >= " + Blood);
             boolean x = false;
            while (resultSet.next()){
               
                cbxBank.setSelectedItem(resultSet.getString("RESULT"));
                x = true;
            }
            
            if(!x){
                   txtBAvailable.setText("Not Available");
            }
            resultSet.close();
            DBCon.EndCon();
        }catch(SQLException ex){
          System.err.println(ex.getMessage());
        }   
     }
     
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        cbxBank = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPatientID = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBTake = new javax.swing.JTextPane();
        btnDone = new javax.swing.JButton();
        cbxBtype = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPName = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtPInfo = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtBAvailable = new javax.swing.JTextPane();
        btnNew = new javax.swing.JButton();

        jScrollPane5.setViewportView(jTextPane3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("BloodBank");

        cbxBank.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBankItemStateChanged(evt);
            }
        });

        jLabel1.setText("Patient ID");

        txtPatientID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPatientIDKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtPatientID);

        jLabel5.setText("Blood Type");

        txtBTake.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Blood Amount / Liter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        txtBTake.setForeground(new java.awt.Color(255, 0, 51));
        txtBTake.setText("0");
        txtBTake.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBTakeKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(txtBTake);

        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        cbxBtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        cbxBtype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBtypeItemStateChanged(evt);
            }
        });

        jLabel2.setText("Patient Name");

        jScrollPane2.setViewportView(txtPName);

        jLabel3.setText("Patient Info");

        txtPInfo.setColumns(20);
        txtPInfo.setRows(5);
        txtPInfo.setTabSize(5);
        jScrollPane3.setViewportView(txtPInfo);

        txtBAvailable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Blood Available  / Liter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        txtBAvailable.setEnabled(false);
        jScrollPane6.setViewportView(txtBAvailable);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user-blue-add.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxBtype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxBank, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxBank, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(cbxBtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addComponent(btnDone)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

    }//GEN-LAST:event_btnNewActionPerformed

    private void txtPatientIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatientIDKeyReleased
        try{
        DBCon.StartCon();
        ResultSet resultSet =  DBCon.Select("SELECT * FROM patient Where Patient_ID = '"+txtPatientID.getText()+"'");
        if (resultSet.next()){
            txtPName.setText(resultSet.getString("Patient_FullName")); 
            cbxBtype.setSelectedItem(resultSet.getString("Patient_BType").toString()); 
            txtPInfo.setText(resultSet.getString("Patient_Info")); 
            cbxBank.setSelectedItem(resultSet.getString("Patient_BloodBank")); 
            blood = resultSet.getInt("Patient_Amount");
            FetchBankAmount(cbxBank.getSelectedItem().toString(),cbxBtype.getSelectedItem().toString());
            cbxBtype.setEnabled(false);
            
            txtPatientID.setEnabled(false);
            btnDone.setEnabled(true);
            txtPName.setEnabled(true);
            txtPInfo.setEnabled(true);
            txtBTake.setEnabled(true);

          //  txtBAvailable.setText(String.format("%d", blood));
            found = true;
            
        }
        resultSet.close();
        DBCon.EndCon();
      }catch(SQLException ex){
          System.err.println(ex.getMessage());
      }
    }//GEN-LAST:event_txtPatientIDKeyReleased

    private void txtBTakeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBTakeKeyReleased
        SelectAutoBlood(Integer.parseInt(txtBTake.getText()),cbxBtype.getSelectedItem().toString());
    }//GEN-LAST:event_txtBTakeKeyReleased

    private void cbxBankItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBankItemStateChanged
        
        FetchBankAmount(cbxBank.getSelectedItem().toString(),cbxBtype.getSelectedItem().toString());

    }//GEN-LAST:event_cbxBankItemStateChanged

    private void cbxBtypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBtypeItemStateChanged
        FetchBankAmount(cbxBank.getSelectedItem().toString(),cbxBtype.getSelectedItem().toString());
    }//GEN-LAST:event_cbxBtypeItemStateChanged

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        if (found){
                DBCon.StartCon();
                DBCon.Update("UPDATE patient SET Patient_FullName='"+txtPName.getText()+"', Patient_Info='"+txtPInfo.getText()+"' , Patient_Amount='"+txtBTake.getText()+"' , Patient_BloodBank='"+cbxBank.getSelectedItem()+"' WHERE Patient_ID ='"+txtPatientID.getText()+"'");
                DBCon.EndCon();
                UpdateBloodBank(cbxBank.getSelectedItem().toString(),cbxBtype.getSelectedItem().toString(), Integer.parseInt(txtBTake.getText()) );
                JOptionPane.showMessageDialog(this, "Thank You For Your Donation","Thank You", JOptionPane.DEFAULT_OPTION);
                this.dispose();
            }else{
               // int AddBlood = blood + Integer.parseInt(txtDonate.getText());
               // lblDonated.setText(String.format("%d", AddBlood)); 
            //    DBCon.StartCon();
//                DBCon.Insert("INSERT INTO donor (Donor_Name,Donor_Amount,Donor_Number,Donor_BloodBank,Donor_BType) VALUES('"+txtDName.getText()+"','"+AddBlood+"','"+txtDNumber.getText()+"','"+cbxBank.getSelectedItem().toString()+"','"+cbxBType.getSelectedItem().toString()+"')");
            //    DBCon.EndCon();
                //AddBloodToBank(cbxBank.getSelectedItem().toString(),cbxBType.getSelectedItem().toString(),  Integer.parseInt(txtDonate.getText()) );
              //  JOptionPane.showMessageDialog(this, "Thank You For Your Donation ","Thank You", JOptionPane.DEFAULT_OPTION);
             //   this.dispose();
            } 
    }//GEN-LAST:event_btnDoneActionPerformed

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
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNew;
    private javax.swing.JComboBox<String> cbxBank;
    private javax.swing.JComboBox<String> cbxBtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane txtBAvailable;
    private javax.swing.JTextPane txtBTake;
    private javax.swing.JTextArea txtPInfo;
    private javax.swing.JTextPane txtPName;
    private javax.swing.JTextPane txtPatientID;
    // End of variables declaration//GEN-END:variables
}
