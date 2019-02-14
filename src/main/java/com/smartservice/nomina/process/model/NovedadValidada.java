package com.smartservice.nomina.process.model;

import com.smartservice.nomina.process.util.StatusNewsLoaded;

import javax.persistence.*;

@Entity
@Table(name = "novedad_validada", schema = "empresa")
public class NovedadValidada {

    @Id
    @Column(name = "id_novedad_validada")
    @SequenceGenerator(name="empresa.novedad_validada_id_novedad_validada_seq", sequenceName="empresa.novedad_validada_id_novedad_validada_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa.novedad_validada_id_novedad_validada_seq")
    private long idNovedadValidada;

    @Column(name = "id_archivo_novedad")
    private long idArchivoNovedad;

    @Column(name = "id_contrato")
    private long idContrato;

    @ManyToOne
    @JoinColumn(name = "id_concepto")
    private Concepto concepto;


    @Column(name = "cantidad")
    private long cantidad;


    @Column(name = "valor")
    private long valor;


    @Column(name = "centro_costos")
    private long centroCostos;


    @Column(name = "sub_centro_costos")
    private long subCentroCostos;


    @Column(name = "estado")
    private String estado;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "id_empresa")
    private long idEmpresa;


    public long getIdNovedadValidada() {
        return idNovedadValidada;
    }

    public void setIdNovedadValidada(long idNovedadValidada) {
        this.idNovedadValidada = idNovedadValidada;
    }

    public long getIdArchivoNovedad() {
        return idArchivoNovedad;
    }

    public void setIdArchivoNovedad(long idArchivoNovedad) {
        this.idArchivoNovedad = idArchivoNovedad;
    }

    public long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(long idContrato) {
        this.idContrato = idContrato;
    }

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
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

    public long getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(long centroCostos) {
        this.centroCostos = centroCostos;
    }

    public long getSubCentroCostos() {
        return subCentroCostos;
    }

    public void setSubCentroCostos(long subCentroCostos) {
        this.subCentroCostos = subCentroCostos;
    }

    public StatusNewsLoaded getEstado() {
        return StatusNewsLoaded.valueOf(estado);
    }

    public void setEstado(StatusNewsLoaded estado) {
        this.estado = estado.name();
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "NovedadValidada{" +
                "idNovedadValidada=" + idNovedadValidada +
                ", idArchivoNovedad=" + idArchivoNovedad +
                ", idContrato=" + idContrato +
                ", concepto=" + concepto +
                ", cantidad=" + cantidad +
                ", valor=" + valor +
                ", centroCostos=" + centroCostos +
                ", subCentroCostos=" + subCentroCostos +
                ", estado=" + estado +
                ", observacion='" + observacion + '\'' +
                ", idEmpresa=" + idEmpresa +
                '}';
    }
}
