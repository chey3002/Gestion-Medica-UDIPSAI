/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comons.negocio;

import java.sql.Date;

/**
 *
 * @author carlos
 */
public class Paciente {
    public Date FechaApertura;
    public Integer id;
    public String Nombres;
    public Date fechanacimiento;
    public String Ciudad;
    public String Domicilio;
    public String Edad;
    public String Cedula;
    public String SectorEst;
    public String Barrio;
    public String Telefono;
    public String Celular;
    public String Correo;
    public String PresentaDiscapacidad;
    public String PortadordelCarnet;
    public String Tipodediscapacidad;
    public String InstitucionEducativa;
    public String Direccion;
    public String SectorInst;
    public String EducacionInclusiva;
    public String Jornada;
    public String TipodeInstitucion;
    public String Paralelo;
    public String TelefonoInst;
    public String AnioEGB_BGU;
    public String DisponeInternet;
    public String Dispositivo;
    public String TipodeInternet;
    public String MotivoConsulta;
    public String Observaciones;

    public Paciente(int id,String cedula, String nombres){
        this.id=id;
        this.Cedula=cedula;
        this.Nombres=nombres;
    }
    public Paciente(Date FechaApertura, Integer NumeroFicha, String Nombres, Date lugaryfechanacimiento, String Ciudad, String Domicilio, String Edad, String Cedula, String SectorEst, String Barrio, String Telefono, String Celular, String Correo, String PresentaDiscapacidad, String PortadordelCarnet, String Tipodediscapacidad, String InstitucionEducativa, String Direccion, String SectorInst, String EducacionInclusiva, String Jornada, String TipodeInstitucion, String Paralelo, String TelefonoInst, String AnioEGB_BGU, String DisponeInternet, String Dispositivo, String TipodeInternet, String MotivoConsulta, String Observaciones) {
        this.FechaApertura = FechaApertura;
        this.id = NumeroFicha;
        this.Nombres = Nombres;
        this.fechanacimiento = lugaryfechanacimiento;
        this.Ciudad = Ciudad;
        this.Domicilio = Domicilio;
        this.Edad = Edad;
        this.Cedula = Cedula;
        this.SectorEst = SectorEst;
        this.Barrio = Barrio;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Correo = Correo;
        this.PresentaDiscapacidad = PresentaDiscapacidad;
        this.PortadordelCarnet = PortadordelCarnet;
        this.Tipodediscapacidad = Tipodediscapacidad;
        this.InstitucionEducativa = InstitucionEducativa;
        this.Direccion = Direccion;
        this.SectorInst = SectorInst;
        this.EducacionInclusiva = EducacionInclusiva;
        this.Jornada = Jornada;
        this.TipodeInstitucion = TipodeInstitucion;
        this.Paralelo = Paralelo;
        this.TelefonoInst = TelefonoInst;
        this.AnioEGB_BGU = AnioEGB_BGU;
        this.DisponeInternet = DisponeInternet;
        this.Dispositivo = Dispositivo;
        this.TipodeInternet = TipodeInternet;
        this.MotivoConsulta = MotivoConsulta;
        this.Observaciones = Observaciones;
    }

    public Date getFechaApertura() {
        return FechaApertura;
    }

    public void setFechaApertura(Date FechaApertura) {
        this.FechaApertura = FechaApertura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getSectorEst() {
        return SectorEst;
    }

    public void setSectorEst(String SectorEst) {
        this.SectorEst = SectorEst;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getPresentaDiscapacidad() {
        return PresentaDiscapacidad;
    }

    public void setPresentaDiscapacidad(String PresentaDiscapacidad) {
        this.PresentaDiscapacidad = PresentaDiscapacidad;
    }

    public String getPortadordelCarnet() {
        return PortadordelCarnet;
    }

    public void setPortadordelCarnet(String PortadordelCarnet) {
        this.PortadordelCarnet = PortadordelCarnet;
    }

    public String getTipodediscapacidad() {
        return Tipodediscapacidad;
    }

    public void setTipodediscapacidad(String Tipodediscapacidad) {
        this.Tipodediscapacidad = Tipodediscapacidad;
    }

    public String getInstitucionEducativa() {
        return InstitucionEducativa;
    }

    public void setInstitucionEducativa(String InstitucionEducativa) {
        this.InstitucionEducativa = InstitucionEducativa;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getSectorInst() {
        return SectorInst;
    }

    public void setSectorInst(String SectorInst) {
        this.SectorInst = SectorInst;
    }

    public String getEducacionInclusiva() {
        return EducacionInclusiva;
    }

    public void setEducacionInclusiva(String EducacionInclusiva) {
        this.EducacionInclusiva = EducacionInclusiva;
    }

    public String getJornada() {
        return Jornada;
    }

    public void setJornada(String Jornada) {
        this.Jornada = Jornada;
    }

    public String getTipodeInstitucion() {
        return TipodeInstitucion;
    }

    public void setTipodeInstitucion(String TipodeInstitucion) {
        this.TipodeInstitucion = TipodeInstitucion;
    }

    public String getParalelo() {
        return Paralelo;
    }

    public void setParalelo(String Paralelo) {
        this.Paralelo = Paralelo;
    }

    public String getTelefonoInst() {
        return TelefonoInst;
    }

    public void setTelefonoInst(String TelefonoInst) {
        this.TelefonoInst = TelefonoInst;
    }

    public String getAnioEGB_BGU() {
        return AnioEGB_BGU;
    }

    public void setAnioEGB_BGU(String AnioEGB_BGU) {
        this.AnioEGB_BGU = AnioEGB_BGU;
    }

    public String getDisponeInternet() {
        return DisponeInternet;
    }

    public void setDisponeInternet(String DisponeInternet) {
        this.DisponeInternet = DisponeInternet;
    }

    public String getDispositivo() {
        return Dispositivo;
    }

    public void setDispositivo(String Dispositivo) {
        this.Dispositivo = Dispositivo;
    }

    public String getTipodeInternet() {
        return TipodeInternet;
    }

    public void setTipodeInternet(String TipodeInternet) {
        this.TipodeInternet = TipodeInternet;
    }

    public String getMotivoConsulta() {
        return MotivoConsulta;
    }

    public void setMotivoConsulta(String MotivoConsulta) {
        this.MotivoConsulta = MotivoConsulta;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }
    
    
}
