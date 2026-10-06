public class ModuloEnergia extends Modulo {
    private int energiaPorCiclo;

    public ModuloEnergia(int id, String nombre, int salud, int costo, RecursosMision recursos, int energiaPorCiclo) {
        super(id, nombre, salud, costo, recursos);

        if (energiaPorCiclo < 0) {
            throw new IllegalArgumentException("La energía por ciclo no puede ser negativa.");
        }
        this.energiaPorCiclo = energiaPorCiclo;
    }

    @Override
    public void procesarCiclo() {
        if (estaOperativo()) {
            getRecursos().agregarEnergia(energiaPorCiclo);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Energía por ciclo: " + energiaPorCiclo;
    }

    public int getEnergiaPorCiclo() {
        return energiaPorCiclo;
    }
}
