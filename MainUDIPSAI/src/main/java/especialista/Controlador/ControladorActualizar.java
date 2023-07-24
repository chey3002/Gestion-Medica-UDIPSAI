
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.Controlador;

import especialista.Vista.Actualizar;
import especialista.Vista.Inicio;
import static especialista.Controlador.CrearControlador.obtenerOpciones;
import comons.datos.EspecialidadesDao;
import comons.datos.EspecialistaDao;
import comons.negocio.Especialidades;
import comons.negocio.Especialista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ControladorActualizar implements ActionListener {

    private Inicio inicio;
    private Actualizar actualizar;
    EspecialistaDao especialistadao = new EspecialistaDao();
    private EspecialidadesDao especialidadesdao;
    Especialista especialista = new Especialista();

    public ControladorActualizar(Actualizar actualizar, Especialista especialista, EspecialidadesDao especialidadesdao, Inicio inicio) {
        this.inicio = inicio;
        this.actualizar = actualizar;
        this.especialistadao = especialistadao;
        this.especialista = especialista;
        this.especialidadesdao = especialidadesdao;
        this.inicio.menuactualizar.addActionListener(this);
        this.actualizar.btnactualizar.addActionListener(this);
        this.actualizar.btnguardar.addActionListener(this);
        this.actualizar.checkSi.addActionListener(this);
        this.actualizar.checkNo.addActionListener(this);
        this.actualizar.checkActivoSi.addActionListener(this);
        this.actualizar.checkActivoNo.addActionListener(this);
        this.actualizar.btnAtras.addActionListener(this);
        validarVentana();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == inicio.menuactualizar) {
            recuperardatostabla();
        }
        if (e.getSource() == actualizar.btnactualizar) {
            int fila = actualizar.tablaespecialistas.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(actualizar, "Debe seleccionar una fila");
            } else {
                limpiarCampos();
                llenarComboBox();
                String cedula = (String) actualizar.tablaespecialistas.getValueAt(fila, 0);
                String pnombre = (String) actualizar.tablaespecialistas.getValueAt(fila, 1);
                String snombre = (String) actualizar.tablaespecialistas.getValueAt(fila, 2);
                String papellido = (String) actualizar.tablaespecialistas.getValueAt(fila, 3);
                String sapellido = (String) actualizar.tablaespecialistas.getValueAt(fila, 4);
                int area = (int) actualizar.tablaespecialistas.getValueAt(fila, 5);
                Object valor = actualizar.tablaespecialistas.getValueAt(fila, 6);
                String especialistaResponsable = (String) actualizar.tablaespecialistas.getValueAt(fila, 7);
                String contraseña = (String) actualizar.tablaespecialistas.getValueAt(fila, 8);
                Object esActivo = actualizar.tablaespecialistas.getValueAt(fila, 9);

                boolean esPsante = Boolean.parseBoolean(valor.toString());
                boolean estaActivo = Boolean.parseBoolean(esActivo.toString());
                actualizar.txtCedula.setText(cedula);
                actualizar.txtPrimerNombre.setText(pnombre);
                actualizar.txtSegundoNombre.setText(snombre);
                actualizar.txtPrimerApellido.setText(papellido);
                actualizar.txtSegundoApellido.setText(sapellido);

                String areaEspecialidad = especialidadesdao.obtenerNombreArea(area);
                actualizar.txtEspeacilistaResponsable.setText(especialistaResponsable);
                actualizar.txtContraseña.setText(contraseña);

                DefaultComboBoxModel modelo = (DefaultComboBoxModel) actualizar.comboEspecialidades.getModel();
                modelo.setSelectedItem(areaEspecialidad);

                if (esPsante) {
                    actualizar.checkSi.setSelected(true);
                } else {
                    actualizar.checkNo.setSelected(true);
                }

                if (estaActivo) {
                    actualizar.checkActivoSi.setSelected(true);
                } else {
                    actualizar.checkActivoNo.setSelected(true);
                }
            }
        }

        if (e.getSource() == actualizar.btnguardar) {
            if (actualizar.txtCedula.getText().isEmpty()
                    && actualizar.txtPrimerNombre.getText().isEmpty()
                    && actualizar.txtSegundoNombre.getText().isEmpty()
                    && actualizar.txtPrimerApellido.getText().isEmpty()
                    && actualizar.txtSegundoApellido.getText().isEmpty()
                    && actualizar.comboEspecialidades.getItemCount() == 0
                    && !actualizar.checkSi.isSelected()
                    && !actualizar.checkActivoNo.isSelected()
                    && actualizar.txtEspeacilistaResponsable.getText().isEmpty()
                    && actualizar.txtContraseña.getText().isEmpty()
                    && !actualizar.checkActivoSi.isSelected()
                    && !actualizar.checkActivoNo.isSelected()) {
                JOptionPane.showMessageDialog(actualizar, "Especialista no seleccionado");
            } else {
                actualizar();
                // Llamar a la función limpiarTabla() pasando el modelo de la tabla actualizar.tablaespecialistas
                limpiarTabla((DefaultTableModel) actualizar.tablaespecialistas.getModel());

                recuperardatostabla();
                limpiarCampos();
                iniciarComboBox();

            }

        }

        //Evento boton atras
        if (e.getSource() == actualizar.btnAtras) {

            if (actualizar.txtCedula.getText().isEmpty()
                    && actualizar.txtPrimerNombre.getText().isEmpty()
                    && actualizar.txtSegundoNombre.getText().isEmpty()
                    && actualizar.txtPrimerApellido.getText().isEmpty()
                    && actualizar.txtSegundoApellido.getText().isEmpty()
                    && actualizar.comboEspecialidades.getItemCount() == 0) {
                actualizar.dispose();

            } else {
                String[] opciones = {"Aceptar", "Cancelar"};

                int seleccion = JOptionPane.showOptionDialog(null, "¿Desea conservar los cambios?", "Pregunta",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                if (seleccion == 0) {
                    JOptionPane.getRootFrame().dispose();
                } else if (seleccion == 1) {
                    actualizar.dispose();
                    limpiarCampos();
                    // Llamar a la función limpiarTabla() pasando el modelo de la tabla actualizar.tablaespecialistas
                    limpiarTabla((DefaultTableModel) actualizar.tablaespecialistas.getModel());

                }
            }
        }

        if (e.getSource() == actualizar.checkSi) {

            if (actualizar.checkSi.isSelected()) {
                actualizar.checkNo.setSelected(false);
            }
        }

        if (e.getSource() == actualizar.checkNo) {
            if (actualizar.checkNo.isSelected()) {
                actualizar.checkSi.setSelected(false);
            }
        }

        if (e.getSource() == actualizar.checkActivoSi) {

            if (actualizar.checkActivoSi.isSelected()) {
                actualizar.checkActivoNo.setSelected(false);
            }
        }

        if (e.getSource() == actualizar.checkActivoNo) {
            if (actualizar.checkActivoNo.isSelected()) {
                actualizar.checkActivoSi.setSelected(false);
            }
        }

    }

    public void actualizar() {
        try {
            EspecialidadesDao especialidadesDao = new EspecialidadesDao();
            String cedula = actualizar.txtCedula.getText();
            String pnombre = actualizar.txtPrimerNombre.getText();
            String snombre = actualizar.txtSegundoNombre.getText();
            String papellido = actualizar.txtPrimerApellido.getText();
            String sapellido = actualizar.txtSegundoApellido.getText();
            Object especialidadSeleccionada = actualizar.comboEspecialidades.getSelectedItem();

            if (especialidadSeleccionada instanceof Especialidades) {
                Especialidades especialidad = (Especialidades) especialidadSeleccionada;
                especialista.setId_especialidad(especialidad.getId_Especialidad());

                // Resto del código para actualizar el especialista
                String especialistaResponsable = actualizar.txtEspeacilistaResponsable.getText();
                String contraseña = actualizar.txtContraseña.getText();

                especialista.setCedula(cedula);
                especialista.setPrimerNombre(pnombre);
                especialista.setSegundoNombre(snombre);
                especialista.setPrimerApellido(papellido);
                especialista.setSegundoApellido(sapellido);
                especialista.setNombreEspecilistaResponsable(especialistaResponsable);
                especialista.setContraseña(contraseña);
                especialista.setEstaActivo(actualizar.checkActivoSi.isSelected());
                especialista.setEsPasante(actualizar.checkSi.isSelected());

                int objetoactualizado = especialistadao.modificar(especialista);
                if (objetoactualizado == 1) {
                    JOptionPane.showMessageDialog(actualizar, "Especialista Actualizado con Exito");
                } else {
                    JOptionPane.showMessageDialog(actualizar, "Algo salió mal al actualizar el especialista");
                }
            } else {
                // Manejar el caso cuando no se encuentra la especialidad seleccionada
                JOptionPane.showMessageDialog(actualizar, "La especialidad seleccionada no es válida");
            }
        } catch (Exception e) {
            System.err.println("Error al modificar el especialista");
            System.err.println("Mensaje de error: " + e.getMessage());
            System.err.println("Detalle del Error:");
            e.printStackTrace();
        }
    }

    public void recuperardatostabla() {
        DefaultTableModel tabla = new DefaultTableModel();
        List<Especialista> especialistas = this.especialistadao.listar();
        tabla.setColumnIdentifiers(new Object[]{"Cedula", "Primer Nombre ", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Area Especialidad", "Es Pasante", "Especialista Asignado", "Contraseña", "Esta Activo"});
        Object[] objeto = new Object[10];
        for (int i = 0; i < especialistas.size(); i++) {
            objeto[0] = especialistas.get(i).getCedula();
            objeto[1] = especialistas.get(i).getPrimerNombre();
            objeto[2] = especialistas.get(i).getSegundoNombre();
            objeto[3] = especialistas.get(i).getPrimerApellido();
            objeto[4] = especialistas.get(i).getSegundoApellido();
            objeto[5] = especialistas.get(i).getId_especialidad();
            objeto[6] = especialistas.get(i).isEsPasante();
            objeto[7] = especialistas.get(i).getNombreEspecilistaResponsable();
            objeto[8] = especialistas.get(i).getContraseña();
            objeto[9] = especialistas.get(i).isEstaActivo();
            tabla.addRow(objeto);
        }
        actualizar.tablaespecialistas.setModel(tabla);
    }

    public void limpiarTabla(DefaultTableModel modeloTabla) {
        for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    public void llenarComboBox() {
        EspecialidadesDao especialidadesDao = new EspecialidadesDao();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(especialidadesDao.obtenerEspecialidades().toArray());
        actualizar.comboEspecialidades.setModel(modelo);
    }

    public void iniciarComboBox() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        actualizar.comboEspecialidades.setModel(modelo);
    }

    private void limpiarCampos() {
        actualizar.txtCedula.setText(null);
        actualizar.txtPrimerNombre.setText(null);
        actualizar.txtSegundoNombre.setText(null);
        actualizar.txtPrimerApellido.setText(null);
        actualizar.txtSegundoApellido.setText(null);
        actualizar.comboEspecialidades.setSelectedItem("Seleccionar");
        actualizar.txtEspeacilistaResponsable.setText(null);
        actualizar.txtContraseña.setText(null);
        actualizar.checkSi.setSelected(false);
        actualizar.checkNo.setSelected(false);
        actualizar.checkActivoSi.setSelected(false);
        actualizar.checkActivoNo.setSelected(false);

    }

    void validarVentana() {

        actualizar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                if (e.WINDOW_CLOSING == 1) {

                } else {

                    limpiarCampos();
                }
            }
        });
    }
}
