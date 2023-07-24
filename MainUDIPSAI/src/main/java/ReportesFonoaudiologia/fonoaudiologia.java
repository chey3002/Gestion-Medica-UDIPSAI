/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportesFonoaudiologia;

import comons.negocio.Paciente;
import configReader.ConfigReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Martin_arteaga07
 */
public class fonoaudiologia {

    Paciente paciente;

    public fonoaudiologia(Paciente paciente) {
        this.paciente = paciente;
    }

    public fonoaudiologia() {
    }

    public void fonoaudoliga(Paciente paciente) {
        // Establecer la conexión a la base de datos
        Connection connection = null;
        try {
            ConfigReader configReader = new ConfigReader();
            String url = "jdbc:mysql://" + configReader.getIp() + ":3306/" + configReader.getDatabase();
            String usuario = configReader.getUser();
            String contrasena = configReader.getPass();
            connection = DriverManager.getConnection(url, usuario, contrasena);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        try {
            // Ruta al archivo JasperReport (.jasper) para fonoaudiología
            String reportPath1 = "C:\\Reportes_udipsai\\ReportesFonoaudiologia\\report1.jasper";

            // Consulta SQL con filtro para los datos de fonoaudiología (si es necesario)
            String sql = "SELECT * FROM historia_fonoaudiologia WHERE idPaciente = ?";

            // Preparar la consulta
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Pasar el ID del paciente como parámetro a la consulta (si es necesario)
            preparedStatement.setInt(1, paciente.getId()); // Asegúrate de tener el objeto Paciente disponible o ajusta esto según tu código

            // Ejecutar la consulta y obtener los resultados
            ResultSet resultSet = preparedStatement.executeQuery();

            // Crear un objeto JRResultSetDataSource utilizando el ResultSet
            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);

            // Parámetros para el informe (si es necesario)
            Map<String, Object> parameters1 = new HashMap<>();

            // Generar y mostrar el informe con los datos de fonoaudiología
            JasperPrint jasperPrint1 = JasperFillManager.fillReport(reportPath1, parameters1, resultSetDataSource);
            JasperViewer.viewReport(jasperPrint1, false);

            // Cerrar el ResultSet y el PreparedStatement
            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión a la base de datos
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
