package com.devappron.backendjava.data.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "usuarios")
@Table(indexes = {
    @Index(columnList = "userId", name="index_userid", unique = true),
    @Index(columnList = "userName", name="index_username", unique = true), 
    @Index(columnList = "email", name="index_email", unique = true),
})
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID =1L;

    @Id 
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 10)
    private String userName;

    @Column(nullable = false, length = 10)
    private String phone;
    
    @Column(nullable = false)
    private String encryptedPassword;

    @ManyToOne
    @JoinColumn(name = "ciudadciudades_id")
    private CiudadEntity ciudadEntityCiudades;

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="usuarioEntity")
    private List<EntradaEntity> entradaEntityList= new ArrayList<>();

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public CiudadEntity getCiudadEntityCiudades() {
        return this.ciudadEntityCiudades;
    }

    public void setCiudadEntityCiudades(CiudadEntity ciudadEntityCiudades) {
        this.ciudadEntityCiudades = ciudadEntityCiudades;
    }

    public List<EntradaEntity> getEntradaEntityList() {
        return this.entradaEntityList;
    }

    public void setEntradaEntityList(List<EntradaEntity> entradaEntityList) {
        this.entradaEntityList = entradaEntityList;
    }
    
}
