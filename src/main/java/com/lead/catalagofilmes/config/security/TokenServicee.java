package com.lead.catalagofilmes.config.security;

import com.lead.catalagofilmes.models.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class TokenServicee {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario log = (Usuario) authentication.getPrincipal();
        Date agoraHoje = new Date();
        Date dataExpiracao = new Date((agoraHoje.getTime()) + Long.parseLong(expiration));


        return Jwts.builder()
                .setIssuer("API CATALAGO-FILMES")
                .setSubject(log.getId().toString())
                .setIssuedAt(agoraHoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    public boolean validaToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(this.secret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();

        return Long.parseLong(claims.getSubject());
    }
}



