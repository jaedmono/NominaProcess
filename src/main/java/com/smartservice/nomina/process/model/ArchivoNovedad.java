package com.smartservice.nomina.process.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "archivos_novedades", schema = "empresa" )
public class ArchivoNovedad {

    @Id
    @Column(name = "id_archivo_novedad")
    @SequenceGenerator(name="empresa.archivos_novedades_id_archivo_novedad_seq", sequenceName="empresa.archivos_novedades_id_archivo_novedad_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="empresa.archivos_novedades_id_archivo_novedad_seq")
    private long idArchivoNovedad;

    @Column(name = "nombre_archivo")
    private String nombreArchivo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_carga")
    private Date fechaCarga;

    @Column(name = "fecha_proceso")
    private Date fechaProceso;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public long getIdArchivoNovedad() {
        return idArchivoNovedad;
    }

    public void setIdArchivoNovedad(long idArchivoNovedad) {
        this.idArchivoNovedad = idArchivoNovedad;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "ArchivoNovedad{" +
                "idArchivoNovedad=" + idArchivoNovedad +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaCarga=" + fechaCarga +
                ", fechaProceso=" + fechaProceso +
                ", empresa=" + empresa +
                '}';
    }
}