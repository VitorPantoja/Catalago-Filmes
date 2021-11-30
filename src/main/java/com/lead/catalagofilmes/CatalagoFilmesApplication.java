package com.lead.catalagofilmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;



@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})//configuração para desativar o spring
public class CatalagoFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalagoFilmesApplication.class, args);
		/*Filme filme = new Filme();
		filme.setTitulo("FilmeH");
		IdiomaService idioma = new IdiomaService("Ingles","US");

		Categoria drama = new Categoria();
		drama.setIdiomas(idioma);
		drama.setNome("drama");
		drama.setTag("Drm");

		drama.AdicionaFilmesCategoria(filme);
		filme.setCategoria(drama.getNome());

		drama.Mostra();
		//drama.PesquisaPorNome("Filme");
		//drama.Categorias("Ação");
		UsuarioService user = new UsuarioService();
		Categoria cat = new Categoria();
		user.setIdioma(idioma);
		cat.setIdiomas(user.getIdioma());
*/
		


	}

}
