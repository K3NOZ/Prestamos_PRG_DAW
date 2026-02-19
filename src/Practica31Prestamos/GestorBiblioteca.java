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
    public void registrarPrestamo(String codigoLibro, String titulo, LocalDate fechaPrestamo, Usuario usuario)throws PrestamoInvalidoException, UsuarioSancionadoException, LibroNoDisponibleException{
        if (usuario.estaSancionado()) {
            throw new UsuarioSancionadoException("El usuario está sancionado");
        }
        for (int i = 0; i < numeroPrestamos; i++) {
            if (prestamos[i].codigoLibro.equals(codigoLibro) && prestamos[i].estaRetrasado()) {
                throw new LibroNoDisponibleException("El libro ya está prestado");
            }
            }
        }
    }




