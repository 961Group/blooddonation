package blooddonation;

import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BloodBank extends javax.swing.JFrame {

    public BloodBank() {
        initComponents();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(this);
        try {
        FetchList();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    boolean existBank(String exi){
        DBCon.StartCon();
        ResultSet resultSet =  DBCon.Select("Select BloodBank_Name From bloodbank Where BloodBank_Name = '" + exi + "'");
      try {
            if(!resultSet.next()){
                return true;
            }
         }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return false;
    }
    
    void FetchList ()  throws SQLException{
        DefaultListModel model = new DefaultListModel();
        DBCon.StartCon();
        ResultSet resultSet =  DBCon.Select("Select BloodBank_Name From bloodbank");
        model.addElement("New Bank");           
        while (resultSet.next()){
            String itemCode = resultSet.getString("BloodBank_Name");
            model.addElement(itemCode); 
        }   
        lsBanks.setModel(model);
        lsBanks.setSelectedIndex(0);
        resultSet.close();
        DBCon.EndCon();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lsBanks = new javax.swing.JList<>();
        label1 = new java.awt.Label();
        txtName = new javax.swing.JTextField();
        txtaplus = new javax.swing.JTextField();
        txtanegative = new javax.swing.JTextField();
        txtbpositve = new javax.swing.JTextField();
        txtbnegative = new javax.swing.JTextField();
        txtabpositive = new javax.swing.JTextField();
        txtabnegative = new javax.swing.JTextField();
        txtopositive = new javax.swing.JTextField();
        txtonegative = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blood Banks");

        lsBanks.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lsBanksValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lsBanks);

        label1.setText("Name");

        txtaplus.setBorder(javax.swing.BorderFactory.createTitledBorder("A + / Units"));
        txtaplus.setEnabled(false);

        txtanegative.setBorder(javax.swing.BorderFactory.createTitledBorder("A - / Units"));
        txtanegative.setEnabled(false);
        txtanegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanegativeActionPerformed(evt);
            }
        });

        txtbpositve.setBorder(javax.swing.BorderFactory.createTitledBorder("B + / Units"));
        txtbpositve.setEnabled(false);

        txtbnegative.setBorder(javax.swing.BorderFactory.createTitledBorder("B - / Units"));
        txtbnegative.setEnabled(false);

        txtabpositive.setBorder(javax.swing.BorderFactory.createTitledBorder("AB + / Units"));
        txtabpositive.setEnabled(false);

        txtabnegative.setBorder(javax.swing.BorderFactory.createTitledBorder("AB - / Units"));
        txtabnegative.setEnabled(false);

        txtopositive.setBorder(javax.swing.BorderFactory.createTitledBorder("O + / Units"));
        txtopositive.setEnabled(false);

        txtonegative.setBorder(javax.swing.BorderFactory.createTitledBorder("O - / Units"));
        txtonegative.setEnabled(false);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exclamation_bank.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtaplus, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbpositve, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtabpositive, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtopositive, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtonegative, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtabnegative, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtbnegative, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtanegative, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSave))
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaplus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtanegative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbpositve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbnegative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtabpositive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtabnegative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtopositive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtonegative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lsBanksValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lsBanksValueChanged
        if(lsBanks.getSelectedValue() ==  "New Bank"){
            txtName.setText("");
            txtaplus.setText("");
            txtanegative.setText("");
            txtbpositve.setText("");
            txtbnegative.setText("");
            txtabpositive.setText("");
            txtabnegative.setText("");
            txtopositive.setText("");
            txtonegative.setText("");
        }else{
            DBCon.StartCon();
            ResultSet resultSet =  DBCon.Select("Select * From bloodbank Where BloodBank_Name = '" + lsBanks.getSelectedValue() + "'");
            try{
                if (resultSet.next()){
                  txtName.setText(resultSet.getString("BloodBank_Name"));
                  txtaplus.setText(resultSet.getString("BloodBank_AP"));
                  txtanegative.setText(resultSet.getString("BloodBank_AN"));
                  txtbpositve.setText(resultSet.getString("BloodBank_BP"));
                  txtbnegative.setText(resultSet.getString("BloodBank_BN"));
                  txtabpositive.setText(resultSet.getString("BloodBank_ABP"));
                  txtabnegative.setText(resultSet.getString("BloodBank_ABN"));
                  txtopositive.setText(resultSet.getString("BloodBank_OP"));
                  txtonegative.setText(resultSet.getString("BloodBank_ON"));
                }
                resultSet.close();
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
            DBCon.EndCon();
        }
    }//GEN-LAST:event_lsBanksValueChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
     if(txtName.getText().equals("")){
        JOptionPane.showMessageDialog(this, "Name is Empty","Error", JOptionPane.DEFAULT_OPTION);
    }else{ 
        
        if(lsBanks.getSelectedValue() ==  "New Bank"){
           if ( existBank(txtName.getText()) ){
            DBCon.StartCon();
            DBCon.Insert("INSERT Into bloodbank(BloodBank_Name) Values('"+txtName.getText()+"') ");
            DBCon.EndCon();
            try {
                 FetchList();
            }catch(SQLException ex){
                 System.err.println(ex.getMessage());
            }
           }else{
                JOptionPane.showMessageDialog(this, "Bank Already Exists", "Error", JOptionPane.WARNING_MESSAGE);
           }

        }else{
             if ( existBank(txtName.getText()) ){
            DBCon.StartCon();
            DBCon.Update("UPDATE bloodbank set BloodBank_Name = '"+txtName.getText()+"' where BloodBank_Name = '" + lsBanks.getSelectedValue().toString() + "' ");
            DBCon.EndCon();
            try {
                 FetchList();
            }catch(SQLException ex){
                 System.err.println(ex.getMessage());
            }
            }else{
                JOptionPane.showMessageDialog(this, "Bank Already Exists", "Error", JOptionPane.WARNING_MESSAGE);
           }
        }
     }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtanegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanegativeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtanegativeActionPerformed

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
            java.util.logging.Logger.getLogger(BloodBank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BloodBank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BloodBank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BloodBank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BloodBank().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JList<String> lsBanks;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtabnegative;
    private javax.swing.JTextField txtabpositive;
    private javax.swing.JTextField txtanegative;
    private javax.swing.JTextField txtaplus;
    private javax.swing.JTextField txtbnegative;
    private javax.swing.JTextField txtbpositve;
    private javax.swing.JTextField txtonegative;
    private javax.swing.JTextField txtopositive;
    // End of variables declaration//GEN-END:variables
}
