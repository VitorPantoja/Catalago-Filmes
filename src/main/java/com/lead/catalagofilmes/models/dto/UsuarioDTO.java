package com.lead.catalagofilmes.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.persistence.Entity;


@Getter
@Setter
public class UsuarioDTO {

    private String senha;
    private String email;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
