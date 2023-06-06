/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests.negocio;

import comons.datos.mysql;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author carlos
 */
public class GestorTest {

    public void eliminarTest(int id) {
        try {
            mysql cn = new mysql("udipsai", "root", "");
            Connection conexion = cn.conexion();
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM tests WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void GuardarPDF(ArchivoPDF pdfFile) {
        mysql cn = new mysql("udipsai", "root", "");

        File archivo = pdfFile.getContenido();
        String nombre = pdfFile.getNombre();
        int paciente_id = pdfFile.getPaciente().getId();
        String especialista_cedula = pdfFile.getEspecialista().getCedula();
        long longitud = archivo.length();

        Connection conexion = null;

        try {
            FileInputStream flujo = new FileInputStream(archivo);
            conexion = cn.conexion();
            PreparedStatement ps = conexion.prepareStatement("insert into tests (id, idPaciente,cedulaEspecialista,nombre,fecha, contenido) values (null,?,?,?,?,?)");
            ps.setInt(1, paciente_id);
            ps.setString(2, especialista_cedula);
            ps.setString(3, nombre);
            ps.setDate(4, new java.sql.Date(new Date().getTime()));
            ps.setBlob(5, flujo, longitud);
            ps.executeUpdate();
            ps.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }

    public static void guardarTestDiscoDuro(InputStream x, String name) throws IOException {
        String desktopPath = System.getProperty("user.home") + "\\Documents\\";
        String folderName = "Descargas UDIPSAI";
        String folderPath = desktopPath + folderName;
        // Crear el objeto File para representar la carpeta
        File folder = new File(folderPath);
        // Verificar si la carpeta existe
        if (!folder.exists()) {
            // Crear la carpeta y sus subdirectorios si no existen
            folder.mkdirs();
        }
        File fichero = new File(folderPath + "\\" + name + ".pdf");
        BufferedInputStream in = new BufferedInputStream(x);
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fichero));
            byte[] bytes = new byte[8096];
            int len = 0;
            while ((len = in.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
            out.flush();
            out.close();
            in.close();

        } catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } catch (IOException e) {

                        JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void DescargarPDF(int id) throws IOException {
        try {
            mysql cn = new mysql("udipsai", "root", "");
            Statement st = cn.conexion().createStatement();
            ResultSet rs = st.executeQuery("select * from tests where id = '" + id + "'");
            while (rs.next()) {
                Blob blob = rs.getBlob("contenido");
                String name = rs.getString("nombre");
                InputStream is = blob.getBinaryStream();
                guardarTestDiscoDuro(is, name);
            }
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al descargar el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet getArchivosPDF(int idPaciente) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            mysql cn = new mysql("udipsai", "root", "");
            conexion = cn.conexion();
            ps = conexion.prepareStatement("SELECT tests.id AS id, CONCAT(especialista.primerNombre, ' ', especialista.primerApellido) AS Especialista, tests.nombre AS Nombre, tests.fecha AS Fecha "
                    + "FROM tests "
                    + "JOIN especialista ON tests.cedulaEspecialista = especialista.cedula "
                    + "WHERE tests.idPaciente = ?");
            ps.setInt(1, idPaciente);

            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar los archivos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

        }
        return null;
    }

    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();

            // Obtener los nombres de las columnas
            for (int column = 2; column <= numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column));
            }
            columnNames.addElement("Descargar");
            columnNames.addElement("Eliminar");

            // Obtener todas las filas
            Vector<Vector<Object>> rows = new Vector<>();

            while (rs.next()) {
                Vector<Object> newRow = new Vector<>();

                for (int i = 2; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }
                newRow.addElement(new JButton("↓"));
                newRow.addElement(new JButton("X"));
                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames) {
                public boolean isCellEditable(int row, int Column) {
                    return false;
                }
            };
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    public GestorTest() {
    }
}
