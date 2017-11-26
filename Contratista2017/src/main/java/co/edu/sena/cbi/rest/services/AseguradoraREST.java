/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Aseguradora;
import co.edu.sena.cbi.jpa.sessions.AseguradoraFacade;
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
@Path("asegurdora")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AseguradoraREST {
    
    @EJB
    private AseguradoraFacade aseguradoraEJB;
    
    @GET
    public List<Aseguradora> findAll(){
        return aseguradoraEJB.findAll();
    }
      /**
     * Crear una Aseguradora
     * @param aseguradora
     * @return 
     */
    @POST
    public Response create(Aseguradora aseguradora){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        aseguradoraEJB.create(aseguradora);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El asegurador se creó correctamente!")).build();     
      
    }
    
    /**
     * Edita una Aseguradora
     * @param id
     * @param aseguradora
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Aseguradora aseguradora){
        aseguradoraEJB.edit(aseguradora);
    }
        
}
