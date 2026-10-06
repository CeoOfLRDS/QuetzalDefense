public class Main {
    public static void main(String[] args) {
        RecursosMision recursos = new RecursosMision(100, 0, 0);
        Mision mision = new Mision(recursos);
        VistaConsola vista = new VistaConsola();
        ControladorMision controlador = new ControladorMision(mision, vista);

        controlador.iniciar();
    }
}
