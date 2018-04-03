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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratos.findAll", query = "SELECT c FROM Contratos c")
    , @NamedQuery(name = "Contratos.findById", query = "SELECT c FROM Contratos c WHERE c.id = :id")
    , @NamedQuery(name = "Contratos.findByNumeroContrato", query = "SELECT c FROM Contratos c WHERE c.numeroContrato = :numeroContrato")
    , @NamedQuery(name = "Contratos.findByFechaSuscripcion", query = "SELECT c FROM Contratos c WHERE c.fechaSuscripcion = :fechaSuscripcion")
    , @NamedQuery(name = "Contratos.findByFechaInicio", query = "SELECT c FROM Contratos c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Contratos.findByFechaFinal", query = "SELECT c FROM Contratos c WHERE c.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "Contratos.findByValorContrato", query = "SELECT c FROM Contratos c WHERE c.valorContrato = :valorContrato")
    , @NamedQuery(name = "Contratos.findByFechaTerminacionAdicional", query = "SELECT c FROM Contratos c WHERE c.fechaTerminacionAdicional = :fechaTerminacionAdicional")
    , @NamedQuery(name = "Contratos.findByValorAdicion", query = "SELECT c FROM Contratos c WHERE c.valorAdicion = :valorAdicion")
    , @NamedQuery(name = "Contratos.findByEstadoContrato", query = "SELECT c FROM Contratos c WHERE c.estadoContrato = :estadoContrato")
    , @NamedQuery(name = "Contratos.findByArchivoAdjunto", query = "SELECT c FROM Contratos c WHERE c.archivoAdjunto = :archivoAdjunto")})
public class Contratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_contrato")
    private Integer numeroContrato;
    @Column(name = "fecha_suscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechaSuscripcion;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Column(name = "valor_contrato")
    private Integer valorContrato;
    @Column(name = "fecha_terminacion_adicional")
    @Temporal(TemporalType.DATE)
    private Date fechaTerminacionAdicional;
    @Column(name = "valor_adicion")
    private Integer valorAdicion;
    @Column(name = "estado_contrato")
    private Boolean estadoContrato;
    @Size(max = 250)
    @Column(name = "archivo_adjunto")
    private String archivoAdjunto;
    @JoinColumn(name = "crp_id", referencedColumnName = "id")
    @ManyToOne
    private Crp crpId;
    @JoinColumn(name = "objeto_contrato_id", referencedColumnName = "id")
    @ManyToOne
    private ObjetoContrato objetoContratoId;
    @JoinColumn(name = "tipos_contrato_id", referencedColumnName = "id")
    @ManyToOne
    private TiposContrato tiposContratoId;
    @JoinColumn(name = "contratista_id", referencedColumnName = "id")
    @ManyToOne
    private Usuarios contratistaId;
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    @ManyToOne
    private Usuarios supervisorId;

    public Contratos() {
    }

    public Contratos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Date getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(Date fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(Integer valorContrato) {
        this.valorContrato = valorContrato;
    }

    public Date getFechaTerminacionAdicional() {
        return fechaTerminacionAdicional;
    }

    public void setFechaTerminacionAdicional(Date fechaTerminacionAdicional) {
        this.fechaTerminacionAdicional = fechaTerminacionAdicional;
    }

    public Integer getValorAdicion() {
        return valorAdicion;
    }

    public void setValorAdicion(Integer valorAdicion) {
        this.valorAdicion = valorAdicion;
    }

    public Boolean getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(Boolean estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public String getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(String archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }

    public Crp getCrpId() {
        return crpId;
    }

    public void setCrpId(Crp crpId) {
        this.crpId = crpId;
    }

    public ObjetoContrato getObjetoContratoId() {
        return objetoContratoId;
    }

    public void setObjetoContratoId(ObjetoContrato objetoContratoId) {
        this.objetoContratoId = objetoContratoId;
    }

    public TiposContrato getTiposContratoId() {
        return tiposContratoId;
    }

    public void setTiposContratoId(TiposContrato tiposContratoId) {
        this.tiposContratoId = tiposContratoId;
    }

    public Usuarios getContratistaId() {
        return contratistaId;
    }

    public void setContratistaId(Usuarios contratistaId) {
        this.contratistaId = contratistaId;
    }
    
    public Usuarios getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Usuarios supervisorId) {
        this.supervisorId = supervisorId;
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
        if (!(object instanceof Contratos)) {
            return false;
        }
        Contratos other = (Contratos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cbi.jpa.entities.Contratos[ id=" + id + " ]";
    }
    
}
