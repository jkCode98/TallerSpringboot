package com.demo.galeria.repository;




import com.demo.galeria.model.Album;
import com.demo.galeria.model.Imagen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImagenRepository extends CrudRepository<Imagen, Long> {

    // Buscar imágenes por álbum
    List<Imagen> findByAlbum(Album album);

    // Buscar imágenes por nombre de archivo
    List<Imagen> findByNombreArchivo(String nombreArchivo);
}