package com.enzomartins.stockmarket.service;

import org.springframework.stereotype.Service;

import com.enzomartins.stockmarket.entities.User;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY = "minha-chave-secreta-super-segura-para-jwt-stockmarket-123456789";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String generateToken(User user) {
    	
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
        	.subject(user.getEmail())
        	.issuedAt(now)
        	.expiration(expiration)
        	.signWith(getSigningKey())
        	.compact();
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
    
    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}