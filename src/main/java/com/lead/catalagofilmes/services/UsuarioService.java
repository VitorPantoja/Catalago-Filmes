package com.lead.catalagofilmes.services;
import com.lead.catalagofilmes.models.Usuario;
import com.lead.catalagofilmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario obj){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        obj.setSenha(passwordEncoder.encode(obj.getPassword()));

        return usuarioRepository.save(obj);
    }



    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Usuario obj){
        return usuarioRepository.save(obj);
    }
    public boolean verificaServiceUsuario(Long id){
        return usuarioRepository.existsById(id);
    }

}
