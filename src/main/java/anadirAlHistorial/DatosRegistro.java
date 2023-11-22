/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anadirAlHistorial;

/**
 *
 * @author U
 */
public class DatosRegistro {

    private String nombre;
    private String apellido;
    private String identificacion;
    private String telefono;
    private String nombreVacuna;
    private String Dosis;
    private String diaAplicacion;
    private String acudiente;

    public DatosRegistro(String nombre, String apellido, String identificacion, String telefono, String nombreVacuna, String Dosis, String diaAplicacion, String acudiente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.nombreVacuna = nombreVacuna;
        this.Dosis = Dosis;
        this.diaAplicacion = diaAplicacion;
        this.acudiente = acudiente;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public String getDosis() {
        return Dosis;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public String getDiaAplicacion() {
        return diaAplicacion;
    }

    public boolean isEmpty() {
        return getNombre().isEmpty() || getApellido().isEmpty() || getIdentificacion().isEmpty() || getTelefono().isEmpty() || getNombreVacuna().isEmpty() || getDosis().isEmpty() || getDiaAplicacion().isEmpty();
    }

}
