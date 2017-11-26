
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Arl;
import co.edu.sena.cbi.jpa.sessions.ArlFacade;
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
@Path("arl")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArlREST {
     @EJB
    private ArlFacade arlEJB;
    
    @GET
    public List<Arl> findAll(){
        return arlEJB.findAll();
    }
      /**
     * Crear una Arl
     * @param arl
     */
    @POST
    public Response create(Arl arl){
    GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        arlEJB.create(arl);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El arl se creó correctamente!")).build();     
               
    }
    
    /**
     * Edita una Arl
     * @param id
     * @param arl
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Arl arl){
        arlEJB.edit(arl);
    }
        
    
}
