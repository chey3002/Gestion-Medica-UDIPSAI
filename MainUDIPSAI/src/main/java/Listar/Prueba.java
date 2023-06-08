/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Listar;

import comons.datos.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class Prueba extends javax.swing.JFrame {

    /**
     * Creates new form Prueba
     */
    public Prueba() {
        initComponents();
        mostrarTodosLosPacientes();
    }

    /*  public void mostrar(String tabla) {
        String sql = "select *from " + tabla;
        Statement st;
        mysql con = new mysql();
        Connection Conexion = con.conexion();
        System.out.println(sql);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("FECHA DE APERTURA");
        model.addColumn("PACIENTE");

        visor.setModel(model);
        String[] datos = new String[10];
        try {
            st = Conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
               datos[2] = rs.getString(3);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }

    }
     */
    ///////////////
    //  "SELECT p.* FROM paciente p INNER JOIN asignaciones a ON p.id = a.id WHERE a.id = 1";
    public void mostrarTodosLosPacientes() {
        String sql = "SELECT p.*\n"
                + "FROM paciente p\n"
                + "INNER JOIN asignaciones a ON p.id = a.id\n"
                + "INNER JOIN especialista e ON a.cedulaEspecialista = e.cedula\n"
                + "WHERE e.cedula = 0105706105";

        Statement st;
        mysql con = new mysql("udipsai", "root", "");
        Connection conexion = con.conexion();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("FECHA DE APERTURA");
        model.addColumn("PACIENTE");

        visor.setModel(model);
        String[] datos = new String[10];
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    /*public void buscarPacientes( String filtro) {
        
       String sql = "SELECT p.* FROM paciente p INNER JOIN asignaciones a ON p.id = a.id INNER JOIN especialista e ON a.cedulaEspecialista = e.cedula WHERE e.cedula = 0105706105 OR p.cedula LIKE ? OR p.nombresApellidos LIKE ?";
       
        PreparedStatement pst;
        mysql con = new mysql("udipsai", "root", "");
        Connection conexion = con.conexion();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("FECHA DE APERTURA");
        model.addColumn("PACIENTE");

        visor.setModel(model);
        String[] datos = new String[10];
        try {
            pst = conexion.prepareStatement(sql);
            pst.setString(1, "%" + filtro + "%");
            pst.setString(2, "%" + filtro + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }*/
/////////////////
    public void buscarPacientes(String filtro) {
  String sql= "SELECT p.* FROM paciente p INNER JOIN asignaciones a ON p.id = a.idPaciente INNER JOIN especialista e ON a.cedulaEspecialista = e.cedula "
          + "WHERE (p.nombresApellidos like ? or p.cedula like ?) and e.cedula = 0105706105";
   // String sql = "SELECT * FROM  paciente WHERE cedula LIKE ? OR nombresApellidos LIKE ?";
    PreparedStatement pst;
    mysql con = new mysql("udipsai", "root", "");
    Connection conexion = con.conexion();

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("FECHA DE APERTURA");
    model.addColumn("PACIENTE");

    visor.setModel(model);
    String[] datos = new String[10];
    try {
        pst = conexion.prepareStatement(sql);
        pst.setString(1, "%" + filtro + "%");
        pst.setString(2, "%" + filtro + "%");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            model.addRow(datos);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.toString());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtcedula = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        visor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(visor);

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcedula, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(txtnombre))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Buscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar

        String filtro = txtcedula.getText();
        
        buscarPacientes(filtro);

    }//GEN-LAST:event_Buscar

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
            java.util.logging.Logger.getLogger(Prueba.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prueba.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prueba.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prueba.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtnombre;
    public javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
