package com.lead.catalagofilmes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter @Setter
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    @OneToMany(mappedBy = "categoria")
    private List<Filme> filmes = new ArrayList<>();
    @ManyToOne
    private Idioma idiomas;

    private String nome;
    private String tag;





   /* public void Mostra(){
        for (Filme i : filmes) {
            System.out.println(i.getTitulo());
            System.out.println(i.getCategoria());
        }
    }*/




}
