/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author LENOVO
 */
public class SqlUsuarios extends Conexion{
    public boolean registrar(usuarios usr){
        PreparedStatement ps=null;
        Connection conectar=establecerConexion();
        
        String sql="INSERT INTO especialista(cedula, primerNombre, segundoNombre, primerApellido, segundoApellido, id_especialidad, esPasante, especialistaAsignado, contraseña) VALUES(?,?,?,?,?,?,?,?,?)";
        //INSERT INTO tipo_usuario(nombre)VALUES('Usuario');
        try {
            ps = conectar.prepareStatement(sql);
            ps.setString(1, usr.getCedula());
            ps.setString(2, usr.getPrimerNombre());
            ps.setString(3, usr.getSegundoNombre());
            ps.setString(4, usr.getPrimerApellido());
            ps.setString(5, usr.getSegundoApellido());
            ps.setInt(6, usr.getId_especialidad());
            ps.setString(7, usr.getEsPasante());
            ps.setString(8, usr.getEspecialistaAsignado());
            ps.setString(9, usr.getContrasenia());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean login(usuarios usr){
        PreparedStatement ps=null;
        ResultSet rs = null;
        Connection conectar=establecerConexion();
        
        String sql="SELECT e.cedula, e.primerNombre, e.contraseña, e.id_especialidad, e.esPasante, t.area FROM especialista AS e "
                + "INNER JOIN especialidad AS t ON e.id_especialidad=t.id WHERE cedula = ?";
        //INSERT INTO tipo_usuario(nombre)VALUES('Usuario');
        try {
            ps = conectar.prepareStatement(sql);
            ps.setString(1, usr.getCedula());
            rs = ps.executeQuery();
            if(rs.next()){
                if(usr.getContrasenia().equals(rs.getString(3))){
                    
                    /*String sqlUpdate="UPDATE usuarios SET last_session = ? WHERE id=?";
                    
                    ps = conectar.prepareStatement(sqlUpdate);
                    ps.setString(1, usr.getLast_session());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();*/
                    
                    usr.setPrimerNombre(rs.getString(2));
                    usr.setId_especialidad(rs.getInt(4));
                    usr.setEsPasante(rs.getString(5));
                    usr.setArea(rs.getString(6));
                    
                    return true;
                    
                }else{
                    return false;
                }
                
            }
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public int existeusuario(String usuario){
        PreparedStatement ps=null;
        ResultSet rs = null;
        Connection conectar=establecerConexion();
        
        String sql="SELECT count(idusuario) FROM usuarios WHERE usuario = ?";
        //INSERT INTO tipo_usuario(nombre)VALUES('Usuario');
        try {
            ps = conectar.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    public int existeCedula(String cedula){
        PreparedStatement ps=null;
        ResultSet rs = null;
        Connection conectar=establecerConexion();
        
        String sql="SELECT count(cedula) FROM especialista WHERE cedula = ?";
        //INSERT INTO tipo_usuario(nombre)VALUES('Usuario');
        try {
            ps = conectar.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    public boolean verificarCedula(usuarios usr, String cedulaIngresada) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conectar = establecerConexion();

    String sql = "SELECT e.cedula FROM especialista AS e WHERE cedula = ?";

    try {
        ps = conectar.prepareStatement(sql);
        ps.setString(1, cedulaIngresada);
        rs = ps.executeQuery();

        if (rs.next()) {
            return true; // La cédula existe en la base de datos
        }

        return false; // La cédula no existe en la base de datos

    } catch (SQLException ex) {
        Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conectar != null) {
                conectar.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public boolean validarCedulaEcuatoriana(String cedula) {
    // Verificar que la cédula tenga 10 dígitos
    if (cedula.length() != 10) {
        return false;
    }

    // Obtener los dígitos de la cédula
    int[] digitos = new int[10];
    for (int i = 0; i < 10; i++) {
        digitos[i] = Integer.parseInt(cedula.substring(i, i + 1));
    }

    // Calcular el dígito verificador
    int verificador = (digitos[0] * 2 + digitos[1] * 1 + digitos[2] * 2 + digitos[3] * 1
            + digitos[4] * 2 + digitos[5] * 1 + digitos[6] * 2 + digitos[7] * 1
            + digitos[8] * 2) % 10;
    if (verificador != 0) {
        verificador = 10 - verificador;
    }

    // Verificar que el dígito verificador sea igual al último dígito de la cédula
    return digitos[9] == verificador;
}


    
}
