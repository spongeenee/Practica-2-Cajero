package models.verificacionStrategies;
import models.ListaUsuarios;
import models.Usuario;

public class VerificacionPIN implements VerificacionStrategy {
    @Override
    public boolean verificar(String usuario, String verificacion, ListaUsuarios usuarios) {
         Usuario u = usuarios.buscarUsuario(usuario);
         if (u == null) {
             return false;
         }
        return u.getUsuario().equals(verificacion);
    }
    
}
