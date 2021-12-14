package com.lead.catalagofilmes.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter
public class UsuarioDTO {

    private String senha;
    private String email;
}
