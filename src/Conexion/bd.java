/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import centrosontologia.Resources;
import centrosontologia.Vocabulario;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jairo
 */
public class bd {

    Connection con;
    String server = "jdbc:mysql://localhost/centros";
    String user = "root";
    String pass = "";
    Resources recurso = new Resources();

    public void conexion() {
        try {
            //Cargamos el puente JDBC =&gt; Mysql
            Class.forName("com.mysql.jdbc.Driver");
            //Intentamos conectarnos a la base de Datos en este caso una base llamada temp
            con = DriverManager.getConnection(server, user, pass);
        } catch (SQLException ex) {
            System.out.println("Error de mysql: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error de algo: " + e);
        } catch (Exception e) {
            System.out.println("Se produjo un error en la conexión: " + e.getMessage());
        }
    }

    public void consulta() {
        conexion();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM centrosdb");
            Model model = ModelFactory.createDefaultModel();
            while (rs.next()) {
                /*recurso.getRecurso(rs.getString("Nombre_Centro"), rs.getString("Ruc"), rs.getString("Propietari"), rs.getString("Telefonos"), rs.getString("Servicio"), rs.getString("Calles"), rs.getString("Actividad"), rs.getString("Category"), rs.getString("Hombre"),
                 rs.getString("Mujer"), rs.getString("Province"), rs.getString("Cantons"), rs.getString("Parroquia"));
                 */
                try {
                    //System.out.println(rs.getString("Calles"));
                    //Resource SDeterminador = model.createResource(Vocabulario.getURIschema().concat("CentrosDiversion")).addProperty(Vocabulario.nombrCentro, model.createResource(Vocabulario.getURIschema().concat(rs.getString("Nombre_Centro"))));
                    Resource resources_centros
                            = model.createResource(Vocabulario.getURIschema().concat("CentrosDiversion"))
                            .addProperty(Vocabulario.nombrCentro, model.createResource(Vocabulario.getURIschema().concat(rs.getString("Nombre_Centro"))))
                            .addProperty(Vocabulario.servicio, model.createResource(Vocabulario.getURIeop().concat(rs.getString("Servicio"))))
                            .addProperty(Vocabulario.ser, model.createResource(Vocabulario.getURIschema().concat(rs.getString("Actividad"))))
                            .addProperty(Vocabulario.nombre, model.createResource(Vocabulario.getURIfoaf().concat(rs.getString("Propietari"))))
                            .addProperty(Vocabulario.telefono, model.createResource(Vocabulario.getURIfoaf().concat(rs.getString("Telefonos"))))
                            .addProperty(Vocabulario.RUC, model.createResource(Vocabulario.getURIfoaf().concat(rs.getString("Ruc"))))
                            //.addProperty(Vocabulario.calles, model.createResource(Vocabulario.getURIloca().concat(rs.getString("Calles"))))
                            .addProperty(Vocabulario.provincia, model.createResource(Vocabulario.getURIloca().concat(rs.getString("Province"))))
                            .addProperty(Vocabulario.canton, model.createResource(Vocabulario.getURIloca().concat(rs.getString("Cantons"))))
                            .addProperty(Vocabulario.distrito, model.createResource(Vocabulario.getURIloca().concat(rs.getString("Parroquia"))))
                            .addProperty(Vocabulario.hombres, model.createResource(Vocabulario.getURIfoaf().concat(rs.getString("Hombre"))))
                            .addProperty(Vocabulario.mujeres, model.createResource(Vocabulario.getURIfoaf().concat(rs.getString("Mujer"))));

                } catch (SQLException e) {
                    System.out.println("Faied algo pasa:" + e);
                }

            }
            model.write(new PrintWriter(System.out));
            rs.close();
        } catch (Exception e) {
            System.out.println("Se produjo un error inesperado en la query: " + e);

        }
    }
}
