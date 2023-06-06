/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.EspecialistaDao;

import java.sql.SQLException;
import comons.datos.Conexion;
import comons.negocio.Especialista;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class EspecialistaDao {

    private Conexion conexion;
    public String registro;

    public EspecialistaDao() {
        this.conexion = new Conexion();
    }

    public boolean registrar(Especialista especialista) {
        try {

            PreparedStatement ps = null;
            String consulta = "insert into especialista(cedula,primerNombre,segundoNombre,primerApellido,segundoApellido,id_especialidad,esPasante,especialistaAsignado,contraseña,estaActivo) values(?,?,?,?,?,?,?,?,?,?)";

            Connection connection = this.conexion.getConnection();
            ps = connection.prepareStatement(consulta);
            ps.setString(1, especialista.getCedula());
            ps.setString(2, especialista.getPrimerNombre());
            ps.setString(3, especialista.getSegundoNombre());
            ps.setString(4, especialista.getPrimerApellido());
            ps.setString(5, especialista.getSegundoApellido());
            ps.setInt(6, especialista.getId_especialidad());
            ps.setString(7, String.valueOf(especialista.isEsPasante()));
            ps.setString(8, especialista.getNombreEspecilistaResponsable());
            ps.setString(9, especialista.getContraseña());
            ps.setString(10, String.valueOf(especialista.isEstaActivo()));

            ps.executeUpdate();
            ps.close();
            connection.close();

            return true;
        } catch (Exception e) {

            System.err.println("Error en crear Especialista");
            System.err.println("Mensaje de error:" + e.getMessage());
            System.err.println("Detalle del Error:");
            e.printStackTrace();
            return false;
        }

    }

    public int modificar(Especialista especialista) {
        try {
            int respuesta = 0;
            PreparedStatement ps = null;
            String consulta = "update especialista set primerNombre=?, segundoNombre=? ,primerApellido=? ,segundoApellido=? ,id_especialidad=?,esPasante=?,especialistaAsignado=?,contraseña=?,estaActivo=? where cedula=?";

            Connection connection = this.conexion.getConnection();
            ps = connection.prepareStatement(consulta);
            ps.setString(1, especialista.getPrimerNombre());
            ps.setString(2, especialista.getSegundoNombre());
            ps.setString(3, especialista.getPrimerApellido());
            ps.setString(4, especialista.getSegundoApellido());
            ps.setInt(5, especialista.getId_especialidad());
            ps.setString(6, String.valueOf(especialista.isEsPasante()));
            ps.setString(7, especialista.getNombreEspecilistaResponsable());
            ps.setString(8, especialista.getContraseña());
            ps.setString(9, especialista.getCedula());
            ps.setString(6, String.valueOf(especialista.isEstaActivo()));

            respuesta = ps.executeUpdate();
            ps.close();
            if (respuesta == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {

            System.err.println("Error en modificar Especialista");
            System.err.println("Mensaje de error:" + e.getMessage());
            System.err.println("Detalle del Error:");
            e.printStackTrace();
            return 0;
        }

    }

    public List<Especialista> listar() {
        List<Especialista> listaespecialistas = new ArrayList<>();
        try {

            String consulta = "select * from especialista";
            Connection connection = conexion.getConnection();
            PreparedStatement ps = connection.prepareStatement(consulta);
            ResultSet data = ps.executeQuery();
            while (data.next() == true) {
                Especialista especialista = new Especialista();
                especialista.setCedula(data.getString(1));
                especialista.setPrimerNombre(data.getString(2));
                especialista.setSegundoNombre(data.getString(3));
                especialista.setPrimerApellido(data.getString(4));
                especialista.setSegundoApellido(data.getString(5));
                especialista.setId_especialidad(data.getInt(6));
                especialista.setEsPasante(data.getBoolean(7));
                especialista.setNombreEspecilistaResponsable(data.getString(8));
                especialista.setContraseña(data.getString(9));

                listaespecialistas.add(especialista);

            }

        } catch (Exception e) {
            System.err.println("Error al listar Especialistas");
            System.err.println("Mensaje de error:" + e.getMessage());
            System.err.println("Detalle del Error:");
            e.printStackTrace();

        }

        return listaespecialistas;
    }

    public void delete(String cedula) {
        PreparedStatement ps = null;
        String consulta = "delete from especialista where cedula=" + cedula;
        try {
            Connection connection = this.conexion.getConnection();
            ps = connection.prepareStatement(consulta);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public int existeUsuario(String especialista) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = this.conexion.getConnection();
        String consulta = "Select count(cedula) from especialista where cedula=?";
        try {
            ps = connection.prepareStatement(consulta);
            ps.setString(1, especialista);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;
        } catch (Exception e) {
            Logger.getLogger(EspecialistaDao.class.getName()).log(Level.SEVERE, null, e);
            return 1;
        }

    }

    //Verificar credenciales en la base de datos para el inicio de sesión
    public Especialista verificarCredenciales(String cedula, String contraseña) {
        try {
            String query = "SELECT * FROM especialista WHERE cedula = ? AND contraseña = ?";
            Connection connection = this.conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cedula);
            statement.setString(2, contraseña);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Especialista especialista = new Especialista();
                especialista.setCedula(resultSet.getString("cedula"));
                especialista.setContraseña(resultSet.getString("contraseña"));
                especialista.setId_especialidad(resultSet.getInt("id_especialidad"));
                // Obtener otros datos del especialista si es necesario
                return especialista;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    /*
    public boolean login(Especialista especialista) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = this.conexion.getConnection();
        String consulta = "Select cedula,primerNombre,primerApellido,areaEspecialidad,contraseña from especialista where cedula=?";
        try {
            ps = connection.prepareStatement(consulta);
            ps.setString(1, especialista.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                if (especialista.getContraseña().equals(rs.getString(5))) {
                    especialista.setPrimerNombre(rs.getString(2));
                    especialista.setPrimerApellido(rs.getString(3));
                    especialista.setAreaProfesional(rs.getString(4));
                    return true;

                }
            }
            return false;
        } catch (Exception e) {
            Logger.getLogger(EspecialistaDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }
     */
}
