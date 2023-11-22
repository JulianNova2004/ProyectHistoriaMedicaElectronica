/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerInventario;

import java.util.List;

/**
 *
 * @author Julian
 */
public interface MedicamentosDAO {

    public List<Medicamento> getAllMedicamentos();

    public void entregarMedicamento(Medicamento medi, int cantidad);

    public void importarMedicamento(Medicamento medi);

}
