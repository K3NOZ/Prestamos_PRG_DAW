package Practica31Prestamos;

import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String email;
    private String numeroSocio;
    private LocalDate fechaRegistro;
    private boolean sancionado;
    private LocalDate fechaFinSancion;
    public Usuario (String nombre, String email, String numeroSocio, LocalDate fechaRegistro, boolean sancionado, LocalDate fechaFinSancion)throws UsuarioInvalidoException {
        this.nombre = nombre;

        if (email.matches(".@.+\\..+")) this.email = email;
        else {
            throw new UsuarioInvalidoException("Tienes que poner el '@' y el '.' para que pueda funcionar");
        }

        if (numeroSocio.matches("SOC[0-9]{5}")) this.numeroSocio = numeroSocio;
        else if throw new UsuarioInvalidoException("Es necesario empezar con SOC seguído de 5 dígitos");

        this.fechaRegistro = fechaRegistro;

        this.sancionado = sancionado;

        if (sancionado == true )this.fechaFinSancion = fechaFinSancion;
        else if (sancionado == false)this.fechaFinSancion = null;
    }
    public Usuario (String nombre, String email, String numeroSocios, LocalDate fechaRegistro)throws UsuarioInvalidoException{
        this.nombre = nombre;

        if (email.matches(".@.+\\..+")) this.email = email;
        else {
            throw new UsuarioInvalidoException("Tienes que poner el '@' y el '.' para que pueda funcionar");
        }

        if (numeroSocio.matches("SOC[0-9]{5}")) this.numeroSocio = numeroSocio;
        else if throw new UsuarioInvalidoException("Es necesario empezar con SOC seguído de 5 dígitos");

        this.fechaRegistro = fechaRegistro;

        this.sancionado = false;

        this.fechaFinSancion = null;
    }
public void sancionar(int dias, LocalDate fechaRegistro) {
    LocalDate fechaFinSancion = fechaRegistro.plusDays(dias);
    this.sancionado = true;
    this.fechaFinSancion = fechaFinSancion;
}
public void levantarSancion() {
    this.sancionado = false;
    this.fechaFinSancion = null;
}
public boolean estaSancionado() {
    return this.sancionado;
}
public String toString() {
    return "Usuario{" +
            ", nombre= " + nombre + '\'' +
            ", email= " + email + '\'' +
            ", numeroSocio= " + numeroSocio + '\'' +
            ", fechaRegistro= " + fechaRegistro +
            ", sancionado= " + sancionado +
            ", fechaFinSancion= " + fechaFinSancion +
'}'



}



}