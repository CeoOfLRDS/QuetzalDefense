public abstract class Modulo implements Comparable<Modulo> {
    private int id;
    private String nombre;
    private int salud;
    private int costoConstruccion;
    private RecursosMision recursos;

    public Modulo(int id, String nombre, int salud, int costoConstruccion, RecursosMision recursos) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo.");
        }
        if (nombre == null || nombre.length() == 0) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (salud < 0 || salud > 100) {
            throw new IllegalArgumentException("La salud debe estar entre 0 y 100.");
        }
        if (costoConstruccion < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo.");
        }
        if (recursos == null) {
            throw new IllegalArgumentException("Los recursos no pueden ser nulos.");
        }

        this.id = id;
        this.nombre = nombre;
        this.salud = salud;
        this.costoConstruccion = costoConstruccion;
        this.recursos = recursos;
    }

    public boolean estaOperativo() {
        return salud > 0;
    }

    public abstract void procesarCiclo();

    @Override
    public int compareTo(Modulo otro) {
        if (costoConstruccion < otro.costoConstruccion) {
            return -1;
        }
        if (costoConstruccion > otro.costoConstruccion) {
            return 1;
        }
        if (id < otro.id) {
            return -1;
        }
        if (id > otro.id) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Tipo: " + getClass().getSimpleName()
                + ", ID: " + id
                + ", Nombre: " + nombre
                + ", Salud: " + salud
                + ", Costo: " + costoConstruccion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getCostoConstruccion() {
        return costoConstruccion;
    }

    public RecursosMision getRecursos() {
        return recursos;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() == 0) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        if (salud < 0 || salud > 100) {
            throw new IllegalArgumentException("La salud debe estar entre 0 y 100.");
        }
        this.salud = salud;
    }
}
