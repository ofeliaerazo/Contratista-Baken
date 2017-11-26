
package co.edu.sena.cbi.rest.services;



import co.edu.sena.cbi.jpa.entities.Contratos;
import co.edu.sena.cbi.jpa.sessions.ContratosFacade;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author ruber
 */
@Path("upload")
@Produces(MediaType.APPLICATION_JSON)
public class UploadRESTFile {
    
    //Se debe cambiar por la URL donde se quiera guardar la imagen
    private static final String UPLOAD_FOLDER = "/home/Videos/CONTRATISTA7/Fronte-contratista/client/assets";
    private static final String UPLOAD_FOLDER_USUARIOS = "/home/Videos/CONTRATISTA7/Fronte-contratista/client/assets/";
    
    @EJB
    private ContratosFacade contratosEJB;
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream in,
            @FormDataParam("file") FormDataContentDisposition info) throws IOException {
        
        File upload = new File(UPLOAD_FOLDER.concat(info.getFileName()));

        try {
            if (upload.exists()) {
                String message = "file: " + upload.getName() + " already exists";
                return Response.status(Response.Status.CONFLICT).entity(message).build();
            } else {
                Files.copy(in, upload.toPath());
                return Response.status(Response.Status.OK).build();
            }
        } catch (IOException e) {
            return Response.status(Response.Status.CONFLICT).entity(e).build();
        }

    }
    
    @POST
    @Path("users")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFileUsuario(@FormDataParam("idUser") Integer idUser,
            @FormDataParam("file") InputStream in,
            @FormDataParam("file") FormDataContentDisposition info) throws IOException {
        
        File upload = new File(UPLOAD_FOLDER_USUARIOS.concat(info.getFileName()));

        try {
            if (upload.exists()) {
                String message = "file: " + upload.getName() + " already exists";
                return Response.status(Response.Status.CONFLICT).entity(message).build();
            } else {
                Files.copy(in, upload.toPath());
                Contratos contrato = contratosEJB.find(idUser);
                contrato.setArchivoAdjunto(upload.getName());
                contratosEJB.edit(contrato);
                return Response.status(Response.Status.OK).build();
            }
        } catch (IOException e) {
            return Response.status(Response.Status.CONFLICT).entity(e).build();
        }

    }
    
}
