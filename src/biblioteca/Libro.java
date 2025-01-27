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
        this.secuela = null;
        this.precuela = null;
    }

    public String obtenerInformacion() {
        return "El libro " + this.titulo + " de " + this.autor + " ha vendido " + this.ejemplaresVendidos + " ejemplares.";
    }

    public void registrarVenta(int cantidad) {
        this.ejemplaresVendidos += cantidad;
    }

    public void obtenerTituloPrecuela() {
        String tituloPrecuela = (this.precuela == null) ? "<NINGUNA>" : this.precuela.titulo;
        System.out.println("* La precuela de " + this.titulo + " es: " + tituloPrecuela);
    }

    public void obtenerTituloSecuela() {
        String tituloSecuela = (this.secuela == null) ? "<NINGUNA>" : this.secuela.titulo;
        System.out.println("* La secuela de " + this.titulo + " es: " + tituloSecuela);
    }

    public void mostrarResumenSaga() {
        int totalVentas = 0;
        int numeroLibro = 0;
        int posicionLibroActual = 0;
        Libro libroActual = this;

        // Encontrar el primer libro de la saga
        libroActual = obtenerPrimerLibro(libroActual);

        System.out.println("*** SAGA DE LIBROS ***");
        // Sumatorio de ejemplares vendidos y posicion del libro actual
        while (libroActual != null) {
            totalVentas += libroActual.ejemplaresVendidos;
            numeroLibro++;
            if (libroActual == this) {
                posicionLibroActual = numeroLibro;
            }
            libroActual = libroActual.secuela;
        }

        System.out.println("* El libro " + this.titulo + " es el libro número " + posicionLibroActual + " de una saga con un total de " + numeroLibro + " libros. Entre todos han vendido un total de " + totalVentas + " ejemplares.");
    }

    public void agregarSecuela(Libro secuela) {
        this.secuela = secuela;
        secuela.precuela = this;
    }

    public Libro[] obtenerSaga() {
        int totalLibros = 1;
        Libro libroActual = this;

        // Recorrer la lista hasta el inicio para el sumatorio total de libros
        while (libroActual.precuela != null) {
            libroActual = libroActual.precuela;
            totalLibros++;
        }
        // Recorrer la lista desde el actual hasta el final para el sumatorio total de libros
        libroActual = this;
        while (libroActual.secuela != null) {
            libroActual = libroActual.secuela;
            totalLibros++;
        }

        Libro[] saga = new Libro[totalLibros];

        libroActual = this;
        int index = 0;

        // Volvemos a buscar el primer libro de la lista
        libroActual = obtenerPrimerLibro(libroActual);
        // Recorremos la lista hasta el final, añadiendo cada elemento al array saga
        while (libroActual != null) {
            saga[index++] = libroActual;
            libroActual = libroActual.secuela;
        }

        return saga;
    }

    private Libro obtenerPrimerLibro(Libro libroActual) {
        while (libroActual.precuela != null) {
            libroActual = libroActual.precuela;
        }
        return libroActual;
    }
}
