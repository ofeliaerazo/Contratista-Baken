/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Ciudades;
import co.edu.sena.cbi.jpa.sessions.CiudadesFacade;
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
@Path("ciudades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CiudadesREST {
    
    @EJB
    private CiudadesFacade ciudadEJB;
    
    @GET
    public List<Ciudades> findAll(){
        return ciudadEJB.findAll();
    }
      /**
     * Crear una ciudad
     * @param ciudad 
     * @return  
     */
    @POST
    public Response create(Ciudades ciudad){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
         ciudadEJB.create(ciudad);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El arl se creó correctamente!")).build();     
      
       
    }
    
    /**
     * Edita una ciudad
     * @param id
     * @param ciudad 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Ciudades ciudad){
        ciudadEJB.edit(ciudad);
    }
               
}
