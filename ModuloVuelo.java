public class ModuloVuelo extends Modulo {
    private int datosPorCiclo;

    public ModuloVuelo(int id, String nombre, int salud, int costo, RecursosMision recursos, int datosPorCiclo) {
        super(id, nombre, salud, costo, recursos);

        if (datosPorCiclo < 0) {
            throw new IllegalArgumentException("Los datos por ciclo no pueden ser negativos.");
        }
        this.datosPorCiclo = datosPorCiclo;
    }

    @Override
    public void procesarCiclo() {
        if (estaOperativo()) {
            getRecursos().agregarDatos(datosPorCiclo);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Datos por ciclo: " + datosPorCiclo;
    }

    public int getDatosPorCIclo() {
        return datosPorCiclo;
    }
}
