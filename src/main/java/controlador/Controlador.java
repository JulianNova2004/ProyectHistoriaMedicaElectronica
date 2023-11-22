/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EntregarMedicamentos.EntregarMedicamentos;
import InicioSesion.Proxy;
import importarMedicamentos.ImportarMedicamentos;
import javax.swing.JTable;
import leerInventario.LeerInventario;
import leerInventario.Medicamento;

/**
 *
 * @author nicor
 */
public class Controlador {

    private Proxy proxy;
    private ImportarMedicamentos importarMed;
    private EntregarMedicamentos entregarMed;
    private LeerInventario leerInve;

    public Boolean comprobarCuenta(String usuario, String contrasena) {
        if (proxy == null) {
            proxy = new Proxy();
        }
        return proxy.log(usuario, contrasena);
    }

    public void importarMedicamentos(String nombre, int cantidad, String formula, String fecha) {
        if (importarMed == null) {
            importarMed = ImportarMedicamentos.getInstance();
        }
        importarMed.importarMedicamentos(new Medicamento(nombre, cantidad, formula, fecha));
    }

    public void entregarMedicamentos(String nombre, int cantidad, String formula, String fecha, int cantidadE) {
        if (entregarMed == null) {
            entregarMed = new EntregarMedicamentos();
        }
        entregarMed.entregarMedicamento(new Medicamento(nombre, cantidad, formula, fecha), cantidadE);
    }

    public JTable Medicamentos() {
        if (leerInve == null) {
            leerInve = LeerInventario.getInstance();
        }
        return leerInve.getMedicamentos();
    }
}
