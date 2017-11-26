/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Crp;
import co.edu.sena.cbi.jpa.sessions.CrpFacade;
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
@Path("crp")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CrpREST {
   
   
    @EJB
    private CrpFacade crpEJB;
   
    /**
     * Obtiene todos los crp
     *
     * @return lista de crp
     */
    @GET
   // @CargoAllowed({"ADMIN"})
    public List<Crp> findAll() {
        return crpEJB.findAll();
    }
    
    @POST  
    public Response create(Crp crp) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        crpEJB.create(crp);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El tcrp se creó correctamente!")).build();     
               
    }

     /**
     * Busca Crp por su id
     *
     * @param id
     * @return crp
     */
    @GET
    @Path("{id}")
    public Crp findById(@PathParam("id") Integer id) {
        return crpEJB.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Crp crp){
        crpEJB.edit(crp);
    }
     
}
