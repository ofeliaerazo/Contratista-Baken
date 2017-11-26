/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Crp;
import co.edu.sena.cbi.jpa.entities.TiposContrato;
import co.edu.sena.cbi.jpa.sessions.CrpFacade;
import co.edu.sena.cbi.jpa.sessions.TiposContratoFacade;
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
@Path("tipoContrato")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoContratoREST {
  @EJB
    private TiposContratoFacade tipoContratoEJB;
   
    /**
     * Obtiene todos los tipoContrato
     *
     * @return lista de tipoContrato
     */
    @GET
   // @CargoAllowed({"ADMIN"})
    public List<TiposContrato> findAll() {
        return tipoContratoEJB.findAll();
    }
    
    @POST  
    public Response create(TiposContrato tipoContrato) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        tipoContratoEJB.create(tipoContrato);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El tipoContrato se creó correctamente!")).build();     
               
    }

     /**
     * Busca tipoContrato por su id
     *
     * @param id
     * @return tipoContrato
     */
    @GET
    @Path("{id}")
    public TiposContrato findById(@PathParam("id") Integer id) {
        return tipoContratoEJB.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, TiposContrato tipoContrato){
        tipoContratoEJB.edit(tipoContrato);
    }  
}
