package com.smartservice.nomina.process.model;

import javax.persistence.*;

@Entity
@Table(name = "nomina_novedad", schema = "empresa")
public class NominaNovedad {

    @Id
    @Column(name = "id_nomina_novedad")
    @SequenceGenerator(name="empresa.nomina_novedad_id_nomina_novedad_seq", sequenceName="empresa.nomina_novedad_id_nomina_novedad_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa.nomina_novedad_id_nomina_novedad_seq")
    private long idNominaNovedad;

    @Column(name = "id_nomina")
    private long idNomina;

    @Column(name = "id_contrato")
    private long idContrato;

    @ManyToOne
    @JoinColumn(name = "id_concepto")
    private Concepto concepto;

    @Column(name = "cantidad")
    private long cantidad;

    @Column(name = "valor")
    private long valor;

    @Column(name = "id_empresa")
    private long idEmpresa;

    public long getIdNominaNovedad() {
        return idNominaNovedad;
    }

    public void setIdNominaNovedad(long idNominaNovedad) {
        this.idNominaNovedad = idNominaNovedad;
    }

    public long getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(long idNomina) {
        this.idNomina = idNomina;
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

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(long idContrato) {
        this.idContrato = idContrato;
    }

    @Override
    public String toString() {
        return new StringBuilder("Nomina Novedad: [")
                .append("Id Nomina Novedad: ").append(idNominaNovedad).append(", ")
                .append("Id Nomina: ").append(idNomina).append(", ")
                .append("Id Contrato: ").append(idContrato).append(", ")
                .append("Concepto: ").append(concepto).append(", ")
                .append("Cantidad: ").append(cantidad).append(", ")
                .append("Valor: ").append(valor).append(", ")
                .append("Id Empresa: ").append(idEmpresa).append("] ")
                .toString();
    }
}
