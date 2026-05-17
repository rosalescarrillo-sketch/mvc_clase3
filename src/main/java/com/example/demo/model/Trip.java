package com.example.demo.model;

public class Trip {

    private int id;
    private String destination;
    private double price;
    private int duration;
    private boolean destacado;
    private int calificacion;
    private String fotoUrl;
    private String descripcion;
    private String fechaPublicacion;
    private String tipo; // LOCAL o INTERNACIONAL

    // ✅ NUEVO: relación con categoría
    private CategoriaTrip categoria;

    public Trip() {}

    // Constructor completo (el que usaremos)
    public Trip(String destination, double price, int duration, boolean destacado, int calificacion,
                String fotoUrl, String descripcion, String fechaPublicacion, String tipo) {
        this.destination = destination;
        this.price = price;
        this.duration = duration;
        this.destacado = destacado;
        this.calificacion = calificacion;
        this.fotoUrl = fotoUrl;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.tipo = tipo;
    }

    // Getters / Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public boolean isDestacado() { return destacado; }
    public void setDestacado(boolean destacado) { this.destacado = destacado; }

    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(String fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    // ✅ NUEVO Getter/Setter
    public CategoriaTrip getCategoria() { return categoria; }
    public void setCategoria(CategoriaTrip categoria) { this.categoria = categoria; }
}