/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import anadirAlHistorial.Adaptador;
import anadirAlHistorial.DatosRegistro;
import anadirAlHistorial.Nino;
import controlador.Controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author nicor
 */
public class NinoView extends JFrame implements ActionListener {

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtIdentificacion;
    private JTextField txtTelefono;
    private JTextField txtNombreVacuna;
    private JTextField txtDosis;
    private JTextField txtFechaAplicacion;
    private JTextField txtAcudiente;
    private Controlador ctrl;
    private List<DatosRegistro> histNino;
    private JButton btnRegistrar;
    private DatosRegistro datos;
    private Adaptador adapt;
    private static NinoView ninoView;

    private NinoView() {
        adapt = new Adaptador();
        histNino = new ArrayList();
        getContentPane().setLayout(null);
        this.setTitle("Agregar Vacuna Niño");
        this.setResizable(false);
        this.setSize(400, 370);
        getContentPane().setBackground(new Color(1, 10, 110));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(90, 10, 80, 20);
        lblNombre.setForeground(Color.WHITE);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(200, 10, 150, 20);
        add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(90, 40, 80, 20);
        lblApellido.setForeground(Color.WHITE);
        add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(200, 40, 150, 20);
        add(txtApellido);

        JLabel lblIdentificacion = new JLabel("Tarjeta De Identidad:");
        lblIdentificacion.setBounds(50, 70, 180, 20);
        lblIdentificacion.setForeground(Color.WHITE);
        add(lblIdentificacion);

        txtIdentificacion = new JTextField();
        txtIdentificacion.setBounds(200, 70, 150, 20);
        add(txtIdentificacion);

        JLabel lblTelefono = new JLabel("Telefono:");
        lblTelefono.setBounds(90, 100, 80, 20);
        lblTelefono.setForeground(Color.WHITE);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(200, 100, 150, 20);
        add(txtTelefono);

        JLabel lblNombreVacuna = new JLabel("NomVacuna:");
        lblNombreVacuna.setBounds(80, 130, 120, 20);
        lblNombreVacuna.setForeground(Color.WHITE);
        add(lblNombreVacuna);

        txtNombreVacuna = new JTextField();
        txtNombreVacuna.setBounds(200, 130, 150, 20);
        add(txtNombreVacuna);

        JLabel lblDosis = new JLabel("Dosis:");
        lblDosis.setBounds(95, 160, 80, 20);
        lblDosis.setForeground(Color.WHITE);
        add(lblDosis);

        txtDosis = new JTextField();
        txtDosis.setBounds(200, 160, 150, 20);
        add(txtDosis);

        JLabel lblFechaAplicacion = new JLabel("Fecha Aplicación (dd/MM/yyyy):");
        lblFechaAplicacion.setBounds(10, 190, 250, 20);
        lblFechaAplicacion.setForeground(Color.WHITE);
        add(lblFechaAplicacion);

        txtFechaAplicacion = new JTextField();
        txtFechaAplicacion.setBounds(200, 190, 150, 20);
        add(txtFechaAplicacion);

        JLabel lblAcudiente = new JLabel("Acudiente:");
        lblAcudiente.setBounds(80, 230, 180, 20);
        lblAcudiente.setForeground(Color.WHITE);
        add(lblAcudiente);

        txtAcudiente = new JTextField();
        txtAcudiente.setBounds(200, 230, 150, 20);
        add(txtAcudiente);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(150, 280, 100, 30);
        btnRegistrar.addActionListener((ActionListener) this);
        add(btnRegistrar);

    }

    public static NinoView getInstance() {
        if (ninoView == null) {
            ninoView = new NinoView();
        }
        return ninoView;
    }

    public List<DatosRegistro> getHistNino() {
        return histNino;
    }

    public boolean verificar() {
        return txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtIdentificacion.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtNombreVacuna.getText().isEmpty() || txtDosis.getText().isEmpty() || txtFechaAplicacion.getText().isEmpty() || txtAcudiente.getText().isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Registrar")) {
            if (verificar()) {
                JOptionPane.showMessageDialog(null, "Ingrese TODOS los datos");
            } else {
                datos = adapt.AdaptadorNi(txtNombre.getText(), txtApellido.getText(), txtIdentificacion.getText(), txtTelefono.getText(), txtNombreVacuna.getText(), txtDosis.getText(), txtFechaAplicacion.getText(), txtAcudiente.getText());
                //datos = new Nino();
                histNino.add(datos);
                for (DatosRegistro s : histNino) {
                    System.out.println(txtAcudiente.getText());
                    System.out.println(s.getNombre() + " " + s.getApellido() + "Acudiente: " + s.getAcudiente());
                }
            }

        }
    }

}
