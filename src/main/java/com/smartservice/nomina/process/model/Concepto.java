package com.smartservice.nomina.process.model;

import javax.persistence.*;

@Entity
@Table(name = "concepto", schema = "public")
public class Concepto {

    @Id
    @Column(name = "id_concepto")
    @SequenceGenerator(name="concepto_id_concepto_seq", sequenceName="concepto_id_concepto_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="concepto_id_concepto_seq")
    private long idConcepto;

    @Column(name = "desc_concepto")
    private String descripcion;

    @Column(name = "tipo_nomina")
    private String tipoNomina;

    @Column(name = "naturaleza")
    private String naturaleza;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "factor")
    private double factor;

    @Column(name = "ibc_seguridad_social")
    private String ibcSeguridadSocial;

    @Column(name = "clasificacion")
    private String clasificacion;

    @Column(name = "modo_liquidacion")
    private String modoLiquidacion;

    @Column(name = "cruza_con_salario")
    private boolean cruzaConSalario;

    @Column(name = "relacionado_con")
    private String realcionadoCon;

    @Column(name = "pago_indirecto")
    private boolean pagoIndirecto;

    @Column(name = "aplica_salud")
    private boolean aplicaSalud;

    @Column(name = "aplica_pension")
    private boolean aplicaPension;

    @Column(name = "aplica_arl")
    private boolean aplicaArl;

    @Column(name = "aplica_retencion")
    private boolean aplicaRetencion;

    @Column(name = "aplica_prima_servicios")
    private boolean aplicaPrimaServicios;

    @Column(name = "aplica_cesantias")
    private boolean aplicaCesantias;

    @Column(name = "contrato_liq_vacaciones")
    private boolean contratoLiqVacaciones;

    @Column(name = "aplica_subsidio_transporte")
    private boolean aplicaSubsidioTransporte;

    @Column(name = "aplica_caja_compemsacion")
    private boolean aplicaCajaCompensacion;

    @Column(name = "aplica_icbf")
    private boolean aplicaIcbf;

    @Column(name = "aplica_sena")
    private boolean aplicaSena;

    @Column(name = "aplica_ley_1393")
    private boolean aplicaLey1393;

    @Column(name = "tope_maximo")
    private long topeMaximo;

    @Column(name = "clase")
    private String clase;


    public long getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(long idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoNomina() {
        return tipoNomina;
    }

    public void setTipoNomina(String tipoNomina) {
        this.tipoNomina = tipoNomina;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public String getIbcSeguridadSocial() {
        return ibcSeguridadSocial;
    }

    public void setIbcSeguridadSocial(String ibcSeguridadSocial) {
        this.ibcSeguridadSocial = ibcSeguridadSocial;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getModoLiquidacion() {
        return modoLiquidacion;
    }

    public void setModoLiquidacion(String modoLiquidacion) {
        this.modoLiquidacion = modoLiquidacion;
    }

    public boolean isCruzaConSalario() {
        return cruzaConSalario;
    }

    public void setCruzaConSalario(boolean cruzaConSalario) {
        this.cruzaConSalario = cruzaConSalario;
    }

    public String getRealcionadoCon() {
        return realcionadoCon;
    }

    public void setRealcionadoCon(String realcionadoCon) {
        this.realcionadoCon = realcionadoCon;
    }

    public boolean isPagoIndirecto() {
        return pagoIndirecto;
    }

    public void setPagoIndirecto(boolean pagoIndirecto) {
        this.pagoIndirecto = pagoIndirecto;
    }

    public boolean isAplicaSalud() {
        return aplicaSalud;
    }

    public void setAplicaSalud(boolean aplicaSalud) {
        this.aplicaSalud = aplicaSalud;
    }

    public boolean isAplicaPension() {
        return aplicaPension;
    }

    public void setAplicaPension(boolean aplicaPension) {
        this.aplicaPension = aplicaPension;
    }

    public boolean isAplicaArl() {
        return aplicaArl;
    }

    public void setAplicaArl(boolean aplicaArl) {
        this.aplicaArl = aplicaArl;
    }

    public boolean isAplicaRetencion() {
        return aplicaRetencion;
    }

    public void setAplicaRetencion(boolean aplicaRetencion) {
        this.aplicaRetencion = aplicaRetencion;
    }

    public boolean isAplicaPrimaServicios() {
        return aplicaPrimaServicios;
    }

    public void setAplicaPrimaServicios(boolean aplicaPrimaServicios) {
        this.aplicaPrimaServicios = aplicaPrimaServicios;
    }

    public boolean isAplicaCesantias() {
        return aplicaCesantias;
    }

    public void setAplicaCesantias(boolean aplicaCesantias) {
        this.aplicaCesantias = aplicaCesantias;
    }

    public boolean isContratoLiqVacaciones() {
        return contratoLiqVacaciones;
    }

    public void setContratoLiqVacaciones(boolean contratoLiqVacaciones) {
        this.contratoLiqVacaciones = contratoLiqVacaciones;
    }

    public boolean isAplicaSubsidioTransporte() {
        return aplicaSubsidioTransporte;
    }

    public void setAplicaSubsidioTransporte(boolean aplicaSubsidioTransporte) {
        this.aplicaSubsidioTransporte = aplicaSubsidioTransporte;
    }

    public boolean isAplicaCajaCompensacion() {
        return aplicaCajaCompensacion;
    }

    public void setAplicaCajaCompensacion(boolean aplicaCajaCompensacion) {
        this.aplicaCajaCompensacion = aplicaCajaCompensacion;
    }

    public boolean isAplicaIcbf() {
        return aplicaIcbf;
    }

    public void setAplicaIcbf(boolean aplicaIcbf) {
        this.aplicaIcbf = aplicaIcbf;
    }

    public boolean isAplicaSena() {
        return aplicaSena;
    }

    public void setAplicaSena(boolean aplicaSena) {
        this.aplicaSena = aplicaSena;
    }

    public boolean isAplicaLey1393() {
        return aplicaLey1393;
    }

    public void setAplicaLey1393(boolean aplicaLey1393) {
        this.aplicaLey1393 = aplicaLey1393;
    }

    public long getTopeMaximo() {
        return topeMaximo;
    }

    public void setTopeMaximo(long topeMaximo) {
        this.topeMaximo = topeMaximo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return new StringBuilder("Concepto [")
                .append("idConcepto").append(idConcepto).append(", ")
                .append("descripcion").append(descripcion).append("] ")
                .toString();
    }
}
