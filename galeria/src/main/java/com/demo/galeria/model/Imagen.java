package com.demo.galeria.model;


import jakarta.persistence.*;


@Entity
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreArchivo;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    // Constructor, getters y setters

    public Imagen() {}

    public Imagen(String nombreArchivo, Album album) {
        this.nombreArchivo = nombreArchivo;
        this.album = album;
    }

    // Getters y Setters, toString()

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
