/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importarMedicamentos;

import java.util.ArrayList;
import java.util.List;
import leerInventario.LeerInventario;
import leerInventario.Medicamento;

/**
 *
 * @author 57300
 */
public class ImportarMedicamentos {

    public LeerInventario inventario;
    public static ImportarMedicamentos importar;

    private ImportarMedicamentos() {
    }

    public void importarMedicamentos(Medicamento medi) {

        if (inventario == null) {
            inventario = LeerInventario.getInstance();
        }
        //notificar();
        inventario.importarMedicamento(medi);

    }

    public static ImportarMedicamentos getInstance() {
        if (importar == null) {
            importar = new ImportarMedicamentos();
        }
        return importar;
    }

}
