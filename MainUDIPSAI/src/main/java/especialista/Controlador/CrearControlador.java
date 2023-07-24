/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.Controlador;

import especialista.Vista.Inicio;
import especialista.Vista.Crear;
import comons.datos.EspecialidadesDao;
import comons.datos.EspecialistaDao;
import comons.negocio.Especialista;
import comons.negocio.Especialidades;
import java.awt.event.ActionEvent;
import especialista.Vista.Eliminar;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class CrearControlador implements ActionListener, KeyListener {

    private Especialista especialista;
    private EspecialistaDao especialistadao;
    private Crear crear;
    private Inicio inicio;
    private EspecialidadesDao especialidadesdao;
    String respuesta;

    public CrearControlador(Especialista especialista, EspecialistaDao especialistadao, Crear crear, EspecialidadesDao especialidadesdao) {
        this.especialistadao = especialistadao;
        this.crear = crear;
        this.especialista = especialista;
        this.especialidadesdao = especialidadesdao;
        this.crear.btnCrear.addActionListener(this);
        this.crear.btnAtras.addActionListener(this);
        this.crear.checkBoxSi.addActionListener(this);
        this.crear.checkBoxNo.addActionListener(this);
        this.crear.checkEsActivoSi.addActionListener(this);
        this.crear.checkBoxEsActivoNo.addActionListener(this);
        this.crear.txtCedula.addKeyListener(this);
        this.crear.txtEspecialistaResponsable.addKeyListener(this);
        validarVentana();
        llenarComboBox();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crear.btnCrear) {
            if (crear.txtCedula.getText().isEmpty()
                    || crear.txtPrimerNombre.getText().isEmpty()
                    || crear.txtSegundoNombre.getText().isEmpty()
                    || crear.txtPrimerApellido.getText().isEmpty()
                    || crear.txtSegundoApellido.getText().isEmpty()
                    || crear.comboEspecialidades.getSelectedItem() == null
                    || crear.comboEspecialidades.getSelectedItem().equals("Seleccionar")
                    || crear.txtContraseña.getText().isEmpty()
                    || crear.txtEspecialistaResponsable.getText().isEmpty()
                    || (crear.checkBoxSi.isSelected() == false && crear.checkBoxNo.isSelected() == false)) {

                JOptionPane.showMessageDialog(crear, "Todos los campos deben estar llenos", "Advertencia", JOptionPane.WARNING_MESSAGE);

            } else {

                // Resto del código...
                if (especialistadao.existeUsuario(crear.txtCedula.getText()) == 0) {
                    String cedulaResponsable = crear.txtEspecialistaResponsable.getText();

                    if (especialistadao.existeEspecialistaResponsable(cedulaResponsable)) {
                        Especialista especialista = new Especialista();
                        especialista.setCedula(crear.txtCedula.getText());
                        especialista.setPrimerNombre(crear.txtPrimerNombre.getText());
                        especialista.setSegundoNombre(crear.txtSegundoNombre.getText());
                        especialista.setPrimerApellido(crear.txtPrimerApellido.getText());
                        especialista.setSegundoApellido(crear.txtSegundoApellido.getText());
                        Especialidades especialidadSeleccionada = (Especialidades) crear.comboEspecialidades.getSelectedItem();
                        int idEspecialidad = especialidadSeleccionada.getId_Especialidad();
                        especialista.setId_especialidad(idEspecialidad);
                        especialista.setEsPasante(crear.checkBoxSi.isSelected() == true || crear.checkBoxNo.isSelected() == false);
                        especialista.setNombreEspecilistaResponsable(crear.txtEspecialistaResponsable.getText());
                        especialista.setContraseña(crear.txtContraseña.getText());
                        especialista.setEstaActivo(crear.checkEsActivoSi.isSelected() == true || crear.checkBoxEsActivoNo.isSelected() == false);

                        if (especialistadao.registrar(especialista)) {
                            JOptionPane.showMessageDialog(null, "Especialista Agregado");
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al registrar el especialista");
                            limpiarCampos();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Especialista responsable no encontrado");
                    }
                } else {
                    JOptionPane.showMessageDialog(crear, "Espealista ya existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    limpiarCampos();
                }

            }

        }

        if (e.getSource() == crear.btnAtras) {

            if (crear.txtCedula.getText().isEmpty()
                    && crear.txtPrimerNombre.getText().isEmpty()
                    && crear.txtSegundoNombre.getText().isEmpty()
                    && crear.txtPrimerApellido.getText().isEmpty()
                    && crear.txtSegundoApellido.getText().isEmpty()
                    && (crear.comboEspecialidades.getSelectedItem() == null || crear.comboEspecialidades.getSelectedItem().equals("Seleccionar"))
                    && crear.txtContraseña.getText().isEmpty()
                    && crear.txtEspecialistaResponsable.getText().isEmpty()
                    && !(crear.checkBoxSi.isSelected() || crear.checkBoxNo.isSelected())) {
                // Todos los campos están vacíos, cerrar el JFrame directamente
                crear.dispose();
            } else {
                String[] opciones = {"No", "Aceptar"};

                int seleccion = JOptionPane.showOptionDialog(null, "¿Desea conservar los cambios?", "Pregunta",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                if (seleccion == 0) {
                    crear.dispose();
                    limpiarCampos();

                } else {

                }
            }
        }

        if (e.getSource() == crear.checkBoxSi) {

            if (crear.checkBoxSi.isSelected()) {
                crear.checkBoxNo.setSelected(false);
            }
        }

        if (e.getSource() == crear.checkBoxNo) {
            if (crear.checkBoxNo.isSelected()) {
                crear.checkBoxSi.setSelected(false);
            }
        }

        if (e.getSource() == crear.checkEsActivoSi) {

            if (crear.checkEsActivoSi.isSelected()) {
                crear.checkBoxEsActivoNo.setSelected(false);
            }
        }

        if (e.getSource() == crear.checkBoxEsActivoNo) {
            if (crear.checkBoxEsActivoNo.isSelected()) {
                crear.checkEsActivoSi.setSelected(false);
            }
        }

    }

    //función para limpiar campos después de ingresar un especialista
    private void limpiarCampos() {
        crear.txtCedula.setText(null);
        crear.txtPrimerNombre.setText(null);
        crear.txtSegundoNombre.setText(null);
        crear.txtPrimerApellido.setText(null);
        crear.txtSegundoApellido.setText(null);
        llenarComboBox();
        crear.txtContraseña.setText(null);
        crear.txtEspecialistaResponsable.setText(null);
        crear.checkBoxSi.setSelected(false);
        crear.checkBoxNo.setSelected(false);
        crear.checkEsActivoSi.setSelected(false);
        crear.checkBoxEsActivoNo.setSelected(false);

    }

    public void llenarComboBox() {
        EspecialidadesDao especialidadesDao = new EspecialidadesDao();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(especialidadesDao.obtenerEspecialidades().toArray());
        modelo.setSelectedItem("Seleccionar");
        crear.comboEspecialidades.setModel(modelo);
    }

//función para validar si están llenos los campos al aplicar un evento en el botón crear 
    private void validar() {
        if (crear.txtCedula.getText().isEmpty() && crear.txtPrimerNombre.getText().isEmpty() && crear.txtSegundoNombre.getText().isEmpty()
                && crear.txtPrimerApellido.getText().isEmpty() && crear.txtSegundoApellido.getText().isEmpty()) ;
        JOptionPane.showMessageDialog(null, "Llene la informaciíon requerida");

    }


    /*función para validar si se cierra la ventana de Crear y si se vuelve a abrir todos 
    los campos se inicien vacíos*/
    void validarVentana() {

        crear.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                if (e.WINDOW_CLOSING == 1) {

                } else {

                    limpiarCampos();
                }
            }
        });
    }

    public static String[] obtenerOpciones() {
        // Lógica para obtener las opciones desde algún origen de datos
        String[] opciones = {"Seleccionar", "Fonoaudiología", "Psicología Educativa", "Psicologia Social"};
        return opciones;
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        char caracter = evt.getKeyChar();

        // Verificar campo txtCedula
        if (evt.getSource() == crear.txtCedula) {
            if (!Character.isDigit(caracter)) {
                JOptionPane.showMessageDialog(null, "No se permite letras en este campo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                evt.consume();
                crear.txtCedula.requestFocus();
            } else if (crear.txtCedula.getText().length() >= 10) {
                evt.consume();
                crear.txtCedula.requestFocus();
            }
        }

        // Verificar campo txtEspecialistaResponsable
        if (evt.getSource() == crear.txtEspecialistaResponsable) {
            if (!Character.isDigit(caracter)) {
                JOptionPane.showMessageDialog(null, "No se permite letras en este campo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                evt.consume();
                crear.txtEspecialistaResponsable.requestFocus();
            } else if (crear.txtEspecialistaResponsable.getText().length() >= 10) {
                evt.consume();
                crear.txtEspecialistaResponsable.requestFocus();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Evaluar si se está presionando una tecla específica en el campo de texto txtCedula
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            // La tecla Enter está siendo presionada en el campo de texto txtCedula
            // Realizar acciones correspondientes
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Tecla liberada: " + e.getKeyChar());
    }

}
