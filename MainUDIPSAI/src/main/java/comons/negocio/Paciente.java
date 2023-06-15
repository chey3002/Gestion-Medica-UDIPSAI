/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comons.negocio;

import java.util.Date;

/**
 *
 * @author carlos
 */
public class Paciente {

    public Integer id;
    public Date fechaApertura;
    public String nombresApellidos;
    public String ciudad;
    public Date fechaNacimiento;
    public String edad;
    public String cedula;
    public String domicilio;
    public String barrio;
    public String telefono;
    public String celular;
    public String institucionEducativa;
    public String tipoInstitucion;
    public String sector;
    public String jornada;
    public String telefonoInstitucion;
    public String anioEducacion;
    public String paralelo;
    public String perteneceInclusion;
    public String tieneDiscapacidad;
    public String portadorCarnet;
    public String diagnostico;
    public String motivoConsulta;
    public String observaciones;
    public String nombreExaminador;
    public String anotaciones;

    public Paciente(Integer id, Date fechaApertura, String nombresApellidos, String ciudad, Date fechaNacimiento, String edad, String cedula, String domicilio, String barrio, String telefono, String celular, String institucionEducativa, String tipoInstitucion, String sector, String jornada, String telefonoInstitucion, String anioEducacion, String paralelo, String perteneceInclusion, String tieneDiscapacidad, String portadorCarnet, String diagnostico, String motivoConsulta, String observaciones, String nombreExaminador, String anotaciones) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.nombresApellidos = nombresApellidos;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.cedula = cedula;
        this.domicilio = domicilio;
        this.barrio = barrio;
        this.telefono = telefono;
        this.celular = celular;
        this.institucionEducativa = institucionEducativa;
        this.tipoInstitucion = tipoInstitucion;
        this.sector = sector;
        this.jornada = jornada;
        this.telefonoInstitucion = telefonoInstitucion;
        this.anioEducacion = anioEducacion;
        this.paralelo = paralelo;
        this.perteneceInclusion = perteneceInclusion;
        this.tieneDiscapacidad = tieneDiscapacidad;
        this.portadorCarnet = portadorCarnet;
        this.diagnostico = diagnostico;
        this.motivoConsulta = motivoConsulta;
        this.observaciones = observaciones;
        this.nombreExaminador = nombreExaminador;
        this.anotaciones = anotaciones;
    }
    
    public Paciente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getInstitucionEducativa() {
        return institucionEducativa;
    }

    public void setInstitucionEducativa(String institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

    public String getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(String tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getTelefonoInstitucion() {
        return telefonoInstitucion;
    }

    public void setTelefonoInstitucion(String telefonoInstitucion) {
        this.telefonoInstitucion = telefonoInstitucion;
    }

    public String getAnioEducacion() {
        return anioEducacion;
    }

    public void setAnioEducacion(String anioEducacion) {
        this.anioEducacion = anioEducacion;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public String getPerteneceInclusion() {
        return perteneceInclusion;
    }

    public void setPerteneceInclusion(String perteneceInclusion) {
        this.perteneceInclusion = perteneceInclusion;
    }

    public String getTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public void setTieneDiscapacidad(String tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }

    public String getPortadorCarnet() {
        return portadorCarnet;
    }

    public void setPortadorCarnet(String portadorCarnet) {
        this.portadorCarnet = portadorCarnet;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombreExaminador() {
        return nombreExaminador;
    }

    public void setNombreExaminador(String nombreExaminador) {
        this.nombreExaminador = nombreExaminador;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

}
