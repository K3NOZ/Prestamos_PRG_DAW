package Practica31Prestamos;

import java.time.LocalDate;

public class Prestamo {
    private String codigoLibro;
    private String tituloLibro;
    private Usuario socio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionPrevista;
    private LocalDate fechaDevolucionReal = null;

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
            throw new PrestamoInvalidoException("la fecha es posterior a la actual");
        }

        else {
            this.fechaPrestamo = fechaPrestamo;
            this.fechaDevolucionPrevista = fechaPrestamo.plusDays(14);
        }


        }

    }


}
