package com.demo.galeria.repository;


import com.demo.galeria.model.Album;
import com.demo.galeria.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {


    List<Album> findByUsuario(Usuario usuario);


    List<Album> findByNombre(String nombre);
}
