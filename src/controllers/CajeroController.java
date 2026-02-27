package controllers;
import views.*;
import models.*;
import models.comisionStrategies.*;
import models.verificacionStrategies.*;

public class CajeroController {
    private VistaCajero vista;
    protected Cajero cajero;

    public CajeroController(VistaCajero vista) {
        this.vista = vista;
    }

    public void iniciar() {
        cajero = new Cajero();
        System.out.println("=== Bienvenido al Cajero ===");
        int opcion = vista.menuMain();
        while (true) {
            switch (opcion) {
                case 1:
                    String nombre = vista.solicitar("Ingrese el nombre del usuario: ");
                    String usuario = vista.solicitar("Ingrese el PIN del usuario: ");
                    String password = vista.solicitar("Ingrese la contraseña del usuario: ");
                    double saldo = vista.pedirMonto("Ingrese el saldo inicial del usuario: ");
                    int bancoSeleccionado = vista.menuBancos();
                    ComisionStrategy banco = null;
                    switch (bancoSeleccionado) {
                        case 1:
                            banco = new BancoLocal();
                            break;
                        case 2:
                            banco = new BancoExterno();
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, intente de nuevo.");
                            return;
                    }
                    Usuario nuevoUsuario = new Usuario(nombre, usuario, saldo, password, banco);
                    cajero.agregarUsuario(nuevoUsuario);
                    System.out.println("Usuario agregado exitosamente.");
                    break;
                case 2:
                    operarConUsuario();
                    break;
                case 3:
                    System.out.println("Gracias por usar el Cajero. Adios.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            opcion = vista.menuMain();
        }
    }

    public void operarConUsuario() {
        int tipoVerificacion = vista.menuVerificacion();
        String usuario = vista.solicitar("Ingrese el nombre del usuario: ");
        String verificacion = vista.solicitar("Ingrese la verificación: ");
        if (!verificarUsuario(tipoVerificacion, usuario, verificacion)) {
            return;
        }
        int operacion = vista.menuOperaciones();
        switch (operacion) {
            case 1:
                double saldo = cajero.verSaldo(usuario);
                System.out.println("El saldo de " + usuario + " es: $" + saldo);
                break;
            case 2:
                double montoRetiro = vista.pedirMonto("Ingrese el monto a retirar: ");
                boolean retiroExitoso = cajero.retirarDinero(usuario, montoRetiro);
                if (retiroExitoso) {
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + cajero.verSaldo(usuario));
                } else {
                    System.out.println("Fondos insuficientes para realizar el retiro.");
                }
                break;
            case 3:
                double montoDeposito = vista.pedirMonto("Ingrese el monto a depositar: ");
                cajero.depositarDinero(usuario, montoDeposito);
                System.out.println("Depósito exitoso. Nuevo saldo: $" + cajero.verSaldo(usuario));
                break;
            case 4:
                System.out.println("Volviendo al menú principal...");
                return;
            default:
                System.out.println("Operación no válida. Por favor, intente de nuevo.");
        }
    }

    public boolean verificarUsuario(int tipoVerificacion, String usuario, String verificacion) {
        VerificacionStrategy estrategia;
        int intentos = 0;
        if (tipoVerificacion == 1) {
            estrategia = new VerificacionPIN();
        } else {
            estrategia = new VerificacionPassword();
        }
        while (true) {
            if (cajero.verificarUsuario(usuario, verificacion, estrategia)) {
                return true;
            } else {
                if (intentos >= 3) {
                    System.out.println("Demasiados intentos fallidos. Volviendo al menú principal.");
                    return false;
                }
                System.out.println("Verificación fallida. Usuario o credenciales incorrectas. Intente de nuevo.");
                usuario = vista.solicitar("Ingrese el usuario: ");
                verificacion = vista.solicitar("Ingrese la verificación: ");
                intentos++;
            }
        return false;
        }
    }
}
