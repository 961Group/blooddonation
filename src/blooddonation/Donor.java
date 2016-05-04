/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blooddonation;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
 import java.util.Random; 

/**
 *
 * @author Anon
 */
public class Donor extends javax.swing.JFrame {
    
      boolean  found = false; 
      int blood = 0;
    /**
     * Creates new form Donor
     */
    public Donor() {
        initComponents();
       setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(this);
           btnDonate.setEnabled(false);
           cbxBType.setEnabled(false);
           cbxBank.setEnabled(false);
           txtDName.setEnabled(false);
           txtDNumber.setEnabled(false);
            txtDonate.setEnabled(false);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDonorID = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDName = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDNumber = new javax.swing.JTextPane();
        cbxBank = new javax.swing.JComboBox<>();
        btnDonate = new javax.swing.JButton();
        cbxBType = new javax.swing.JComboBox<>();
        btnNew = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lblDonated = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDonate = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Donor");
        setResizable(false);

        jLabel1.setText("Donor ID Card");

        jLabel2.setText("Donor Name");

        jLabel3.setText("Donor Number");

        jLabel5.setText("Blood Type");

        jLabel6.setText("BloodBank");

        txtDonorID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDonorIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDonorIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDonorIDKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDonorID);

        jScrollPane2.setViewportView(txtDName);

        txtDNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNumberKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtDNumber);

        btnDonate.setBackground(new java.awt.Color(255, 0, 51));
        btnDonate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/donatesave.png"))); // NOI18N
        btnDonate.setText("Donate");
        btnDonate.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDonate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonateActionPerformed(evt);
            }
        });

        cbxBType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user-blue-add.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        lblDonated.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Donated / Liter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        lblDonated.setForeground(new java.awt.Color(255, 0, 51));
        lblDonated.setText("0");
        lblDonated.setEnabled(false);
        lblDonated.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblDonatedKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(lblDonated);

        txtDonate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Donate / Liter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        txtDonate.setForeground(new java.awt.Color(255, 0, 51));
        txtDonate.setText("0");
        txtDonate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDonateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDonateKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(txtDonate);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(cbxBank, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDonate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxBank)
                                .addGap(23, 23, 23)))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBType)
                    .addComponent(btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDonorIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonorIDKeyPressed
        
    }//GEN-LAST:event_txtDonorIDKeyPressed

    private void txtDonorIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonorIDKeyReleased
      
    }//GEN-LAST:event_txtDonorIDKeyReleased

    void AddBloodToBank(String BankName,String Type,int blood ){
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
                int BloodTotal = resultSet.getInt("RESULT") + blood;
                DBCon.Update("UPDATE bloodbank set "+BloodType+" = '"+BloodTotal+"' WHERE BloodBank_Name = '"+BankName+"'");
            }
            DBCon.EndCon();
              }catch(SQLException ex){
          System.err.println(ex.getMessage());
      }
    }
    
    
    
    
    private void btnDonateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonateActionPerformed
      if(txtDName.getText().equals("")){
        JOptionPane.showMessageDialog(this, "Enter Donor Name","Missing", JOptionPane.DEFAULT_OPTION);
      }else if (txtDNumber.getText().equals("")){
        JOptionPane.showMessageDialog(this, "Enter Donor Cell Number","Missing", JOptionPane.DEFAULT_OPTION);   
      }else if (txtDonate.getText().equals("")){
        JOptionPane.showMessageDialog(this, "Enter Donation Amount"+ "","Missing", JOptionPane.DEFAULT_OPTION);
      }else{
      
            if (found){
                int AddBlood = blood + Integer.parseInt(txtDonate.getText());
                lblDonated.setText(String.format("%d", AddBlood)); 
                DBCon.StartCon();
                DBCon.Update("UPDATE donor SET Donor_Name='"+txtDName.getText()+"', Donor_Number='"+txtDNumber.getText()+"' , Donor_Amount='"+AddBlood+"' WHERE Donor_ID ='"+txtDonorID.getText()+"'");
                DBCon.EndCon();
                AddBloodToBank(cbxBank.getSelectedItem().toString(),cbxBType.getSelectedItem().toString(),  Integer.parseInt(txtDonate.getText()) );
                JOptionPane.showMessageDialog(this, "Thank You For Your Donation","Thank You", JOptionPane.DEFAULT_OPTION);
                this.dispose();
            }else{
                int AddBlood = blood + Integer.parseInt(txtDonate.getText());
                lblDonated.setText(String.format("%d", AddBlood)); 
                DBCon.StartCon();
                DBCon.Insert("INSERT INTO donor (Donor_Name,Donor_Amount,Donor_Number,Donor_BloodBank,Donor_BType) VALUES('"+txtDName.getText()+"','"+AddBlood+"','"+txtDNumber.getText()+"','"+cbxBank.getSelectedItem().toString()+"','"+cbxBType.getSelectedItem().toString()+"')");
                DBCon.EndCon();
                AddBloodToBank(cbxBank.getSelectedItem().toString(),cbxBType.getSelectedItem().toString(),  Integer.parseInt(txtDonate.getText()) );
                JOptionPane.showMessageDialog(this, "Thank You For Your Donation ","Thank You", JOptionPane.DEFAULT_OPTION);
                this.dispose();
            } 
      }
    }//GEN-LAST:event_btnDonateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
            blood = 0;
            found = false;
            lblDonated.setText("0");
            txtDName.setEnabled(true);
            txtDNumber.setEnabled(true);
            txtDonate.setEnabled(true);
            lblDonated.setEnabled(false);
            txtDonorID.setText("");
            cbxBType.setEnabled(true);
            txtDonorID.setEnabled(true);
            cbxBank.setEnabled(true);
            txtDName.setText(""); 
            txtDNumber.setText(""); 
            cbxBank.setSelectedIndex(0); 
            cbxBType.setSelectedIndex(0); 
            btnDonate.setEnabled(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void lblDonatedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblDonatedKeyReleased
       
    }//GEN-LAST:event_lblDonatedKeyReleased

    private void txtDonateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonateKeyReleased

    }//GEN-LAST:event_txtDonateKeyReleased

    private void txtDonorIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonorIDKeyTyped
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
        try{
        DBCon.StartCon();
        ResultSet resultSet =  DBCon.Select("SELECT * FROM donor Where Donor_ID = '"+txtDonorID.getText() + evt.getKeyChar() +"'");
        if (resultSet.next()){
            txtDName.setText(resultSet.getString("Donor_Name")); 
            cbxBank.setSelectedItem(resultSet.getString("Donor_BloodBank").toString()); 
            txtDNumber.setText(resultSet.getString("Donor_Number")); 
            cbxBType.setSelectedItem(resultSet.getString("Donor_BType")); 
            cbxBType.setEnabled(false);
            cbxBank.setEnabled(false);
            txtDonorID.setEnabled(false);
            txtDonorID.setText(txtDonorID.getText() + evt.getKeyChar());
            btnDonate.setEnabled(true);
            txtDName.setEnabled(true);
            txtDNumber.setEnabled(true);
            txtDonate.setEnabled(true);
            blood = resultSet.getInt("Donor_Amount");
            lblDonated.setText(String.format("%d", blood));
            found = true;
            
        }/*else{
            btnDonate.setEnabled(true);
            txtDonorID.setEnabled(true);
            blood = 0;
            lblDonated.setText("");
            cbxBType.setEnabled(true);
            cbxBank.setEnabled(true);
            txtDName.setText(""); 
            txtDNumber.setText(""); 
            cbxBank.setSelectedIndex(0); 
            cbxBType.setSelectedIndex(0); 
        }   */
            resultSet.close();
        DBCon.EndCon();
      }catch(SQLException ex){
          System.err.println(ex.getMessage());
      }
    }//GEN-LAST:event_txtDonorIDKeyTyped

    private void txtDonateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonateKeyTyped
          if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txtDonateKeyTyped

    private void txtDNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNumberKeyTyped
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txtDNumberKeyTyped

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
            java.util.logging.Logger.getLogger(Donor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Donor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Donor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Donor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Donor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonate;
    private javax.swing.JButton btnNew;
    private javax.swing.JComboBox<String> cbxBType;
    private javax.swing.JComboBox<String> cbxBank;
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
    private javax.swing.JTextPane lblDonated;
    private javax.swing.JTextPane txtDName;
    private javax.swing.JTextPane txtDNumber;
    private javax.swing.JTextPane txtDonate;
    private javax.swing.JTextPane txtDonorID;
    // End of variables declaration//GEN-END:variables
}
