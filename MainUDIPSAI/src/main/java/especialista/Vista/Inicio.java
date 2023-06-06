/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package especialista.Vista;
import comons.negocio.Especialista;
import especialista.Vista.Crear;

/**
 *
 * @author Usuario
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    public Inicio(Especialista especialista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        txtareaprofesional = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        labelhorasistema = new javax.swing.JLabel();
        labelfechasistema = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menugestion = new javax.swing.JMenu();
        menuitemcrear = new javax.swing.JMenuItem();
        menuactualizar = new javax.swing.JMenuItem();
        menuver = new javax.swing.JMenuItem();
        menueliminar = new javax.swing.JMenuItem();
        menuCitas = new javax.swing.JMenu();
        menuReportes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtareaprofesional, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(txtareaprofesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelhorasistema.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                labelhorasistemaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelhorasistema, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(labelfechasistema, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelfechasistema, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                    .addComponent(labelhorasistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        menuInicio.setText("Inicio");
        menuInicio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuBar1.add(menuInicio);

        menugestion.setText("Gestión Especialistas");
        menugestion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        menuitemcrear.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menuitemcrear.setText("Crear Especialista");
        menuitemcrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemcrearActionPerformed(evt);
            }
        });
        menugestion.add(menuitemcrear);

        menuactualizar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menuactualizar.setText("Editar Especialista");
        menuactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuactualizarActionPerformed(evt);
            }
        });
        menugestion.add(menuactualizar);

        menuver.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menuver.setText("Ver Especialistas");
        menuver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuverActionPerformed(evt);
            }
        });
        menugestion.add(menuver);

        menueliminar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menueliminar.setText("Eliminar Especialista");
        menueliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menueliminarActionPerformed(evt);
            }
        });
        menugestion.add(menueliminar);

        jMenuBar1.add(menugestion);

        menuCitas.setText("Citas");
        menuCitas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuBar1.add(menuCitas);

        menuReportes.setText("Reportes");
        menuReportes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuBar1.add(menuReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuactualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuactualizarActionPerformed

    private void menuverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuverActionPerformed

    private void menueliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menueliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menueliminarActionPerformed

    private void labelhorasistemaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelhorasistemaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_labelhorasistemaFocusGained

    private void menuitemcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemcrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuitemcrearActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JLabel labelfechasistema;
    public javax.swing.JLabel labelhorasistema;
    public javax.swing.JMenu menuCitas;
    public javax.swing.JMenu menuInicio;
    public javax.swing.JMenu menuReportes;
    public javax.swing.JMenuItem menuactualizar;
    public javax.swing.JMenuItem menueliminar;
    public javax.swing.JMenu menugestion;
    public javax.swing.JMenuItem menuitemcrear;
    public javax.swing.JMenuItem menuver;
    public javax.swing.JTextField txtareaprofesional;
    // End of variables declaration//GEN-END:variables
}
