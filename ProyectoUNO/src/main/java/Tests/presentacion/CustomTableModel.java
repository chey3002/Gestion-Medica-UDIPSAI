/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests.presentacion;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class CustomTableModel extends AbstractTableModel {
    private Vector<Vector<Object>> data; // Datos de la tabla
    private Vector<String> columnNames; // Nombres de las columnas

    public CustomTableModel() {
        data = new Vector<>();
        columnNames = new Vector<>();
    }

    public void setColumnNames(Vector<String> columnNames) {
        this.columnNames = columnNames;
        fireTableStructureChanged(); // Notificar al modelo que la estructura ha cambiado
    }

    public void setData(Vector<Vector<Object>> data) {
        this.data = data;
        fireTableDataChanged(); // Notificar al modelo que los datos han cambiado
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data.get(row).get(column);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Deshabilitar la edición de celdas
    }

    @Override
    public Class<?> getColumnClass(int column) {
        if (column == getColumnCount() - 2 || column == getColumnCount() - 1) {
            return JButton.class; // Utilizar objetos JButton para las últimas dos columnas
        } else {
            return super.getColumnClass(column);
        }
    }
}
