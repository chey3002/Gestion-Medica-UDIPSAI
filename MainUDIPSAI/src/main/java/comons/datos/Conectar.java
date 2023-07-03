/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comons.datos;

import configReader.ConfigReader;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author ALEX
 */
public class Conectar {  //con esta clase y la ayuda del driver podemos conectar con xamp
    static Connection conexion = null;
    static String driver = "com.mysql.jdbc.Driver";
    ConfigReader configReader = new ConfigReader();

    String url = "jdbc:mysql://"+configReader.getIp()+":3306/"+configReader.getDatabase();
    
     public Connection conectar() {
        try {       
            if (conexion == null) {
                Class.forName(driver);
                conexion = DriverManager.getConnection(url, configReader.getUser(), configReader.getPass());
                System.out.println("Conexion Correcta!!");
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }
}
