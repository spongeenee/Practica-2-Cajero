package models;

public class ListaUsuarios {
    public Usuario actual;
    public Usuario siguiente;

    public ListaUsuarios() {
        this.actual = null;
        this.siguiente = null;
    }

    public void agregarUsuario(Usuario usuario) {
        if (actual == null) {
            actual = usuario;
        } else {
            Usuario temp = actual;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = usuario;
        }
    }

    public Usuario buscarUsuario(String usuario) {
        Usuario temp = actual;
        while (temp != null) {
            if (temp.getUsuario().equals(usuario)) {
                return temp;
            }
            temp = temp.siguiente;
        }
        return null;
    }
}
