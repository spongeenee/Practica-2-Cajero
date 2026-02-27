package views;
import java.util.Scanner;

public class VistaCajero {
    private Scanner scanner = new Scanner(System.in);

    public int menuMain() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar usuario");
        System.out.println("2. Operar con usuario");
        System.out.println("3. Salir");
        return scanner.nextInt();
    }

    public int menuVerificacion() {
        System.out.println("Ingresar por PIN o contraseña:");
        System.out.println("1. PIN");
        System.out.println("2. Contraseña");
        return scanner.nextInt();
    }

    public int menuOperaciones() {
        System.out.println("Seleccione una operación:");
        System.out.println("1. Ver saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Volver al menú principal");
        return scanner.nextInt();
    }

    public int menuBancos() {
        System.out.println("Seleccione un banco:");
        System.out.println("1. Banco Local");
        System.out.println("2. Otro Banco");
        return scanner.nextInt();
    }

    public String solicitar(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    public int pedirMonto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    
}
