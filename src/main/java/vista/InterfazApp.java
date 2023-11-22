package vista;

import InicioSesion.Proxy;
import controlador.Controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import util.Util;

public class InterfazApp extends JFrame implements ActionListener {

    private JPanel panel1;
    private JPanel panel2;
    //private Panel3 panel3;
    private JLabel txt1;
    private JLabel txt2;
    private JTextField txtF1;
    private JTextField txtF2;
    private JButton btnInicio;
    private Proxy proxy;
    private Controlador ctrl;

    public InterfazApp(Controlador ctrl) {

        // Propiedades de la ventana 
        getContentPane().setLayout(null);
        this.setTitle("HISTORIA CLINICA ELECTRONICA");
        this.setResizable(false);
        this.setSize(400, 250);
        getContentPane().setBackground(new Color(1, 10, 110));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Integracion
        this.ctrl = ctrl;

        // Agregar controles   
        panel1 = new JPanel();
        panel1.setBounds(10, 10, 370, 120);
        panel2 = new JPanel();
        panel2.setBounds(10, 140, 370, 70);
        panel1.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder(" INICIO DE SESION ")));
        panel1.setLayout(null);
        panel2.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
        panel2.setLayout(null);

        txt1 = new JLabel("Usuario:");
        txt2 = new JLabel("Contrasena:");
        txtF1 = new JTextField();
        txtF2 = new JTextField();

        btnInicio = new JButton("Iniciar Sesión");
        btnInicio.addActionListener((ActionListener) this);
        btnInicio.setBounds(110, 25, 130, 30);

        txt1.setBounds(110, 20, 60, 20);
        txt2.setBounds(110, 70, 90, 20);
        txtF1.setBounds(110, 45, 130, 25);
        txtF2.setBounds(110, 90, 130, 25);

        // Agregar al layout
        add(panel1);
        add(panel2);
        panel1.add(txt1);
        panel1.add(txt2);
        panel1.add(txtF1);
        panel1.add(txtF2);
        panel2.add(btnInicio);
        // Centrar ventana
        Util.centrarVentana(this);
    }

    public String getUsuario() {
        return txtF1.getText();
    }

    public String getContrasena() {
        return txtF2.getText();
    }

    public String getCuenta() {
        return "el usuario es " + txtF1.getText() + " y la contrasena es " + txtF2.getText();
    }

    public static void main(String[] args) {
        InterfazApp frmMain = new InterfazApp(new Controlador());
        frmMain.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Iniciar Sesión")) {

            if (ctrl.comprobarCuenta(txtF1.getText(), txtF2.getText())) {
                setVisible(false);
                Gestion pant = new Gestion(ctrl);
                pant.setVisible(true);
                pant.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe, Intentelo de nuevo");
                //System.out.println("intente de nuevo");
            }

        }
    }

}
