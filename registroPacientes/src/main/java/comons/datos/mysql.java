/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comons.datos;

/**
 *
 * @author carlos
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql {
    private String nombreBaseDatos;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private String usuario ;
    private String contrasena;

    public mysql(String nombreBaseDatos, String usuario, String contrasena) {
        setNombreBaseDatos(nombreBaseDatos) ;
        setUsuario(usuario);
        setContrasena(contrasena);
        setUrl("jdbc:mysql://localhost:3306/" + this.nombreBaseDatos);
    }


    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, usuario, contrasena);

        } catch (ClassNotFoundException e) {
            System.out.println(e);

            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e);

            e.printStackTrace();
        }

        return con;
    }

    public mysql() {

    }

    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

}
