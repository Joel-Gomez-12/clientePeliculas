package es.uah.clientepeliculas.controller;


import es.uah.clientepeliculas.model.Pelicula;
import es.uah.clientepeliculas.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/web/peliculas")
public class PeliculasController {

    @Autowired
    IPeliculasService peliculasService;

    @Value("${upload.dir}")
    private String uploadDir;

    // Listar todas las películas
    @GetMapping
    public String listarPeliculas(Model model) {
        List<Pelicula> peliculas = peliculasService.obtenerPeliculas();
        model.addAttribute("peliculas", peliculas);
        return "peliculas/lista";
    }

    // Mostrar formulario para crear una nueva película
    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula,
                                  @RequestParam("imagen") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            try {
                // Crear la ruta del archivo en el directorio de recursos estáticos
                String filePath = new File("src/main/resources/" + uploadDir + imagen.getOriginalFilename()).getAbsolutePath();
                File destFile = new File(filePath);

                // Crear directorios si no existen
                destFile.getParentFile().mkdirs();

                // Guardar la imagen en el directorio configurado
                imagen.transferTo(destFile);

                // Establecer la ruta de la imagen en la película (accesible en la web)
                pelicula.setImagenPortada("/uploads/" + imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                // Manejo de errores
                return "redirect:/web/peliculas/crear?error=upload";
            }
        }

        peliculasService.guardarPelicula(pelicula);
        return "redirect:/web/peliculas";

    }

    // Editar una película
    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Integer id, Model model) {
        Pelicula pelicula = peliculasService.obtenerPeliculaPorId(id);
        model.addAttribute("pelicula", pelicula);
        return "peliculas/formulario";
    }

    // Eliminar una película
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Integer id) {
        peliculasService.eliminarPelicula(id);
        return "redirect:/web/peliculas";
    }


}


