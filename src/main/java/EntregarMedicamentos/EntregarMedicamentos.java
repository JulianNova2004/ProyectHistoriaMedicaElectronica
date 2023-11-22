/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntregarMedicamentos;

import leerInventario.Medicamento;
import leerInventario.LeerInventario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57300
 */
public class EntregarMedicamentos implements InventarioNotificacion {

    private static EntregarMedicamentos entregar;
    public LeerInventario inve;
    public ArrayList<String> agotados = new ArrayList();

    public void entregarMedicamento(Medicamento medi, int cantidad) {
        if (inve == null) {
            inve = LeerInventario.getInstance();
        }
        inve.entregarMedicamento(medi, cantidad);
        notificar();
    }

    public LeerInventario getInve() {
        return inve;
    }

    @Override
    public void notificar() {
        List<Medicamento> lista = inve.getAllMedicamentos();

        for (Medicamento w : lista) {
            //System.out.println(w);
            if (w.getCantidad() == 0) {
                System.out.println("Se agoto el/la: " + w.getNombre() + " por lo tanto se ingresara el medicamento a la lista de medicamentos agotados");
                agotados.add(w.getNombre());
            }
        }
    }

    @Override
    public String toString() {
        return "ImportarMedicamentos{" + "agotados=" + agotados + '}';
    }

}
