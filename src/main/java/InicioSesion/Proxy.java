/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InicioSesion;

/**
 *
 * @author 57300
 */
public class Proxy {

    private Cuenta cuenta;

    public boolean log(String usuario, String contrasena) {
        if (cuenta == null) {
            cuenta = new Cuenta(usuario, contrasena);
        }
        if (cuenta.log(usuario, contrasena)) {
            //System.out.println("ha entrado al programa con exito");
            return true;
        }
        System.out.println("el usuario no existe");
        return false;
    }
}
