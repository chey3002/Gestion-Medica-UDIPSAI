/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.Controlador;

import especialista.Vista.Eliminar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import comons.datos.EspecialistaDao;
import comons.negocio.Especialista;
import especialista.Vista.Inicio;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ControladorEliminar implements ActionListener {

    private Inicio inicio;
    private Eliminar eliminar;
    EspecialistaDao especialistadao = new EspecialistaDao();
    
    

    public ControladorEliminar(Eliminar eliminar,Inicio inicio) {
         this.inicio = inicio;
        this.eliminar = eliminar;
        this.inicio.menueliminar.addActionListener(this);
        this.eliminar.itemEliminar.addActionListener(this);
        this.eliminar.itemAtras.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if (e.getSource() == inicio.menueliminar) {
            recuperardatostabla();
        }
        try {
            if (e.getSource() == eliminar.itemEliminar) {
                int fila = eliminar.tablaespecialistas.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(eliminar, "Debe seleccionar un Especialista");
                } else {
                    String cedula = (String) eliminar.tablaespecialistas.getValueAt(fila, 0);
                    int confirmDialog = JOptionPane.showConfirmDialog(eliminar, "¿Está seguro de eliminar este especialista con cédula? "  +cedula, "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmDialog == JOptionPane.YES_OPTION) {
                        especialistadao.delete(cedula);
                        JOptionPane.showMessageDialog(eliminar, "Usuario Eliminado");
                        
                        recuperardatostabla();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(eliminar, "Error al eliminar el Especialista");
        }

        if (e.getSource() == eliminar.itemAtras) {
            eliminar.dispose();
        }
    }

    

    public void recuperardatostabla() {
        DefaultTableModel tabla = new DefaultTableModel();
        List<Especialista> especialistas = this.especialistadao.listar();
        tabla.setColumnIdentifiers(new Object[]{"Cedula", "Primer Nombre ", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Area Especialidad", "Es Pasante", "Especialista Asignado", "Contraseña","Esta Activo"});
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
        eliminar.tablaespecialistas.setModel(tabla);
    }

    
}
