/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.Controlador;

import especialista.Vista.Login;
import especialista.Vista.Crear;
import especialista.Vista.Listar;
import especialista.Vista.Eliminar;
import especialista.Vista.Inicio;
import especialista.Vista.Actualizar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import comons.negocio.Especialista;

/**
 *
 * @author Usuario
 */
public class ControladorInicio implements ActionListener {

    private Crear crear;
    private Login login;
    private Inicio inicio;
    private Listar listar;
    private Actualizar actualizar;
    private Eliminar eliminar;
    Especialista especialista;
    
    

    public ControladorInicio(Crear crear, Inicio inicio, Listar listar, Actualizar actualizar, Eliminar eliminar,Login login) {
        this.crear = crear;
        this.inicio = inicio;
        this.listar = listar;
        this.login = login;
        this.actualizar = actualizar;
        this.eliminar = eliminar;
        this.inicio.menugestion.addActionListener(this);
        this.inicio.menuver.addActionListener(this);
        this.inicio.menuitemcrear.addActionListener(this);
        this.login.btnIniciarsesion.addActionListener(this);
        this.inicio.menuactualizar.addActionListener(this);
        this.inicio.menueliminar.addActionListener(this);
    }

    
    
    

    public void iniciar() {
        
        crear.setLocationRelativeTo(null);
        login.setLocationRelativeTo(null);
        listar.setLocationRelativeTo(null);
        inicio.setLocationRelativeTo(null);
        actualizar.setLocationRelativeTo(null);
        eliminar.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if (e.getSource() == login.btnIniciarsesion) {
           

        }
        if (e.getSource() == inicio.menuitemcrear) {
            crear.setVisible(true);

        }
        if (e.getSource() == inicio.menuver) {
            listar.setVisible(true);

        }
        if (e.getSource() == inicio.menuactualizar) {
            actualizar.setVisible(true);

        }
        if (e.getSource() == inicio.menueliminar) {
            eliminar.setVisible(true);

        }
    }
    
    public void validarVentanas(){
        if (crear.isDisplayable()==true) {
            limpiarCampos();
        } else {
            
        }
    }
    
    private void limpiarCampos() {
        crear.txtCedula.setText(null);
        crear.txtPrimerNombre.setText(null);
        crear.txtSegundoNombre.setText(null);
        crear.txtPrimerApellido.setText(null);
        crear.txtSegundoApellido.setText(null);
        

    }

}
