/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "objeto_contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObjetoContrato.findAll", query = "SELECT o FROM ObjetoContrato o")
    , @NamedQuery(name = "ObjetoContrato.findById", query = "SELECT o FROM ObjetoContrato o WHERE o.id = :id")
    , @NamedQuery(name = "ObjetoContrato.findByDescripcion", query = "SELECT o FROM ObjetoContrato o WHERE o.descripcion = :descripcion")})
public class ObjetoContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "objetoContratoId")
    private List<Contratos> contratosList;

    public ObjetoContrato() {
    }

    public ObjetoContrato(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Contratos> getContratosList() {
        return contratosList;
    }

    public void setContratosList(List<Contratos> contratosList) {
        this.contratosList = contratosList;
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
        if (!(object instanceof ObjetoContrato)) {
            return false;
        }
        ObjetoContrato other = (ObjetoContrato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cbi.jpa.entities.ObjetoContrato[ id=" + id + " ]";
    }
    
}
