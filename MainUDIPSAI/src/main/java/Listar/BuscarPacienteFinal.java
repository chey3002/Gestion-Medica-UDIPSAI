/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listar;

import FichasMedicas.Resultados;
import Tests.presentacion.RenderTable;
import comons.datos.mysql;
import comons.negocio.Especialista;
import comons.negocio.Paciente;
import configReader.ConfigReader;
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
 * @author KEVIN
 */
public class BuscarPacienteFinal extends javax.swing.JFrame {

    String[] Titulos = {"ID", "CÉDULA", "NOMBRE", "CIUDAD", "EDITAR", "FICHA COMPLETA"}; //Arreglo de los titulos para la tabla
    DefaultTableModel dtm_datos = new DefaultTableModel(); //creamos  un modelo para la taba de datos
    TableRowSorter<TableModel> trs; //Hacemos el table row sorter para poder ordenar la tabla al presionar los encabezados de la misma
    ResultSet rs;  //el result set es el resultado de la consulta que mandamos por sql
    Object[][] M_datos;  //iniciamos una matriz donde pasaremos los datos de sql
ConfigReader configReader = new ConfigReader();
    mysql cc = new mysql(configReader.getDatabase(), configReader.getUser(), configReader.getPass());
    Connection cn = cc.conexion();
    //Conectar cc = new Conectar();   //iniciamos un objeto que se encargara de la conexion de datos
    // Connection cn = cc.conectar();

    /**
     * Creates new form vista1
     */
    Especialista especialista;
    public BuscarPacienteFinal(Especialista especialista) {
        this.especialista=especialista;
        initComponents();
        datos_tabla(); //iniciamos el metodo para mostrar los datos en la tabla
        //jtable_datos.setDefaultRenderer(Object.class, new RenderTable());
        jtable_datos.setDefaultRenderer(Object.class, new RenderTable());
        jtable_datos.setRowHeight(40);
    }
    String cedula = "0105886949";
    //0105706105

