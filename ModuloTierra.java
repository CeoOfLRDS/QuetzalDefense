public class ModuloTierra extends Modulo {
    private int capacidadDescarga;
    private int consumoEnergia;

    public ModuloTierra(int id, String nombre, int salud, int costo, RecursosMision recursos,
                        int capacidadDescarga, int consumoEnergia) {
        super(id, nombre, salud, costo, recursos);

        if (capacidadDescarga < 0 || consumoEnergia < 0) {
            throw new IllegalArgumentException("Los valores no pueden ser negativos.");
        }
        this.capacidadDescarga = capacidadDescarga;
        this.consumoEnergia = consumoEnergia;
    }

    @Override
    public void procesarCiclo() {
        if (estaOperativo()) {
            getRecursos().descargarDatos(capacidadDescarga, consumoEnergia);
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Capacidad descarga: " + capacidadDescarga
                + ", Consumo energía: " + consumoEnergia;
    }

    public int getCapacidadDescarga() {
        return capacidadDescarga;
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }
}
