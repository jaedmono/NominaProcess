package com.smartservice.nomina.process.model;

import com.opencsv.bean.CsvBindByName;

public class ArchivoNovedadesRecords {

    @CsvBindByName
    private String documento;

    @CsvBindByName
    private String idConcepto;

    @CsvBindByName
    private String cantidad;

    @CsvBindByName
    private String valor;

    @CsvBindByName
    private String centroCostos;

    @CsvBindByName
    private String subCentroCostos;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(String centroCostos) {
        this.centroCostos = centroCostos;
    }

    public String getSubCentroCostos() {
        return subCentroCostos;
    }

    public void setSubCentroCostos(String subCentroCostos) {
        this.subCentroCostos = subCentroCostos;
    }

    @Override
    public String toString() {
        return "ArchivoNovedadesRecords{" +
                "documento=" + documento +
                ", idConcepto=" + idConcepto +
                ", cantidad=" + cantidad +
                ", valor=" + valor +
                ", centroCostos=" + centroCostos +
                ", subCentroCostos=" + subCentroCostos +
                '}';
    }
}
