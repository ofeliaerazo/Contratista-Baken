/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.findByNumDocumento", query = "SELECT u FROM Usuarios u WHERE u.numDocumento = :numDocumento")
    , @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")
    , @NamedQuery(name = "Usuarios.findByNombresCompletos", query = "SELECT u FROM Usuarios u WHERE u.nombresCompletos = :nombresCompletos")
    , @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo")
    , @NamedQuery(name = "Usuarios.findByFechaNacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Usuarios.findByDireccion", query = "SELECT u FROM Usuarios u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuarios.findByEmailPersonal", query = "SELECT u FROM Usuarios u WHERE u.emailPersonal = :emailPersonal")
    , @NamedQuery(name = "Usuarios.findByEmailInstitucional", query = "SELECT u FROM Usuarios u WHERE u.emailInstitucional = :emailInstitucional")
    , @NamedQuery(name = "Usuarios.findByTelefonoFijo", query = "SELECT u FROM Usuarios u WHERE u.telefonoFijo = :telefonoFijo")
    , @NamedQuery(name = "Usuarios.findByCelular", query = "SELECT u FROM Usuarios u WHERE u.celular = :celular")
    , @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "num_documento")
    private String numDocumento;
    @Size(max = 300)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "nombres_completos")
    private String nombresCompletos;
    @Size(max = 2)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 60)
    @Column(name = "email_personal")
    private String emailPersonal;
    @Size(max = 60)
    @Column(name = "email_institucional")
    private String emailInstitucional;
    @Size(max = 20)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    @Column(name = "activo")
    private Boolean activo;
    @ManyToMany(mappedBy = "usuariosList")
    private List<Roles> rolesList;
    @JoinColumn(name = "arl_id", referencedColumnName = "id")
    @ManyToOne
    private Arl arlId;
    @JoinColumn(name = "ciudades_id", referencedColumnName = "id")
    @ManyToOne
    private Ciudades ciudadesId;
    @JoinColumn(name = "eps_id", referencedColumnName = "id")
    @ManyToOne
    private Eps epsId;
    @JoinColumn(name = "pension_id", referencedColumnName = "id")
    @ManyToOne
    private Pension pensionId;
    @JoinColumn(name = "tipos_documento_id", referencedColumnName = "id")
    @ManyToOne
    private TiposDocumento tiposDocumentoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosId")
    private List<Polizas> polizasList;
    @OneToMany(mappedBy = "contratistaId")
    private List<Contratos> contratosList;
    @OneToMany(mappedBy = "supervisorId")
    private List<Contratos> contratosList1;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }

    public void setNombresCompletos(String nombresCompletos) {
        this.nombresCompletos = nombresCompletos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public Arl getArlId() {
        return arlId;
    }

    public void setArlId(Arl arlId) {
        this.arlId = arlId;
    }

    public Ciudades getCiudadesId() {
        return ciudadesId;
    }

    public void setCiudadesId(Ciudades ciudadesId) {
        this.ciudadesId = ciudadesId;
    }

    public Eps getEpsId() {
        return epsId;
    }

    public void setEpsId(Eps epsId) {
        this.epsId = epsId;
    }

    public Pension getPensionId() {
        return pensionId;
    }

    public void setPensionId(Pension pensionId) {
        this.pensionId = pensionId;
    }

    public TiposDocumento getTiposDocumentoId() {
        return tiposDocumentoId;
    }

    public void setTiposDocumentoId(TiposDocumento tiposDocumentoId) {
        this.tiposDocumentoId = tiposDocumentoId;
    }

    @XmlTransient
    public List<Polizas> getPolizasList() {
        return polizasList;
    }

    public void setPolizasList(List<Polizas> polizasList) {
        this.polizasList = polizasList;
    }

    @XmlTransient
    public List<Contratos> getContratosList() {
        return contratosList;
    }

    public void setContratosList(List<Contratos> contratosList) {
        this.contratosList = contratosList;
    }

    @XmlTransient
    public List<Contratos> getContratosList1() {
        return contratosList1;
    }

    public void setContratosList1(List<Contratos> contratosList1) {
        this.contratosList1 = contratosList1;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cbi.jpa.entities.Usuarios[ id=" + id + " ]";
    }
    
}
