/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhon Miguel Jimenez Arce
 */
/*public class Conexion {
    Connection conectar = null;
    
    private final String usuario = "postgres";
    private final String contrasenia = "Clases.2022";
    private final String bd = "UDIPSAI";
    private final String ip = "localhost";
    private final String puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try {
            Class.forName("org.postgresql.Driver");
            conectar= DriverManager.getConnection(cadena,usuario,contrasenia);
            JOptionPane.showMessageDialog(null, "Se conecto correctamente a la Base de Datos");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, error: "+e.toString());
            }
        return conectar;
    }*/
    public class Conexion {
    Connection conectar = null;
    String usuario="root";
    String contrasenia="Clases.2022";
    String bd= "udipsai";
    String ip="localhost";
    String puerto="3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
   

    public Connection establecerConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            //JOptionPane.showMessageDialog(null, "Se conecto a la base de datos");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se conecto a la base de datos, error" +e.toString());
        }
        return conectar;
    }
}

