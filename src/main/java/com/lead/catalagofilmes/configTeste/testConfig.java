package com.lead.catalagofilmes.configTeste;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.models.Filme;
import com.lead.catalagofilmes.models.Idioma;
import com.lead.catalagofilmes.models.Usuario;
import com.lead.catalagofilmes.repository.CategoriaRepository;
import com.lead.catalagofilmes.repository.FilmeRepository;
import com.lead.catalagofilmes.repository.IdiomaRepository;
import com.lead.catalagofilmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
public class testConfig implements CommandLineRunner{
    @Autowired
    private IdiomaRepository idiomaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private FilmeRepository filmeRepository;



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

        Filme filme = new Filme(null,"The secret life of ElanoDescomplica", "Elano vivi no seu mundo da lua e de repente encontra o seu real propósito de vida","fingi que realmente tem uma imagem","20/12/2013","1h 54min",portugues,aventura);
        Filme filme2 = new Filme(null,"Cleber, o cacto", "O filme retrata a vida diária de Cleber e sua vida de cacto apreciando o sol e uma brisa", "Finge que tem uma imagem aqui", "20/01/2021","1hr",portugues,aventura);


        System.out.println(new BCryptPasswordEncoder().encode("queSenha"));

      /*  Usuario Elano = new Usuario(null,"Elano","000-000-000-00","+00-000-00000000","elanoDescomplica@email.com","queSenha",ingles);
        Usuario Cleber = new Usuario(null, "Cleber","000.000.000-00","+000000000-0000","emailDescomplica@email.com","queSenha?",portugues);
*/

        /*idiomaRepository.saveAll(Arrays.asList(ingles,portugues));
        categoriaRepository.saveAll(Arrays.asList(aventura));
        filmeRepository.saveAll(Arrays.asList(filme, filme2));
        usuarioRepository.saveAll(Arrays.asList(Elano,Cleber));*/

        //idiomaRepository.saveAll(Arrays.asList(ingles, portugues));
        //  categoriaRepository.saveAll(Arrays.asList(aventura));



    }
}
