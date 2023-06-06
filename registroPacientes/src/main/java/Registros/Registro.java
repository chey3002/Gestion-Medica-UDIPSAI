/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registros;

import java.sql.Date;

/**
 *
 * @author Francisco
 */
public class Registro {
    public Date FechaApertura;
    public Integer NumeroFicha;
    public String Nombres;
    public String lugaryfechanacimiento;
    public String Ciudad;
    public String Domicilio;
    public String Edad;
    public Integer Cedula;
    public String SectorEst;
    public String Barrio;
    public Integer Telefono;
    public Integer Celular;
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
    public Integer TelefonoInst;
    public Date AnioEGB_BGU;
    public String DisponeInternet;
    public String Dispositivo;
    public String TipodeInternet;
    public String MotivoConsulta;
    public String Observaciones;

    public Registro(Date FechaApertura, Integer NumeroFicha, String Nombres, String lugaryfechanacimiento, String Ciudad, String Domicilio, String Edad, Integer Cedula, String SectorEst, String Barrio, Integer Telefono, Integer Celular, String Correo, String PresentaDiscapacidad, String PortadordelCarnet, String Tipodediscapacidad, String InstitucionEducativa, String Direccion, String SectorInst, String EducacionInclusiva, String Jornada, String TipodeInstitucion, String Paralelo, Integer TelefonoInst, Date AnioEGB_BGU, String DisponeInternet, String Dispositivo, String TipodeInternet, String MotivoConsulta, String Observaciones) {
        this.FechaApertura = FechaApertura;
        this.NumeroFicha = NumeroFicha;
        this.Nombres = Nombres;
        this.lugaryfechanacimiento = lugaryfechanacimiento;
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

    public Integer getNumeroFicha() {
        return NumeroFicha;
    }

    public void setNumeroFicha(Integer NumeroFicha) {
        this.NumeroFicha = NumeroFicha;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getLugaryfechanacimiento() {
        return lugaryfechanacimiento;
    }

    public void setLugaryfechanacimiento(String lugaryfechanacimiento) {
        this.lugaryfechanacimiento = lugaryfechanacimiento;
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

    public Integer getCedula() {
        return Cedula;
    }

    public void setCedula(Integer Cedula) {
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

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer Telefono) {
        this.Telefono = Telefono;
    }

    public Integer getCelular() {
        return Celular;
    }

    public void setCelular(Integer Celular) {
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

    public Integer getTelefonoInst() {
        return TelefonoInst;
    }

    public void setTelefonoInst(Integer TelefonoInst) {
        this.TelefonoInst = TelefonoInst;
    }

    public Date getAnioEGB_BGU() {
        return AnioEGB_BGU;
    }

    public void setAnioEGB_BGU(Date AnioEGB_BGU) {
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
