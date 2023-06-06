/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Usuario
 */
public class Conexion {
    
    Connection con;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/udipsai","root","");
            if(con!=null){
                System.out.println("Conexión Exitosa");
            }
        } catch (Exception e) {
            System.err.println("Fallo en la conexión");
            System.err.println("Estado de conexión:"+e.getMessage());
            System.err.print("Detalle del error:");
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
    
}
