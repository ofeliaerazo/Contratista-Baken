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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "crp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crp.findAll", query = "SELECT c FROM Crp c")
    , @NamedQuery(name = "Crp.findById", query = "SELECT c FROM Crp c WHERE c.id = :id")
    , @NamedQuery(name = "Crp.findByNumeroCrp", query = "SELECT c FROM Crp c WHERE c.numeroCrp = :numeroCrp")})
public class Crp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "numero_crp")
    private String numeroCrp;
    @OneToMany(mappedBy = "crpId")
    private List<Contratos> contratosList;

    public Crp() {
    }

    public Crp(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCrp() {
        return numeroCrp;
    }

    public void setNumeroCrp(String numeroCrp) {
        this.numeroCrp = numeroCrp;
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
        if (!(object instanceof Crp)) {
            return false;
        }
        Crp other = (Crp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cbi.jpa.entities.Crp[ id=" + id + " ]";
    }
    
}
