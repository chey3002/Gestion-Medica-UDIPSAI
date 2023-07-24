/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ReportesClinicas;

import ReportesPersonales.Reportes_personales.*;
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
public class Reportes_clinica {

    Paciente paciente;

    public Reportes_clinica(Paciente paciente) {
        this.paciente = paciente;

    }

    public Reportes_clinica() {
    }

    public void reportes_clinica(Paciente paciente) {
        try {
            // Ruta al archivo JasperReport (.jasper)
            String reportPath1 = "C:\\Reportes_udipsai\\ReportesClinicas\\report1.jasper";

            // Establecer la conexión a la base de datos
            ConfigReader configReader = new ConfigReader();
            String url = "jdbc:mysql://" + configReader.getIp() + ":3306/" + configReader.getDatabase();
            String usuario = configReader.getUser();
            String contrasena = configReader.getPass();
            Connection connection = DriverManager.getConnection(url, usuario, contrasena);

            // Consulta SQL con filtro para el ID del paciente
            String sql = "SELECT * FROM historia_psicologia_clinica WHERE idPaciente = ?";

            // Preparar la consulta
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Pasar el ID del paciente como parámetro a la consulta
            preparedStatement.setInt(
                    1, paciente.getId());

            // Ejecutar la consulta y obtener los resultados
            ResultSet resultSet = preparedStatement.executeQuery();

            // Crear un objeto JRResultSetDataSource utilizando el ResultSet
            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);

            // Parámetros para el informe
            Map<String, Object> parameters1 = new HashMap<>();

            // Generar y mostrar el informe con los datos del paciente seleccionado
            JasperPrint jasperPrint1 = JasperFillManager.fillReport(reportPath1, parameters1, resultSetDataSource);

            JasperViewer.viewReport(jasperPrint1,
                    false);

            // Cerrar el ResultSet y el PreparedStatement
            resultSet.close();

            preparedStatement.close();
            // Cerrar la conexión a la base de datos

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
