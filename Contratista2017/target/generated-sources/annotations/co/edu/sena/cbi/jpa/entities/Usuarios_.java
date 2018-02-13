package co.edu.sena.cbi.jpa.entities;

import co.edu.sena.cbi.jpa.entities.Arl;
import co.edu.sena.cbi.jpa.entities.Ciudades;
import co.edu.sena.cbi.jpa.entities.Contratos;
import co.edu.sena.cbi.jpa.entities.Eps;
import co.edu.sena.cbi.jpa.entities.Pension;
import co.edu.sena.cbi.jpa.entities.Polizas;
import co.edu.sena.cbi.jpa.entities.Roles;
import co.edu.sena.cbi.jpa.entities.TiposDocumento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-08T12:43:49")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Eps> epsId;
    public static volatile SingularAttribute<Usuarios, String> numDocumento;
    public static volatile SingularAttribute<Usuarios, String> emailPersonal;
    public static volatile SingularAttribute<Usuarios, Pension> pensionId;
    public static volatile SingularAttribute<Usuarios, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuarios, Ciudades> ciudadesId;
    public static volatile SingularAttribute<Usuarios, String> nombresCompletos;
    public static volatile SingularAttribute<Usuarios, String> direccion;
    public static volatile SingularAttribute<Usuarios, TiposDocumento> tiposDocumentoId;
    public static volatile ListAttribute<Usuarios, Contratos> contratosList;
    public static volatile SingularAttribute<Usuarios, String> telefonoFijo;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, String> emailInstitucional;
    public static volatile ListAttribute<Usuarios, Roles> rolesList;
    public static volatile SingularAttribute<Usuarios, String> celular;
    public static volatile ListAttribute<Usuarios, Polizas> polizasList;
    public static volatile SingularAttribute<Usuarios, Arl> arlId;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile ListAttribute<Usuarios, Contratos> contratosList1;
    public static volatile SingularAttribute<Usuarios, String> sexo;
    public static volatile SingularAttribute<Usuarios, Boolean> activo;

}