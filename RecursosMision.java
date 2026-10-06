public class RecursosMision {
    private int energiaDisponible;
    private int datosPendientes;
    private int datosDescargados;

    public RecursosMision(int energiaInicial, int datosIniciales, int descargadosIniciales) {
        if (energiaInicial < 0 || datosIniciales < 0 || descargadosIniciales < 0) {
            throw new IllegalArgumentException("Los recursos no pueden ser negativos.");
        }

        energiaDisponible = energiaInicial;
        datosPendientes = datosIniciales;
        datosDescargados = descargadosIniciales;
    }

    public void agregarEnergia(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        energiaDisponible += cantidad;
    }

    public void agregarDatos(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        datosPendientes += cantidad;
    }

    public int descargarDatos(int capacidad, int consumo) {
        if (capacidad < 0 || consumo < 0) {
            throw new IllegalArgumentException("Los valores no pueden ser negativos.");
        }

        if (datosPendientes == 0 || energiaDisponible < consumo) {
            return 0;
        }

        int cantidad = capacidad;
        if (datosPendientes < capacidad) {
            cantidad = datosPendientes;
        }

        datosPendientes -= cantidad;
        datosDescargados += cantidad;
        energiaDisponible -= consumo;

        return cantidad;
    }

    public int getEnergiaDisponible() {
        return energiaDisponible;
    }

    public int getDatosPendientes() {
        return datosPendientes;
    }

    public int getDatosDescargados() {
        return datosDescargados;
    }
}
