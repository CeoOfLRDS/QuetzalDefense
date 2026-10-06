import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Mision {
    private List<Modulo> modulos;
    private RecursosMision recursos;
    private boolean cargaRealizada;

    public Mision(RecursosMision recursos) {
        if (recursos == null) {
            throw new IllegalArgumentException("Los recursos no pueden ser nulos.");
        }
        this.recursos = recursos;
        modulos = new ArrayList<Modulo>();
        cargaRealizada = false;
    }

    public void cargaInicial() {
        if (cargaRealizada) {
            return;
        }

        registrarModulo(new ModuloVuelo(1, "Navegacion", 100, 5000, recursos, 120));
        registrarModulo(new ModuloVuelo(2, "Telemetria", 90, 4200, recursos, 100));
        registrarModulo(new ModuloVuelo(3, "Sensores", 85, 3800, recursos, 80));
        registrarModulo(new ModuloVuelo(4, "Observacion", 95, 4500, recursos, 110));

        registrarModulo(new ModuloTierra(5, "Antena Principal", 100, 6000, recursos, 150, 20));
        registrarModulo(new ModuloTierra(6, "Antena Secundaria", 80, 3500, recursos, 90, 15));
        registrarModulo(new ModuloTierra(7, "Estacion de Respaldo", 75, 3000, recursos, 70, 12));

        registrarModulo(new ModuloEnergia(8, "Panel Solar", 100, 7000, recursos, 200));
        registrarModulo(new ModuloEnergia(9, "Generador Auxiliar", 90, 5500, recursos, 140));
        registrarModulo(new ModuloEnergia(10, "Bateria", 95, 4000, recursos, 100));

        cargaRealizada = true;
    }

    public void registrarModulo(Modulo modulo) {
        if (modulo == null) {
            throw new IllegalArgumentException("El modulo no puede ser nulo.");
        }

        if (modulo.getRecursos() != recursos) {
            throw new IllegalArgumentException("El modulo debe usar los recursos de la mision.");
        }

        if (buscarModulo(modulo.getId()).isPresent()) {
            throw new IllegalArgumentException("El ID ya existe.");
        }

        modulos.add(modulo);
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public Optional<Modulo> buscarModulo(int id) {
        for (Modulo modulo : modulos) {
            if (modulo.getId() == id) {
                return Optional.of(modulo);
            }
        }
        return Optional.empty();
    }

    public List<Modulo> buscarModulo(String nombre) {
        List<Modulo> encontrados = new ArrayList<Modulo>();

        for (Modulo modulo : modulos) {
            if (modulo.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(modulo);
            }
        }

        return encontrados;
    }

    public void ordenarPorCosto() {
        Collections.sort(modulos);
    }
}
