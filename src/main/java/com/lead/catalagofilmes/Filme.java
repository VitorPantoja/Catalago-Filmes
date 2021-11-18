package com.lead.catalagofilmes;

public class Filme {
    private String nome;
    private String sinopse;


    public Filme(String nome, String sinopse) {
        this.nome = nome;
        this.sinopse = sinopse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

}
