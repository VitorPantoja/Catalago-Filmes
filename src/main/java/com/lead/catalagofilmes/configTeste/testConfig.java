package com.lead.catalagofilmes.configTeste;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.models.Idioma;
import com.lead.catalagofilmes.models.Usuario;
import com.lead.catalagofilmes.repository.CategoriaRepository;
import com.lead.catalagofilmes.repository.IdiomaRepository;
import com.lead.catalagofilmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

@Configuration
public class testConfig implements CommandLineRunner{
    @Autowired
    private IdiomaRepository idiomaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;



    @Override
    public void run(String... args) throws Exception {
        Idioma ingles = new Idioma();
        ingles.setId(null);
        ingles.setNome("Inglês");
        ingles.setTag("En");

        Idioma portugues = new Idioma();
        portugues.setNome("Português-brasileiro");
        portugues.setTag("PT-BR");

        Categoria aventura = new Categoria();

        aventura.setId(null);
        aventura.setIdiomas(ingles);
        aventura.setNome("aventura");
        aventura.setTag("avent");

        Usuario Elano = new Usuario(null,"Elano","000-000-000-00","+00-000-00000000","elanoDescomplica@email.com","queSenha",ingles,aventura);
        Usuario Cleber = new Usuario(null, "Cleber","000.000.000-00","+000000000-0000","emailDescomplica@email.com","queSenha?",portugues,aventura);

       /* idiomaRepository.saveAll(Arrays.asList(ingles, portugues));
        categoriaRepository.saveAll(Arrays.asList(aventura));

        usuarioRepository.saveAll(Arrays.asList(Elano,Cleber));*/


    }
}
