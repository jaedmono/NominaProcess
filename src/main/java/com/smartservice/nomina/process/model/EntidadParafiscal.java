package com.smartservice.nomina.process.model;

import javax.persistence.*;

@Entity
@Table(name = "entidad_parafiscal", schema = "public")
public class EntidadParafiscal {

    @Id
    @Column(name = "id_entidad")
    @SequenceGenerator(name="entidad_parafiscal_id_entidad_seq", sequenceName="entidad_parafiscal_id_entidad_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="entidad_parafiscal_id_entidad_seq")
    private long idEntidad;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private long telefono;

    @Column(name = "pagina_web")
    private String paginaWeb;

    @Column(name = "email")
    private String email;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "tipo_entidad")
    private String tipoEntidad;

    public long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(long idEntidad) {
        this.idEntidad = idEntidad;
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

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }
}
