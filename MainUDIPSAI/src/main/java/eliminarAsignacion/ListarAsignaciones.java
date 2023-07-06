/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminarAsignacion;

import Tests.presentacion.RenderTable;
import comons.datos.Conectar;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author
 */
public class ListarAsignaciones extends javax.swing.JFrame {

    String[] Titulos = {"FICHA", "NOMBRE PACIENTE", "CEDULA PACIENTE", "ESPECIALISTA", "ELIMINAR"}; //Arreglo de los titulos para la tabla
    DefaultTableModel dtm_datos = new DefaultTableModel(); //creamos  un modelo para la taba de datos
    TableRowSorter<TableModel> trs; //Hacemos el table row sorter para poder ordenar la tabla al presionar los encabezados de la misma
    ResultSet rs;  //el result set es el resultado de la consulta que mandamos por sql
    Object[][] M_datos;  //iniciamos una matriz donde pasaremos los datos de sql
    Conectar cc = new Conectar();   //iniciamos un objeto que se encargara de la conexion de datos
    Connection cn = cc.conectar();

    /**
     * Creates new form vista1
     */
    public ListarAsignaciones() {
        initComponents();
        datos_tabla(); //iniciamos el metodo para mostrar los datos en la tabla
        jtable_datos.setDefaultRenderer(Object.class, new RenderTable());
        jtable_datos.setRowHeight(40);
        dtm_datos = new DefaultTableModel(M_datos, Titulos) {
            public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla, 
                return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
            }
        };
        jtable_datos.setModel(dtm_datos);
    }

    private void datos_tabla() {

//        int contador = 0;  //creamos un contador para saber el numero de datos que obtendremos de la tabla datos de sql
//        try { //para las consultas sql siempre vamos a ocupar un try catch por su ocurre un error
//            Statement st_cont = cn.createStatement(); //el statement nos ayuda a procesar una sentencia sql 
//            ResultSet rs_cont = st_cont.executeQuery("SELECT COUNT(*) FROM paciente"); // asignamos los datos obtenidos de la consulta al result set
//             if (rs_cont.next()) {
//                contador = rs_cont.getInt(1);
//            }
////lo anterior fue solo para conocer el numero de datos que manejariamos esto mediante logra gracias con count de sql y con el  * le decimos que nos cuenta todas las filas de la tabla
//
//            
//            Statement st = cn.createStatement(); //ahora vamos a  hacer lo mismo solo que esta vez no obtendremos el numero de filas en la tabla
//            rs = st.executeQuery("SELECT id,nombresApellidos,cedula FROM paciente"); //aora obtendremos los datos de la tabla para mostrarlos en el jtable
//            
//            int cont = 0; //el contador nos ayudara para movernos en las filas de la matriz mientras que los numeros fijos (0,1,2,3) nos moveran por las 4 columnas que seran el id, nombre, etc
//            M_datos = new String[contador][4]; //definimos el tamaño de la matriz 
//            while (rs.next()) { //el while nos ayudara a recorrer los datos obtenidos en la consulta anterior y asignarlos a la matriz  
//                M_datos[cont][0] = rs.getString("id");    //agregamos los datos a la table
//                M_datos[cont][1] = rs.getString("nombresApellidos");
//                M_datos[cont][2] = rs.getString("cedula");
//                
//                cont = cont + 1; //avanzamos una posicion del contador para que pase a la siguiente fila
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ListarAsignaciones.class.getName()).log(Level.SEVERE, null, ex); //si llegara a ocurrir un error ya se  una mala consulta o mala conexion aqui nos lo mostraria
//        }
//
//        dtm_datos = new DefaultTableModel(M_datos, Titulos) { //ahora agregaremos la matriz y los titulos al modelo de tabla
//            public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla, 
//                return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
//            }
//        };
//        jtable_datos.setModel(dtm_datos); //ahora el modelo que ya tiene tanto los datos como los titulos lo agregamos a la tabla
//        trs = new TableRowSorter<>(dtm_datos); //iniciamos el table row sorter para ordenar los datos (esto es si gustan)
//        jtable_datos.setRowSorter(trs); //y lo agregamos al jtable
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_datos = new javax.swing.JTable();
        jt_buscador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtable_datos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtable_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtable_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable_datos);

        jt_buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_buscadorActionPerformed(evt);
            }
        });
        jt_buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_buscadorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_buscadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jt_buscadorKeyTyped(evt);
            }
        });

        jLabel1.setText("Número de cédula del especialista:");

        jPanel2.setBackground(new java.awt.Color(181, 37, 26));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Eliminar Asignaciones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_buscadorKeyReleased
        // TODO add your handling code here:
        int valor = 0;
        int cont = 0;
        String aux = "" + jt_buscador.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
        try {
            Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
            rs = st_cont.executeQuery("SELECT COUNT(*) FROM paciente JOIN asignaciones ON paciente.id=asignaciones.idPaciente WHERE asignaciones.cedulaEspecialista LIKE '%" + jt_buscador.getText() + "%'");//solo que esta ves usamos like
            if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                valor = rs.getInt(1); //una vez que obtenimos el numero de filas continuamos a sacar  el valor que buscamos
            }

            M_datos = new Object[valor][5];
            rs = st_cont.executeQuery("SELECT paciente.id, paciente.nombresApellidos,paciente.cedula, asignaciones.cedulaEspecialista FROM paciente JOIN asignaciones ON paciente.id=asignaciones.idPaciente WHERE asignaciones.cedulaEspecialista LIKE '%" + jt_buscador.getText() + "%'"); //aqui es donde buscaremos a a la persona en especifico o las personas
            while (rs.next()) {
                M_datos[cont][0] = rs.getString("id");
                M_datos[cont][1] = rs.getString("nombresApellidos");
                M_datos[cont][2] = rs.getString("cedula");
                M_datos[cont][3] = rs.getString("cedulaEspecialista");
                M_datos[cont][4] = new JButton("X");
                cont = cont + 1;
            }
            dtm_datos = new DefaultTableModel(M_datos, Titulos) {
                public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla, 
                    return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
                }
            };
            jtable_datos.setModel(dtm_datos);
            trs = new TableRowSorter<>(dtm_datos);
            jtable_datos.setRowSorter(trs);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jt_buscadorKeyReleased

    private void jt_buscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_buscadorKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_jt_buscadorKeyPressed

    private void jt_buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_buscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_buscadorActionPerformed

    private void jt_buscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_buscadorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_buscadorKeyTyped

    private void jtable_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable_datosMouseClicked
        // TODO add your handling code here:
        int col = jtable_datos.columnAtPoint(evt.getPoint());
        int row = jtable_datos.rowAtPoint(evt.getPoint());
        if (col == 4) {
            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "¿Desea eleminar este test?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "No"
            );

            if (opcion == JOptionPane.YES_OPTION) {
                try {
                    Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
                    System.out.println("DELETE FROM asignaciones WHERE idPaciente=" + jtable_datos.getValueAt(row, 0) + " AND cedulaEspecialista='" + jtable_datos.getValueAt(row, 3) + "'");
                    int resp = st_cont.executeUpdate("DELETE FROM asignaciones WHERE idPaciente=" + jtable_datos.getValueAt(row, 0) + " AND cedulaEspecialista='" + jtable_datos.getValueAt(row, 3) + "'");//solo que esta ves usamos like

                    ListarAsignaciones listarAsignaciones = new ListarAsignaciones();
                    listarAsignaciones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Establecer acción de cierre
                    listarAsignaciones.setVisible(true); // Mostrar el JFrame NuevoFrame
                    this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(ListarAsignaciones.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }


    }//GEN-LAST:event_jtable_datosMouseClicked

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
            java.util.logging.Logger.getLogger(ListarAsignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarAsignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarAsignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarAsignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarAsignaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jt_buscador;
    private javax.swing.JTable jtable_datos;
    // End of variables declaration//GEN-END:variables
}
