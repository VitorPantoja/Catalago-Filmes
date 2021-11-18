package com.lead.catalagofilmes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Usuario {
    private String nome;
    private String cpf;
    private String telefone;
    private String emaiil;
    private String senha;
    private Idioma idioma;


}

