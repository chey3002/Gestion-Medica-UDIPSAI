/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.MAIN;

import especialista.Controlador.ControladorActualizar;
import especialista.Controlador.ControladorLogin;
import especialista.Controlador.CrearControlador;
import especialista.Controlador.ControladorInicio;
import especialista.Controlador.ControladorEliminar;
import especialista.Controlador.ControladorListar;
import especialista.Vista.Eliminar;
import especialista.Vista.Listar;
import especialista.Vista.Actualizar;
import especialista.Vista.Inicio;
import especialista.Vista.Login;
import especialista.Vista.Crear;
import comons.datos.EspecialidadesDao;
import comons.datos.EspecialistaDao;
import comons.negocio.Especialidades;
import comons.negocio.Especialista;
import java.awt.Color;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
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
public class EspecialistaMain  {

    public EspecialistaMain() {
    }

    public void inicio() {
        
       

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
        ControladorInicio ci = new ControladorInicio(crear, inicio, listar,actualizar,eliminar,login,especialistadao);
        ControladorEliminar ce = new ControladorEliminar(eliminar, especialistadao);
        ControladorActualizar ca = new ControladorActualizar( actualizar,especialistadao,especialista,especialidadesDao);
        ControladorLogin clo = new ControladorLogin(especialistadao, especialista, login, inicio);
        //Fin de las instancias de los controladores
        
        ci.iniciar();
        login.setTitle("UDIPSAI");
        login.setVisible(true);
        login.setSize(590,490);
        login.setResizable(false);
        inicio.setSize(590, 490);
        crear.setSize(680, 590);
        listar.setSize(700, 450);
        actualizar.setSize(850,590);
        eliminar.setSize(700,450);
        
       
        
    }
        
        
          
    }
    
    
      




       


