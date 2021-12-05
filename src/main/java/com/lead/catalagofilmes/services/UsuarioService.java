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

    public Usuario update(Long id, Usuario obj){
        Usuario newObj = usuarioRepository.getById(id);
        updateData(newObj, obj);
        return usuarioRepository.save(obj);
    }

    private void updateData(Usuario newObj, Usuario obj) {
        newObj.setNome(obj.getNome());
        newObj.setCpf(obj.getCpf());
        newObj.setEmaiil(obj.getEmaiil());
        newObj.setIdioma(obj.getIdioma());
        newObj.setTelefone(obj.getTelefone());
    }

}
