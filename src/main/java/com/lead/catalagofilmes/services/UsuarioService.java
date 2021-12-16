package com.lead.catalagofilmes.services;

import com.lead.catalagofilmes.models.Usuario;
import com.lead.catalagofilmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        Optional<Usuario> obg = usuarioRepository.findById(id);

        return obg.get();
    }

    public Usuario save(Usuario obj){
        return usuarioRepository.save(obj);
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Usuario obj){

        Usuario newObj = usuarioRepository.getById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setTelefone(obj.getTelefone());
        newObj.setIdioma(obj.getIdioma());
        newObj.setEmail(obj.getEmail());
        newObj.setCpf(obj.getCpf());
        return usuarioRepository.save(newObj);

    }


}
