package com.trabajoFinal.trabajoFinal.controllers;

import org.springframework.web.bind.annotation.*;
import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JwtControllers {

    @PostMapping("/decryptUserData")
    public String decryptJwt(@RequestBody String jwtEncrypted) throws Exception {

        // Clave pública en formato String
        String publicKeyString = "tu_clave_publica_aqui";

        // Decodificar la clave pública
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);

        // Crear objeto de clave pública
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKeyBytes));

        // Inicializar el objeto Cipher con el algoritmo RSA
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        // Decodificar y desencriptar el texto JWT
        byte[] jwtBytes = Base64.getDecoder().decode(jwtEncrypted);
        byte[] decryptedBytes = cipher.doFinal(jwtBytes);

        // Convertir los bytes desencriptados a String
        String decryptedJwt = new String(decryptedBytes);

        // Retornar el JWT desencriptado
        return decryptedJwt;
    }
}
