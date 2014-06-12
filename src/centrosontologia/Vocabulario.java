/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package centrosontologia;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.impl.PropertyImpl;
import com.hp.hpl.jena.rdf.model.impl.ResourceImpl;
/**
 *
 * @author Jairo
 */
public class Vocabulario {

          // URI for vocabulary elements
    protected static final String schema = "http://schema.org/";
protected static final String foaf = "http://xmlns.com/foaf/spec/";
protected static final String op = "http://neologism.ecs.soton.ac.uk/oo#capacity/";
protected static final String eop= "http://data.fundacionctic.org/vocab/infraestructuras/organizacion.html/";
protected static final String loca= "http://data.fundacionctic.org/vocab/infraestructuras/localizacion.html/";

    // Return URI for vocabulary elements
    public static String getURIschema() {
        return schema;
    }
    public static String getURIfoaf() {
        return foaf;
    }
    public static String getURIop() {
        return op;
    }
    public static String getURIeop() {
        return eop;
    }
    public static String getURIloca() {
        return loca;
    }
    
    // Define the property labels and objects
    static final String centros = "centro";
public static Resource centro = null;
static final String legalname = "nombreCentro";
public static Property nombrCentro = null;
static final String capacity = "capacidad";
public static Property capacidad = null;
static final String category = "categoria";
public static Property categoria = null;
static final String puedeSer = "ser";
public static Property ser = null;
static final String servicios = "servicio";
public static Property servicio = null;


static final String Person = "persona";
public static Resource persona = null;
static final String name = "nombre";
public static Property nombre = null;
static final String lastname = "apellido";
public static Property apellido = null;
static final String phone = "telefono";
public static Property telefono = null;
static final String ruc = "RUC";
public static Property RUC = null;

static final String Empleado = "empleado";
public static Resource empleado = null;
static final String hombre = "hombres";
public static Property hombres = null;
static final String mujer = "mujeres";
public static Property mujeres = null;


static final String Localizacion = "localizacion";
public static Resource localizacion = null;
static final String direccion = "calles";
public static Property calles = null;
static final String province = "provincia";
public static Property provincia = null;
static final String Canton = "canton";
public static Property canton = null;
static final String parroquia = "distrito";
public static Property distrito = null;



// Instantiate the properties and the resource
static {
try {
// Instantiate the properties
centro = new ResourceImpl(schema, centros);
nombrCentro = new PropertyImpl(schema, legalname);
capacidad = new PropertyImpl(op, capacity);
ser = new PropertyImpl(schema, puedeSer);
servicio = new PropertyImpl(eop, servicios);
    
persona = new ResourceImpl(foaf, Person);
nombre = new PropertyImpl(foaf, name);
apellido = new PropertyImpl(foaf, lastname);
telefono = new PropertyImpl(foaf, phone);
RUC = new PropertyImpl(foaf, ruc);

empleado = new ResourceImpl(foaf, Empleado);
hombres = new PropertyImpl(foaf, hombre);
mujeres = new PropertyImpl(foaf, mujer);


localizacion = new ResourceImpl(loca, Localizacion);
calles = new PropertyImpl(loca, direccion);
provincia = new PropertyImpl(loca, province);
canton = new PropertyImpl(loca, Canton);
distrito = new PropertyImpl(loca, parroquia);


} catch (Exception e) {
    System.out.println("POSTCON" +  e);
}
}
    

    
}
