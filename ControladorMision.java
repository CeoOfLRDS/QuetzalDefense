import java.util.List;
import java.util.Optional;

public class ControladorMision {
    private Mision modelo;
    private VistaConsola vista;

    public ControladorMision(Mision modelo, VistaConsola vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        modelo.cargaInicial();

        boolean salir = false;

        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    listar();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    buscarPorNombre();
                    break;
                case 4:
                    ordenar();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opcion invalida.");
            }
        }

        vista.mostrarMensaje("Programa finalizado.");
    }

    public void listar() {
        vista.mostrarModulos(modelo.getModulos());
    }

    public void buscarPorId() {
        int id = vista.leerEntero("Ingrese el ID: ");
        Optional<Modulo> resultado = modelo.buscarModulo(id);

        if (resultado.isPresent()) {
            vista.mostrarModulo(resultado.get());
        } else {
            vista.mostrarMensaje("No se encontro el modulo.");
        }
    }

    public void buscarPorNombre() {
        String nombre = vista.leerTexto("Ingrese el nombre: ");
        List<Modulo> resultados = modelo.buscarModulo(nombre);

        if (resultados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron modulos.");
        } else {
            vista.mostrarModulos(resultados);
        }
    }

    public void ordenar() {
        modelo.ordenarPorCosto();
        vista.mostrarMensaje("Modulos ordenados por costo.");
        listar();
    }
}
