/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RegistroPaciente.Registro_Principal;

import comons.datos.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco
 */
public class FichaUnica extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();

    public FichaUnica() {
        initComponents();
        this.setTitle("Ficha Unica");
        this.setSize(735, 860);
        this.setLocationRelativeTo(null);
        btn_Guardar.setEnabled(true);
        
    }

    /*public void habilitarboton(){
   if (!txt_FechaApertura.getText().isEmpty() && !txt_NumeroFicha.getText().isEmpty() && !txt_NombresApellidos.getText().isEmpty() && !txt_LugaryFechaNacimiento.getText().isEmpty()
    && !txt_Ciudad.getText().isEmpty() && !txt_Domicilio.getText().isEmpty() && !txt_edad.getText().isEmpty() && !txt_Cedula.getText().isEmpty()
    && !txt_Sector.getText().isEmpty() && !txt_Barrio.getText().isEmpty() && !txt_Telefono.getText().isEmpty() && !txt_Celular.getText().isEmpty()
    && !txt_Correo.getText().isEmpty() && cb_PortaCarnet.getSelectedItem() != null && cb_PortaCarnet.getSelectedItem() != null
    && !txt_TipoDisca.getText().isEmpty() && !txt_Inst_educa.getText().isEmpty() && !txt_Direccion.getText().isEmpty() && !txt_SectorInst.getText().isEmpty()
    && !txt_EducaInclusi.getText().isEmpty() && cb_Jornada.getSelectedItem() != null && cb_TipoInst.getSelectedItem() != null
    && !txt_teleInst.getText().isEmpty() && !txt_Paralelo.getText().isEmpty() && !txt_AnioCursa.getText().isEmpty() && cb_AccesoInter.getSelectedItem() != null
    && cb_TipoDispo.getSelectedItem() != null && cb_TipoInst.getSelectedItem() != null && !txt_MotivoCons.getText().isEmpty() && !txt_Observaciones.getText().isEmpty()) {
    btn_Guardar.setEnabled(true);
   } else {
       btn_Guardar.setEnabled(false);
}
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_NombresApellidos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_FechaNacimiento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_edad = new javax.swing.JTextField();
        txt_Cedula = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_Domicilio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_Ciudad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_Sector = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_Celular = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_Correo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_Barrio = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Observaciones = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        cb_PresentaDisca = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cb_PortaCarnet = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txt_TipoDisca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_MotivoCons = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_anotaciones = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txt_Inst_educa = new javax.swing.JTextField();
        cb_TipoInst = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        txt_Direccion = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_SectorInst = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_teleInst = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_EducaInclusi = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_AnioCursa = new javax.swing.JTextField();
        cb_Jornada = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_Paralelo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txt_examinador = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btn_Guardar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), null));

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("DATOS DE IDENTIFICACION DEL ESTUDIANTE:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jLabel10.setText("Nombres y Apellidos:");

        txt_NombresApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombresApellidosActionPerformed(evt);
            }
        });

        jLabel11.setText("Fecha de Nacimiento:");

        txt_FechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FechaNacimientoActionPerformed(evt);
            }
        });

        jLabel12.setText("Edad:");

        jLabel13.setText("N° Cedula:");

        txt_edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_edadActionPerformed(evt);
            }
        });

        txt_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CedulaActionPerformed(evt);
            }
        });

        jLabel14.setText("Domicilio:");

        txt_Domicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DomicilioActionPerformed(evt);
            }
        });

        jLabel15.setText("Ciudad:");

        jLabel16.setText("Sector:");

        jLabel17.setText("Telefono:");

        jLabel18.setText("Celular:");

        jLabel19.setText("Correo Electronico:");

        jLabel20.setText("Barrio del domicilio:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_Domicilio, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txt_Ciudad)
                            .addComponent(txt_NombresApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_FechaNacimiento, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(108, 108, 108))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txt_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(txt_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_Sector, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_Barrio, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_NombresApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txt_Sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txt_Barrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txt_Domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(txt_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel32.setText("Observaciones:");

        txt_Observaciones.setColumns(20);
        txt_Observaciones.setRows(5);
        jScrollPane2.setViewportView(txt_Observaciones);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setText("Presenta Discapacidad:");

        cb_PresentaDisca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel22.setText("Portador del Carnet:");

        cb_PortaCarnet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel23.setText("Tipo de discapacidad:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_PresentaDisca, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_PortaCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(txt_TipoDisca, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cb_PresentaDisca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(cb_PortaCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txt_TipoDisca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setText("                FICHA ÚNICA");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        jLabel31.setText("Motivo de la Consulta:");

        txt_MotivoCons.setColumns(20);
        txt_MotivoCons.setRows(5);
        jScrollPane1.setViewportView(txt_MotivoCons);

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel30.setText("Anotaciones:");

        txt_anotaciones.setColumns(20);
        txt_anotaciones.setRows(5);
        jScrollPane3.setViewportView(txt_anotaciones);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel30))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setText("Institucion Educativa:");

        cb_TipoInst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiscal", "Particular", "Fiscomisional" }));
        cb_TipoInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TipoInstActionPerformed(evt);
            }
        });

        jLabel25.setText("Direccion:");

        jLabel26.setText("Sector:");

        jLabel27.setText("Telefono de la institucion:");

        txt_teleInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleInstActionPerformed(evt);
            }
        });

        jLabel29.setText("Educacion Inclusiva:");

        jLabel33.setText("Año EGB/BGU:");

        cb_Jornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutina", "Vespertina", "Nocturna" }));

        jLabel34.setText("Jornada:");

        jLabel35.setText("Paralelo:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Inst_educa, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_EducaInclusi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(txt_SectorInst, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_Jornada, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_TipoInst, 0, 114, Short.MAX_VALUE)
                    .addComponent(txt_Paralelo)
                    .addComponent(txt_teleInst)
                    .addComponent(txt_AnioCursa))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Inst_educa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel34)
                    .addComponent(cb_Jornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_TipoInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txt_teleInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txt_SectorInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(txt_Paralelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txt_EducaInclusi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(txt_AnioCursa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel28.setText("Nombre del examinador:");
        jLabel28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_examinador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txt_examinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        btn_Guardar.setText("Guardar");
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btn_Guardar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NombresApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombresApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombresApellidosActionPerformed

    private void txt_edadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_edadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_edadActionPerformed

    private void txt_DomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DomicilioActionPerformed

    private void txt_teleInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleInstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teleInstActionPerformed

    private void txt_CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CedulaActionPerformed


    }//GEN-LAST:event_txt_CedulaActionPerformed

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed
        try {
            mysql cc = new mysql("udipsai", "root", "Clases.2023");
            Connection cn = cc.conexion();
            // VALIDACION DE CEDULA 
            String cedula = txt_Cedula.getText();
            if (!validarCedula(cedula)) {
                JOptionPane.showMessageDialog(this, "La cédula ingresada no es válida");

                return;

            }
            PreparedStatement ps = cn.prepareStatement("insert into Paciente (id,fechaApertura,nombresApellidos,ciudad,fechaNacimiento,edad,cedula,domicilio,barrio,telefono,celular,institucionEducativa,tipoInstitucion,"
                    + "sector,jornada,telefonoInstitucion,anioEducacion,paralelo,perteneceInclusion,tieneDiscapacidad,portadorCarnet,diagnostico,motivoConsulta,observaciones,nombreExaminador,anotaciones) values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//hay 26 datos y 25 values ignorando el ID.
            ps.setDate(1, new java.sql.Date(new Date().getTime()));
            ps.setString(2, txt_NombresApellidos.getText());
            ps.setString(3, txt_Ciudad.getText());

            String fechaNacimientoStr = txt_FechaNacimiento.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date fechaNacimientoSql = null;

            try {
                Date fechaNacimiento = sdf.parse(fechaNacimientoStr);
                fechaNacimientoSql = new java.sql.Date(fechaNacimiento.getTime());

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Error de la fecha: " + e.getMessage(), "yyyy-MM-dd", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                ps.setDate(4, fechaNacimientoSql);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al establecer la fecha de nacimiento: " + ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                String edad = txt_edad.getText();
                if (!esNumero(edad)) {
                    throw new IllegalArgumentException("La edad debe ser un valor numérico.");
                }
                ps.setString(5, edad);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de edad", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al establecer el valor de la edad: " + ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            }
            ps.setString(6, txt_Cedula.getText());

            try {
                String domicilio = txt_Domicilio.getText();
                if (domicilio.isEmpty()) {
                    throw new IllegalArgumentException("El campo de domicilio está vacío.");
                }

                ps.setString(7, domicilio);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de domicilio", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al establecer el domicilio: " + ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                String barrio = txt_Barrio.getText();
                if (barrio.isEmpty()) {
                    throw new IllegalArgumentException("El Campo esta vacio.");
                }
                ps.setString(8, barrio);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de Barrio", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al establecer el Barrio: " + ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                String telefono = txt_Telefono.getText();
                if (telefono.isEmpty()) {
                    throw new IllegalArgumentException("El campo de teléfono está vacío.");
                }
                if (!esNumero(telefono)) {
                    throw new IllegalArgumentException("El valor del teléfono debe ser numérico.");

                }
                if (telefono.length() > 7) {
                    throw new IllegalArgumentException("El teléfono debe tener máximo 7 dígitos.");
                }
                ps.setString(9, telefono);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de teléfono", JOptionPane.ERROR_MESSAGE);
            }
            try {
                String celular = txt_Celular.getText();
                if (celular.isEmpty()) {
                    throw new IllegalArgumentException("El campo de celular está vacío.");
                }
                if (!esNumero(celular)) {
                    throw new IllegalArgumentException("El valor del celular debe ser numérico.");
                }
                if (celular.length() != 10) {
                    throw new IllegalArgumentException("El celular debe tener 10 dígitos.");
                }
                ps.setString(10, celular);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de celular", JOptionPane.ERROR_MESSAGE);
            }
            try {
                String institucionEducativa = txt_Inst_educa.getText();
                if (institucionEducativa.isEmpty()) {
                    throw new IllegalArgumentException("El campo de institución educativa está vacío.");
                }
                ps.setString(11, institucionEducativa);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de institución educativa", JOptionPane.ERROR_MESSAGE);
            }
            ps.setString(12, (String) cb_TipoInst.getSelectedItem());
            try {
                String sector = txt_Sector.getText();
                if (sector.isEmpty()) {
                    throw new IllegalArgumentException("El campo de sector está vacío.");
                }
                ps.setString(13, sector);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de sector", JOptionPane.ERROR_MESSAGE);
            }
            ps.setString(14, (String) cb_Jornada.getSelectedItem());
            try {
                String teleInst = txt_teleInst.getText();
                if (teleInst.isEmpty()) {
                    throw new IllegalArgumentException("El campo de teléfono de la institución está vacío.");
                }
                if (!esNumero(teleInst)) {
                    throw new IllegalArgumentException("El valor del teléfono de la institución debe ser numérico.");
                }
                if (!validarTelefono(teleInst)) {
                    throw new IllegalArgumentException("El número de teléfono de la institución no es válido.");
                }
                ps.setString(15, teleInst);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de teléfono de la institución", JOptionPane.ERROR_MESSAGE);
            }
            try {
                String anioCursa = txt_AnioCursa.getText();

                if (anioCursa.isEmpty()) {
                    throw new IllegalArgumentException("El campo de año estudiantil está vacío.");
                }
                ps.setString(16, anioCursa);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de año estudiantil", JOptionPane.ERROR_MESSAGE);
            }
            try {
                String paralelo = txt_Paralelo.getText();

                if (paralelo.isEmpty()) {
                    throw new IllegalArgumentException("El campo de paralelo está vacío.");
                }
                ps.setString(17, paralelo);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de paralelo", JOptionPane.ERROR_MESSAGE);
            }

            try {
                String educacionInclusiva = txt_EducaInclusi.getText();
                if (educacionInclusiva.isEmpty()) {
                    throw new IllegalArgumentException("El Campo Eduacacion Inclusiva está vacío");
                }
                ps.setString(18, educacionInclusiva);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de educacion inclusiva", JOptionPane.ERROR_MESSAGE);
            }
            ps.setString(19, (String) cb_PresentaDisca.getSelectedItem());
            ps.setString(20, (String) cb_PortaCarnet.getSelectedItem());
            try {
                String tipodiscapacidad = txt_TipoDisca.getText();
                if (tipodiscapacidad.isEmpty()) {
                    throw new IllegalArgumentException("El campo de diagnostico está vacío");
                }
                ps.setString(21, tipodiscapacidad);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de diagnostico", JOptionPane.ERROR_MESSAGE);
            }
            try {
                String motivoConsulta = txt_MotivoCons.getText();
                if (motivoConsulta.isEmpty()) {
                    throw new IllegalArgumentException("El campo motivo de consulta está vacío");
                }
                ps.setString(22, motivoConsulta);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de Motivo de consulta", JOptionPane.ERROR_MESSAGE);
            }
            try {
                String observaciones = txt_Observaciones.getText();
                if (observaciones.isEmpty()) {
                    throw new IllegalArgumentException("El campo observaciones está vacío");
                }
                ps.setString(23, observaciones);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de observaciones", JOptionPane.ERROR_MESSAGE);
            }
            try {
                String examinador = txt_examinador.getText();
                if (examinador.isEmpty()) {
                    throw new IllegalArgumentException("El campo examinador está vacío");

                }
                ps.setString(24, examinador);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de examinador", JOptionPane.ERROR_MESSAGE);
            }
            try {
                String anotaciones = txt_anotaciones.getText();

                if (anotaciones.isEmpty()) {
                    throw new IllegalArgumentException("El campo de anotaciones está vacío.");
                }
                ps.setString(25, anotaciones);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de anotaciones", JOptionPane.ERROR_MESSAGE);
            }
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            LimpiarCampos();
        } catch (SQLException ex) {
            Logger.getLogger(FichaUnica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void txt_FechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaNacimientoActionPerformed

    private void cb_TipoInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TipoInstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_TipoInstActionPerformed
    private boolean validarCedula(String cedula) {
        if (cedula.length() != 10) {
            return false;
        }

        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int suma = 0;

        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i));
            int resultado = digito * coeficientes[i];
            suma += (resultado < 10) ? resultado : resultado - 9;
        }

        int ultimoDigitoCalculado = (suma % 10 != 0) ? 10 - (suma % 10) : 0;
        int ultimoDigitoCedula = Character.getNumericValue(cedula.charAt(9));

        return ultimoDigitoCalculado == ultimoDigitoCedula;
    }

    private boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validarTelefono(String telefono) {
        //verificar el formato del número de teléfono
        String patron = "^\\d{7,10}$";
        // Crear un objeto Pattern con la expresión regular
        Pattern pattern = Pattern.compile(patron);
        // Crear un objeto Matcher para hacer coincidir el número de teléfono con el patrón
        Matcher matcher = pattern.matcher(telefono);
        // Verificar si hay una coincidencia entre el número de teléfono y el patrón
        return matcher.matches();
    }
    private void LimpiarCampos() {
    // Limpiar los campos de texto
    // fechaApertura,nombresApellidos,ciudad,fechaNacimiento,edad,cedula,domicilio,barrio,telefono,celular,institucionEducativa,tipoInstitucion,"
    // + "sector,jornada,telefonoInstitucion,anioEducacion,paralelo,perteneceInclusion,tieneDiscapacidad,portadorCarnet,diagnostico,motivoConsulta,observaciones,nombreExaminador,anotaciones)
    txt_Cedula.setText("");
    txt_NombresApellidos.setText("");
    txt_Ciudad.setText("");
    txt_FechaNacimiento.setText("");
    txt_edad.setText("");
    txt_Cedula.setText("");
    txt_Domicilio.setText("");
    txt_Barrio.setText("");
    txt_Telefono.setText("");
    txt_Celular.setText("");
    txt_Inst_educa.setText("");
    txt_Sector.setText("");
    txt_teleInst.setText("");
    txt_AnioCursa.setText("");
    txt_Paralelo.setText("");
    txt_EducaInclusi.setText("");
    txt_TipoDisca.setText("");
    txt_MotivoCons.setText("");
    txt_Observaciones.setText("");
    txt_examinador.setText("");
    txt_anotaciones.setText("");
    txt_Correo.setText("");
    
}

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
            java.util.logging.Logger.getLogger(FichaUnica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaUnica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaUnica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaUnica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaUnica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btn_Guardar;
    private javax.swing.JComboBox<String> cb_Jornada;
    private javax.swing.JComboBox<String> cb_PortaCarnet;
    private javax.swing.JComboBox<String> cb_PresentaDisca;
    private javax.swing.JComboBox<String> cb_TipoInst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txt_AnioCursa;
    private javax.swing.JTextField txt_Barrio;
    private javax.swing.JTextField txt_Cedula;
    private javax.swing.JTextField txt_Celular;
    private javax.swing.JTextField txt_Ciudad;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Direccion;
    private javax.swing.JTextField txt_Domicilio;
    private javax.swing.JTextField txt_EducaInclusi;
    private javax.swing.JTextField txt_FechaNacimiento;
    private javax.swing.JTextField txt_Inst_educa;
    private javax.swing.JTextArea txt_MotivoCons;
    private javax.swing.JTextField txt_NombresApellidos;
    private javax.swing.JTextArea txt_Observaciones;
    private javax.swing.JTextField txt_Paralelo;
    private javax.swing.JTextField txt_Sector;
    private javax.swing.JTextField txt_SectorInst;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JTextField txt_TipoDisca;
    private javax.swing.JTextArea txt_anotaciones;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_examinador;
    private javax.swing.JTextField txt_teleInst;
    // End of variables declaration//GEN-END:variables
}
