package co.edu.sena.cbi.jpa.entities;

import co.edu.sena.cbi.jpa.entities.Polizas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T09:36:09")
@StaticMetamodel(Aseguradora.class)
public class Aseguradora_ { 

    public static volatile ListAttribute<Aseguradora, Polizas> polizasList;
    public static volatile SingularAttribute<Aseguradora, Integer> id;
    public static volatile SingularAttribute<Aseguradora, String> nombreAseguradora;
    public static volatile SingularAttribute<Aseguradora, Boolean> activo;

}