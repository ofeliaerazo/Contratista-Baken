/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "polizas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polizas.findAll", query = "SELECT p FROM Polizas p")
    , @NamedQuery(name = "Polizas.findById", query = "SELECT p FROM Polizas p WHERE p.id = :id")
    , @NamedQuery(name = "Polizas.findByNumeroPoliza", query = "SELECT p FROM Polizas p WHERE p.numeroPoliza = :numeroPoliza")
    , @NamedQuery(name = "Polizas.findByFechaPoliza", query = "SELECT p FROM Polizas p WHERE p.fechaPoliza = :fechaPoliza")
    , @NamedQuery(name = "Polizas.findByActivo", query = "SELECT p FROM Polizas p WHERE p.activo = :activo")})
public class Polizas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "numero_poliza")
    private String numeroPoliza;
    @Column(name = "fecha_poliza")
    @Temporal(TemporalType.DATE)
    private Date fechaPoliza;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "aseguradora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aseguradora aseguradoraId;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuariosId;

    public Polizas() {
    }

    public Polizas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Date getFechaPoliza() {
        return fechaPoliza;
    }

    public void setFechaPoliza(Date fechaPoliza) {
        this.fechaPoliza = fechaPoliza;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Aseguradora getAseguradoraId() {
        return aseguradoraId;
    }

    public void setAseguradoraId(Aseguradora aseguradoraId) {
        this.aseguradoraId = aseguradoraId;
    }

    public Usuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuarios usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polizas)) {
            return false;
        }
        Polizas other = (Polizas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cbi.jpa.entities.Polizas[ id=" + id + " ]";
    }
    
}
