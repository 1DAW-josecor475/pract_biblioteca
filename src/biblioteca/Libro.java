package biblioteca;

 public class Libro {
    private String autor;
    private String titulo;
    private int ejemplaresVendidos;
    private Libro secuela;
    private Libro precuela;

    public Libro(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
        this.ejemplaresVendidos = 0;
    }

    public String obtenerInformacion() {
        return String.format("El libro '%s' de %s ha vendido %d ejemplares.", titulo, autor, ejemplaresVendidos);
    }

    public void registrarVenta(int cantidad) {
        if (cantidad > 0) {
            this.ejemplaresVendidos += cantidad;
        }
    }

    public void obtenerTituloPrecuela() {
        System.out.println("* La precuela de '" + titulo + "' es: " + 
            (precuela != null ? precuela.titulo : "<NINGUNA>"));
    }

    public void obtenerTituloSecuela() {
        System.out.println("* La secuela de '" + titulo + "' es: " + 
            (secuela != null ? secuela.titulo : "<NINGUNA>"));
    }

    public void mostrarResumenSaga() {
        Libro primerLibro = obtenerPrimerLibro();
        int totalVentas = 0;
        int posicion = 0;
        int numeroLibro = 1;

        System.out.println("*** SAGA DE LIBROS ***");
        for (Libro actual = primerLibro; actual != null; actual = actual.secuela, numeroLibro++) {
            totalVentas += actual.ejemplaresVendidos;
            if (actual == this) {
                posicion = numeroLibro;
            }
        }

        System.out.printf("* El libro '%s' es el libro número %d de una saga con un total de %d libros. Entre todos han vendido un total de %d ejemplares.%n",
                titulo, posicion, numeroLibro - 1, totalVentas);
    }

    public void agregarSecuela(Libro secuela) {
        if (secuela != null) {
            this.secuela = secuela;
            secuela.precuela = this;
        }
    }

    public Libro[] obtenerSaga() {
        Libro primerLibro = obtenerPrimerLibro();
        int totalLibros = contarLibrosSaga(primerLibro);

        Libro[] saga = new Libro[totalLibros];
        int index = 0;

        for (Libro actual = primerLibro; actual != null; actual = actual.secuela) {
            saga[index++] = actual;
        }

        return saga;
    }

    private Libro obtenerPrimerLibro() {
        Libro actual = this;
        while (actual.precuela != null) {
            actual = actual.precuela;
        }
        return actual;
    }

    private int contarLibrosSaga(Libro primerLibro) {
        int contador = 0;
        for (Libro actual = primerLibro; actual != null; actual = actual.secuela) {
            contador++;
        }
        return contador;
    }
}
