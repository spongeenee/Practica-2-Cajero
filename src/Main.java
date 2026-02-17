import controllers.CajeroController;
import models.Usuario;
import views.VistaCajero;

public class Main {
    public static void main(String[] args) {
        VistaCajero vista = new VistaCajero();
        CajeroController controlador = new CajeroController(vista);
        controlador.agregarUsuario(new Usuario("Juan", "1234", 1000.0));
        controlador.agregarUsuario(new Usuario("Maria", "5678", 2500.0));
        controlador.iniciar();

        System.exit(0);
    }
}
