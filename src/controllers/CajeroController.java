package controllers;
import views.*;
import models.*;

public class CajeroController {
    private VistaCajero vista;
    protected Cajero cajero;

    public CajeroController(VistaCajero vista) {
        this.vista = vista;
    }

    public void agregarUsuario(Usuario usuario) {
        if (cajero != null) {
            cajero.agregarUsuario(usuario);
        }
    }

    public void iniciar() {
        cajero = new Cajero();
        cajero.agregarUsuario(new Usuario("Juan Perez", "1234", 1000.0));
        cajero.agregarUsuario(new Usuario("Maria Lopez", "5678", 2500.0));
        System.out.println("=== Bienvenido al Cajero ===");
        while (true) {
            /* Solicitar el usuario */
            int intentos = 0;
            String usuario = vista.solicitarUsuario("Ingrese su PIN: ");
            Usuario u = cajero.usuarios.buscarUsuario(usuario);
            while (u == null) {
                intentos++;
                if (intentos >= 3) {
                    System.out.println("Demasiados intentos fallidos. Saliendo.");
                    return;
                }
                System.out.println("PIN incorrecto. Intente de nuevo.");
                usuario = vista.solicitarUsuario("Ingrese su PIN: ");
                u = cajero.usuarios.buscarUsuario(usuario);
            }
            
            int opcion = vista.mostrarMenu();
            /* Opciones */
            switch (opcion) {
                case 1:
                    double saldo = cajero.verSaldo(usuario);
                    System.out.println("Su saldo es: $" + saldo);
                    break;
                case 2:
                    double montoRetiro = vista.pedirMonto("Ingrese el monto a retirar: ");
                    if (cajero.retirarDinero(usuario, montoRetiro)) {
                        System.out.println("Retiro exitoso. Su nuevo saldo es: $" + cajero.verSaldo(usuario));
                    } else {
                        System.out.println("Fondos insuficientes.");
                    }
                    break;
                case 3:
                    double montoDeposito = vista.pedirMonto("Ingrese el monto a depositar: ");
                    cajero.depositarDinero(usuario, montoDeposito);
                    System.out.println("Depósito exitoso. Su nuevo saldo es: $" + cajero.verSaldo(usuario));
                    break;
                case 4:
                    System.out.println("Gracias por usar el Cajero. Adios.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}
