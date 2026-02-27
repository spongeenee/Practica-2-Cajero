import controllers.CajeroController;
import views.VistaCajero;

public class Main {
    public static void main(String[] args) {
        VistaCajero vista = new VistaCajero();
        CajeroController controlador = new CajeroController(vista);
        controlador.iniciar();

        System.exit(0);
    }
}
