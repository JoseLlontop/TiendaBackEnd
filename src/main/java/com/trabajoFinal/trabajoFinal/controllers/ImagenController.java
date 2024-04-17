package com.trabajoFinal.trabajoFinal.controllers;

import com.trabajoFinal.trabajoFinal.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ImagenController {

    /*

    @Autowired
    private S3Service s3Service;

    //Endpoint para subir la imagen
    @PostMapping("/api/imagen/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        s3Service.uploadFile(file);
        return "Image uploaded successfully!";
    }

    //Endpoint para visualizar la imagen
    @GetMapping("/api/images/{imageName}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String imageName) {
        InputStream imageStream = s3Service.getImage(imageName);
        if (imageStream != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Cambiar según el tipo de imagen
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + imageName)
                    .body(new InputStreamResource(imageStream));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     */
}
