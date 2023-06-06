/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests.negocio;

import comons.datos.mysql;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author carlos
 */
public class GestorTest {

    public void GuardarPDF(ArchivoPDF pdfFile) {
        mysql cn = new mysql("udipsai", "root", "");

        File archivo = pdfFile.getContenido();
        String nombre=pdfFile.getNombre();
        int paciente_id=pdfFile.getPaciente().getId();
        String especialista_cedula=pdfFile.getEspecialista().getCedula();
        long longitud = archivo.length();

        try {
            FileInputStream flujo = new FileInputStream(archivo);
            Connection conexion = cn.conexion();
            PreparedStatement ps = conexion.prepareStatement("insert into tests (id, idPaciente,cedulaEspecialista,nombre,fecha, contenido) values (null,?,?,?,?,?)");
            ps.setInt(1, paciente_id);
            ps.setString(2, especialista_cedula);
            ps.setString(3, nombre);
            ps.setDate(4, new java.sql.Date(new Date().getTime()));
            ps.setBlob(5, flujo, longitud);

            ps.executeUpdate();
            ps.close();
            conexion.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public GestorTest() {
    }
}
