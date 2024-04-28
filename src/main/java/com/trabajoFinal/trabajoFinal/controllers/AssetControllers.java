package com.trabajoFinal.trabajoFinal.controllers;

import com.trabajoFinal.trabajoFinal.models.virtualModel.Asset;
import com.trabajoFinal.trabajoFinal.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AssetControllers {

    @Autowired
    private S3Service s3service;

    //EndPoint para subir un objeto al bucket
    @PostMapping("api/upload")
    Map<String, String> upload(@RequestParam MultipartFile file) {
        String key = s3service.putObject(file);

        Map<String, String> result = new HashMap<>();

        result.put("key", key);
        result.put("url", s3service.getObjectURL(key));

        return result;
    }

    //EndPoint para obtener el objeto del bucket
    @GetMapping(value = "api/get-object", params = "key")
    ResponseEntity<ByteArrayResource> getObject(@RequestParam String key){

        Asset asset = s3service.getObject(key);
        ByteArrayResource resource = new ByteArrayResource(asset.getContent());

        return ResponseEntity
                .ok()
                .header("Content-type", asset.getContentType())
                .contentLength(asset.getContent().length)
                .body(resource);
    }

    //EndPoint para eliminar un objeto del bucket
    @DeleteMapping(value = "api/delete-object", params = "key")
    void deleteObject(@RequestParam String key){
        s3service.deleteObject(key);
    }
}
