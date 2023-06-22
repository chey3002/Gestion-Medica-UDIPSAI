/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comons.datos;

import comons.negocio.Especialidades;
import comons.datos.Conexion;
import comons.datos.Conexion;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Usuario
 */
public class EspecialidadesDao {

    private Conexion conexion;

    public EspecialidadesDao() {
        this.conexion = new Conexion();
    }

    

    public ArrayList<Especialidades> obtenerEspecialidades() {
        ArrayList<Especialidades> listaEspecialidades = new ArrayList<>();
        try {
            Connection connection = this.conexion.getConnection();
            Statement statement = connection.createStatement();
            String consulta = "SELECT * FROM especialidad";
            ResultSet resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                int idEspecialidad = resultSet.getInt("id");
                String nombreEspecialidad = resultSet.getString("area");

                Especialidades especialidad = new Especialidades(idEspecialidad, nombreEspecialidad);
                listaEspecialidades.add(especialidad);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEspecialidades;
    }

    public String obtenerNombreArea(int id_Especialidad) {
        Conexion conexion = new Conexion();
        String nombreArea = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            String query = "SELECT area FROM especialidad WHERE id = ?";
            connection = conexion.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id_Especialidad);
            rs = statement.executeQuery();

            if (rs.next()) {
                nombreArea = rs.getString("area");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos en el orden inverso de apertura
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return nombreArea;
    }

    public int buscarIdEspecialidadPorNombre(String nombreEspecialidad) {
        try {
            int idEspecialidad = 0;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String consulta = "SELECT id_especialidad FROM especialidades WHERE nombre_especialidad = ?";

            Connection connection = this.conexion.getConnection();

            ps = connection.prepareStatement(consulta);
            ps.setString(1, nombreEspecialidad);
            rs = ps.executeQuery();

            if (rs.next()) {
                idEspecialidad = rs.getInt("id_especialidad");
            }

            rs.close();
            ps.close();

            return idEspecialidad;
        } catch (Exception e) {
            System.err.println("Error en buscarIdEspecialidadPorNombre");
            System.err.println("Mensaje de error: " + e.getMessage());
            System.err.println("Detalle del Error:");
            e.printStackTrace();
            return 0;
        }
    }

}
