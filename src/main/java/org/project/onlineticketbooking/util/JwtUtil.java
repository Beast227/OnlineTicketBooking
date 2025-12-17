package org.project.onlineticketbooking.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private Key getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String getJwtToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 36000000))
                .signWith(getKey())
                .compact();
    }

    public String extractEmail(String token) {
        Key key = getKey();

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token).getBody();

        return claims.getSubject();
    }
}
