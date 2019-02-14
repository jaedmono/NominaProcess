package com.smartservice.nomina.process.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "descuento", schema = "empresa")
public class Descuento {

    @Id
    @Column(name = "id_descuento")
    @SequenceGenerator(name="empresa.descuento_id_descuento_seq", sequenceName="empresa.descuento_id_descuento_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa.descuento_id_descuento_seq")
    private long idDescuento;

    @Column(name = "id_concepto")
    private long idConcepto;

    @Column(name = "id_contrato")
    private long idContrato;

    @Column(name = "total_descuento")
    private long totalDescuento;

    @Column(name = "numero_cuotas")
    private int numeroCuentas;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;

    @Column(name = "estado")
    private  String estado;

    @Column(name = "descripcion")
    private String descripcion;

    public long getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(long idDescuento) {
        this.idDescuento = idDescuento;
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

    public long getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(long totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public int getNumeroCuentas() {
        return numeroCuentas;
    }

    public void setNumeroCuentas(int numeroCuentas) {
        this.numeroCuentas = numeroCuentas;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}