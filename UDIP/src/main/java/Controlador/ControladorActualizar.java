
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.CrearControlador.obtenerOpciones;
import EspecialistaDao.EspecialistaDao;
import Modelo.Especialista;
import Vista.*;
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
    private EspecialistaDao especialistadao;
    Especialista especialista = new Especialista();
    DefaultTableModel tabla = new DefaultTableModel();

    public ControladorActualizar(Actualizar actualizar, EspecialistaDao especialistadao, Especialista especialista) {
        this.inicio = inicio;
        this.actualizar = actualizar;
        this.especialistadao = especialistadao;
        this.especialista = especialista;
        this.actualizar.btnactualizar.addActionListener(this);
        this.actualizar.btnguardar.addActionListener(this);
        this.actualizar.checkSi.addActionListener(this);
        this.actualizar.checkNo.addActionListener(this);
        this.actualizar.btnAtras.addActionListener(this);
        recuperardatostabla();
        llenarComboBox();
        validarVentana();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == actualizar.btnactualizar) {
            int fila = actualizar.tablaespecialistas.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(actualizar, "Debe seleccionar una fila");
            } else {
                verificarFoco();
                String cedula = (String) actualizar.tablaespecialistas.getValueAt(fila, 0);
                String pnombre = (String) actualizar.tablaespecialistas.getValueAt(fila, 1);
                String snombre = (String) actualizar.tablaespecialistas.getValueAt(fila, 2);
                String papellido = (String) actualizar.tablaespecialistas.getValueAt(fila, 3);
                String sapellido = (String) actualizar.tablaespecialistas.getValueAt(fila, 4);
                String area = (String) actualizar.tablaespecialistas.getValueAt(fila, 5);
                Object valor = actualizar.tablaespecialistas.getValueAt(fila, 6);
                String especialistaResposable = (String) actualizar.tablaespecialistas.getValueAt(fila, 7);
                String contraseña = (String) actualizar.tablaespecialistas.getValueAt(fila, 8);
                
                boolean esPsante = Boolean.parseBoolean(valor.toString());
                actualizar.txtCedula.setText(cedula);
                actualizar.txtPrimerNombre.setText(pnombre);
                actualizar.txtSegundoNombre.setText(snombre);
                actualizar.txtPrimerApellido.setText(papellido);
                actualizar.txtSegundoApellido.setText(sapellido);
                String areaEspecialidad = area;
                llenarComboBox();
                actualizar.comboEspecialidades.setSelectedItem(areaEspecialidad);
                actualizar.txtEspeacilistaResponsable.setText(especialistaResposable);
                actualizar.txtContraseña.setText(contraseña);
                
           
                if (esPsante == true) {
                    actualizar.checkSi.setSelected(true);

                }
                if (esPsante == false) {
                    actualizar.checkNo.setSelected(true);
                } 
                }
                

            
        }

        if (e.getSource() == actualizar.btnguardar) {
            if (actualizar.txtCedula.getText().isEmpty()
                    && actualizar.txtPrimerNombre.getText().isEmpty()
                    && actualizar.txtSegundoNombre.getText().isEmpty()
                    && actualizar.txtPrimerApellido.getText().isEmpty()
                    && actualizar.txtSegundoApellido.getText().isEmpty()
                    && actualizar.comboEspecialidades.getItemCount()==0) {
                JOptionPane.showMessageDialog(actualizar, "Especialista no seleccionado");
            } else {
                actualizar();
                limpiarTabla();
                recuperardatostabla();
                limpiarCampos();
            }

        }
        
       
        //Evento boton atras
        if (e.getSource() == actualizar.btnAtras) {

            if (actualizar.txtCedula.getText().isEmpty()
                    && actualizar.txtPrimerNombre.getText().isEmpty()
                    && actualizar.txtSegundoNombre.getText().isEmpty()
                    && actualizar.txtPrimerApellido.getText().isEmpty()
                    && actualizar.txtSegundoApellido.getText().isEmpty()
                    && actualizar.comboEspecialidades.getItemCount()==0) {
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
                    limpiarTabla();
                }
            }
        }
        
         if (e.getSource() == actualizar.checkSi ) {

            if (actualizar.checkSi.isSelected()) {
                actualizar.checkNo.setSelected(false);
            }
        }
        
        if( e.getSource() == actualizar.checkNo){
            if (actualizar.checkNo.isSelected()) {
                actualizar.checkSi.setSelected(false);
            }
        }

    }

    public void actualizar() {
        try {
            String cedula = actualizar.txtCedula.getText();
            String pnombre = actualizar.txtPrimerNombre.getText();
            String snombre = actualizar.txtSegundoNombre.getText();
            String papellido = actualizar.txtPrimerApellido.getText();
            String sapellido = actualizar.txtSegundoApellido.getText();
            int area = (int) actualizar.comboEspecialidades.getSelectedItem();
            String especialistaResponsable = actualizar.txtEspeacilistaResponsable.getText();
            String contraseña = actualizar.txtContraseña.getText();
            especialista.setCedula(cedula);
            especialista.setPrimerNombre(pnombre);
            especialista.setSegundoNombre(snombre);
            especialista.setPrimerApellido(papellido);
            especialista.setSegundoApellido(sapellido);
            especialista.setId_especialidad(area);
            especialista.setEsPasante(actualizar.checkSi.isSelected() == true || actualizar.checkNo.isSelected() == false);
            especialista.setNombreEspecilistaResponsable(especialistaResponsable);
            especialista.setContraseña(contraseña);
            int objetoactualizado = 0;
            objetoactualizado = especialistadao.modificar(especialista);
            if (objetoactualizado == 1) {
                JOptionPane.showMessageDialog(actualizar, "Especialista Actualizado con Exito");
            } else {
                JOptionPane.showMessageDialog(actualizar, "Algo salio mal al actualizar especialista");
            }
        } catch (Exception e) {
            System.err.println("" + e);
        }

    }

    public void recuperardatostabla() {

        List<Especialista> especialistas = this.especialistadao.listar();
        tabla.setColumnIdentifiers(new Object[]{"Cedula", "Primer Nombre ", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Area Especialidad","Es Pasante", "Especialista Asignado", "Contraseña", });
        Object[] objeto = new Object[9];
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
            tabla.addRow(objeto);
        }
        actualizar.tablaespecialistas.setModel(tabla);
    }
    
    public void verificarFoco(){
        if(!actualizar.txtCedula.getText().isEmpty()){
            JOptionPane.showMessageDialog(actualizar, "Espealista ya seleccionado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    void limpiarTabla() {
        for (int i = 0; i < actualizar.tablaespecialistas.getRowCount(); i++) {
            tabla.removeRow(i);
            i = i - 1;

        }

    }
    
    public static String[] obtenerOpciones() {
        // Lógica para obtener las opciones desde algún origen de datos
        String[] opciones = {"Seleccionar","Fonoaudiología", "Psicología Educativa", "Psicologia Social"};
        return opciones;
    }
    
    public void llenarComboBox() {

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        // Llama a la función obtenerOpciones() para obtener el array de opciones
        String[] opciones = obtenerOpciones();

        // Agrega las opciones al modelo del ComboBox
        for (String opcion : opciones) {
            comboBoxModel.addElement(opcion);
        }

        // Asigna el modelo al ComboBox
        actualizar.comboEspecialidades.setModel(comboBoxModel);

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
