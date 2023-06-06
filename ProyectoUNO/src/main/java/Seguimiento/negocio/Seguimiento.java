/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguimiento.negocio;

import java.util.Date;

/**
 *
 * @author carlos
 */
public class Seguimiento {
    int id;
    int idPaciente;
    String cedulaEspecialista;
    Date fecha;
    String observacion;

    public Seguimiento(int idPaciente, String cedulaEspecialista, String observacion) {

        this.idPaciente = idPaciente;
        this.cedulaEspecialista = cedulaEspecialista;
        this.observacion = observacion;
        this.fecha=new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getCedulaEspecialista() {
        return cedulaEspecialista;
    }

    public void setCedulaEspecialista(String cedulaEspecialista) {
        this.cedulaEspecialista = cedulaEspecialista;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    
}
