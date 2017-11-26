
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Eps;
import co.edu.sena.cbi.jpa.sessions.EpsFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ofelia
 */
@Path("eps")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EpsREST {
   @EJB
    private EpsFacade epsEJB;
   
    /**
     * Obtiene todos los eps
     *
     * @return lista de eps
     */
    @GET
   // @EpsAllowed({"ADMIN"})
    public List<Eps> findAll() {
        return epsEJB.findAll();
    }
    
    @POST  
    public Response create(Eps eps) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        epsEJB.create(eps);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El eps se creó correctamente!")).build();     
               
    }

     /**
     * Busca eps por su id
     *
     * @param id
     * @return eps
     */
    @GET
    @Path("{id}")
    public Eps findById(@PathParam("id") Integer id) {
        return epsEJB.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Eps eps){
        epsEJB.edit(eps);
    } 
    
}
