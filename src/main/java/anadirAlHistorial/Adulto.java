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
public class Adulto extends DatosRegistro {

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String nombreVacuna;
    private String Dosis;
    private String diaAplicacion;
    private String acudiente;

    public Adulto(String nombre, String apellido, String identificacion, String telefono, String nombreVacuna, String Dosis, String diaAplicacion, String acudiente) {
        
        super(nombre, apellido, identificacion, telefono, nombreVacuna, Dosis, diaAplicacion, acudiente);
        
        this.nombre = nombre;
        this.apellido = apellido;
        cedula = identificacion;
        this.telefono = telefono;
        this.nombreVacuna = nombreVacuna;
        this.Dosis = Dosis;
        this.diaAplicacion = diaAplicacion;
        acudiente = null;
    }

}
