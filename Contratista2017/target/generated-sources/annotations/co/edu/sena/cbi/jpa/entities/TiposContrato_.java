package co.edu.sena.cbi.jpa.entities;

import co.edu.sena.cbi.jpa.entities.Contratos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-31T09:39:41")
@StaticMetamodel(TiposContrato.class)
public class TiposContrato_ { 

    public static volatile SingularAttribute<TiposContrato, String> descripcion;
    public static volatile ListAttribute<TiposContrato, Contratos> contratosList;
    public static volatile SingularAttribute<TiposContrato, String> id;
    public static volatile SingularAttribute<TiposContrato, Boolean> activo;

}