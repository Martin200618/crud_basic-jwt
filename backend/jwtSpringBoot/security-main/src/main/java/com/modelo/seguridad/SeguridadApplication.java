package com.modelo.seguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguridadApplication.class, args);
		//   // Generar una nueva clave HMAC-SHA256 segura
        // Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // // Mostrar la clave generada
        // byte[] keyBytes = key.getEncoded();
        // System.out.println("Clave generada: " + Base64.getEncoder().encodeToString(keyBytes));
	}

}
