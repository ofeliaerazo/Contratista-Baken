package co.edu.sena.cbi.jpa.sessions;


import co.edu.sena.cbi.jpa.entities.Ciudades;
import co.edu.sena.cbi.jpa.entities.Ciudades_;
import co.edu.sena.cbi.jpa.entities.Departamentos;
import co.edu.sena.cbi.jpa.entities.Usuarios;
import co.edu.sena.cbi.jpa.entities.Usuarios_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "co.edu.sena.adsi.jpa_Contratista2017_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
     public Usuarios findUsuarioByEmailInstitucional(String emailInstitucional) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> usuario = cq.from(Usuarios.class);
        cq.where(cb.equal(usuario.get(Usuarios_.emailInstitucional), emailInstitucional));
        TypedQuery<Usuarios> q = getEntityManager().createQuery(cq);
        try {
            return (Usuarios) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    /**
     * Busca usuario por numDocumento
     *
     * @param numDocumento
     * @return Usuario
     */
  public Usuarios findUsuarioByNumDocumento(String numDocumento) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> usuario = cq.from(Usuarios.class);
        cq.where(cb.equal(usuario.get(Usuarios_.numDocumento), numDocumento));
        TypedQuery<Usuarios> q = getEntityManager().createQuery(cq);
        try {
            return (Usuarios) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
  
   /**
     * Este método sirve para buscar USUARIO en un autocomplete
     * Además si se pasa el id del departamento en el autocomplete solo 
     * sale las ciudades pertenecientes a ese departamento
     * @param query
        * @return lista de uSUARIO
     */
    public List<Usuarios> findUsuarioByNombre(String query) {
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> usuario = cq.from(Usuarios.class);
        
        Predicate restrictions = cb.conjunction();
        
                
        if(query != null){
            restrictions = cb.and(restrictions, cb.like(usuario.get(Usuarios_.nombresCompletos), "%" + query + "%"));
        }
        
        cq.where(restrictions);
        cq.orderBy(cb.asc(usuario.get(Usuarios_.nombresCompletos)));
        TypedQuery<Usuarios> q = em.createQuery(cq);
        try {
            return q.setMaxResults(10).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    
    public List<Usuarios> findUsers(Integer idUsuario, String sexo, Boolean activo,
            String numDocumento, String email, Integer idCiudad, String idDepartamento,
            Integer idTipoDocumento, String nombresCompletos){
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> usuario = cq.from(Usuarios.class);
        
        Predicate data = cb.conjunction();
        
        if(idUsuario != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.id), idUsuario));
        }
        
        if(sexo != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.sexo), sexo));
        }
        
        if(numDocumento != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.numDocumento), numDocumento));
        }
        
        if(email != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.emailInstitucional), email));
        }
        
        if(nombresCompletos != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.nombresCompletos), nombresCompletos));
        }
        
        if(idCiudad != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.ciudadesId), new Ciudades(idCiudad)));
        }
        
        if(idDepartamento != null){
            Join<Usuarios, Ciudades> joinCiudad = usuario.join(Usuarios_.ciudadesId);
            data = cb.and(data, cb.equal(joinCiudad.get(Ciudades_.departamentosId), new Departamentos(idDepartamento)));
        }
        
        
        
               
        cq.where(data);
        cq.orderBy(cb.asc(usuario.get(Usuarios_.nombresCompletos)));
        TypedQuery<Usuarios> tq = em.createQuery(cq);
        
        try {
            return tq.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}

