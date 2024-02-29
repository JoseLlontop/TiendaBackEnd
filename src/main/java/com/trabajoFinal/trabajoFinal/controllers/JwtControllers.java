package com.trabajoFinal.trabajoFinal.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trabajoFinal.trabajoFinal.models.*;

import com.trabajoFinal.trabajoFinal.services.Interface.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.*;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JwtControllers {

    @Autowired
    private IJwtService service;

    @Value("${sistema.externo.identificador}")
    private String clientId;

    @Value("${sistema.externo.clave}")
    private String clientSecret;

    @Value("${sistema.renaper.modulo}")
    private String publicKeyModulus;

    @Value("${sistema.renaper.exponencial}")
    private String publicKeyExponent;

    private static final String RENAPER_API_URL = "https://colosal.duckdns.org:15001/Renaper/api/Auth/loguearJWT";

    @PostMapping("/api/retornarDatos")
    public Persona decryptJwt(@RequestBody ParametrosSolicitud parametros) throws Exception {

        String parametroUsuario = parametros.getParametroUsuario();
        String tipoIngresoSistema = parametros.getTipoIngresoSistema();

        System.out.println("parametroUsuario = " + parametroUsuario);

        System.out.println("Tipo de usuario que ingreso al sistema = " + tipoIngresoSistema);

        //CODIGO RELACIONADO A LA LLAMADA HTTP AL RENAPER

        RestTemplate restTemplate = new RestTemplate();

        // Crear el cuerpo de la solicitud
        String requestBody = "{\"clientId\":\"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"authorizationCode\":\"" + parametroUsuario + "\"}";

        System.out.println("\nJson a enviar al Renaper = " + requestBody);
        
        // Configurar las cabeceras de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear la entidad de solicitud con el cuerpo y las cabeceras
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Realizar la llamada a la API del Renaper
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(RENAPER_API_URL, requestEntity, String.class);

        // Obtener el cuerpo de la respuesta
        String responseBody = responseEntity.getBody();

        System.out.println("\nRespuesta del Renaper = " + responseBody);

        //ME QUEDO SOLO EN VALOR DE DATOS:
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);
        String datos = rootNode.get("datos").asText();

        System.out.println("\ndatos incriptados = " + datos);

        System.out.println("modulo = " + publicKeyModulus);
        System.out.println("exponencial = " + publicKeyExponent + "\n");

        //CÓDIGO RELACIONADO A LA DESENCRIPTACIÓN

        try {
            // Decodificar el Modulus y el Exponent
            byte[] modulusBytes = Base64.getDecoder().decode(publicKeyModulus);
            byte[] exponentBytes = Base64.getDecoder().decode(publicKeyExponent);

            // Crear la clave pública
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(
                    new java.math.BigInteger(1, modulusBytes),
                    new java.math.BigInteger(1, exponentBytes)
            ));

            // Decodificar el payload del JWT
            Claims jsonDesencriptado = Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .setAllowedClockSkewSeconds(60) // Permitir un margen de tiempo de 1 minuto
                    .build()
                    .parseClaimsJws(datos)
                    .getBody();

            System.out.println("\nJson Desencriptado = " + jsonDesencriptado + "\n");

            Persona persona = service.convertirJsonAPersona(jsonDesencriptado);

            //Verificación 1
            System.out.println("\npersona = " + persona);

            Persona personaCompleta = service.asignarTipo(persona, tipoIngresoSistema);
            //Verificación 2
            System.out.println("A la persona se le asigno el tipo = " + personaCompleta);

            return personaCompleta;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // Método para combinar los bytes del módulo y el exponente
    private byte[] combineByteArrays(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    // Método para decodificar una cadena base64 URL segura
    private byte[] parseBase64Url(String base64Url) {
        String paddedBase64Url = base64Url + "==";
        return Base64.getUrlDecoder().decode(paddedBase64Url);
    }
}
