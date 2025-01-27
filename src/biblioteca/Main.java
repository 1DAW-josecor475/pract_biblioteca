package biblioteca;

public class Main {
    public static void main(String[] args) {
        // CASO 1: Creacion primer libro, registro de ventas y obtener informacion
        System.out.println("*****PRIMER CASO*****");
        Libro libro1 = new Libro("Robert Jordan", "El Ojo del Mundo");
        System.out.println(libro1.obtenerInformacion());
        libro1.registrarVenta(123);
        System.out.println(libro1.obtenerInformacion());
        System.out.println();

        // CASO 2: Obtencion del titulo de la precuela y la secuela
        System.out.println("*****SEGUNDO CASO*****");
        libro1.obtenerTituloPrecuela();
        libro1.obtenerTituloSecuela();
        System.out.println();

        // CASO 3: Mostrar resumen de la saga
        System.out.println("*****TERCER CASO*****");
        libro1.mostrarResumenSaga();
        System.out.println();

        // CASO 4: Crear segundo libro, agregar secuela y mostrar resumen
        System.out.println("*****CUARTO CASO*****");
        Libro libro2 = new Libro("Robert Jordan", "La Gran Caceria");
        libro2.registrarVenta(517);
        System.out.println(libro2.obtenerInformacion());
        libro1.mostrarResumenSaga();
        System.out.println();

        libro1.agregarSecuela(libro2);
        libro2.mostrarResumenSaga();
        System.out.println();

        // CASO 5: Obtener array con los libros de la saga y mostrar informacion
        System.out.println("*****QUINTO CASO*****");
        Libro[] saga = libro2.obtenerSaga();

        for (int i = 0; i < saga.length; i++) {
            System.out.println("* El libro " + (i + 1) + " de la saga es: " + saga[i].obtenerInformacion());
        }
        System.out.println();

        // CASO 6: Añadir secuela al segundo libro y recuperar la saga
        System.out.println("*****SEXTO CASO*****");
        Libro libro3 = new Libro("Robert Jordan", "El Dragon Renacido");
        libro3.registrarVenta(360);
        System.out.println(libro3.obtenerInformacion());

        saga = libro3.obtenerSaga();
        for (int i = 0; i < saga.length; i++) {
            System.out.println("* El libro " + (i + 1) + " de la saga es: " + saga[i].obtenerInformacion());
        }
        System.out.println();
        libro2.agregarSecuela(libro3);
        saga = libro1.obtenerSaga();
        for (int i = 0; i < saga.length; i++) {
            System.out.println("* El libro " + (i + 1) + " de la saga es: " + saga[i].obtenerInformacion());
        }
    }
}
