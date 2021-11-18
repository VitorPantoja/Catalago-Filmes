package com.lead.catalagofilmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalagoFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalagoFilmesApplication.class, args);
		/*Filme filme = new Filme("Filme","filmeeeeee");
        Categoria categoria = new Categoria();
        categoria.AdicionaFilmesCategoria("Ação", filme);
        categoria.Mostra();
        //categoria.PesquisaPorNome("Filme");
        categoria.Categorias("Ação");*/
		Usuario user = new Visitante();
		Usuario user1 = new Visitante();

		System.out.println(user.getNome());
	}

}
