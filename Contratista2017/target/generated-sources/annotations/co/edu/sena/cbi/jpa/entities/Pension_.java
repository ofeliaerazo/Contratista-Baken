package co.edu.sena.cbi.jpa.entities;

import co.edu.sena.cbi.jpa.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T09:36:09")
@StaticMetamodel(Pension.class)
public class Pension_ { 

    public static volatile ListAttribute<Pension, Usuarios> usuariosList;
    public static volatile SingularAttribute<Pension, Integer> id;
    public static volatile SingularAttribute<Pension, String> nombre;
    public static volatile SingularAttribute<Pension, Boolean> activo;

}