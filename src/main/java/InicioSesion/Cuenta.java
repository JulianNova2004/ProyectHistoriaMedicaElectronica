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
public class Cuenta extends Subject {

    private String usuario;
    private String contrasena;
    private String[] user = {"julian-nova", "nicolas-moreno", "mario-palencia", "juan-romero", "camila-ramirez", "karen-gomez", "jose-enriquez", "camilo-rodriguez", "andrea-marin", "santiago-galvis", "diego-perez", "catalina-pulido", "felipe-vera", "gabriel-garzon", "tomas-castro"};
    private String[] password = {"pasw1", "pasw2", "pasw3", "pasw4", "pasw5", "pasw6", "pasw7", "pasw8", "pasw9", "pasw10", "pasw11", "pasw12", "pasw13", "pasw14", "pasw15"};

    public Cuenta(String usuario, String contraseña) {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String[] getUser() {
        return user;
    }

    public String[] getContraseña() {
        return password;
    }

    @Override
    public Boolean log(String usuario, String contrasena) {

        for (int i = 0; i < user.length; i++) {
            if (usuario.equals(user[i]) && contrasena.equals(password[i])) {
                return true;
            }
        }
        return false;
    }

}
