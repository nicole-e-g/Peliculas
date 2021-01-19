package com.example.proyecto;

public class Peliculas {
    private String id;
    private String img;
    private String nombre;
    private String genero;
    private String descripcion;
    private String director;
    private String duracion;

    public Peliculas(String id,String img,String nombre, String genero, String descripcion, String director, String duracion) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
        this.genero = genero;
        this.descripcion = descripcion;
        this.director = director;
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() { return img; }

    public void setImg(String img) { this.img = img; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
