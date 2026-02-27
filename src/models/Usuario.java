package models;

import models.comisionStrategies.ComisionStrategy;

public class Usuario {
    protected String nombre;
    protected String usuario;
    protected String password;
    protected double saldo;

    public ComisionStrategy banco;
    public Usuario siguiente;

    public Usuario(String nombre, String usuario, double saldo, String password, ComisionStrategy banco) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.saldo = saldo;
        this.password = password;
        this.banco = banco;
    }

    public void setComisionStrategy(ComisionStrategy comisionStrategy) {
        this.banco = comisionStrategy;
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

    public String getPassword() {
        return password;
    }
}
