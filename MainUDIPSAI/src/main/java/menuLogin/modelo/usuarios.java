/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuLogin.modelo;

import java.util.Date;



/**
 *
 * @author LENOVO
 */
public class usuarios {
    private String cedula;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private int id_especialidad;
    private String esPasante;
    private String especialistaAsignado;
    private String contrasenia;
    private String area;

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

    public String getEsPasante() {
        return esPasante;
    }

    public void setEsPasante(String esPasante) {
        this.esPasante = esPasante;
    }

    public String getEspecialistaAsignado() {
        return especialistaAsignado;
    }

    public void setEspecialistaAsignado(String especialistaAsignado) {
        this.especialistaAsignado = especialistaAsignado;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
   public String getNombre() {
        return getPrimerNombre()+" "+getSegundoNombre()+" "+getPrimerApellido()+" "+getSegundoApellido();
    }
    
    
}
