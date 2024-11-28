package com.proyectos.proyectosapi.controller;


import com.proyectos.proyectosapi.model.Proyecto;
import com.proyectos.proyectosapi.repository.ProyectoRepository;
import com.proyectos.proyectosapi.service.service.FileUploadUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoRepository proyectoRepository;

    @GetMapping
    public ResponseEntity<?> getAllProyectos() {
        List<Proyecto> proyectos = proyectoRepository.findAll();
        if (proyectos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(proyectos);
        }
    }
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<?> getProyectoByTipo(@PathVariable String tipo) {
        List<Proyecto> proyectos = proyectoRepository.findByTipo(tipo);
        if (proyectos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(proyectos);
        }
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getProyectoByNombre(@PathVariable String nombre) {
        Proyecto proyecto = proyectoRepository.findByNombre(nombre);
        if (proyecto != null) {
            return ResponseEntity.ok(proyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/idproyecto/{idProyecto}")
    public ResponseEntity<?> getProyectoById(@PathVariable int idProyecto) {
        Proyecto proyecto = proyectoRepository.findById(idProyecto);
        if (proyecto != null) {
            return ResponseEntity.ok(proyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<?> createProyecto(@RequestBody Proyecto proyecto) {
        if (proyectoRepository.save(proyecto) == 1)
            return ResponseEntity.status(HttpStatus.CREATED).body(proyecto);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo insertar el proyecto");
    }

    @PutMapping("{proyecto}")
    public ResponseEntity<Proyecto> updateProyecto(@RequestBody Proyecto proyecto){
        Proyecto existingProyecto=proyectoRepository.findById(proyecto.getIdProyecto());
        if(existingProyecto!=null){
            proyectoRepository.update(proyecto);
            return ResponseEntity.ok(proyecto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{idProyecto}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable int idProyecto){
        Proyecto existingProyecto=proyectoRepository.findById(idProyecto);
        if(existingProyecto!=null){
            proyectoRepository.delete(existingProyecto);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/ficheros")
    public ResponseEntity<String> saveProyecto(@RequestParam("idProyecto") int id,
                                               @RequestParam("fichero") MultipartFile multipartFile) {
        // Verificación de que el archivo no está vacío
        if (multipartFile.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha seleccionado un archivo.");
        }

        // Limpia el nombre del archivo
        String nombreArchivo = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        // Directorio donde se almacenará el archivo
        String uploadDir = "proyectos/archivos/";

        // Crear el directorio si no existe
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Obtener la extensión del archivo
        String extension = FilenameUtils.getExtension(nombreArchivo).toLowerCase();

        // Validar si el archivo es una imagen o un PDF
        boolean esImagen = extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png");
        boolean esPDF = extension.equals("pdf");
        boolean esZip = extension.equals("zip") || extension.equals("rar") || extension.equals("gz") || extension.equals("bz2") || extension.equals("bz") || extension.equals("7z");

        if (!esImagen && !esPDF && !esZip ) {
            return ResponseEntity.badRequest().body("El archivo debe ser una imagen JPG, JPEG, PNG, un PDF o un extraible.");
        }

        // Buscar el proyecto por ID
        Proyecto proyecto = proyectoRepository.findById(id);

        if (proyecto == null) {
            return ResponseEntity.badRequest().body("El proyecto no existe.");
        }

        try {
            // Guardar el archivo usando un método utilitario (asegúrate de que esta clase esté implementada)
            FileUploadUtil.guardarFichero(uploadDir, nombreArchivo, multipartFile);

            // Actualizar el proyecto según el tipo de archivo
            if (esImagen) {
                proyecto.setLogo(nombreArchivo);
            } else if (esPDF) {
                    proyecto.setMemoria(nombreArchivo);
            } else if (esZip) {
                proyecto.setArchivos(nombreArchivo);
            }

            // Guardar los cambios en la base de datos
            proyectoRepository.update(proyecto);

            return ResponseEntity.ok("Archivo subido correctamente para el proyecto " + proyecto.getNombre() + " con ID " + id);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al subir el archivo: " + e.getMessage());
        }
    }

    @GetMapping("/ficheros")
    public ResponseEntity<Resource> getArchivoProyecto(@RequestParam("idProyecto") int id,
                                                       @RequestParam(value = "tipo", required = false) String tipo) {
        // Buscar el proyecto por ID
        Proyecto proyecto = proyectoRepository.findById(id);

        if (proyecto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Determinar qué archivo se quiere obtener
        String nombreArchivo = null;
        if ("logo".equalsIgnoreCase(tipo)) {
            nombreArchivo = proyecto.getLogo();
        } else if ("memoria".equalsIgnoreCase(tipo)) {
            nombreArchivo = proyecto.getMemoria();
        } else if ("archivos".equalsIgnoreCase(tipo)) {
            nombreArchivo = proyecto.getArchivos();
        } else {
            return ResponseEntity.badRequest().body(null);
        }

        if (nombreArchivo == null || nombreArchivo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try {
            // Ruta al archivo almacenado
            Path filePath = Paths.get("proyectos/archivos/").resolve(nombreArchivo);
            Resource resource = new UrlResource(filePath.toUri());

            // Verificar si el archivo existe y es legible
            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            // Configurar los headers para mostrar el logo en el navegador (solo para el logo)
            if ("logo".equalsIgnoreCase(tipo)) {
                String mimeType = Files.probeContentType(filePath);
                if (mimeType == null) {
                    mimeType = "image/jpeg";
                }
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .contentType(MediaType.parseMediaType(mimeType))
                        .body(resource);
            }

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
