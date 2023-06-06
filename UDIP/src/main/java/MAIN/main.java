/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MAIN;

import Vista.*;
import EspecialistaDao.*;
import Controlador.*;
import Modelo.Especialista;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


/**
 *
 * @author Usuario
 */
public class main  {

    public static void main(String[] args) {
        
       

        //Mostrar hora del Sistema
        Inicio inicio = new Inicio();
        Date fechaActual = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        String horaFormateada = formatoHora.format(fechaActual);
        inicio.labelhorasistema.setText(horaFormateada);
        //Obtener fecha del Sistema
        Date fecha = new Date();
        String fechaconvertida = (String) fecha.toString();
        inicio.labelfechasistema.setText(fechaconvertida);
        
        //Instacias la clase especialista y especialistaDao
        Especialista especialista = new Especialista();
        EspecialistaDao especialistadao = new EspecialistaDao();
        EspecialidadesDao especialidadesDao = new EspecialidadesDao();
        
      
        
        
        //Instacias de las Vistas
        Crear crear = new Crear();
        Listar listar = new Listar();
        Actualizar actualizar = new Actualizar();
        Eliminar eliminar = new Eliminar();
        Login login = new Login();
        //Fin de las instacnias de las vistas
        
        //Instancias de los controladores
        ControladorListar cl = new ControladorListar(inicio, listar);
        CrearControlador cr = new CrearControlador(especialista, especialistadao, crear,especialidadesDao);
        ControladorInicio ci = new ControladorInicio(crear, inicio, listar,actualizar,eliminar,login);
        ControladorEliminar ce = new ControladorEliminar(eliminar, especialistadao);
        ControladorActualizar ca = new ControladorActualizar( actualizar,especialistadao,especialista);
        ControladorLogin clo = new ControladorLogin(especialistadao, especialista, login, inicio);
        //Fin de las instancias de los controladores
        
        ci.iniciar();
        login.setTitle("UDIPSAI");
        login.setVisible(true);
        login.setSize(590,490);
        inicio.setSize(590, 490);
        crear.setSize(610, 510);
        listar.setSize(550, 390);
        actualizar.setSize(650,500);
        
     
        
    }
        
        
          
    }
    
    
      




       


