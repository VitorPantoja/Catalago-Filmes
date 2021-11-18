package com.lead.catalagofilmes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Filme {
    private String titulo;
    private String sinopse;
    private String imagem;
    private String dataDelançamento;
    private String duração;
    private Idioma idiomas;

}
