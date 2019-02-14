package com.smartservice.nomina.process.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "periodo_nomina", schema = "empresa")
public class PeriodoNomina {

    @Id
    @Column(name = "id_periodo_nomina")
    @SequenceGenerator(name="empresa.periodos_nomina_id_periodos_nomina_seq", sequenceName="empresa.periodos_nomina_id_periodos_nomina_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa.periodos_nomina_id_periodos_nomina_seq")
    private long idPeriodoNomina;

    @Column(name = "tipo_nomina")
    private String tipoNomina;

    @Column(name = "year")
    private int year;

    @Column(name = "periodo")
    private String periodo;

    @Column(name = "fecha_pago")
    private Date fechaPago;

    @Column(name = "id_empresa")
    private long idEmpresa;

    public long getIdPeriodoNomina() {
        return idPeriodoNomina;
    }

    public void setIdPeriodoNomina(long idPeriodoNomina) {
        this.idPeriodoNomina = idPeriodoNomina;
    }

    public String getTipoNomina() {
        return tipoNomina;
    }

    public void setTipoNomina(String tipoNomina) {
        this.tipoNomina = tipoNomina;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
