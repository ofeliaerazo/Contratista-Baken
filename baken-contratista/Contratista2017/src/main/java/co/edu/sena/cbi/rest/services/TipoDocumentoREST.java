/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;
import co.edu.sena.cbi.jpa.entities.TiposDocumento;
import co.edu.sena.cbi.jpa.sessions.TiposDocumentoFacade;
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
@Path("tipoDocumento")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoDocumentoREST {
    
 
   
    @EJB
    private TiposDocumentoFacade tipoDocumentoEJB;
   
    /**
     * Obtiene todos los tiposDocumento
     *
     * @return lista de tipos documento
     */
    @GET
   // @CargoAllowed({"ADMIN"})
    public List<TiposDocumento> findAll() {
        return tipoDocumentoEJB.findAll();
    }
    
    @POST  
    public Response create(TiposDocumento tipoDocumento) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        tipoDocumentoEJB.create(tipoDocumento);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El tipo documento  se creó correctamente!")).build();

                
               
    }

     /**
     * Busca tipo documento por su id
     *
     * @param id
     * @return tipo documento
     */
    @GET
    @Path("{id}")
    public TiposDocumento findById(@PathParam("id") Integer id) {
        return tipoDocumentoEJB.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, TiposDocumento tipoDocumento){
        tipoDocumentoEJB.edit(tipoDocumento);
    }
    
}
            

