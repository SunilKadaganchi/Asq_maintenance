package dev.sunil.Asq.maintenance.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class JwtTokenProvider {

    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public String generateToken(Authentication authentication){
        String email = authentication.getName();
        Date issuedAt = new Date();
        Date expirationTime = new Date(issuedAt.getTime()+ 300000);

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(issuedAt)
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS512,key)
                .compact();

        return token;
    }

    public String getEmailFromToken(String token){
     Claims claims =   Jwts.parser().setSigningKey(key).build()
               .parseSignedClaims(token).getBody();

     return claims.getSubject();
    }
}
