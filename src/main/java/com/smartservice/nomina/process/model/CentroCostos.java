package com.smartservice.nomina.process.model;

import javax.persistence.*;

@Entity
@Table(name = "centro_costos", schema = "public")
public class CentroCostos {

    @Id
    @Column(name = "id_centro_costos")
    @SequenceGenerator(name="centro_costos_id_centro_costos_seq", sequenceName="centro_costos_id_centro_costos_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="centro_costos_id_centro_costos_seq")
    private long idCentroCostos;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "relacion_centro_costos")
    private long relacionCentroCostos;

    @Column(name="codigo")
    private String codigo;

    public long getIdCentroCostos() {
        return idCentroCostos;
    }

    public void setIdCentroCostos(long idCentroCostos) {
        this.idCentroCostos = idCentroCostos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getRelacionCentroCostos() {
        return relacionCentroCostos;
    }

    public void setRelacionCentroCostos(long relacionCentroCostos) {
        this.relacionCentroCostos = relacionCentroCostos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString(){
        return String.format("Centro Costos:{[Id: %s ],[Codigo: %s ],[Descripcion: %s ],[Tipo: %s ],[Relacion: %s ]  }",
                this.idCentroCostos,this.codigo,this.descripcion,this.tipo,this.relacionCentroCostos);
    }
}
