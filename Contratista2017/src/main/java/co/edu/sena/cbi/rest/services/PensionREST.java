/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Crp;
import co.edu.sena.cbi.jpa.entities.Pension;
import co.edu.sena.cbi.jpa.sessions.PensionFacade;
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
@Path("pension")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PensionREST {
    @EJB
    private PensionFacade pensionEJB;
   
    /**
     * Obtiene todos los pension
     *
     * @return lista de pension
     */
    @GET
   // @pensionAllowed({"ADMIN"})
    public List<Pension> findAll() {
        return pensionEJB.findAll();
    }
    
    @POST  
    public Response create(Pension pension) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        pensionEJB.create(pension);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El pension se creó correctamente!")).build();     
               
    }

     /**
     * Busca pension por su id
     *
     * @param id
     * @return pension
     */
    @GET
    @Path("{id}")
    public Pension findById(@PathParam("id") Integer id) {
        return pensionEJB.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Pension pension){
        pensionEJB.edit(pension);
    }
}
