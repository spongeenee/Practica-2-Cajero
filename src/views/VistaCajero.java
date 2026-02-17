package views;
import java.util.Scanner;

public class VistaCajero {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("Bienvenido al Cajero Automático");
        System.out.println("1. Ver saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String solicitarUsuario(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    public int pedirMonto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    
}
