/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerInventario;

/**
 *
 * @author Julián
 */
public class Medicamento {

    private String nombre;
    private int cantidad;
    private String formula;
    private String fechaV;

    public Medicamento() {
    }

    public Medicamento(String nombre, int cantidad, String formula, String fechaV) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.fechaV = fechaV;
        this.formula = formula;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaV() {
        return fechaV;
    }

    public void setFechaV(String fechaV) {
        this.fechaV = fechaV;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

}
