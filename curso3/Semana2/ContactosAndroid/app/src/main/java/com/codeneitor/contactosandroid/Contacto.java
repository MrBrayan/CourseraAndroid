package com.codeneitor.contactosandroid;

/**
 * Created by b41n on 17/12/18.
 */

public class Contacto {
    private String nombre;
    private String fechaN;
    private String telefono;
    private String email;
    private String descripcion;

    public Contacto(String nombre, String fechaN, String telefono, String email, String descripcion) {
        this.nombre = nombre;
        this.fechaN = fechaN;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
