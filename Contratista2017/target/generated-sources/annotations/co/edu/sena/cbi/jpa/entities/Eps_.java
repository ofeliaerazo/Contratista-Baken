package co.edu.sena.cbi.jpa.entities;

import co.edu.sena.cbi.jpa.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-31T09:39:41")
@StaticMetamodel(Eps.class)
public class Eps_ { 

    public static volatile ListAttribute<Eps, Usuarios> usuariosList;
    public static volatile SingularAttribute<Eps, Integer> id;
    public static volatile SingularAttribute<Eps, String> nombre;
    public static volatile SingularAttribute<Eps, Boolean> activo;

}