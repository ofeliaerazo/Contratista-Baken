package co.edu.sena.cbi.jpa.entities;

import co.edu.sena.cbi.jpa.entities.Crp;
import co.edu.sena.cbi.jpa.entities.ObjetoContrato;
import co.edu.sena.cbi.jpa.entities.TiposContrato;
import co.edu.sena.cbi.jpa.entities.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-08T12:43:49")
@StaticMetamodel(Contratos.class)
public class Contratos_ { 

    public static volatile SingularAttribute<Contratos, Integer> valorAdicion;
    public static volatile SingularAttribute<Contratos, Integer> numeroContrato;
    public static volatile SingularAttribute<Contratos, Date> fechaFinal;
    public static volatile SingularAttribute<Contratos, String> estadoContrato;
    public static volatile SingularAttribute<Contratos, Usuarios> supervisorId;
    public static volatile SingularAttribute<Contratos, Integer> valorContrato;
    public static volatile SingularAttribute<Contratos, Usuarios> contratistaId;
    public static volatile SingularAttribute<Contratos, Crp> crpId;
    public static volatile SingularAttribute<Contratos, Date> fechaInicio;
    public static volatile SingularAttribute<Contratos, Integer> id;
    public static volatile SingularAttribute<Contratos, Date> fechaTerminacionAdicional;
    public static volatile SingularAttribute<Contratos, ObjetoContrato> objetoContratoId;
    public static volatile SingularAttribute<Contratos, Date> fechaSuscripcion;
    public static volatile SingularAttribute<Contratos, String> archivoAdjunto;
    public static volatile SingularAttribute<Contratos, TiposContrato> tiposContratoId;

}