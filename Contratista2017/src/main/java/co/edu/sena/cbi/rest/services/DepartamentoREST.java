/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Departamentos;
import co.edu.sena.cbi.jpa.sessions.DepartamentosFacade;
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
@Path("departamentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartamentoREST {
  @EJB
    private DepartamentosFacade departamentoEJB;
   
    /**
     * Obtiene todos los departamentos
     *
     * @return lista de departamentos
     */
    @GET
   // @DepartamentoAllowed({"ADMIN"})
    public List<Departamentos> findAll() {
        return departamentoEJB.findAll();
    }
    
    @POST  
    public Response create(Departamentos departamento) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        departamentoEJB.create(departamento);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El departamento se creó correctamente!")).build();     
               
    }

     /**
     * Busca departamento por su id
     *
     * @param id
     * @return crp
     */
    @GET
    @Path("{id}")
    public Departamentos findById(@PathParam("id") Integer id) {
        return departamentoEJB.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Departamentos departamento){
        departamentoEJB.edit(departamento);
    }  
}
