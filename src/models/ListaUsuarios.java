package models;

public class ListaUsuarios {
    public Usuario inicio;
    public Usuario siguiente;

    public ListaUsuarios() {
        this.inicio = null;
        this.siguiente = null;
    }

    public void agregarUsuario(Usuario usuario) {
        if (inicio == null) {
            inicio = usuario;
        } else {
            Usuario temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = usuario;
        }
    }

    public Usuario buscarUsuario(String usuario) {
        Usuario temp = inicio;
        while (temp != null) {
            if (temp.getUsuario().equals(usuario)) {
                return temp;
            }
            temp = temp.siguiente;
        }
        return null;
    }
}
