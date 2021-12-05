package com.lead.catalagofilmes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String sinopse;
    private String imagem;
    private String dataDelançamento;
    private String duração;

    @ManyToOne
    private Idioma idiomas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Categoria categoria;


}
