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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author nicor
 */
public class ImportarView extends JFrame implements ActionListener {

    private Controlador ctrl;
    private JLabel nombre, cantidad, formula, fecha;
    private JTextField nombret, cantidadt, formulat, fechat;
    private JButton btnImp, btnVolver;
    private JPanel panel;

    ImportarView(Controlador ctrl) {
        getContentPane().setLayout(null);
        this.setTitle("Importar Medicamentos");
        this.setResizable(false);
        this.setSize(400, 250);
        getContentPane().setBackground(new Color(1, 10, 110));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Integracion
        panel = new JPanel();
        this.ctrl = ctrl;
        nombre = new JLabel("Nombre ");
        nombret = new JTextField();
        cantidad = new JLabel("Cantidad ");
        cantidadt = new JTextField();
        formula = new JLabel("Formula ");
        formulat = new JTextField();
        fecha = new JLabel("Fecha ");
        fechat = new JTextField();

        btnImp = new JButton("Importar");
        btnImp.addActionListener((ActionListener) this);
        btnImp.setBounds(50, 150, 130, 30);

        btnVolver = new JButton("Volver");
        btnVolver.addActionListener((ActionListener) this);
        btnVolver.setBounds(200, 150, 130, 30);

        panel.setBounds(10, 10, 370, 200);
        panel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder(" Importación ")));
        panel.setLayout(null);

        nombre.setBounds(100, 20, 60, 20);
        nombret.setBounds(150, 20, 90, 20);
        cantidad.setBounds(100, 60, 130, 25);
        cantidadt.setBounds(150, 60, 130, 25);
        formula.setBounds(100, 90, 60, 20);
        formulat.setBounds(150, 90, 90, 20);
        fecha.setBounds(100, 120, 130, 25);
        fechat.setBounds(150, 120, 130, 25);

        add(panel);
        panel.add(nombre);
        panel.add(nombret);
        panel.add(cantidad);
        panel.add(cantidadt);
        panel.add(formula);
        panel.add(formulat);
        panel.add(fecha);
        panel.add(fechat);
        panel.add(btnImp);
        panel.add(btnVolver);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Importar")) {
            int aux = Integer.parseInt(cantidadt.getText());
            ctrl.importarMedicamentos(nombret.getText(), aux, formulat.getText(), fechat.getText());
        } else {
            setVisible(false);

        }
    }

}
