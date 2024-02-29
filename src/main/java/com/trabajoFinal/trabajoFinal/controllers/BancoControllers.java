package com.trabajoFinal.trabajoFinal.controllers;

import com.trabajoFinal.trabajoFinal.models.ParametrosSolicitud;
import com.trabajoFinal.trabajoFinal.models.Persona;
import com.trabajoFinal.trabajoFinal.models.Transaccion;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BancoControllers {

    private static final String BANCO_API_URL = "https://bank-tomorrow.onrender.com/transaction";

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/api/realizarTransaccion")
    public boolean realizarTransaccion(@RequestBody Transaccion transactionRequest) {

        System.out.println("transactionRequest = " + transactionRequest);

        // Configurar las cabeceras de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear la entidad de solicitud con el cuerpo y las cabeceras
        HttpEntity<Transaccion> requestEntity = new HttpEntity<>(transactionRequest, headers);

        // Crear una instancia de RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Realizar la llamada a la API de transacción
        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                BANCO_API_URL,
                HttpMethod.POST,
                requestEntity,
                Void.class
        );

        System.out.println("responseEntity = " + responseEntity);

        // Verificar el código de estado de la respuesta
        HttpStatus statusCode = responseEntity.getStatusCode();
        return statusCode == HttpStatus.OK;
    }
}

