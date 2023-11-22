/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author nicor
 */
//implements ActionListener
public class VerInveView extends JFrame {

    private Controlador ctrl;
    private JPanel panel;
    private JTable tabla;

    VerInveView(Controlador ctrl) {
        getContentPane().setLayout(null);
        //this.setTitle("Leer Inventario");
        this.setResizable(false);
        this.setSize(400, 400);
        getContentPane().setBackground(new Color(1, 10, 110));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Integracion
        panel = new JPanel();
        panel.setBounds(10, 10, 370, 350);
        panel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("INVENTARIO")));
        this.ctrl = ctrl;

        tabla = new JTable();
        tabla.setBounds(20, 20, 300, 300);
        tabla = ctrl.Medicamentos();

        add(panel);
        panel.add(tabla);
    }

}
