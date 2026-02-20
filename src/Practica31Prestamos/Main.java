package Practica31Prestamos;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);
        GestorBiblioteca gestor = new GestorBiblioteca();
        boolean salir = false;
        int opcion=0;
        while(!salir) {
            System.out.println("\nMENÚ BIBLIOTECA");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Registrar préstamo de libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Consultar estado de usuario");
            System.out.println("5. Mostrar préstamos activos");
            System.out.println("6. Mostrar usuarios sancionados");
            System.out.println("7. Actualizar sanciones");
            System.out.println("8. Salir");
            System.out.println("Elige una opción: ");


            try {
                opcion = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Debes introducir un número válido ");
                continue;
            }
            switch (opcion) {

                case 1:
                    try {
                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.println("Email: ");
                        String email = sc.nextLine();

                        System.out.println("Número de socio: ");
                        String numero = sc.nextLine();

                        LocalDate fecha = LocalDate.now();


                        Usuario u = new Usuario(nombre, email, numero, fecha);
                        gestor.registrarUsuario(u);

                        System.out.println("Usuario registrado correctamente: ");
                    } catch (Exception e) {
                        System.out.println("Error: "e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Número de socio: ");
                        String numSocio = sc.nextLine();

                        Usuario u = gestor.buscarUsuario(numSocio);
                        if (u == null) {
                            System.out.println("Usuario no encontrado. ");
                            break;
                        }
                        System.out.println("Código del libro: ");
                        String codigo = sc.nextLine().toUpperCase();

                        if (!codigo.matches("[A-Z{3}[0-9]{4}]")) {
                            System.out.println("Código inválido. Debe ser 3 letras y 4 números. ");
                            break;
                        }
                        System.out.println("Título del libro: ");
                        String titulo = sc.nextLine();

                        if (titulo.isBlank()) {
                            System.out.println("El título no puede estar vacío. ");
                            break;
                        }
                        LocalDate fecha = LocalDate.now();

                        Prestamo p = gestor.registrarPrestamo(codigo, titulo, fecha, u);
                        System.out.println("Préstamo registrado: " + p);

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Código del libro: ");
                        String codigo = sc.nextLine().toUpperCase();
                        LocalDate fecha = LocalDate.now();

                        boolean devuelto = gestor.devolverLibro(codigo, fecha);
                        if (devuelto) {
                            System.out.println("Libro devuelto correctamente. ");
                        } else {
                            System.out.println("No se pudo devolver el libro. ");
                        }
                    }catch(Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Número de socio: ");
                    String num=sc.nextLine();
                    Usuario u=gestor.buscarUsuario(num);
                    if(u !=null) {
                        System.out.println(u);
                    }else {
                        System.out.println("Usuario no encontrado. ");
                    }
                    break;

                case 5:
                    System.out.println("nPréstamos Activos: ");
                    Prestamo[]prestamos=gestor.getPrestamos();
                    boolean hayActivos=false;
                    for (int i=0; i<prestamos.length;i++) {
                        if (prestamos[i] != null && prestamos[i].fechaDevolucionReal == null) {
                            System.out.println(prestamos[i]);
                            hayActivos = true;
                        }
                    }
                    if(!hayActivos) System.out.println("No hay préstamos activos. ");
                    break;

                case 6:
                    System.out.println("\nUsuarios Sancionados: ");
                    Usuario[]usuarios= gestor.getUsuario();
                    boolean haySancionados=false;
                    for(int i=0; i< usuarios.length;i++) {
                        if (usuarios[i] != null && usuarios[i].estaSancionado()) {
                            System.out.println(usuarios[i]);
                            haySancionados = true;
                        }
                    }
                    if(!haySancionados) System.out.println("No hay Sancionados");
                    break;

                        }
            }
        }
}

