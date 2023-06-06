/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguimiento.negocio;

import comons.datos.mysql;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author carlos
 */
public class GestorSeguimiento {

    public void nuevoSeguimiento(Seguimiento seguimiento) {
        mysql cn = new mysql("udipsai", "root", "");

        String observacion = seguimiento.getObservacion();
        int paciente_id = seguimiento.getIdPaciente();
        String especialista_cedula = seguimiento.getCedulaEspecialista();

        Connection conexion = null;

        try {
            conexion = cn.conexion();
            PreparedStatement ps = conexion.prepareStatement(
                    "insert into seguimiento (id, idPaciente,cedulaEspecialista,fecha, observacion) values (null,?,?,?,?)");
            ps.setInt(1, paciente_id);
            ps.setString(2, especialista_cedula);
            ps.setDate(3, new java.sql.Date(seguimiento.getFecha().getTime()));
            ps.setString(4, observacion);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar seguimiento: " + e.getMessage(), "ERROR!",
                    JOptionPane.ERROR_MESSAGE);

        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "ERROR!",
                            JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }

    public void eliminarSeguimiento(int id) {
        try {
            mysql cn = new mysql("udipsai", "root", "");
            Connection conexion = cn.conexion();
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM seguimiento WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el seguimiento: " + ex.getMessage(), "ERROR!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet getSeguimientos(int idPaciente) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            mysql cn = new mysql("udipsai", "root", "");
            conexion = cn.conexion();
            ps = conexion.prepareStatement("SELECT s.id AS id,"
                    + "CONCAT(e.primerNombre, ' ', e.primerApellido) AS Especialista,"
                    + "s.fecha,"
                    + "s.observacion "
                    + "FROM seguimiento s "
                    + "JOIN especialista e ON s.cedulaEspecialista = e.cedula "
                    + "WHERE s.idPaciente = ? ORDER BY s.fecha DESC ");
            ps.setInt(1, idPaciente);

            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar los archivos: " + ex.getMessage(), "ERROR!",
                    JOptionPane.ERROR_MESSAGE);
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
            for (int column = 1; column <= numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column));
            }
            columnNames.addElement("Eliminar");

            // Obtener todas las filas
            Vector<Vector<Object>> rows = new Vector<>();

            while (rs.next()) {
                Vector<Object> newRow = new Vector<>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }
                newRow.addElement(new JButton("X"));
                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames) {
                public boolean isCellEditable(int row, int Column) {
                    if (Column == 3) {
                        return true;
                    }
                    return false;
                }
            };
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }
}
