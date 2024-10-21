package com.demo.galeria;


import com.demo.galeria.model.Album;
import com.demo.galeria.model.Imagen;
import com.demo.galeria.model.Usuario;
import com.demo.galeria.repository.AlbumRepository;
import com.demo.galeria.repository.ImagenRepository;
import com.demo.galeria.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UsuarioRepository usuarioRepository,
                                  AlbumRepository albumRepository,
                                  ImagenRepository imagenRepository) {
        return (args) -> {
            Usuario usuario = new Usuario("Juan Pérez", "juan@example.com", "password123");
            usuarioRepository.save(usuario);
            log.info("Usuario guardado: " + usuario);

            Album album = new Album("Vacaciones en la Playa", usuario);
            albumRepository.save(album);
            log.info("Álbum guardado: " + album);

            Imagen imagen1 = new Imagen("playa.jpg", album);
            Imagen imagen2 = new Imagen("atardecer.jpg", album);
            imagenRepository.save(imagen1);
            imagenRepository.save(imagen2);
            log.info("Imágenes guardadas: " + imagen1 + ", " + imagen2);

            log.info("Usuarios encontrados con findAll():");
            for (Usuario u : usuarioRepository.findAll()) {
                log.info(u.toString());
            }

            // 5. Consultar un usuario por ID
            Usuario foundUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
            log.info("Usuario encontrado con findById(" + usuario.getId() + "): " + foundUsuario);

            // 6. Consultar todos los álbumes
            log.info("Álbumes encontrados con findAll():");
            for (Album a : albumRepository.findAll()) {
                log.info(a.toString());
            }

            // 7. Consultar todos los álbumes de un usuario
            log.info("Álbumes encontrados para el usuario " + usuario.getNombre() + ":");
            for (Album a : albumRepository.findByUsuario(usuario)) {
                log.info(a.toString());
            }

            // 8. Consultar todas las imágenes de un álbum
            log.info("Imágenes encontradas para el álbum " + album.getNombre() + ":");
            for (Imagen i : imagenRepository.findByAlbum(album)) {
                log.info(i.toString());
            }
        };
    }
}

