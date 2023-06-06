/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.EspecialistaDao;

import especialista.Modelo.Especialidades;
import comons.datos.Conexion;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class EspecialidadesDao {
    
    private Conexion conexion;

    public EspecialidadesDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public EspecialidadesDao() {
    }
    
    public ArrayList obetenerEspecialidades(){
        Conexion conexion = new Conexion();
EspecialidadesDao especialidadesDao = new EspecialidadesDao(conexion);

        PreparedStatement ps = null;
        ResultSet rs = null;
        String consulta = "Select * from especialidad";
        ArrayList listaEspecialidades = new ArrayList();
        try {
            Connection connection = conexion.getConnection();
            ps = connection.prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()){
                Especialidades especialidades = new Especialidades(rs.getInt(1),rs.getString(2));
                listaEspecialidades.add(especialidades);
            }
            
        } catch (Exception e) {
             System.err.println("Error en Obtener Especialidades");
            System.err.println("Mensaje de error:" + e.getMessage());
            System.err.println("Detalle del Error:");
            e.printStackTrace();
        }
        return listaEspecialidades;
    }
    
}
