/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.ObjetoContrato;
import co.edu.sena.cbi.jpa.sessions.ObjetoContratoFacade;
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
@Path("objetoContrato")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ObjetoContratoREST {
    @EJB
    private ObjetoContratoFacade objetoContratoEJB;
   
    /**
     * Obtiene todos los ObjetoContrato
     *
     * @return lista de ObjetoContrato
     */
    @GET
   // @CargoAllowed({"ADMIN"})
    public List<ObjetoContrato> findAll() {
        return objetoContratoEJB.findAll();
    }
    
    @POST  
    public Response create(ObjetoContrato objetoContrato) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        objetoContratoEJB.create(objetoContrato);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("ElObjetoContrato se creó correctamente!")).build();     
               
    }

     /**
     * Busca Crp por su id
     *
     * @param id
     * @return crp
     */
    @GET
    @Path("{id}")
    public ObjetoContrato findById(@PathParam("id") Integer id) {
        return objetoContratoEJB.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, ObjetoContrato objetoContrato){
        objetoContratoEJB.edit(objetoContrato);
    }
}
