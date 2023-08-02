/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FichasMedicas;

import Seguimiento.presentacion.SeguimientoPaciente;
import Tests.presentacion.AgregarTest;
import asignaciones.Asignar_Paciente;
import comons.negocio.Especialista;
import ReportesFonoaudiologia.*;
import ReportesPersonales.*;
import ReportesClinicas.*;
import ReportesEducativos.*;
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
        this.especialista = especialista;
        this.paciente = paciente;
        initComponents();
        Connection con = null;
        System.err.println("" + paciente.id + "" + paciente.nombresApellidos);

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
        jPanel2 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
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
        menuInformes = new javax.swing.JMenu();
        itemFonoaudiologia = new javax.swing.JMenuItem();
        itemPsicologiaClinica = new javax.swing.JMenuItem();
        itemPsicologiaEducativa = new javax.swing.JMenuItem();
        itemResultados = new javax.swing.JMenuItem();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Fuente de  información: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Motivo:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Peso: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Especialidad:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Antecedentes médicos: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Antecedentes familiares:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Contacto de emergencia:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Correo electrónico: ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Embarazo deseado: ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Control embarazo: ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Amenaza de aborto: ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Estado emocional: ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Duración del embarazo: ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Tipo de parto: ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Lloro al nacer:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Talla:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Consumo de medicamentos: ");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Presentó:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Mal formación  congénita:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Problemas de alimentación: ");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("# de Ficha:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Dirección: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Lugar de nacimiento:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Discapacidad: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Grado:");

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Enfermedades de la madre: ");

        txtConsumoMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsumoMedicamentosActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Cédula del especialista:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("Causa:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("Esquema de vacunacion completa: ");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Control cefalico: ");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("Oraciones: ");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("Formulacion lingüística completa: ");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setText("Numero total de palabras: ");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setText("Tipo de antecedente: ");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Descripcion: ");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Primeras palabras: ");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setText("Silabeo: ");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Juego vocal: ");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Vocalizacion: ");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Balbuceo:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setText("Control de esfinteres: ");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setText("Tiempo:");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setText("Incubadora:");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setText("Compliaciones en el parto: ");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setText("Sedestacion: ");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setText("Bipedestacion: ");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setText("Camina con apoyo:");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setText("Camina solo: ");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        txtJuegoVocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJuegoVocalActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(181, 37, 26));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("UDIPSAI");

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 51));
        jLabel51.setText("Resultados");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel51)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        menuInformes.setText("Informes");

        itemFonoaudiologia.setText("Fonoaudiologia");
        itemFonoaudiologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFonoaudiologiaActionPerformed(evt);
            }
        });
        menuInformes.add(itemFonoaudiologia);

        itemPsicologiaClinica.setText("Psicologia Clinica");
        itemPsicologiaClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPsicologiaClinicaActionPerformed(evt);
            }
        });
        menuInformes.add(itemPsicologiaClinica);

        itemPsicologiaEducativa.setText("Psicologia Educativa");
        itemPsicologiaEducativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPsicologiaEducativaActionPerformed(evt);
            }
        });
        menuInformes.add(itemPsicologiaEducativa);

        itemResultados.setText("Resultados");
        itemResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemResultadosActionPerformed(evt);
            }
        });
        menuInformes.add(itemResultados);

        jMenuBar1.add(menuInformes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContactoEmergencia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel24)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel25)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtIdPaciente))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAntecentesFamiliares)
                                    .addComponent(txtAntecedentesMedicos)
                                    .addComponent(txtEspecialidad)
                                    .addComponent(txtMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(txtFuenteInformacion)
                                    .addComponent(txtGrado)
                                    .addComponent(cmbDiscapacidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdEspecialista, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(txtLugarNacimiento)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbEmbarazoDeseado, javax.swing.GroupLayout.Alignment.TRAILING, 0, 226, Short.MAX_VALUE)
                            .addComponent(cmbControlEmbarazo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbAborto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDuracionEmbarazo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoEmocional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoParto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLloro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPresento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMalFormacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProblemasAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnfermedadesMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConsumoMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtControlEsfinteres, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBalbuceo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbComplicaionesParto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJuegoVocal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbIncubadora, 0, 175, Short.MAX_VALUE)
                    .addComponent(txtCausa, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(cmbVacunacion, 0, 175, Short.MAX_VALUE)
                    .addComponent(txtCefalico, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtSedestacion, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtBipedestacion, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtCaminaApoyo, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtCaminaSolo, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtSubeEscaleras, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtSilabeo, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtPrimerasPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtOraciones, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtFormulacionL, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtNumeroPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtTipoAntecedente, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbAborto, cmbComplicaionesParto, cmbDuracionEmbarazo, cmbLloro, cmbPresento, cmbTipoParto, txtBalbuceo, txtConsumoMedicamentos, txtControlEsfinteres, txtEnfermedadesMadre, txtEstadoEmocional, txtJuegoVocal, txtMalFormacion, txtPeso, txtProblemasAlimentacion, txtTalla, txtVocalizacion});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(txtCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel37)
                                    .addComponent(txtSilabeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36)
                                    .addComponent(txtPrimerasPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel43)
                                    .addComponent(cmbIncubadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42)
                                    .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFormulacionL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txtNumeroPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtTipoAntecedente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(cmbVacunacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtCefalico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txtSedestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txtBipedestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txtCaminaApoyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txtCaminaSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(txtSubeEscaleras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(cmbAborto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtEstadoEmocional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(cmbDuracionEmbarazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(cmbTipoParto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(cmbLloro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(cmbPresento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtMalFormacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtProblemasAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(txtEnfermedadesMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtConsumoMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(txtControlEsfinteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(txtIdEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtLugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cmbDiscapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtFuenteInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtAntecedentesMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtAntecentesFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(cmbEmbarazoDeseado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel39)
                                            .addComponent(txtVocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel40)
                                            .addComponent(txtBalbuceo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel38)
                                            .addComponent(cmbComplicaionesParto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel44)
                                            .addComponent(txtJuegoVocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(cmbControlEmbarazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel11)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbControlEmbarazo, cmbDiscapacidad, cmbEmbarazoDeseado, txtAntecedentesMedicos, txtAntecentesFamiliares, txtContactoEmergencia, txtCorreo, txtDireccion, txtEspecialidad, txtFuenteInformacion, txtGrado, txtIdEspecialista, txtIdPaciente, txtLugarNacimiento, txtMotivo});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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

    private void txtJuegoVocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJuegoVocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJuegoVocalActionPerformed

    private void itemResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemResultadosActionPerformed
        Reportes_personales reportesPersonales = new Reportes_personales(paciente);
        reportesPersonales.Reportes_personales(paciente);
    }//GEN-LAST:event_itemResultadosActionPerformed

    private void itemFonoaudiologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFonoaudiologiaActionPerformed
        fonoaudiologia fono = new fonoaudiologia(paciente);
        fono.fonoaudoliga(paciente);

    }//GEN-LAST:event_itemFonoaudiologiaActionPerformed

    private void itemPsicologiaClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPsicologiaClinicaActionPerformed
        Reportes_clinica reportes = new Reportes_clinica(paciente);
        reportes.reportes_clinica(paciente);

    }//GEN-LAST:event_itemPsicologiaClinicaActionPerformed

    private void itemPsicologiaEducativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPsicologiaEducativaActionPerformed
        Reportes_educativos reportesEducativos = new Reportes_educativos(paciente);
        reportesEducativos.reportes_educativos(paciente);
    }//GEN-LAST:event_itemPsicologiaEducativaActionPerformed
    ConfigReader configReader = new ConfigReader();
    public String url = "jdbc:mysql://" + configReader.getIp() + ":3306/" + configReader.getDatabase();
    public String usuario = configReader.getUser();
    public String contrasena = configReader.getPass();
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
    private javax.swing.JMenuItem itemFonoaudiologia;
    private javax.swing.JMenuItem itemPsicologiaClinica;
    private javax.swing.JMenuItem itemPsicologiaEducativa;
    private javax.swing.JMenuItem itemResultados;
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
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    public javax.swing.JMenu menuInformes;
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
