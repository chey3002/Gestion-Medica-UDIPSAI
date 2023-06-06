/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Especialista {
    
    String cedula;
    String primerNombre;
    String segundoNombre;
    String primerApellido;
    String segundoApellido;
    int id_especialidad;
    boolean esPasante;
    String nombreEspecilistaResponsable; 
    String contraseña;
    boolean estaActivo;
   

    public Especialista() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public boolean isEsPasante() {
        return esPasante;
    }

    public void setEsPasante(boolean esPasante) {
        this.esPasante = esPasante;
    }

    public String getNombreEspecilistaResponsable() {
        return nombreEspecilistaResponsable;
    }

    public void setNombreEspecilistaResponsable(String nombreEspecilistaResponsable) {
        this.nombreEspecilistaResponsable = nombreEspecilistaResponsable;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    @Override
    public String toString() {
        return "Especialista{" + "cedula=" + cedula + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", id_especialidad=" + id_especialidad + ", esPasante=" + esPasante + ", nombreEspecilistaResponsable=" + nombreEspecilistaResponsable + ", contrase\u00f1a=" + contraseña + ", estaActivo=" + estaActivo + '}';
    }

   
    
    
    
    
    
    
}
