/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrosontologia;

import Conexion.bd;

/**
 *
 * @author Jairo
 */
public class Resources {

    public static void main(String[] args) {
        bd db = new bd();
        db.consulta();

    }
    

/*    public void getRecurso(String nombre, String ruc, String propietario, String telefono, String servicios, String calles, String actividad, String categoria, String hombre, String mujer, String provincia, String canton, String parroquia) {

        String Resource = "CentrosDiversion";
        String legalName = nombre;
        //String capacidad = ca;
        String servicio = servicios;
        String ser = actividad;
        String propietari = propietario;
        String fono = telefono;
        String Ruc = ruc;
        String calle = calles;
        String province = provincia;
        String cantoN = canton;
        String paroqui = parroquia;
        String Nhombre = hombre;
        String Nmujer = mujer;
        String category = categoria;

        
                          
    }*/

}
