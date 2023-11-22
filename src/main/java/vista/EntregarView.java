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
public class EntregarView extends JFrame implements ActionListener {

    private Controlador ctrl;
    private JLabel nombre, cantidad, formula, fecha, cantidadE;
    private JTextField nombret, cantidadt, formulat, fechat, cantidadEt;
    private JButton btnImp, btnVolver;
    private JPanel panel;

    EntregarView(Controlador ctrl) {
        getContentPane().setLayout(null);
        this.setTitle("Importar Medicamentos");
        this.setResizable(false);
        this.setSize(400, 290);
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
        cantidadE = new JLabel("Cantidad Entregada");
        cantidadEt = new JTextField();

        btnImp = new JButton("Entregar");
        btnImp.addActionListener((ActionListener) this);
        btnImp.setBounds(50, 190, 130, 30);

        btnVolver = new JButton("Volver");
        btnVolver.addActionListener((ActionListener) this);
        btnVolver.setBounds(200, 190, 130, 30);

        panel.setBounds(10, 10, 370, 240);
        panel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Entrega")));
        panel.setLayout(null);

        nombre.setBounds(100, 20, 60, 20);
        nombret.setBounds(160, 20, 130, 20);
        cantidad.setBounds(100, 60, 130, 25);
        cantidadt.setBounds(160, 60, 130, 25);
        formula.setBounds(100, 90, 60, 20);
        formulat.setBounds(160, 90, 130, 20);
        fecha.setBounds(100, 120, 130, 25);
        fechat.setBounds(160, 120, 130, 25);
        cantidadE.setBounds(30, 150, 130, 25);
        cantidadEt.setBounds(160, 150, 130, 25);

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
        panel.add(cantidadE);
        panel.add(cantidadEt);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Entregar")) {
            int aux = Integer.parseInt(cantidadt.getText());
            int aux2 = Integer.parseInt(cantidadEt.getText());
            ctrl.entregarMedicamentos(nombret.getText(), aux, formulat.getText(), fechat.getText(), aux2);

        } else {

        }
    }

}
