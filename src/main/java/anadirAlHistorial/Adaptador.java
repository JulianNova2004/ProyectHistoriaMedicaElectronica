/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anadirAlHistorial;

/**
 *
 * @author nicor
 */
public class Adaptador {

    private DatosRegistro datos;
    private Adulto adulto;
    private Nino nino;

    public DatosRegistro AdaptadorAd(String nombre, String apellido, String identificacion, String telefono, String nombreVacuna, String Dosis, String diaAplicacion) {
        datos = new Adulto(nombre, apellido, identificacion, telefono, nombreVacuna, Dosis, diaAplicacion, null);
        return datos;

    }

    public DatosRegistro AdaptadorNi(String nombre, String apellido, String identificacion, String telefono, String nombreVacuna, String Dosis, String diaAplicacion, String acudiente) {
        datos = new Nino(nombre, apellido, identificacion, telefono, nombreVacuna, Dosis, diaAplicacion, acudiente);
        return datos;
    }

    public DatosRegistro getDatos() {
        return datos;
    }

}
