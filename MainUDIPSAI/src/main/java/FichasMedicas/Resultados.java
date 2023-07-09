/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FichasMedicas;

import Seguimiento.presentacion.SeguimientoPaciente;
import Tests.presentacion.AgregarTest;
import asignaciones.Asignar_Paciente;
import comons.negocio.Especialista;
import comons.negocio.Paciente;
import configReader.ConfigReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Resultados extends javax.swing.JFrame {

    Paciente paciente;
    Especialista especialista;
    /**
     * Creates new form Resultados
     */
    public Resultados(Paciente paciente, Especialista especialista) {
        this.especialista=especialista;
        this.paciente = paciente;
        initComponents();
        Connection con = null;

        try {
            con = conexion();

            ps = con.prepareStatement("SELECT * FROM datos_personales WHERE idPaciente=?");
            ps.setString(1, Integer.toString(paciente.id));

            rs = ps.executeQuery();

            if (rs.next()) {
                txtIdPaciente.setText(rs.getString("idPaciente"));
                txtIdEspecialista.setText(rs.getString("idEspecialista"));
                txtLugarNacimiento.setText(rs.getString("lugarNacimiento"));
                txtCorreo.setText(rs.getString("correoElectronico"));
                txtGrado.setText(rs.getString("grado"));
                txtFuenteInformacion.setText(rs.getString("fuenteInformacion"));
                txtMotivo.setText(rs.getString("motivo"));
                txtEspecialidad.setText(rs.getString("especialidad"));
                txtAntecedentesMedicos.setText(rs.getString("antecedentesMedicos"));
                txtAntecentesFamiliares.setText(rs.getString("antecedentesFamiliares"));
                txtContactoEmergencia.setText(rs.getString("contactoEmergencia"));
                txtDireccion.setText(rs.getString("direccion"));
                txtConsumoMedicamentos.setText(rs.getString("consumoMedicamentosSustancias"));
                txtEnfermedadesMadre.setText(rs.getString("enfermedadesMadre"));
                txtControlEsfinteres.setText(rs.getString("controlDeEsfinteres"));
                txtEstadoEmocional.setText(rs.getString("estadoEmocional"));
                txtFormulacionL.setText(rs.getString("formulacionLinguisticaCompleta"));
                txtPeso.setText(rs.getString("peso"));
                txtTalla.setText(rs.getString("talla"));
                txtNumeroPalabras.setText(rs.getString("numeroTotalDePalabras"));
                txtMalFormacion.setText(rs.getString("malformacionCongenita"));
                txtProblemasAlimentacion.setText(rs.getString("problemasAlimentacion"));
                txtCefalico.setText(rs.getString("controlCefalico"));
                txtTiempo.setText(rs.getString("tiempo"));
                txtCausa.setText(rs.getString("causa"));
                txtCaminaApoyo.setText(rs.getString("caminaConApoyo"));
                txtSedestacion.setText(rs.getString("sedestacion"));
                txtBipedestacion.setText(rs.getString("bipedestacion"));

                txtCaminaSolo.setText(rs.getString("caminaSolo"));
                txtSubeEscaleras.setText(rs.getString("subeEscaleras"));

                txtBalbuceo.setText(rs.getString("balbuceo"));
                txtVocalizacion.setText(rs.getString("vocalizacion"));
                txtJuegoVocal.setText(rs.getString("juegovocal"));
                txtSilabeo.setText(rs.getString("silabeo"));
                txtPrimerasPalabras.setText(rs.getString("primerasPalabras"));
                txtOraciones.setText(rs.getString("oraciones"));

                txtTipoAntecedente.setText(rs.getString("tipoAntecedente"));
                txtDescripcion.setText(rs.getString("descripcion"));

                cmbDiscapacidad.setSelectedItem(rs.getString("discapacidad"));
                cmbEmbarazoDeseado.setSelectedItem(rs.getString("embarazoDeseado"));
                cmbControlEmbarazo.setSelectedItem(rs.getString("controlEmbarazo"));
                cmbAborto.setSelectedItem(rs.getString("amenazaAborto"));
                cmbDuracionEmbarazo.setSelectedItem(rs.getString("duracionEmbarazo"));
                cmbTipoParto.setSelectedItem(rs.getString("tipoParto"));
                cmbLloro.setSelectedItem(rs.getString("lloroAlNacer"));
                cmbPresento.setSelectedItem(rs.getString("presento"));
                cmbComplicaionesParto.setSelectedItem(rs.getString("complicacionesEnElParto"));
                cmbIncubadora.setSelectedItem(rs.getString("incubadora"));
                cmbVacunacion.setSelectedItem(rs.getString("esquemaVacunacionCompleto"));

                // Cargar el valor del ComboBox1
                String valorComboBox1 = rs.getString("discapacidad");
                if (valorComboBox1 != null) {
                    switch (valorComboBox1) {
                        case "Si":
                            cmbDiscapacidad.setSelectedItem("Si");
                            break;
                        case "No":
                            cmbDiscapacidad.setSelectedItem("No");
                            break;
                        default:
                            cmbDiscapacidad.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbDiscapacidad.setSelectedItem(null);
                }

                // Cargar el valor del ComboBox2
                String valorComboBox2 = rs.getString("embarazoDeseado");
                if (valorComboBox2 != null) {
                    switch (valorComboBox2) {
                        case "Si":
                            cmbEmbarazoDeseado.setSelectedItem("Si");
                            break;
                        case "No":
                            cmbEmbarazoDeseado.setSelectedItem("No");
                            break;
                        default:
                            cmbEmbarazoDeseado.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbEmbarazoDeseado.setSelectedItem(null);
                }

                // Cargar el valor del ComboBox3
                String valorComboBox3 = rs.getString("controlEmbarazo");
                if (valorComboBox3 != null) {
                    switch (valorComboBox3) {
                        case "Si":
                            cmbControlEmbarazo.setSelectedItem("Si");
                            break;
                        case "No":
                            cmbControlEmbarazo.setSelectedItem("No");
                            break;
                        default:
                            cmbControlEmbarazo.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbControlEmbarazo.setSelectedItem(null);
                }

                // Cargar el valor del ComboBox4
                String valorComboBox4 = rs.getString("amenazaAborto");
                if (valorComboBox4 != null) {
                    switch (valorComboBox4) {
                        case "Si":
                            cmbAborto.setSelectedItem("Si");
                            break;
                        case "No":
                            cmbAborto.setSelectedItem("No");
                            break;
                        default:
                            cmbAborto.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbAborto.setSelectedItem(null);
                }
                String valorComboBox5 = rs.getString("duracionEmbarazo");
                if (valorComboBox5 != null) {
                    switch (valorComboBox5) {
                        case "A termino":
                            cmbDuracionEmbarazo.setSelectedItem("A termino");
                            break;
                        case "Pre termino":
                            cmbDuracionEmbarazo.setSelectedItem("Pre termino");
                            break;
                        case "Postermico":
                            cmbDuracionEmbarazo.setSelectedItem("Postermico");
                            break;
                        default:
                            cmbDuracionEmbarazo.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbDuracionEmbarazo.setSelectedItem(null);
                }
                String valorComboBox6 = rs.getString("tipoParto");
                if (valorComboBox6 != null) {
                    switch (valorComboBox6) {
                        case "Inducido":
                            cmbTipoParto.setSelectedItem("Inducido");
                            break;
                        case "Eutocico":
                            cmbTipoParto.setSelectedItem("Eutocico");
                            break;
                        case "Distocico":
                            cmbTipoParto.setSelectedItem("Distocico");
                            break;
                        default:
                            cmbTipoParto.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbTipoParto.setSelectedItem(null);
                }
                String valorComboBox8 = rs.getString("presento");
                if (valorComboBox8 != null) {
                    switch (valorComboBox8) {
                        case "Anoxia":
                            cmbPresento.setSelectedItem("Anoxia");
                            break;
                        case "Hipoxia":
                            cmbPresento.setSelectedItem("Hipoxia");
                            break;
                        case "Ictericia":
                            cmbPresento.setSelectedItem("Ictericia");
                            break;
                        case "Cianosis":
                            cmbPresento.setSelectedItem("Cianosis");
                            break;
                        default:
                            cmbPresento.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbPresento.setSelectedItem(null);
                }
                String valorComboBox7 = rs.getString("lloroAlNacer");
                if (valorComboBox7 != null) {
                    switch (valorComboBox7) {
                        case "Si":
                            cmbLloro.setSelectedItem("Si");
                            break;
                        case "No":
                            cmbLloro.setSelectedItem("No");
                            break;
                        default:
                            cmbLloro.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbLloro.setSelectedItem(null);
                }
                String valorComboBox9 = rs.getString("complicacionesEnElParto");
                if (valorComboBox9 != null) {
                    switch (valorComboBox9) {
                        case "Si":
                            cmbComplicaionesParto.setSelectedItem("Si");
                            break;
                        case "No":
                            cmbComplicaionesParto.setSelectedItem("No");
                            break;
                        default:
                            cmbComplicaionesParto.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbComplicaionesParto.setSelectedItem(null);
                }
                String valorComboBox10 = rs.getString("incubadora");
                if (valorComboBox10 != null) {
                    switch (valorComboBox10) {
                        case "Si":
                            cmbIncubadora.setSelectedItem("Si");
                            break;
                        case "No":
                            cmbIncubadora.setSelectedItem("No");
                            break;
                        default:
                            cmbIncubadora.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbIncubadora.setSelectedItem(null);
                }
                String valorComboBox11 = rs.getString("esquemaVacunacionCompleto");
                if (valorComboBox11 != null) {
                    switch (valorComboBox11) {
                        case "Si":
                            cmbVacunacion.setSelectedItem("Si");
                            break;
                        case "No":
                            cmbVacunacion.setSelectedItem("No");
                            break;
                        default:
                            cmbVacunacion.setSelectedItem(null);
                            break;
                    }
                } else {
                    cmbVacunacion.setSelectedItem(null);
                }
            } else {
                txtIdPaciente.setText(Integer.toString(paciente.id));
                JOptionPane.showMessageDialog(null, "No existe un paciente con ese número de cédula/ficha");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Asignar_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Resultados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        txtProblemasAlimentacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtTalla = new javax.swing.JTextField();
        txtMalFormacion = new javax.swing.JTextField();
        txtTiempo = new javax.swing.JTextField();
        txtEspecialidad = new javax.swing.JTextField();
        txtAntecedentesMedicos = new javax.swing.JTextField();
        txtAntecentesFamiliares = new javax.swing.JTextField();
        txtContactoEmergencia = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdEspecialista = new javax.swing.JTextField();
        txtEstadoEmocional = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        txtFuenteInformacion = new javax.swing.JTextField();
        txtEnfermedadesMadre = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtConsumoMedicamentos = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtIdPaciente = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        cmbDiscapacidad = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        cmbEmbarazoDeseado = new javax.swing.JComboBox<>();
        cmbControlEmbarazo = new javax.swing.JComboBox<>();
        cmbAborto = new javax.swing.JComboBox<>();
        cmbDuracionEmbarazo = new javax.swing.JComboBox<>();
        cmbTipoParto = new javax.swing.JComboBox<>();
        cmbLloro = new javax.swing.JComboBox<>();
        cmbPresento = new javax.swing.JComboBox<>();
        cmbComplicaionesParto = new javax.swing.JComboBox<>();
        cmbIncubadora = new javax.swing.JComboBox<>();
        txtCausa = new javax.swing.JTextField();
        cmbVacunacion = new javax.swing.JComboBox<>();
        txtCefalico = new javax.swing.JTextField();
        txtSedestacion = new javax.swing.JTextField();
        txtBipedestacion = new javax.swing.JTextField();
        txtCaminaApoyo = new javax.swing.JTextField();
        txtCaminaSolo = new javax.swing.JTextField();
        txtSubeEscaleras = new javax.swing.JTextField();
        txtControlEsfinteres = new javax.swing.JTextField();
        txtSilabeo = new javax.swing.JTextField();
        txtVocalizacion = new javax.swing.JTextField();
        txtJuegoVocal = new javax.swing.JTextField();
        txtBalbuceo = new javax.swing.JTextField();
        txtPrimerasPalabras = new javax.swing.JTextField();
        txtOraciones = new javax.swing.JTextField();
        txtFormulacionL = new javax.swing.JTextField();
        txtNumeroPalabras = new javax.swing.JTextField();
        txtTipoAntecedente = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtLugarNacimiento = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Fuente de  información: ");

        jLabel5.setText("Motivo:");

        jLabel26.setText("Peso: ");

        jLabel6.setText("Especialidad:");

        jLabel7.setText("Antecedentes médicos: ");

        jLabel8.setText("Antecedentes familiares:");

        jLabel9.setText("Contacto de emergencia:");

        jLabel10.setText("Correo electrónico: ");

        jLabel11.setText("Embarazo deseado: ");

        jLabel12.setText("Control embarazo: ");

        jLabel13.setText("Amenaza de aborto: ");

        jLabel14.setText("Estado emocional: ");

        jLabel15.setText("Duración del embarazo: ");

        jLabel16.setText("Tipo de parto: ");

        jLabel17.setText("Lloro al nacer:");

        jLabel18.setText("Talla:");

        jLabel19.setText("Consumo de medicamentos: ");

        jLabel20.setText("Presentó:");

        jLabel21.setText("Mal formación  congénita:");

        jLabel22.setText("Problemas de alimentación: ");

        jLabel25.setText("Id");

        jLabel24.setText("Dirección: ");

        jLabel1.setText("Lugar de nacimiento:");

        jLabel2.setText("Discapacidad: ");

        jLabel3.setText("Grado:");

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        jLabel23.setText("Enfermedades de la madre: ");

        txtConsumoMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsumoMedicamentosActionPerformed(evt);
            }
        });

        jLabel27.setText("IdEspecialista:");

        jLabel28.setText("Causa:");

        jLabel29.setText("Esquema de vacunacion completa: ");

        jLabel30.setText("Control cefalico: ");

        jLabel31.setText("Oraciones: ");

        jLabel32.setText("Formulacion lingüística completa: ");

        jLabel33.setText("Numero total de palabras: ");

        jLabel34.setText("Tipo de antecedente: ");

        jLabel35.setText("Descripcion: ");

        jLabel36.setText("Primeras palabras: ");

        jLabel37.setText("Silabeo: ");

        jLabel38.setText("Juego vocal: ");

        jLabel39.setText("Vocalizacion: ");

        jLabel40.setText("Balbuceo:");

        jLabel41.setText("Control de esfinteres: ");

        jLabel42.setText("Tiempo:");

        jLabel43.setText("Incubadora:");

        jLabel44.setText("Compliaciones en el parto: ");

        jLabel45.setText("Sedestacion: ");

        jLabel46.setText("Bipedestacion: ");

        jLabel47.setText("Camina con apoyo:");

        jLabel48.setText("Camina solo: ");

        jLabel49.setText("Sube escaleras: ");

        cmbDiscapacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", " " }));

        cmbEmbarazoDeseado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No", " " }));

        cmbControlEmbarazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        cmbAborto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        cmbDuracionEmbarazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A termino ", "Pre termino", "Postermico", " " }));

        cmbTipoParto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inducido", "Eutocico", "Distocico" }));

        cmbLloro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        cmbPresento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anoxia", "Hipoxia", "Ictericia", "Cianosis", "" }));

        cmbComplicaionesParto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        cmbIncubadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        txtCausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCausaActionPerformed(evt);
            }
        });

        cmbVacunacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jMenu1.setText("Menu");

        jMenu2.setText("Historias");

        jMenuItem2.setText("Fonoaudiologia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Psicología Clinica");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Psicología Educativa");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenu1.add(jMenu2);

        jMenuItem5.setText("Actualizar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Tests");

        jMenuItem1.setText("Abrir Tests");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Seguimiento");

        jMenuItem6.setText("Seguimientos del paciente");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3)
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAntecedentesMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtAntecentesFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtContactoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cmbControlEmbarazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbEmbarazoDeseado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(60, 60, 60)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFuenteInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbDiscapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMalFormacion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtProblemasAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEnfermedadesMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel19)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtConsumoMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addGap(20, 20, 20)
                                                            .addComponent(jLabel39)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(txtVocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addGap(6, 6, 6)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                            .addGap(25, 25, 25)
                                                                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(45, 45, 45)
                                                                    .addComponent(txtBalbuceo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(txtControlEsfinteres, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtCefalico, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel45)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtSedestacion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel46)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtBipedestacion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtCaminaApoyo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCaminaSolo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtSubeEscaleras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel29)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbVacunacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtJuegoVocal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbComplicaionesParto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbAborto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel26)
                                                    .addComponent(jLabel18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel16)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel20)
                                                            .addComponent(jLabel17))))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtEstadoEmocional, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cmbDuracionEmbarazo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(txtTalla))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(88, 88, 88)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel43)
                                                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(txtCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cmbIncubadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(txtSilabeo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(58, 58, 58)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabel36))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(txtPrimerasPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(txtOraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(cmbPresento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cmbLloro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(cmbTipoParto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(33, 33, 33)
                                                                .addComponent(jLabel32)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtFormulacionL, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtNumeroPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtTipoAntecedente, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel10)))
                .addGap(133, 133, 133))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(jLabel24)
                        .addComponent(jLabel9)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4))
                    .addContainerGap(930, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtLugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cmbDiscapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFuenteInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(cmbAborto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtEstadoEmocional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(cmbDuracionEmbarazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel42)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel28)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel37))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbIncubadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(txtCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(txtSilabeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel36)
                                .addComponent(txtPrimerasPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(txtOraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cmbTipoParto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtFormulacionL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAntecedentesMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAntecentesFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContactoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbEmbarazoDeseado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmbControlEmbarazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1045, 1045, 1045))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cmbLloro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(txtNumeroPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cmbPresento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(txtTipoAntecedente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtMalFormacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtProblemasAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(txtEnfermedadesMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtConsumoMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(txtControlEsfinteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVocalizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel44)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtBalbuceo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(txtJuegoVocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbComplicaionesParto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbVacunacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(txtCefalico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel45)
                                    .addComponent(txtSedestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel46)
                                    .addComponent(txtBipedestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addComponent(txtCaminaApoyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48)
                                    .addComponent(txtCaminaSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel49)
                                    .addComponent(txtSubeEscaleras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(jLabel4)
                    .addGap(28, 28, 28)
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel6)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel7)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel8)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel9)
                    .addGap(24, 24, 24)
                    .addComponent(jLabel24)
                    .addGap(125, 1213, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:

        Fonoaudilogia f = new Fonoaudilogia(paciente);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtConsumoMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsumoMedicamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsumoMedicamentosActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed

    private void txtCausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCausaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCausaActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        // Dentro del ActionListener del botón
        try {
            Connection con = conexion();

            // Verificar si el paciente ya tiene un registro en la tabla datos_personales
            String consulta = "SELECT * FROM datos_personales WHERE idPaciente = ?";
            PreparedStatement psVerificar = con.prepareStatement(consulta);
            psVerificar.setString(1, txtIdPaciente.getText());
            ResultSet rsVerificar = psVerificar.executeQuery();

            if (rsVerificar.next()) {
                // El paciente ya tiene un registro, por lo que se realizará una actualización

                // Preparar la consulta de actualización
                String updateQuery = "UPDATE datos_personales SET "
                        + "idEspecialista=?, lugarNacimiento=?, correoElectronico=?, grado=?, "
                        + "fuenteInformacion=?, motivo=?, especialidad=?, antecedentesMedicos=?, antecedentesFamiliares=?, "
                        + "contactoEmergencia=?, direccion=?, consumoMedicamentosSustancias=?, enfermedadesMadre=?, "
                        + "controlDeEsfinteres=?, estadoEmocional=?, formulacionLinguisticaCompleta=?, peso=?, "
                        + "talla=?, numeroTotalDePalabras=?, malformacionCongenita=?, problemasAlimentacion=?, "
                        + "controlCefalico=?, tiempo=?, causa=?, caminaConApoyo=?, sedestacion=?, bipedestacion=?, "
                        + "caminaSolo=?, subeEscaleras=?, balbuceo=?, vocalizacion=?, juegovocal=?, silabeo=?, "
                        + "primerasPalabras=?, oraciones=?, tipoAntecedente=?, descripcion=?, discapacidad=?, "
                        + "embarazoDeseado=?, controlEmbarazo=?, amenazaAborto=?, duracionEmbarazo=?, tipoParto=?, "
                        + "lloroAlNacer=?, presento=?, complicacionesEnElParto=?, incubadora=?, "
                        + "esquemaVacunacionCompleto=? WHERE idPaciente=?";

                PreparedStatement psActualizar = con.prepareStatement(updateQuery);

                // Asignar los valores de los campos a los parámetros de la consulta de actualización
                psActualizar.setString(1, txtIdEspecialista.getText());
                psActualizar.setString(2, txtLugarNacimiento.getText());
                psActualizar.setString(3, txtCorreo.getText());
                psActualizar.setString(4, txtGrado.getText());
                psActualizar.setString(5, txtFuenteInformacion.getText());
                psActualizar.setString(6, txtMotivo.getText());
                psActualizar.setString(7, txtEspecialidad.getText());
                psActualizar.setString(8, txtAntecedentesMedicos.getText());
                psActualizar.setString(9, txtAntecentesFamiliares.getText());
                psActualizar.setString(10, txtContactoEmergencia.getText());
                psActualizar.setString(11, txtDireccion.getText());
                psActualizar.setString(12, txtConsumoMedicamentos.getText());
                psActualizar.setString(13, txtEnfermedadesMadre.getText());
                psActualizar.setString(14, txtControlEsfinteres.getText());
                psActualizar.setString(15, txtEstadoEmocional.getText());
                psActualizar.setString(16, txtFormulacionL.getText());
                psActualizar.setString(17, txtPeso.getText());
                psActualizar.setString(18, txtTalla.getText());
                psActualizar.setString(19, txtNumeroPalabras.getText());
                psActualizar.setString(20, txtMalFormacion.getText());
                psActualizar.setString(21, txtProblemasAlimentacion.getText());
                psActualizar.setString(22, txtCefalico.getText());
                psActualizar.setString(23, txtTiempo.getText());
                psActualizar.setString(24, txtCausa.getText());
                psActualizar.setString(25, txtCaminaApoyo.getText());
                psActualizar.setString(26, txtSedestacion.getText());
                psActualizar.setString(27, txtBipedestacion.getText());
                psActualizar.setString(28, txtCaminaSolo.getText());
                psActualizar.setString(29, txtSubeEscaleras.getText());
                psActualizar.setString(30, txtBalbuceo.getText());
                psActualizar.setString(31, txtVocalizacion.getText());
                psActualizar.setString(32, txtJuegoVocal.getText());
                psActualizar.setString(33, txtSilabeo.getText());
                psActualizar.setString(34, txtPrimerasPalabras.getText());
                psActualizar.setString(35, txtOraciones.getText());
                psActualizar.setString(36, txtTipoAntecedente.getText());
                psActualizar.setString(37, txtDescripcion.getText());
                psActualizar.setString(38, cmbDiscapacidad.getSelectedItem().toString());
                psActualizar.setString(39, cmbEmbarazoDeseado.getSelectedItem().toString());
                psActualizar.setString(40, cmbControlEmbarazo.getSelectedItem().toString());
                psActualizar.setString(41, cmbAborto.getSelectedItem().toString());
                psActualizar.setString(42, cmbDuracionEmbarazo.getSelectedItem().toString());
                psActualizar.setString(43, cmbTipoParto.getSelectedItem().toString());
                psActualizar.setString(44, cmbLloro.getSelectedItem().toString());
                psActualizar.setString(45, cmbPresento.getSelectedItem().toString());
                psActualizar.setString(46, cmbComplicaionesParto.getSelectedItem().toString());
                psActualizar.setString(47, cmbIncubadora.getSelectedItem().toString());
                psActualizar.setString(48, cmbVacunacion.getSelectedItem().toString());
                psActualizar.setString(49, txtIdPaciente.getText()); // ID del paciente para la cláusula WHERE

                int resultado = psActualizar.executeUpdate();

                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos.");
                }

                psActualizar.close();
            } else {
                // El paciente no tiene un registro en la tabla datos_personales, por lo que se realizará una inserción

                // Preparar la consulta de inserción
                String insertQuery = "INSERT INTO datos_personales (idEspecialista, lugarNacimiento, correoElectronico, grado, fuenteInformacion, motivo, especialidad, antecedentesMedicos, antecedentesFamiliares, contactoEmergencia, direccion, consumoMedicamentosSustancias, enfermedadesMadre, controlDeEsfinteres, estadoEmocional, formulacionLinguisticaCompleta, peso, talla, numeroTotalDePalabras, malformacionCongenita, problemasAlimentacion, controlCefalico, tiempo, causa, caminaConApoyo, sedestacion, bipedestacion, caminaSolo, subeEscaleras, balbuceo, vocalizacion, juegovocal, silabeo, primerasPalabras, oraciones, tipoAntecedente, descripcion, discapacidad, embarazoDeseado, controlEmbarazo, amenazaAborto, duracionEmbarazo, tipoParto, lloroAlNacer, presento, complicacionesEnElParto, incubadora, esquemaVacunacionCompleto, idPaciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";

                PreparedStatement psInsertar = con.prepareStatement(insertQuery);

// Asignar los valores de los campos a los parámetros de la consulta de inserción
                psInsertar.setString(1, txtIdEspecialista.getText());
                psInsertar.setString(2, txtLugarNacimiento.getText());
                psInsertar.setString(3, txtCorreo.getText());
                psInsertar.setString(4, txtGrado.getText());
                psInsertar.setString(5, txtFuenteInformacion.getText());
                psInsertar.setString(6, txtMotivo.getText());
                psInsertar.setString(7, txtEspecialidad.getText());
                psInsertar.setString(8, txtAntecedentesMedicos.getText());
                psInsertar.setString(9, txtAntecentesFamiliares.getText());
                psInsertar.setString(10, txtContactoEmergencia.getText());
                psInsertar.setString(11, txtDireccion.getText());
                psInsertar.setString(12, txtConsumoMedicamentos.getText());
                psInsertar.setString(13, txtEnfermedadesMadre.getText());
                psInsertar.setString(14, txtControlEsfinteres.getText());
                psInsertar.setString(15, txtEstadoEmocional.getText());
                psInsertar.setString(16, txtFormulacionL.getText());
                psInsertar.setString(17, txtPeso.getText());
                psInsertar.setString(18, txtTalla.getText());
                psInsertar.setString(19, txtNumeroPalabras.getText());
                psInsertar.setString(20, txtMalFormacion.getText());
                psInsertar.setString(21, txtProblemasAlimentacion.getText());
                psInsertar.setString(22, txtCefalico.getText());
                psInsertar.setString(23, txtTiempo.getText());
                psInsertar.setString(24, txtCausa.getText());
                psInsertar.setString(25, txtCaminaApoyo.getText());
                psInsertar.setString(26, txtSedestacion.getText());
                psInsertar.setString(27, txtBipedestacion.getText());
                psInsertar.setString(28, txtCaminaSolo.getText());
                psInsertar.setString(29, txtSubeEscaleras.getText());
                psInsertar.setString(30, txtBalbuceo.getText());
                psInsertar.setString(31, txtVocalizacion.getText());
                psInsertar.setString(32, txtJuegoVocal.getText());
                psInsertar.setString(33, txtSilabeo.getText());
                psInsertar.setString(34, txtPrimerasPalabras.getText());
                psInsertar.setString(35, txtOraciones.getText());
                psInsertar.setString(36, txtTipoAntecedente.getText());
                psInsertar.setString(37, txtDescripcion.getText());
                psInsertar.setString(38, cmbDiscapacidad.getSelectedItem().toString());
                psInsertar.setString(39, cmbEmbarazoDeseado.getSelectedItem().toString());
                psInsertar.setString(40, cmbControlEmbarazo.getSelectedItem().toString());
                psInsertar.setString(41, cmbAborto.getSelectedItem().toString());
                psInsertar.setString(42, cmbDuracionEmbarazo.getSelectedItem().toString());
                psInsertar.setString(43, cmbTipoParto.getSelectedItem().toString());
                psInsertar.setString(44, cmbLloro.getSelectedItem().toString());
                psInsertar.setString(45, cmbPresento.getSelectedItem().toString());
                psInsertar.setString(46, cmbComplicaionesParto.getSelectedItem().toString());
                psInsertar.setString(47, cmbIncubadora.getSelectedItem().toString());
                psInsertar.setString(48, cmbVacunacion.getSelectedItem().toString());
                psInsertar.setString(49, txtIdPaciente.getText());

                int resultado = psInsertar.executeUpdate();
                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Los datos se insertaron correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al insertar los datos.");
                }

                psInsertar.close();
            }

            rsVerificar.close();
            psVerificar.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
         PiscologiaClinica f = new PiscologiaClinica(paciente);
         f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        PiscologiaEducativa f = new PiscologiaEducativa(paciente);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
          AgregarTest tests = new AgregarTest(this.especialista, paciente);
        tests.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Establecer acción de cierre
        tests.setVisible(true); // Mostrar el JFrame NuevoFrame
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
         SeguimientoPaciente seguimientos = new SeguimientoPaciente(this.especialista, paciente);
        seguimientos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Establecer acción de cierre
        seguimientos.setVisible(true); // Mostrar el JFrame NuevoFrame
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    ConfigReader configReader=new ConfigReader();
    public String url = "jdbc:mysql://"+configReader.getIp()+":3306/"+configReader.getDatabase();
    public String usuario = configReader.getUser();
    public String contrasena = configReader.getPass();//Preguntar
    PreparedStatement ps;
    ResultSet rs;

    public Connection conexion() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, usuario, contrasena);

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
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
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultados().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAborto;
    private javax.swing.JComboBox<String> cmbComplicaionesParto;
    private javax.swing.JComboBox<String> cmbControlEmbarazo;
    private javax.swing.JComboBox<String> cmbDiscapacidad;
    private javax.swing.JComboBox<String> cmbDuracionEmbarazo;
    private javax.swing.JComboBox<String> cmbEmbarazoDeseado;
    private javax.swing.JComboBox<String> cmbIncubadora;
    private javax.swing.JComboBox<String> cmbLloro;
    private javax.swing.JComboBox<String> cmbPresento;
    private javax.swing.JComboBox<String> cmbTipoParto;
    private javax.swing.JComboBox<String> cmbVacunacion;
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JTextField txtAntecedentesMedicos;
    private javax.swing.JTextField txtAntecentesFamiliares;
    private javax.swing.JTextField txtBalbuceo;
    private javax.swing.JTextField txtBipedestacion;
    private javax.swing.JTextField txtCaminaApoyo;
    private javax.swing.JTextField txtCaminaSolo;
    private javax.swing.JTextField txtCausa;
    private javax.swing.JTextField txtCefalico;
    private javax.swing.JTextField txtConsumoMedicamentos;
    private javax.swing.JTextField txtContactoEmergencia;
    private javax.swing.JTextField txtControlEsfinteres;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEnfermedadesMadre;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtEstadoEmocional;
    private javax.swing.JTextField txtFormulacionL;
    private javax.swing.JTextField txtFuenteInformacion;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtIdEspecialista;
    private javax.swing.JTextField txtIdPaciente;
    private javax.swing.JTextField txtJuegoVocal;
    private javax.swing.JTextField txtLugarNacimiento;
    private javax.swing.JTextField txtMalFormacion;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtNumeroPalabras;
    private javax.swing.JTextField txtOraciones;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPrimerasPalabras;
    private javax.swing.JTextField txtProblemasAlimentacion;
    private javax.swing.JTextField txtSedestacion;
    private javax.swing.JTextField txtSilabeo;
    private javax.swing.JTextField txtSubeEscaleras;
    private javax.swing.JTextField txtTalla;
    private javax.swing.JTextField txtTiempo;
    private javax.swing.JTextField txtTipoAntecedente;
    private javax.swing.JTextField txtVocalizacion;
    // End of variables declaration//GEN-END:variables
}
