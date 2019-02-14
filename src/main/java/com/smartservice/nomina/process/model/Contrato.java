package com.smartservice.nomina.process.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contrato", schema = "empresa")
public class Contrato {

    @Id
    @Column(name = "id_contrato")
    @SequenceGenerator(name="empresa.contrato_id_contrato_seq", sequenceName="empresa.contrato_id_contrato_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa.contrato_id_contrato_seq")
    private long idContrato;

    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    private Empleado empleado;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "tipo_contrato")
    private int tipoContrato;

    @Column(name = "periodo_pago")
    private String periodoPago;

    @Column(name = "sueldo")
    private long sueldo;

    @Column(name = "jornada")
    private int jornada;

    @ManyToOne
    @JoinColumn(name = "centro_costos")
    private CentroCostos centroCostos;

    @ManyToOne
    @JoinColumn(name = "sub_centro_costos")
    private CentroCostos subCentroCostos;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "id_eps")
    private EntidadParafiscal eps;

    @ManyToOne
    @JoinColumn(name = "id_caja_compensacion")
    private EntidadParafiscal cajaCompensacion;

    @ManyToOne
    @JoinColumn(name = "id_arl")
    private EntidadParafiscal arl;

    @ManyToOne
    @JoinColumn(name = "id_fondo_pension")
    private EntidadParafiscal fondoPension;

    @ManyToOne
    @JoinColumn(name = "id_fondo_cesantias")
    private EntidadParafiscal fondoCesantias;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "estado")
    private String estado;

    @Column(name = "id_empresa")
    private long idEmpresa;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    public long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(long idContrato) {
        this.idContrato = idContrato;
    }


    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(int tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getPeriodoPago() {
        return periodoPago;
    }

    public void setPeriodoPago(String periodoPago) {
        this.periodoPago = periodoPago;
    }

    public long getSueldo() {
        return sueldo;
    }

    public void setSueldo(long sueldo) {
        this.sueldo = sueldo;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public CentroCostos getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(CentroCostos centroCostos) {
        this.centroCostos = centroCostos;
    }

    public CentroCostos getSubCentroCostos() {
        return subCentroCostos;
    }

    public void setSubCentroCostos(CentroCostos subCentroCostos) {
        this.subCentroCostos = subCentroCostos;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public EntidadParafiscal getEps() {
        return eps;
    }

    public void setEps(EntidadParafiscal eps) {
        this.eps = eps;
    }

    public EntidadParafiscal getCajaCompensacion() {
        return cajaCompensacion;
    }

    public void setCajaCompensacion(EntidadParafiscal cajaCompensacion) {
        this.cajaCompensacion = cajaCompensacion;
    }

    public EntidadParafiscal getArl() {
        return arl;
    }

    public void setArl(EntidadParafiscal arl) {
        this.arl = arl;
    }

    public EntidadParafiscal getFondoPension() {
        return fondoPension;
    }

    public void setFondoPension(EntidadParafiscal fondoPension) {
        this.fondoPension = fondoPension;
    }

    public EntidadParafiscal getFondoCesantias() {
        return fondoCesantias;
    }

    public void setFondoCesantias(EntidadParafiscal fondoCesantias) {
        this.fondoCesantias = fondoCesantias;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }}
