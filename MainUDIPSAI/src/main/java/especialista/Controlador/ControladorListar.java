/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.Controlador;

import especialista.Vista.Listar;
import especialista.Vista.Inicio;
import comons.datos.EspecialistaDao;
import comons.negocio.Especialista;
import comons.negocio.Especialista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ControladorListar implements ActionListener {

    private Inicio inicio;
    private Listar listar;
    EspecialistaDao especialistadao = new EspecialistaDao();

    public ControladorListar(Inicio inicio, Listar listar) {
        this.inicio = inicio;
        this.listar = listar;
        this.inicio.menuver.addActionListener(this);
        this.inicio.menueliminar.addActionListener(this);
        this.listar.itemSalir.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inicio.menuver) {
            DefaultTableModel tabla = new DefaultTableModel();
            List<Especialista> especialistas = this.especialistadao.listar();
            tabla.setColumnIdentifiers(new Object[]{"Cedula", "Primer Nombre ", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Area Especialidad", "Es Pasante", "Especialista Asignado", "Contraseña",});
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
            listar.tablaespecialistas.setModel(tabla);
        }
        
        if (e.getSource() == listar.itemSalir) {
            listar.dispose();
        }
    }

    public void listar() {

        DefaultTableModel tabla = new DefaultTableModel();
        List<Especialista> especialistas = this.especialistadao.listar();
        tabla.setColumnIdentifiers(new Object[]{"Cedula", "Primer Nombre ", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Area Especialidad", "Es Pasante", "Especialista Asignado", "Contraseña",});
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
        listar.tablaespecialistas.setModel(tabla);
    }
}
