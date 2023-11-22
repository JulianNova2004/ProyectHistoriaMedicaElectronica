/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import util.Util;

/**
 *
 * @author 57300
 */
public class VerHistView extends JFrame implements ActionListener {

    private JLabel lblTitulo;
    private JButton btnNino, btnAdulto;

    public VerHistView() {
        // Propiedades de la ventana 
        getContentPane().setLayout(null);
        this.setTitle("Historia Clinica Electronica");
        this.setResizable(false);
        this.setSize(400, 190);
        getContentPane().setBackground(new Color(1, 10, 110));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar controles
        btnNino = new JButton("Ver Historial de Vacuna Niño");
        btnAdulto = new JButton("Ver Historial de Vacuna Adulto");

        btnNino.setBounds(100, 40, 220, 30);
        add(btnNino);
        btnNino.addActionListener((ActionListener) this);
        btnAdulto.setBounds(100, 100, 220, 30);
        add(btnAdulto);
        btnAdulto.addActionListener((ActionListener) this);

        Util.centrarVentana(this);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Ver Historial de Vacuna Niño")) {
            HistNinoView histNino = new HistNinoView();
            histNino.setVisible(true);
        } else {
            HistAdultoView adulV = new HistAdultoView();
            adulV.setVisible(true);
            adulV.setLocationRelativeTo(null);
        }
    }

}
