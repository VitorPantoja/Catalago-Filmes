package com.lead.catalagofilmes.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {

    private String token;
    private String tipo;

    public TokenDto(String token, String tipo) {
        this.token  = token;
        this.tipo = tipo;
    }
}
