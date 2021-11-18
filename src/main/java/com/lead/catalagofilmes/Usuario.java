package com.lead.catalagofilmes;

import lombok.Getter;
import lombok.Setter;

public abstract class Usuario {
    private Idioma idiomas;
    @Getter @Setter
    private String nome;
    private String cpf;
    private String telefone;
    private String emaiil;
    private String senha;
    private String perfil;

   /* public Usuario(String nome, String cpf, String telefone, String emaiil, String senha, Idioma idiomas) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.emaiil = emaiil;
        this.senha = senha;
        this.idiomas = idiomas;
    }*/
}
