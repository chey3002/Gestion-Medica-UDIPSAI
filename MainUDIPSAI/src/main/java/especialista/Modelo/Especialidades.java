/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.Modelo;

/**
 *
 * @author Usuario
 */
public class Especialidades {
    
    int id_Especialidad;
    String nombre_Especialidad;

    public Especialidades(int id_Especialidad, String nombre_Especialidad) {
        this.id_Especialidad = id_Especialidad;
        this.nombre_Especialidad = nombre_Especialidad;
    }

    

    public Especialidades(String nombre_Especialidad) {
        this.nombre_Especialidad = nombre_Especialidad;
    }

   
    

    public int getId_Especialidad() {
        return id_Especialidad;
    }

    public void setId_Especialidad(int id_Especialidad) {
        this.id_Especialidad = id_Especialidad;
    }

    public String getNombre_Especialidad() {
        return nombre_Especialidad;
    }

    public void setNombre_Especialidad(String nombre_Especialidad) {
        this.nombre_Especialidad = nombre_Especialidad;
    }

    @Override
    public String toString() {
        return nombre_Especialidad;
    }
    
    
    
}
