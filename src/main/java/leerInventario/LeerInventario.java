/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerInventario;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julián
 */
public class LeerInventario implements MedicamentosDAO {

    private static LeerInventario inventario;
    private String driver;
    private String url;
    private String login;
    private String password;
    private String sentencia;
    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    private Medicamento medi;

    private LeerInventario() {
        //jdbc:derby://localhost:1527/sample [app on APP]
        driver = "org.apache.derby.jdbc.ClientDriver";
        url = "jdbc:derby://localhost:1527/sample";
        login = "app";
        password = "app";
        sentencia = "";
        connection = null;
        statement = null;
        rs = null;
        medi = new Medicamento();

    }

    public static LeerInventario getInstance() {
        if (inventario == null) {
            inventario = new LeerInventario();
        }
        return inventario;
    }

    public void conectar() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LeerInventario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 1-" + ex.getMessage());
        } catch (SQLException ex2) {
            Logger.getLogger(LeerInventario.class.getName()).log(Level.SEVERE, null, ex2);
            System.out.println("Error 2-" + ex2.getMessage());
        }

        System.out.println("Conexion exitosa");

    }

    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException ex2) {
            Logger.getLogger(LeerInventario.class.getName()).log(Level.SEVERE, null, ex2);
            System.out.println("Error 2-" + ex2.getMessage());
        }
    }

    @Override
    public List<Medicamento> getAllMedicamentos() {

        if (connection == null) {
            conectar();
        }
        List<Medicamento> lista = new ArrayList();
        sentencia = "SELECT * FROM APP.MEDICAMENTOS";
        try {
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sentencia);
            if (rs == null) {
                System.out.println("NO HAY DATOS");
            }
            rs.first();
            do {
                System.out.println("Ingreso a añadir " + rs.getString(1));
                medi.setNombre(rs.getString(1));
                medi.setCantidad(rs.getInt(2));
                medi.setFechaV(rs.getString(3));
                medi.setFormula(rs.getString(4));
                lista.add(medi);
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(LeerInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void entregarMedicamento(Medicamento medi, int cantidad) {

        if (connection == null) {
            conectar();
        }

        if (medi.getCantidad() - cantidad >= 0) {

            int aux = medi.getCantidad() - cantidad;
            sentencia = "UPDATE APP.Medicamentos SET Cantidad=" + aux + " WHERE Nombre=" + "'" + medi.getNombre() + "'";
            try {
                statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.executeUpdate(sentencia);
            } catch (SQLException ex) {
                Logger.getLogger(LeerInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void importarMedicamento(Medicamento medi) {

        if (connection == null) {
            conectar();
        }
        sentencia = "INSERT INTO Medicamentos VALUES("
                + "'"
                + medi.getNombre() + "',"
                + medi.getCantidad() + ",'"
                + medi.getFormula() + "','"
                + medi.getFechaV() + "'"
                + ")";

        System.out.println("Ingreso a añadir Medicamento " + sentencia);
        try {
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(sentencia);
        } catch (SQLException ex) {
            Logger.getLogger(LeerInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String metodito(Medicamento medi, int cantidad) {
        int aux = medi.getCantidad() - cantidad;
        sentencia = "UPDATE Medicamentos \n"
                + "SET Cantidad = " + aux + "\n"
                + "WHERE Nombre = " + "'" + medi.getNombre() + "';";

        return sentencia;
    }

    public JTable getMedicamentos() {
        JTable table = new JTable();
        if (connection == null) {
            conectar();
        }
        sentencia = "SELECT * FROM APP.MEDICAMENTOS";
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("NOMBRE");
        model.addColumn("CANTIDAD");
        model.addColumn("FORMULA");
        model.addColumn("FECHA_VENCIMIENTO");

        table.setModel(model);

        String tabla[] = new String[4];

        try {
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sentencia);
            while (rs.next()) {
                tabla[0] = rs.getString(1);
                tabla[1] = rs.getString(2);
                tabla[2] = rs.getString(3);
                tabla[3] = rs.getString(4);
                model.addRow(tabla);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LeerInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;

    }
}
