/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.Controlador;

import especialista.Vista.Eliminar;
import especialista.Vista.Listar;
import especialista.Vista.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import comons.datos.EspecialistaDao;
import comons.negocio.Especialista;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ControladorEliminar implements ActionListener {

    private Eliminar eliminar;
    private EspecialistaDao especialistadao;
    private ControladorListar cl;
    private Inicio inicio;
    private Listar listar;
    DefaultTableModel tabla = new DefaultTableModel();

    public ControladorEliminar(Eliminar eliminar, EspecialistaDao especialistadao) {
        this.eliminar = eliminar;
        this.especialistadao = especialistadao;
        this.eliminar.btneliminar.addActionListener(this);
        this.eliminar.btnatras.addActionListener(this);
        recuperardatostabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == eliminar.btneliminar) {
                int fila = eliminar.tablaespecialistas.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(eliminar, "Debe sellecionar un Especialista");
                } else {
                    String cedula = (String) eliminar.tablaespecialistas.getValueAt(fila, 0).toString();
                    especialistadao.delete(cedula);
                    System.out.println("" + cedula);
                    JOptionPane.showMessageDialog(eliminar, "Usuario Eliminado");
                }
                limpiarTabla();
                recuperardatostabla();

            }
        } catch (Exception ex) {
            System.out.println("" + ex);
        }

        if (e.getSource() == eliminar.btnatras) {
            eliminar.dispose();

        }

    }

    public void recuperardatostabla() {

        List<Especialista> especialistas = this.especialistadao.listar();
        tabla.setColumnIdentifiers(new Object[]{"Cedula", "Primer Nombre ", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Id Especialidad","Es Pasante","Especialista Asignado","Contraseña","Esta activo"});
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

    void limpiarTabla() {
        for (int i = 0; i < eliminar.tablaespecialistas.getRowCount(); i++) {
            tabla.removeRow(i);
            i = i - 1;

        }

    }

}
