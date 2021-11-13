package com.devappron.backendjava.data.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "entradas")
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {
    @Index(columnList = "entradaId", name="index_entradaId", unique = true) 
})
public class EntradaEntity implements Serializable {

    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String entradaId;

    @Column(nullable = false)
    private Date fecha;
    
    @Column(nullable = false)
    private String estatus;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String nombreMascota;

    @Column(nullable = false)
    private String raza;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String nombreDueno;

    @Column(nullable = false)
    private String phoneDueno;

    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "ciudadciudades_id")
    private CiudadEntity ciudadEntityCiudades;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntradaId() {
        return this.entradaId;
    }

    public void setEntradaId(String entradaId) {
        this.entradaId = entradaId;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreMascota() {
        return this.nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreDueno() {
        return this.nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getPhoneDueno() {
        return this.phoneDueno;
    }

    public void setPhoneDueno(String phoneDueno) {
        this.phoneDueno = phoneDueno;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UsuarioEntity getUsuarioEntity() {
        return this.usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public CiudadEntity getCiudadEntityCiudades() {
        return this.ciudadEntityCiudades;
    }

    public void setCiudadEntityCiudades(CiudadEntity ciudadEntityCiudades) {
        this.ciudadEntityCiudades = ciudadEntityCiudades;
    }
   
}
