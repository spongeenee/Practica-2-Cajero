package controllers;
import views.*;
import models.*;

public class CajeroController {
    private VistaCajero vista;

    public CajeroController(VistaCajero vista) {
        this.vista = vista;
    }

    public void iniciar() {
        Cajero cajero = new Cajero();
        cajero.agregarUsuario(new Usuario("Juan Perez", "1234", 1000.0));
        cajero.agregarUsuario(new Usuario("Maria Lopez", "5678", 2500.0));
        System.out.println("=== Bienvenido al Cajero ===");
        while (true) {
            int opcion = vista.mostrarMenu();
            if (opcion == 4) {
                System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
                break;
            }
            String usuario = vista.solicitarUsuario("Ingrese su PIN: ");
            for (Usuario u : cajero.usuarios) {
                if (u.getUsuario().equals(usuario)) {
                    System.out.println("Bienvenido, " + u.getNombre() + "!");
                    break;
                }
            }

            switch (opcion) {
                case 1:
                    double saldo = cajero.verSaldo(usuario);
                    System.out.println("Su saldo es: $" + saldo);
                    break;
                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetiro = vista.pedirMonto("Ingrese el monto a retirar: ");
                    if (cajero.retirarDinero(usuario, montoRetiro)) {
                        System.out.println("Retiro exitoso. Su nuevo saldo es: $" + cajero.verSaldo(usuario));
                    } else {
                        System.out.println("Fondos insuficientes o usuario no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDeposito = vista.pedirMonto("Ingrese el monto a depositar: ");
                    cajero.depositarDinero(usuario, montoDeposito);
                    System.out.println("Depósito exitoso. Su nuevo saldo es: $" + cajero.verSaldo(usuario));
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}
