package com.demo.galeria.repository;


import com.demo.galeria.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    // Buscar usuarios por nombre
    List<Usuario> findByNombre(String nombre);

    // Buscar usuarios por email
    Usuario findByEmail(String email);
}
