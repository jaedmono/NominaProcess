package com.smartservice.nomina.process.model;

import javax.persistence.*;

@Entity
@Table(name = "empresa", schema = "public")
public class Empresa {

    @Id
    @Column(name = "id_empresa")
    @SequenceGenerator(name="empresa_id_empresa_seq", sequenceName="empresa_id_empresa_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa_id_empresa_seq")
    private long idEmpresa;

    @Column(name = "nit")
    private long nit;

    @Column(name = "digito_verificacion")
    private int digitoVerificacion;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private long telefono;

    @Column(name = "emial")
    private String email;

    @Column(name = "celular")
    private String celular;

    @Column(name = "id_usuario")
    private long idUsuario;

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public int getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(int digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}