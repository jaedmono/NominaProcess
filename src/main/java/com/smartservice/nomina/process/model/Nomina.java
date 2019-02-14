package com.smartservice.nomina.process.model;

import javax.persistence.*;

@Entity
@Table(name = "nomina", schema = "empresa")
public class Nomina {

    @Id
    @Column(name = "id_nomina")
    @SequenceGenerator(name="empresa.nomina_id_nomina_seq", sequenceName="empresa.nomina_id_nomina_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa.nomina_id_nomina_seq")
    private long idNomina;

    @Column(name = "id_empresa")
    private long idEmpresa;

    @ManyToOne
    @JoinColumn(name = "periodo_nomina")
    private PeriodoNomina periodoNomina;

    @Column(name = "estado")
    private String estado;

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

    public long getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(long idNomina) {
        this.idNomina = idNomina;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public PeriodoNomina getPeriodoNomina() {
        return periodoNomina;
    }

    public void setPeriodoNomina(PeriodoNomina periodoNomina) {
        this.periodoNomina = periodoNomina;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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


    @Override
    public String toString() {
        return "Nomina{" +
                "idNomina=" + idNomina +
                ", idEmpresa=" + idEmpresa +
                ", periodoNomina='" + periodoNomina + '\'' +
                ", estado='" + estado + '\'' +
                ", totalEps=" + totalEps +
                ", totalPension=" + totalPension +
                ", totalCesantias=" + totalCesantias +
                ", totalDeducido=" + totalDeducido +
                ", totalDevengado=" + totalDevengado +
                ", pagoNeto=" + pagoNeto +
                '}';
    }}
