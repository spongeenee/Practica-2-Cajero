package models;

public class Cajero {
    public ListaUsuarios usuarios;

    public Cajero() {
        this.usuarios = null;
    }

    public void agregarUsuario(Usuario usuario) {
        if (usuarios == null) {
            usuarios = new ListaUsuarios();
        }
        usuarios.agregarUsuario(usuario);
    }

    public double verSaldo(String usuario) {
        Usuario u = usuarios.buscarUsuario(usuario);
        if (u != null) {
            return u.getSaldo();
        }
        return 0;
    }

    public boolean retirarDinero(String usuario, double monto) {
        Usuario u = usuarios.buscarUsuario(usuario);
        if (u != null) {
            if (u.getSaldo() >= monto) {
                u.saldo -= monto;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void depositarDinero(String usuario, double monto) {
        Usuario u = usuarios.buscarUsuario(usuario);
        if (u != null) {
            u.saldo += monto;
        }
    }
}
