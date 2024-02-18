package com.trabajoFinal.trabajoFinal.controllers;

import com.trabajoFinal.trabajoFinal.models.Persona;
import com.trabajoFinal.trabajoFinal.services.Interface.IJwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.crypto.Cipher;
import javax.swing.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JwtControllers {

    @Autowired
    private IJwtService service;

    @PostMapping("/api/desencriptarJwt")
    public Persona decryptJwt(@RequestBody String jwtEncrypted) /*throws Exception*/ {

        /*// Clave pública proporcionada
        String modulusString = "9BJ0WxXATSJ6KtiSHhglSd3kgc6j5kXLp8sx5hm5KN2Y8H1uygVrPAJGBqPEIgRpMHG8yMFyKh2hXLSnZNLtZ+7c+fMIUYJYARS8f4yxF3CpkMtVW4wJ5Sbg99vIyi8Hi/134QuwU9ghYKiGgaYEvsQo5P9R+y/MiJrclETu5mkUdazs0Sua5+WdnsmJqykVxrfHtgvlavtmhF2B8zUWWOb8zdPgWqzxULt4RHWIasdf6GxzG+XGK+6jyNfb4DpUJQBlHssVGgflNEukoYefTcqx865JeGMeIBJzmxceiD2PrEnDsHHYk8w5/2dAWbnf8Pk19T3CXDDd73MLiPR5xQ==";
        String exponentString = "AQAB";

        // Convertir la clave pública a BigIntegers
        byte[] modulusBytes = Base64.getDecoder().decode(modulusString);
        byte[] exponentBytes = Base64.getDecoder().decode(exponentString);
        BigInteger modulus = new BigInteger(1, modulusBytes);
        BigInteger exponent = new BigInteger(1, exponentBytes);

        // Crear objeto de clave pública
        RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, exponent);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(rsaPublicKeySpec);

        // Inicializar el objeto Cipher con el algoritmo RSA
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        // Decodificar y desencriptar el texto JWT
        byte[] jwtBytes = Base64.getDecoder().decode(jwtEncrypted);
        byte[] decryptedBytes = cipher.doFinal(jwtBytes);

        // Convertir los bytes desencriptados a String
        String decryptedJwt = new String(decryptedBytes);

        System.out.printf("Texto desencriptado: " + decryptedJwt);

        // Retornar el JWT desencriptado
        return decryptedJwt;*/

        String textoDesencriptado = "{ \"nombre\" : \"José\", \"apellido\": \"Llontop\",  \"email\" : \"josellontop100@gmail.com\", \"estadoCrediticio\": \"activa\",  \"vivo\" : true }";

        Persona persona = service.convertirTextoPersona(textoDesencriptado);
        //Verificación 1
        System.out.println("persona = " + persona);


        Persona personaCompleta = service.asignarTipo(persona);
        //Verificación 2
        System.out.println("persona = " + personaCompleta);

        return personaCompleta;

    }
}
