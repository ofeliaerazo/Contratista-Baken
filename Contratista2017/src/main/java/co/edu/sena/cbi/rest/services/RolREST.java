/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Crp;
import co.edu.sena.cbi.jpa.entities.Roles;
import co.edu.sena.cbi.jpa.sessions.CrpFacade;
import co.edu.sena.cbi.jpa.sessions.RolesFacade;
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
@Path("roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RolREST {
  @EJB
    private RolesFacade rolEJB;
   
    /**
     * Obtiene todos los rol
     *
     * @return lista de rol
     */
    @GET
   // @CargoAllowed({"ADMIN"})
    public List<Roles> findAll() {
        return rolEJB.findAll();
    }
    
    @POST  
    public Response create(Roles rol) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        rolEJB.create(rol);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El rol se creó correctamente!")).build();     
               
    }

     /**
     * Busca rol por su id
     *
     * @param id
     * @return rol
     */
    @GET
    @Path("{id}")
    public Roles findById(@PathParam("id") Integer id) {
        return rolEJB.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Roles rol){
        rolEJB.edit(rol);
    }  
}
