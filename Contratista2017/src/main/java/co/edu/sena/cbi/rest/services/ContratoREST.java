package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Contratos;
import co.edu.sena.cbi.jpa.sessions.ContratosFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author ofelia
 */

@Path("contratos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ContratoREST {
    @EJB
    private ContratosFacade contratoEJB;
    
    private static final String UPLOAD_FOLDER = "/home/adsi1261718/OFELIA/CONTRATISTAS/ContratistaFronten/client/assets/imagenesContratos/";
    
    @GET
    public List<Contratos> findAll() {
        return contratoEJB.findAll();
    }
    
    @GET
    @Path("{id}")
    public Contratos findById(
            @PathParam("id") Integer id){
        return contratoEJB.find(id);
    }
    
   
     /**
     * Crear una contrato
     * @param contrato
     * @return 
     */
    /*@POST
    public Response create(Contratos contrato){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        contratoEJB.create(contrato);
        return Response.status(Response.Status.CREATED).entity(gson.toJson("El contrato se creó correctamente!")).build();     
                    
    }*/
    
    
    
    @POST
    @Path("crearContrato")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormDataParam("estadoContrato") String estadoContrato,
            @FormDataParam("numeroContrato") Integer numeroContrato,
            @FormDataParam("valorContrato") Integer valorContrato,
            @FormDataParam("file") InputStream in,
            @FormDataParam("file") FormDataContentDisposition info) throws IOException {
        
        File upload = new File(UPLOAD_FOLDER.concat(info.getFileName()));

        try {
            if (upload.exists()) {
                String message = "file: " + upload.getName() + " already exists";
                return Response.status(Response.Status.CONFLICT).entity(message).build();
            } else {
                Files.copy(in, upload.toPath());
                Contratos contrato = new Contratos();
                contrato.setEstadoContrato(estadoContrato);
                contrato.setNumeroContrato(numeroContrato);
                contrato.setValorContrato(valorContrato);
                contrato.setArchivoAdjunto(upload.getName());
                contratoEJB.create(contrato);
                return Response.status(Response.Status.OK).build();
            }
        } catch (IOException e) {
            return Response.status(Response.Status.CONFLICT).entity(e).build();
        }

    }
    
    /**
     * Edita una contrato
     * @param id
     * @param contrato 
     * @return  
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Contratos contrato) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            contratoEJB.edit(contrato);
            return Response.status(Response.Status.CREATED).entity(gson.toJson("El contrato se actualizó correctamente!")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al actualizar el contrato!.")).build();
        }
    }
}