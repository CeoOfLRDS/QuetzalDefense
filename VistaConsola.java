import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== MISION QUETZAL-2 ===");
        System.out.println("1. Listar modulos");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Buscar por nombre");
        System.out.println("4. Ordenar por costo");
        System.out.println("5. Salir");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarModulo(Modulo modulo) {
        System.out.println(modulo);
    }

    public void mostrarModulos(List<Modulo> modulos) {
        if (modulos.isEmpty()) {
            mostrarMensaje("No hay modulos.");
            return;
        }

        for (Modulo modulo : modulos) {
            mostrarModulo(modulo);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
