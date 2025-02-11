package com.example.trabajounidad5listamultimedia;

public class Multimedia {
    public enum Tipo{VIDEO, AUDIO, WEB}

    private String titulo;
    private String url;
    private Tipo tipo;
    private String descripcion;
    private int imagen;

    public Multimedia(String titulo, String url, Tipo tipo, String descripcion, int imagen) {
        this.titulo = titulo;
        this.url = url;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titulo='" + titulo + '\'' +
                ", url='" + url + '\'' +
                ", tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
