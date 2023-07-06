/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menuLogin.formularios;

import configReader.ConfigReader;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import menuLogin.modelo.SqlUsuarios;
import menuLogin.modelo.usuarios;

/**
 *
 * @author LENOVO
 */
public class frm_RecuperarContra extends javax.swing.JFrame {
  Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public String user;
    /**
     * Creates new form frm_RecuperarContra
     */
    public frm_RecuperarContra() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCambiar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lblPass3 = new javax.swing.JLabel();
        txtNuevaContrasenia = new javax.swing.JPasswordField();
        jSeparator8 = new javax.swing.JSeparator();
        lblPass4 = new javax.swing.JLabel();
        txtVerificarContrasenia = new javax.swing.JPasswordField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabelOlvidasteContrasenia = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnCambiar.setBackground(new java.awt.Color(58, 69, 75));
        btnCambiar.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiar.setText("Cambiar Contraseña");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(58, 69, 75));
        jLabel23.setText("Cédula:");

        txtCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(58, 69, 75));
        txtCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCedula.setBorder(null);
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        jSeparator7.setBackground(new java.awt.Color(58, 69, 75));
        jSeparator7.setForeground(new java.awt.Color(58, 69, 75));

        lblPass3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblPass3.setForeground(new java.awt.Color(58, 69, 75));
        lblPass3.setText("Nueva Contraseña:");

        txtNuevaContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNuevaContrasenia.setForeground(new java.awt.Color(58, 69, 75));
        txtNuevaContrasenia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNuevaContrasenia.setBorder(null);

        jSeparator8.setBackground(new java.awt.Color(58, 69, 75));
        jSeparator8.setForeground(new java.awt.Color(58, 69, 75));

        lblPass4.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblPass4.setForeground(new java.awt.Color(58, 69, 75));
        lblPass4.setText("Verificar Contraseña:");

        txtVerificarContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtVerificarContrasenia.setForeground(new java.awt.Color(58, 69, 75));
        txtVerificarContrasenia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVerificarContrasenia.setBorder(null);

        jSeparator9.setBackground(new java.awt.Color(58, 69, 75));
        jSeparator9.setForeground(new java.awt.Color(58, 69, 75));

        jLabelOlvidasteContrasenia.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelOlvidasteContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOlvidasteContrasenia.setText("Iniciar Sesion");
        jLabelOlvidasteContrasenia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelOlvidasteContraseniaMouseMoved(evt);
            }
        });
        jLabelOlvidasteContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelOlvidasteContraseniaMousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(181, 37, 26));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Recuperar Contraseña");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(jLabelOlvidasteContrasenia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCedula)
                                .addComponent(txtNuevaContrasenia)
                                .addComponent(jSeparator8)
                                .addComponent(jSeparator7)
                                .addComponent(txtVerificarContrasenia)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(lblPass3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(lblPass4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btnCambiar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel23)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPass3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNuevaContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPass4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVerificarContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelOlvidasteContrasenia)
                .addGap(1, 1, 1)
                .addComponent(btnCambiar)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        // TODO add your handling code here:
        SqlUsuarios modSql = new SqlUsuarios();
        usuarios mod = new usuarios();
        String cedula = txtCedula.getText();
        
        
        
      if (modSql.verificarCedula(mod, cedula)) {
    // La cédula coincide, se puede cambiar la contraseña
    if (txtNuevaContrasenia.getText().isEmpty() || txtVerificarContrasenia.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Los campos de contraseña están vacíos");
    }else if (txtNuevaContrasenia.getText().equals(txtVerificarContrasenia.getText())) {
        try {
            String updateQuery = "UPDATE especialista SET contraseña = ? WHERE cedula=?";
                            ConfigReader configReader = new ConfigReader();

            con = DriverManager.getConnection("jdbc:mysql://"+configReader.getIp()+":3306/"+configReader.getDatabase(), configReader.getUser(),configReader.getPass());
            pst = con.prepareStatement(updateQuery);
            pst.setString(1, txtVerificarContrasenia.getText());
            pst.setString(2, cedula);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se cambió la contraseña con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
    }
} else {
    JOptionPane.showMessageDialog(null, "La cédula no es correcta");
}

    }//GEN-LAST:event_btnCambiarActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void jLabelOlvidasteContraseniaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOlvidasteContraseniaMouseMoved
        // TODO add your handling code here:
        jLabelOlvidasteContrasenia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabelOlvidasteContraseniaMouseMoved

    private void jLabelOlvidasteContraseniaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOlvidasteContraseniaMousePressed
        // TODO add your handling code here:
        frm_login sc = new frm_login();
        this.setVisible(false);

        sc.setVisible(true);
    }//GEN-LAST:event_jLabelOlvidasteContraseniaMousePressed

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
            java.util.logging.Logger.getLogger(frm_RecuperarContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_RecuperarContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_RecuperarContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_RecuperarContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_RecuperarContra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabelOlvidasteContrasenia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblPass3;
    private javax.swing.JLabel lblPass4;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtNuevaContrasenia;
    private javax.swing.JPasswordField txtVerificarContrasenia;
    // End of variables declaration//GEN-END:variables
}
