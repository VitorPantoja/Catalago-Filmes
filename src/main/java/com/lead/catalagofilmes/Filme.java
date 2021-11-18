package com.lead.catalagofilmes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Filme {
    private String titulo;
    private String sinopse;
    private String imagem;
    //data de lançamento, duração, idioma
    private String dataDeLançamente;
    private String duração;
    private Idioma idioma;


    public Filme(String nome, String sinopse) {
        this.titulo = nome;
        this.sinopse = sinopse;
    }

}
