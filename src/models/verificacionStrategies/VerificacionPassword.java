package models.verificacionStrategies;

import models.ListaUsuarios;
import models.Usuario;

public class VerificacionPassword implements VerificacionStrategy {
    @Override
    public boolean verificar(String usuario, String verificacion, ListaUsuarios usuarios) {
         Usuario u = usuarios.buscarUsuario(usuario);
         if (u == null) {
             return false;
         }
        return u.getPassword().equals(verificacion);
    }
    
}
