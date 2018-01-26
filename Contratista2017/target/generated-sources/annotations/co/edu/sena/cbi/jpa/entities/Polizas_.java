package co.edu.sena.cbi.jpa.entities;

import co.edu.sena.cbi.jpa.entities.Aseguradora;
import co.edu.sena.cbi.jpa.entities.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T09:36:09")
@StaticMetamodel(Polizas.class)
public class Polizas_ { 

    public static volatile SingularAttribute<Polizas, String> numeroPoliza;
    public static volatile SingularAttribute<Polizas, Usuarios> usuariosId;
    public static volatile SingularAttribute<Polizas, Date> fechaPoliza;
    public static volatile SingularAttribute<Polizas, Integer> id;
    public static volatile SingularAttribute<Polizas, Aseguradora> aseguradoraId;
    public static volatile SingularAttribute<Polizas, Boolean> activo;

}