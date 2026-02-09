package Practica31Prestamos;

public class LibroNoDisponibleException extends Exception{
    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
