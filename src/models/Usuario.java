package models;

public class Usuario {
    protected String nombre;
    protected String usuario;
    protected double saldo;
    public Usuario siguiente;

    public Usuario(String nombre, String usuario, double saldo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public double getSaldo() {
        return saldo;
    }
}
