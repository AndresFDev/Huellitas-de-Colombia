package com.unab.apijavahuellitas.data.entidades;

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

@Entity(name="partidos")
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {
    @Index(columnList = "partidoId", name = "index_partidoId", unique = true)
})
public class PartidoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String partidoId;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String golesLocal;

    @Column(nullable = false)
    private String golesVisitante;

    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "equipolocal_id")
    private EquipoEntity equipoEntityLocal;

    @ManyToOne
    @JoinColumn(name = "equipovisitante_id")
    private EquipoEntity equipoEntityVisitante;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(String partidoId) {
        this.partidoId = partidoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(String golesLocal) {
        this.golesLocal = golesLocal;
    }

    public String getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(String golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public EquipoEntity getEquipoEntityLocal() {
        return equipoEntityLocal;
    }

    public void setEquipoEntityLocal(EquipoEntity equipoEntityLocal) {
        this.equipoEntityLocal = equipoEntityLocal;
    }

    public EquipoEntity getEquipoEntityVisitante() {
        return equipoEntityVisitante;
    }

    public void setEquipoEntityVisitante(EquipoEntity equipoEntityVisitante) {
        this.equipoEntityVisitante = equipoEntityVisitante;
    }
    
}