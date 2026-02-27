package models.verificacionStrategies;

import models.ListaUsuarios;

public interface VerificacionStrategy {
    public boolean verificar(String usuario, String verificacion, ListaUsuarios usuarios);
}