    private BuscarPacienteFinal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void datos_tabla() {
        if (cedula.equals("0105886949")) {
            int contador = 0;  //creamos un contador para saber el numero de datos que obtendremos de la tabla datos de sql
            try { //para las consultas sql siempre vamos a ocupar un try catch por su ocurre un error
                Statement st_cont = cn.createStatement(); //el statement nos ayuda a procesar una sentencia sql 
                ResultSet rs_cont = st_cont.executeQuery("SELECT COUNT(*) FROM paciente"); // asignamos los datos obtenidos de la consulta al result set
                if (rs_cont.next()) {
                    contador = rs_cont.getInt(1);
                }
//lo anterior fue solo para conocer el numero de datos que manejariamos esto mediante logra gracias con count de sql y con el  * le decimos que nos cuenta todas las filas de la tabla

                Statement st = cn.createStatement(); //ahora vamos a  hacer lo mismo solo que esta vez no obtendremos el numero de filas en la tabla
                rs = st.executeQuery("SELECT * FROM paciente");
                //aora obtendremos los datos de la tabla para mostrarlos en el jtable

                int cont = 0; //el contador nos ayudara para movernos en las filas de la matriz mientras que los numeros fijos (0,1,2,3) nos moveran por las 4 columnas que seran el id, nombre, etc
                M_datos = new Object[contador][6]; //definimos el tamaño de la matriz 
                while (rs.next()) { //el while nos ayudara a recorrer los datos obtenidos en la consulta anterior y asignarlos a la matriz  
                    M_datos[cont][0] = rs.getString("id");    //agregamos los datos a la table
                    M_datos[cont][1] = rs.getString("cedula");
                    M_datos[cont][2] = rs.getString("nombresApellidos");
                    M_datos[cont][3] = rs.getString("ciudad");
                    M_datos[cont][4] = new JButton("EDITAR");
                    M_datos[cont][5] = new JButton("ABRIR");
                    cont = cont + 1; //avanzamos una posicion del contador para que pase a la siguiente fila
                }

            } catch (SQLException ex) {
                Logger.getLogger(BuscarPacienteFinal.class.getName()).log(Level.SEVERE, null, ex); //si llegara a ocurrir un error ya se  una mala consulta o mala conexion aqui nos lo mostraria
            }

            dtm_datos = new DefaultTableModel(M_datos, Titulos) { //ahora agregaremos la matriz y los titulos al modelo de tabla
                //  public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla, 
                //     return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
                //  }
            };
            jtable_datos.setModel(dtm_datos); //ahora el modelo que ya tiene tanto los datos como los titulos lo agregamos a la tabla
            trs = new TableRowSorter<>(dtm_datos); //iniciamos el table row sorter para ordenar los datos (esto es si gustan)
            jtable_datos.setRowSorter(trs); //y lo agregamos al jtable

        } else {
            int contador = 0;  //creamos un contador para saber el numero de datos que obtendremos de la tabla datos de sql
            try { //para las consultas sql siempre vamos a ocupar un try catch por su ocurre un error
                Statement st_cont = cn.createStatement(); //el statement nos ayuda a procesar una sentencia sql 
                ResultSet rs_cont = st_cont.executeQuery("SELECT COUNT(*)\n"
                        + "FROM paciente p\n"
                        + "INNER JOIN asignaciones a ON p.id = a.id\n"
                        + "INNER JOIN especialista e ON a.cedulaEspecialista = e.cedula\n"
                        + "WHERE e.cedula = '" + cedula + "'"); // asignamos los datos obtenidos de la consulta al result set
                if (rs_cont.next()) {
                    contador = rs_cont.getInt(1);
                }
//lo anterior fue solo para conocer el numero de datos que manejariamos esto mediante logra gracias con count de sql y con el  * le decimos que nos cuenta todas las filas de la tabla

                Statement st = cn.createStatement(); //ahora vamos a  hacer lo mismo solo que esta vez no obtendremos el numero de filas en la tabla
                rs = st.executeQuery("SELECT p.*\n"
                        + "FROM paciente p\n"
                        + "INNER JOIN asignaciones a ON p.id = a.id\n"
                        + "INNER JOIN especialista e ON a.cedulaEspecialista = e.cedula\n"
                        + "WHERE e.cedula = '" + cedula + "'");                                                 //aora obtendremos los datos de la tabla para mostrarlos en el jtable

                int cont = 0; //el contador nos ayudara para movernos en las filas de la matriz mientras que los numeros fijos (0,1,2,3) nos moveran por las 4 columnas que seran el id, nombre, etc
                M_datos = new Object[contador][6]; //definimos el tamaño de la matriz 
                while (rs.next()) { //el while nos ayudara a recorrer los datos obtenidos en la consulta anterior y asignarlos a la matriz  
                    M_datos[cont][0] = rs.getString("id");    //agregamos los datos a la table
                    M_datos[cont][1] = rs.getString("cedula");
                    M_datos[cont][2] = rs.getString("nombresApellidos");
                    M_datos[cont][3] = rs.getString("ciudad");
                    M_datos[cont][4] = new JButton("EDITAR");
                    M_datos[cont][5] = new JButton("ABRIR");
                    cont = cont + 1; //avanzamos una posicion del contador para que pase a la siguiente fila
                }

            } catch (SQLException ex) {
                Logger.getLogger(BuscarPacienteFinal.class.getName()).log(Level.SEVERE, null, ex); //si llegara a ocurrir un error ya se  una mala consulta o mala conexion aqui nos lo mostraria
            }

            dtm_datos = new DefaultTableModel(M_datos, Titulos) { //ahora agregaremos la matriz y los titulos al modelo de tabla
                //  public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla, 
                //     return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
                //  }
            };
            jtable_datos.setModel(dtm_datos); //ahora el modelo que ya tiene tanto los datos como los titulos lo agregamos a la tabla
            trs = new TableRowSorter<>(dtm_datos); //iniciamos el table row sorter para ordenar los datos (esto es si gustan)
            jtable_datos.setRowSorter(trs); //y lo agregamos al jtable
            
        }//
    }//

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        setResizable(false);

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
        });

        jPanel2.setBackground(new java.awt.Color(181, 37, 26));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UDIPSAI");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Búsqueda de paciente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1037, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel3.setText("Ingrese el nombre o cédula del paciente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_buscadorKeyReleased

        int valor = 0;
        int cont = 0;
        String aux = "" + jt_buscador.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
        if (cedula.equals("0105886949")) {

            try {
                Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
                //rs = st_cont.executeQuery("SELECT COUNT(*) FROM paciente WHERE cedula LIKE'" + jt_buscador.getText() + "%'");//solo que esta ves usamos like
                //rs = st_cont.executeQuery("SELECT COUNT(*) FROM paciente WHERE nombresApellidos LIKE'%" + jt_buscador.getText() + "%' OR cedula LIKE '%" + jt_buscador.getText() + "%'");
                rs = st_cont.executeQuery("SELECT COUNT(*) FROM paciente WHERE cedula LIKE '%" + jt_buscador.getText() + "%'" + " OR nombresApellidos LIKE '%" + jt_buscador.getText() + "%'");

                if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                    valor = rs.getInt(1); //una vez que obtenimos el numero de filas continuamos a sacar  el valor que buscamos
                }

                M_datos = new Object[valor][6];
                //rs = st_cont.executeQuery("SELECT * FROM paciente WHERE cedula LIKE'" + jt_buscador.getText() + "%'"); //aqui es donde buscaremos a a la persona en especifico o las personas
                // rs = st_cont.executeQuery("SELECT * FROM paciente WHERE cedula LIKE '" + jt_buscador.getText() + "%'");

                //rs = st_cont.executeQuery("SELECT * FROM paciente WHERE nombresApellidos LIKE'%" + jt_buscador.getText() + "%' OR cedula LIKE '%" + jt_buscador.getText() + "%'");
                rs = st_cont.executeQuery("SELECT * FROM paciente WHERE  cedula LIKE '%" + jt_buscador.getText() + "%'" + " OR nombresApellidos LIKE '%" + jt_buscador.getText() + "%'");

                while (rs.next()) {
                    M_datos[cont][0] = rs.getString("id");
                    M_datos[cont][1] = rs.getString("cedula");
                    M_datos[cont][2] = rs.getString("nombresApellidos");
                    M_datos[cont][3] = rs.getString("ciudad");
                    M_datos[cont][4] = new JButton("EDITAR");
                    M_datos[cont][5] = new JButton("ABRIR");

                    cont = cont + 1;
                }

                dtm_datos = new DefaultTableModel(M_datos, Titulos) {
                    // public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla, 
                    //       return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
                    //  }
                };
                jtable_datos.setModel(dtm_datos);
                trs = new TableRowSorter<>(dtm_datos);
                jtable_datos.setRowSorter(trs);

            } catch (Exception e) {
            }

        } else {

            try {
                Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
                //rs = st_cont.executeQuery("SELECT COUNT(*) FROM paciente WHERE cedula LIKE'" + jt_buscador.getText() + "%'");//solo que esta ves usamos like
                rs = st_cont.executeQuery("SELECT COUNT(*) FROM paciente p INNER JOIN asignaciones a ON p.id = a.idPaciente INNER JOIN especialista e ON a.cedulaEspecialista = e.cedula "
                        + "WHERE (p.nombresApellidos LIKE '%" + jt_buscador.getText() + "%' OR p.cedula LIKE '%" + jt_buscador.getText() + "%') AND e.cedula = '" + cedula + "'");

                if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                    valor = rs.getInt(1); //una vez que obtenimos el numero de filas continuamos a sacar  el valor que buscamos
                }

                M_datos = new Object[valor][6];
                //rs = st_cont.executeQuery("SELECT * FROM paciente WHERE cedula LIKE'" + jt_buscador.getText() + "%'"); //aqui es donde buscaremos a a la persona en especifico o las personas
                // rs = st_cont.executeQuery("SELECT * FROM paciente WHERE cedula LIKE '" + jt_buscador.getText() + "%'");

                rs = st_cont.executeQuery("SELECT p.* FROM paciente p INNER JOIN asignaciones a ON p.id = a.idPaciente INNER JOIN especialista e ON a.cedulaEspecialista = e.cedula "
                        + "WHERE (p.nombresApellidos LIKE '%" + jt_buscador.getText() + "%' OR p.cedula LIKE '%" + jt_buscador.getText() + "%') AND e.cedula = '" + cedula + "'");

                dtm_datos = new DefaultTableModel(M_datos, Titulos) {
                    // public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla, 
                    //       return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
                    //  }
                };
                jtable_datos.setModel(dtm_datos);
                trs = new TableRowSorter<>(dtm_datos);
                jtable_datos.setRowSorter(trs);

            } catch (Exception e) {
            }
    }//GEN-LAST:event_jt_buscadorKeyReleased
    }

    private void jt_buscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_buscadorKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jt_buscadorKeyPressed

    private void jt_buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_buscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_buscadorActionPerformed

    private void jtable_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable_datosMouseClicked
        // TODO add your handling code here:
        int col = jtable_datos.columnAtPoint(evt.getPoint());
        int row = jtable_datos.rowAtPoint(evt.getPoint());

        if (col == 4) {
            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "¿Desea actualizar esta observación?",
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
                    ResultSet resp = st_cont.executeQuery("SELECT * FROM paciente WHERE id=" + jtable_datos.getValueAt(row, 0));//solo que esta ves usamos like
                    if (resp.next()) {
                        Integer id = resp.getInt("id");
                        Date fechaApertura = resp.getDate("fechaApertura");
                        String nombresApellidos = resp.getString("nombresApellidos");
                        String ciudad = resp.getString("ciudad");
                        Date fechaNacimiento = resp.getDate("fechaNacimiento");
                        String edad = resp.getString("edad");
                        String pacientecedula = resp.getString("cedula");
                        String domicilio = resp.getString("domicilio");
                        String barrio = resp.getString("barrio");
                        String telefono = resp.getString("telefono");
                        String celular = resp.getString("celular");
                        String institucionEducativa = resp.getString("institucionEducativa");
                        String tipoInstitucion = resp.getString("tipoInstitucion");
                        String sector = resp.getString("sector");
                        String jornada = resp.getString("jornada");
                        String telefonoInstitucion = resp.getString("telefonoInstitucion");
                        String anioEducacion = resp.getString("anioEducacion");
                        String paralelo = resp.getString("paralelo");
                        String perteneceInclusion = resp.getString("perteneceInclusion");
                        String tieneDiscapacidad = resp.getString("tieneDiscapacidad");
                        String portadorCarnet = resp.getString("portadorCarnet");
                        String diagnostico = resp.getString("diagnostico");
                        String motivoConsulta = resp.getString("motivoConsulta");
                        String observaciones = resp.getString("observaciones");
                        String nombreExaminador = resp.getString("nombreExaminador");
                        String anotaciones = resp.getString("anotaciones");

                        Paciente paciente = new Paciente(id, fechaApertura, nombresApellidos, ciudad, fechaNacimiento, edad, pacientecedula, domicilio, barrio, telefono, celular, institucionEducativa, tipoInstitucion, sector, jornada, telefonoInstitucion, anioEducacion, paralelo, perteneceInclusion, tieneDiscapacidad, portadorCarnet, diagnostico, motivoConsulta, observaciones, nombreExaminador, anotaciones);

                        Editar editarPaciente = new Editar(paciente);
                        editarPaciente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Establecer acción de cierre
                        editarPaciente.setVisible(true); // Mostrar el JFrame NuevoFrame
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el paciente", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al buscar al paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        if (col == 5) {

            try {
                Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
                ResultSet resp = st_cont.executeQuery("SELECT * FROM paciente WHERE id=" + jtable_datos.getValueAt(row, 0));//solo que esta ves usamos like
                if (resp.next()) {
                    Integer id = resp.getInt("id");
                    Date fechaApertura = resp.getDate("fechaApertura");
                    String nombresApellidos = resp.getString("nombresApellidos");
                    String ciudad = resp.getString("ciudad");
                    Date fechaNacimiento = resp.getDate("fechaNacimiento");
                    String edad = resp.getString("edad");
                    String pacientecedula = resp.getString("cedula");
                    String domicilio = resp.getString("domicilio");
                    String barrio = resp.getString("barrio");
                    String telefono = resp.getString("telefono");
                    String celular = resp.getString("celular");
                    String institucionEducativa = resp.getString("institucionEducativa");
                    String tipoInstitucion = resp.getString("tipoInstitucion");
                    String sector = resp.getString("sector");
                    String jornada = resp.getString("jornada");
                    String telefonoInstitucion = resp.getString("telefonoInstitucion");
                    String anioEducacion = resp.getString("anioEducacion");
                    String paralelo = resp.getString("paralelo");
                    String perteneceInclusion = resp.getString("perteneceInclusion");
                    String tieneDiscapacidad = resp.getString("tieneDiscapacidad");
                    String portadorCarnet = resp.getString("portadorCarnet");
                    String diagnostico = resp.getString("diagnostico");
                    String motivoConsulta = resp.getString("motivoConsulta");
                    String observaciones = resp.getString("observaciones");
                    String nombreExaminador = resp.getString("nombreExaminador");
                    String anotaciones = resp.getString("anotaciones");

                    Paciente paciente = new Paciente(id, fechaApertura, nombresApellidos, ciudad, fechaNacimiento, edad, pacientecedula, domicilio, barrio, telefono, celular, institucionEducativa, tipoInstitucion, sector, jornada, telefonoInstitucion, anioEducacion, paralelo, perteneceInclusion, tieneDiscapacidad, portadorCarnet, diagnostico, motivoConsulta, observaciones, nombreExaminador, anotaciones);

                    Resultados editarPaciente = new Resultados(paciente,this.especialista);
                    editarPaciente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Establecer acción de cierre
                    editarPaciente.setVisible(true); // Mostrar el JFrame NuevoFrame
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el paciente", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al buscar al paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(BuscarPacienteFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPacienteFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPacienteFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPacienteFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new BuscarPacienteFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jt_buscador;
    private javax.swing.JTable jtable_datos;
    // End of variables declaration//GEN-END:variables
}
