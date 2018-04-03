/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.jpa.sessions;

import co.edu.sena.cbi.jpa.entities.Contratos;
import co.edu.sena.cbi.jpa.entities.Contratos_;
import co.edu.sena.cbi.jpa.entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class ContratosFacade extends AbstractFacade<Contratos> {

    @PersistenceContext(unitName = "co.edu.sena.adsi.jpa_Contratista2017_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratosFacade() {
        super(Contratos.class);
    }
    
    public Contratos findContratoByUsuario(Integer idUsuario) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Contratos> cq = cb.createQuery(Contratos.class);
        Root<Contratos> usuario = cq.from(Contratos.class);
        cq.where(cb.equal(usuario.get(Contratos_.contratistaId), new Usuarios(idUsuario)), cb.equal(usuario.get(Contratos_.estadoContrato), true));
        TypedQuery<Contratos> q = getEntityManager().createQuery(cq);
        try {
            return (Contratos) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public List<Contratos> findContratos(Integer idUsuario){
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Contratos> cq = cb.createQuery(Contratos.class);
        Root<Contratos> contratos = cq.from(Contratos.class);
        
        Predicate data = cb.conjunction();
        
        if(idUsuario != null){
            data = cb.and(data, cb.equal(contratos.get(Contratos_.contratistaId), new Usuarios(idUsuario)));
        }
        
     
            data = cb.and(data, cb.equal(contratos.get(Contratos_.estadoContrato), true));
        
        
               
        cq.where(data);
        cq.orderBy(cb.asc(contratos.get(Contratos_.id)));
        TypedQuery<Contratos> tq = em.createQuery(cq);
        
        try {
            return tq.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
