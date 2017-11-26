package co.edu.sena.cbi.jpa.entities;

import co.edu.sena.cbi.jpa.entities.Departamentos;
import co.edu.sena.cbi.jpa.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T16:02:50")
@StaticMetamodel(Ciudades.class)
public class Ciudades_ { 

    public static volatile ListAttribute<Ciudades, Usuarios> usuariosList;
    public static volatile SingularAttribute<Ciudades, Integer> id;
    public static volatile SingularAttribute<Ciudades, Departamentos> departamentosId;
    public static volatile SingularAttribute<Ciudades, String> nombre;
    public static volatile SingularAttribute<Ciudades, Boolean> activo;

}