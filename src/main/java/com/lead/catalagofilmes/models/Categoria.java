package com.lead.catalagofilmes.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

import java.util.List;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    public void addFilmes(Filme filme){
        this.filmes.add(filme);
    }

    public void removeFilme(Long Id) {
        for (Filme i: filmes) {
            if (i.getId().equals(Id)){
                this.filmes.remove(i);
                return;
            }

        }
    }


    /*public Long getIdFilmes(Long id) {
        Long retorno = null;
        for (Filme i : filmes) {
            if (i.getId().equals(id)){
                retorno = id;
            }
        }
        return retorno;
    }

    public long removeFilmeId(Long id){
        for (Filme i : filmes) {
            if(i.getId().equals(id)){
              this.filmes.remove(i);
              break;
            }
        }
        return 0;
    }*/

    /*@OneToOne
    private Usuario usuario;*/


    }

