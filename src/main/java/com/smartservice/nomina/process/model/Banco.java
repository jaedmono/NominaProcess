package com.smartservice.nomina.process.model;

import javax.persistence.*;

@Entity
@Table(name = "banco", schema = "public" )
public class Banco {

    @Id
    @Column(name = "id_banco")
    @SequenceGenerator(name="banco_id_banco_seq", sequenceName="banco_id_banco_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="banco_id_banco_seq")
    private long idBanco;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private long telefono;

    @Column(name = "email")
    private String email;

    public long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(long idBanco) {
        this.idBanco = idBanco;
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

    @Override
    public String toString(){
        return String.format("Banco:{[Id: %s ],[Razon Social: %s ],[Direccion: %s ],[Telefono: %s ],[Email: %s ]  }",
                this.idBanco, this.razonSocial,this.direccion,this.telefono,this.email);
    }
}
