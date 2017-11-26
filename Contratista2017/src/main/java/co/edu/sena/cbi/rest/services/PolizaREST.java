/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Crp;
import co.edu.sena.cbi.jpa.entities.Polizas;
import co.edu.sena.cbi.jpa.sessions.CrpFacade;
import co.edu.sena.cbi.jpa.sessions.PolizasFacade;
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
@Path("poliza")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PolizaREST {
   @EJB
    private PolizasFacade polizaEJB;
   
    /**
     * Obtiene todos los poliza
     *
     * @return lista de poliza
     */
    @GET
   // @CargoAllowed({"ADMIN"})
    public List<Polizas> findAll() {
        return polizaEJB.findAll();
    }
    
    @POST  
    public Response create(Polizas poliza) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        polizaEJB.create(poliza);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El poliza se creó correctamente!")).build();     
               
    }

     /**
     * Busca Crp por su id
     *
     * @param id
     * @return poliza
     */
    @GET
    @Path("{id}")
    public Polizas findById(@PathParam("id") Integer id) {
        return polizaEJB.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Polizas poliza){
        polizaEJB.edit(poliza);
    } 
}
