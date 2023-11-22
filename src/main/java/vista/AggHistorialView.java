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
import util.Util;

/**
 *
 * @author nicor
 */
public class AggHistorialView extends JFrame implements ActionListener {

    private JLabel lblTitulo;
    private JButton btnNino, btnAdulto;

    public AggHistorialView() {
        // Propiedades de la ventana 
        getContentPane().setLayout(null);
        this.setTitle("Historia Clinica Electronica");
        this.setResizable(false);
        this.setSize(400, 190);
        getContentPane().setBackground(new Color(1, 10, 110));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar controles
        btnNino = new JButton("Registrar Vacuna Niño");
        btnAdulto = new JButton("Registrar Vacuna Adulto");

        btnNino.setBounds(100, 40, 180, 30);
        add(btnNino);
        btnNino.addActionListener((ActionListener) this);
        btnAdulto.setBounds(100, 100, 180, 30);
        add(btnAdulto);
        btnAdulto.addActionListener((ActionListener) this);

        Util.centrarVentana(this);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Registrar Vacuna Niño")) {
            NinoView ninoV = NinoView.getInstance();
            ninoV.setVisible(true);
            ninoV.setLocationRelativeTo(null);
        } else {
            AdultoView AdulV = AdultoView.getInstance();
            AdulV.setVisible(true);
            AdulV.setLocationRelativeTo(null);
        }
    }

}
