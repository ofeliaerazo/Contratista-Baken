package co.edu.sena.cbi.rest.services;

import co.edu.sena.cbi.jpa.entities.Usuarios;
import co.edu.sena.cbi.jpa.sessions.UsuariosFacade;
import co.edu.sena.cbi.rest.auth.DigestUtil;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioREST {

    @EJB
    private UsuariosFacade usuarioEJB;

    @GET
    //@RolesAllowed({"ADMIN"})
    public List<Usuarios> findUsers(@QueryParam("idUsuario") Integer idUsuario,
            @QueryParam("sexo") String sexo,
            @QueryParam("activo") Boolean activo,
            @QueryParam("numDocumento") String numDocumento,
            @QueryParam("email_institucional") String emailInstitucional,
            @QueryParam("ciudadesId") Integer ciudadesId,
            @QueryParam("nombresCompletos") String nombresCompletos,
            @QueryParam("departamentosId") Integer departamentosId,
            @QueryParam("tiposDocumentoId") String tiposDocumentoId
            
    ) {
        return usuarioEJB.findUsers(idUsuario, sexo, activo,
                numDocumento, emailInstitucional, ciudadesId, nombresCompletos,
                departamentosId, tiposDocumentoId);
    }

    @GET
    @Path("{id}")
    public Usuarios findById(
            @PathParam("id") Integer id) {
        return usuarioEJB.find(id);
    }

    /**
     * Es utilizado para los autocomplete de usuario en el cliente
     *
     * @param nombresCompletosUsuario
     * @return Lista de Usuarios
     */
    @GET
    @Path("find")
    public List<Usuarios> findUsuarioByNombre(
            @QueryParam("nombresCompletos") String nombresCompletosUsuario) {
        return usuarioEJB.findUsuarioByNombre(nombresCompletosUsuario);
    }

    @POST
    public Response create(Usuarios usuario) {
        System.out.println("TEST");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        System.out.println("emailP"+usuario.getEmailPersonal());
        System.out.println("emailI"+usuario.getEmailInstitucional());
        try {
            System.out.println("EMAIL"+usuarioEJB.findUsuarioByEmailInstitucional(usuario.getEmailInstitucional()));
            if (usuarioEJB.findUsuarioByEmailInstitucional(usuario.getEmailInstitucional()) == null) {
                if (usuarioEJB.findUsuarioByNumDocumento(usuario.getNumDocumento()) == null) {
                    usuario.setPassword(DigestUtil.cifrarPassword(usuario.getPassword()));

                    usuario.setActivo(true);
                    usuarioEJB.create(usuario);
                    return Response.status(Response.Status.CREATED)
                            .entity(gson.toJson("El usuario se registro correctamente"))
                            .build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(gson.toJson("EL numero de documento ya existe."))
                            .build();
                }
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(gson.toJson("El email ya existe.."))
                        .build();
            }
        } catch (Exception e) {
            System.out.println("ofelia" + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el usuario"))
                    .build();
        }
    }

    /**
     * Edita un usuario
     *
     * @param id
     * @param usuario
     * @return
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Usuarios usuario) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
       

        try {
              usuario.setPassword(DigestUtil.cifrarPassword(usuario.getPassword()));

            usuarioEJB.edit(usuario);
            return Response.status(Response.Status.CREATED)
                    .entity(gson.toJson("El usuario se actualizo correctamente"))
                    .build();

        } catch (Exception e) {
            System.out.println("Err" + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al actualizar el usuario"))
                    .build();
        }
    }
}
