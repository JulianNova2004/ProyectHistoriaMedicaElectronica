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
public class Gestion extends JFrame implements ActionListener {

    private Controlador ctrl;
    private JLabel lblTitulo;
    private JButton btnImportarM, btnEntregarM, btnVerInv, btnVacuna, btnVacunaHist;

    public Gestion(Controlador ctrl) {// Propiedades de la ventana 
        getContentPane().setLayout(null);
        this.setTitle("Historia Clinica Electronica");
        this.setResizable(false);
        this.setSize(420, 350);
        getContentPane().setBackground(new Color(1, 10, 110));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Integracion
        this.ctrl = ctrl;

        // Agregar controles
        btnImportarM = new JButton("Importar Medicamentos");
        btnEntregarM = new JButton("Entregar Medicamentos");
        btnVerInv = new JButton("Ver Inventario");
        btnVacuna = new JButton("Agregar Vacuna Al Historial del Paciente");
        btnVacunaHist = new JButton("Ver Historial de vacunas del Paciente");

        btnImportarM.setBounds(10, 50, 180, 30);
        add(btnImportarM);
        btnImportarM.addActionListener((ActionListener) this);
        btnEntregarM.setBounds(220, 50, 180, 30);
        add(btnEntregarM);
        btnEntregarM.addActionListener((ActionListener) this);
        btnVerInv.setBounds(10, 140, 120, 30);
        add(btnVerInv);
        btnVerInv.addActionListener((ActionListener) this);
        btnVacuna.setBounds(135, 140, 265, 30);
        add(btnVacuna);
        btnVacuna.addActionListener((ActionListener) this);
        btnVacunaHist.setBounds(70, 230, 280, 30);
        add(btnVacunaHist);
        btnVacunaHist.addActionListener((ActionListener) this);
        Util.centrarVentana(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Importar Medicamentos")) {
            //setVisible(false);
            ImportarView impant = new ImportarView(ctrl);
            impant.setVisible(true);
            impant.setLocationRelativeTo(null);

        } else if (e.getActionCommand().equals("Entregar Medicamentos")) {
            //setVisible(false);
            EntregarView entpant = new EntregarView(ctrl);
            entpant.setVisible(true);
            entpant.setLocationRelativeTo(null);
        } else if (e.getActionCommand().equals("Ver Inventario")) {
            VerInveView inveV = new VerInveView(ctrl);
            inveV.setVisible(true);
            inveV.setLocationRelativeTo(null);
        } else if (e.getActionCommand().equals("Agregar Vacuna Al Historial del Paciente")) {
            AggHistorialView hist = new AggHistorialView();
            hist.setVisible(true);
            hist.setLocationRelativeTo(null);
        } else if (e.getActionCommand().equals("Ver Historial de vacunas del Paciente")) {
            VerHistView haview = new VerHistView();
            haview.setVisible(true);
            haview.setLocationRelativeTo(null);
        }
        {

        }

    }
}
