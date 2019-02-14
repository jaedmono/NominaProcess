package com.smartservice.nomina.process.model;

import javax.persistence.*;

@Entity
@Table(name = "nomina_contrato", schema = "empresa")
public class NominaContrato {

    @Id
    @Column(name = "id_nomina_contrato")
    @SequenceGenerator(name="empresa.nomina_contrato_id_nomina_contrato_seq", sequenceName="empresa.nomina_contrato_id_nomina_contrato_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa.nomina_contrato_id_nomina_contrato_seq")
    private long idNominaContrato;

    @Column(name = "id_nomina")
    private long idNomina;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @Column(name = "total_eps")
    private long totalEps;

    @Column(name = "total_pension")
    private long totalPension;

    @Column(name = "total_cesantias")
    private long totalCesantias;

    @Column(name = "total_deducido")
    private long totalDeducido;

    @Column(name = "total_devengado")
    private long totalDevengado;

    @Column(name = "pago_neto")
    private long pagoNeto;

    public long getIdNominaContrato() {
        return idNominaContrato;
    }

    public void setIdNominaContrato(long idNominaContrato) {
        this.idNominaContrato = idNominaContrato;
    }

    public long getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(long idNomina) {
        this.idNomina = idNomina;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public long getTotalEps() {
        return totalEps;
    }

    public void setTotalEps(long totalEps) {
        this.totalEps = totalEps;
    }

    public long getTotalPension() {
        return totalPension;
    }

    public void setTotalPension(long totalPension) {
        this.totalPension = totalPension;
    }

    public long getTotalCesantias() {
        return totalCesantias;
    }

    public void setTotalCesantias(long totalCesantias) {
        this.totalCesantias = totalCesantias;
    }

    public long getTotalDeducido() {
        return totalDeducido;
    }

    public void setTotalDeducido(long totalDeducido) {
        this.totalDeducido = totalDeducido;
    }

    public long getTotalDevengado() {
        return totalDevengado;
    }

    public void setTotalDevengado(long totalDevengado) {
        this.totalDevengado = totalDevengado;
    }

    public long getPagoNeto() {
        return pagoNeto;
    }

    public void setPagoNeto(long pagoNeto) {
        this.pagoNeto = pagoNeto;
    }
}