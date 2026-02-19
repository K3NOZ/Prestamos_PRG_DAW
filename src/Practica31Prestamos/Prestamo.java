package Practica31Prestamos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    String codigoLibro;
    private String tituloLibro;
    private Usuario socio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionPrevista;
    LocalDate fechaDevolucionReal = null;

    public Prestamo(String codigoLibro, String tituloLibro, Usuario socio, LocalDate fechaPrestamo, LocalDate fechaDevolucionPrevista, LocalDate fechaDevolucionReal)throws PrestamoInvalidoException{
        if (codigoLibro.matches("[A-Z]{3}" + "[0-9]{4}")) this.codigoLibro = codigoLibro;
        else {
            throw new PrestamoInvalidoException("Este código no es de un libro ");
        }

        this.tituloLibro=tituloLibro;

        this.socio=socio;

        this.fechaPrestamo=fechaPrestamo;

        this.fechaDevolucionPrevista=fechaDevolucionPrevista;

        this.fechaDevolucionReal=fechaDevolucionReal;
    }
    public Prestamo(String codigoLibro, String tituloLibro, Usuario socio, LocalDate fechaPrestamo)throws PrestamoInvalidoException {
        if (codigoLibro.matches("[A-Z]{3}" + "[0-9]{4}")) this.codigoLibro = codigoLibro;
        else {
            throw new PrestamoInvalidoException("Este código no es de un libro ");
        }

        if(tituloLibro ==null || tituloLibro.isBlank()) {
            throw new PrestamoInvalidoException(("El título está vació"));
        }

        else{
            this.tituloLibro = tituloLibro;
        }

        this.socio=socio;

        if(fechaPrestamo == null) {
            throw new PrestamoInvalidoException("La fecha es nula");
        }
        if (fechaPrestamo.isAfter(LocalDate.now())) {
            throw new PrestamoInvalidoException("La fecha es posterior a la actual");
        }

        else {
            this.fechaPrestamo = fechaPrestamo;
            this.fechaDevolucionPrevista = fechaPrestamo.plusDays(14);
        }
        }
    public void registrarDevolucion(LocalDate fechaDevolucion) throws PrestamoInvalidoException {
        if (fechaDevolucion == null || fechaDevolucion.isBefore(LocalDate.now()));
        throw new PrestamoInvalidoException("La fecha es nula o anterior a la fecha del préstamo");
    }
    public int calcularDiasRetraso() {
        long dias = 0;

        if (fechaDevolucionReal != null) {
            dias = ChronoUnit.DAYS.between(fechaDevolucionPrevista, fechaDevolucionReal);
        } else {
            dias = ChronoUnit.DAYS.between((fechaPrestamo , LocalDate.now());
        }

        if (dias < 0) {
            return 0;
        } else {
            return (int) dias;
        }
    }

    public boolean estaRetrasado() {
        if (LocalDate.now().isAfter(fechaDevolucionPrevista)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Título: " + this.tituloLibro +
                "\nUsuario: " + this.socio +
                "\nFecha préstamo: " + this.tituloLibro +
                "\nFecha devolución prevista: " + this.fechaDevolucionPrevista +
                "\nFecha devolución real: " + this.fechaDevolucionReal;
    }
public String getfechaPrestamo() {
    return this.fechaPrestamo;
}
    }






