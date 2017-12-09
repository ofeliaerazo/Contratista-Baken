/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cbi.rest.services;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author adsi1261718
 */
@ApplicationPath("api")
public class AppConfig extends ResourceConfig{

    public AppConfig() {
         packages("co.edu.sena.cbi.rest.services;co.edu.sena.cbi.rest.auth");
        register(RolesAllowedDynamicFeature.class);
        register(MultiPartFeature.class);//Para subir imagenes se necesita
    }
}