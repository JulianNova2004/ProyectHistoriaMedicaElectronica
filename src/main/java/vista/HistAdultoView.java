/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import anadirAlHistorial.DatosRegistro;
import java.awt.Color;
import java.awt.Panel;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import vista.AdultoView;

/**
 *
 * @author 57300
 */
public class HistAdultoView extends JFrame {

    private JPanel panel;
    private JTable tabla;
    private DefaultTableModel model;
    private AdultoView adultoView;

    public HistAdultoView() {
        getContentPane().setLayout(null);
        setTitle("HISTORIAL VACUNAS ADULTO");
        //this.setTitle("Leer Inventario");
        this.setResizable(false);
        this.setSize(600, 600);
        getContentPane().setBackground(new Color(1, 10, 110));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.adultoView = AdultoView.getInstance();

        model = new DefaultTableModel();
        //setSize(600,600);
        tabla = new JTable(model);
        //tabla.setBounds(20, 20, 300, 300);

        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Cedula");
        model.addColumn("Telefono");
        model.addColumn("Vacuna");
        model.addColumn("Dosis");
        model.addColumn("Fecha_Ap");

        List<DatosRegistro> datos = adultoView.getHistAdul();

        for (DatosRegistro registro : datos) {
            String nombre = registro.getNombre();
            System.out.println(nombre);
            String apellido = registro.getApellido();
            String cedula = registro.getIdentificacion();
            String telefono = registro.getTelefono();
            String vacuna = registro.getNombreVacuna();
            String dosis = registro.getDosis();
            String fecha = registro.getDiaAplicacion();

            Object[] data;
            data = new Object[]{nombre, apellido, cedula, telefono, vacuna, dosis, fecha};

            model.addRow(data);
        }
        //add(panel);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(10, 10, 550, 530);
        getContentPane().add(scrollPane);

        //add(tabla);
    }

}
