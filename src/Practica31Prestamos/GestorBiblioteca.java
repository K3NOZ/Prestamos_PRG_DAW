package Practica31Prestamos;

import java.time.LocalDate;

public class GestorBiblioteca {
    private static final int MAX_USUARIOS = 50;
    private static final int MAX_PRESTAMOS = 200;

    private Usuario[] usuarios;
    private Prestamo[] prestamos;

    private int numeroUsuarios;
    private int numeroPrestamos;

    public GestorBiblioteca() {
        usuarios = new Usuario[MAX_USUARIOS];
        prestamos = new Prestamo[MAX_PRESTAMOS];
        numeroUsuarios = 0;
        numeroPrestamos = 0;
    }

    public void registrarUsuario(Usuario usuario) throws UsuarioRepetidoException {

        for (int i = 0; i < numeroUsuarios; i++) {
            if (usuarios[i].equals(usuario)) {
                throw new UsuarioRepetidoException("Usuario ya registrado");
            }
        }
        usuarios[numeroUsuarios] = usuario;
        numeroUsuarios++;
    }

    public Prestamo registrarPrestamo(String codigoLibro, String titulo, LocalDate fechaPrestamo, Usuario usuario) throws PrestamoInvalidoException, UsuarioSancionadoException, LibroNoDisponibleException {
        if (usuario.estaSancionado()) {
            throw new UsuarioSancionadoException("El usuario está sancionado");
        }
        for (int i = 0; i < numeroPrestamos; i++) {
            if (prestamos[i].codigoLibro.equals(codigoLibro) && prestamos[i].fechaDevolucionReal == null) {
                throw new LibroNoDisponibleException("El libro ya está prestado");
            }
            Prestamo nuevoPrestamo = new Prestamo(codigoLibro, titulo, usuario, fechaPrestamo);

            prestamos[numeroPrestamos] = nuevoPrestamo;
            numeroPrestamos++;

            return nuevoPrestamo;
        }

        if (codigoLibro == null || !codigoLibro.matches("[A-Z]{3}[0-9]{4}")) {
            throw new PrestamoInvalidoException("Código del libro inválido");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new PrestamoInvalidoException("Título del libro vacío");
        }

        if (fechaPrestamo == null || fechaPrestamo.isAfter((LocalDate.now()))) {
            throw new PrestamoInvalidoException("Fecha del préstamo inválida");
        }

        return null;
    }

    public boolean devolverLibro(String codigoLibro, LocalDate fechaDevolucion)throws PrestamoInvalidoException {
        for (int i =0; i < numeroPrestamos; i++) {
            Prestamo p = prestamos[i];

            if(p.codigoLibro.equals(codigoLibro) && p.fechaDevolucionReal == null) {

                if (fechaDevolucion.isBefore((p.getfechaPrestamo()) {
                    throw new PrestamoInvalidoException(("La fecha de devolución es anterior a la fecha de préstamos");
                }
                p.fechaDevolucionReal = fechaDevolucion;

                return true;
            }
        }
        return false;
    }

}




