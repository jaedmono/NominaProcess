package com.smartservice.nomina.process.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "novedad_programada", schema = "empresa")
public class NovedadProgramada {

    @Id
    @Column(name = "id_novedad_programada")
    @SequenceGenerator(name="empresa.novedad_programada_id_novedad_programada_seq", sequenceName="empresa.novedad_programada_id_novedad_programada_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa.novedad_programada_id_novedad_programada_seq")
    private long idNovedadProgramada;

    @Column(name = "id_concepto")
    private long idConcepto;

    @Column(name = "cantidad")
    private long cantidad;

    @Column(name = "valor")
    private long valor;

    @Column(name = "id_contrato")
    private long idContrato;

    @Column(name = "estado_novedad")
    private String estadoNovedad;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;


    public long getIdNovedadProgramada() {
        return idNovedadProgramada;
    }

    public void setIdNovedadProgramada(long idNovedadProgramada) {
        this.idNovedadProgramada = idNovedadProgramada;
    }

    public long getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(long idConcepto) {
        this.idConcepto = idConcepto;
    }

    public long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(long idContrato) {
        this.idContrato = idContrato;
    }

    public String getEstadoNovedad() {
        return estadoNovedad;
    }

    public void setEstadoNovedad(String estadoNovedad) {
        this.estadoNovedad = estadoNovedad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }
}