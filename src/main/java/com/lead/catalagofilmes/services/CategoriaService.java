package com.lead.catalagofilmes.services;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.models.Filme;
import com.lead.catalagofilmes.repository.CategoriaRepository;
import com.lead.catalagofilmes.repository.FilmeRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoriaService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id){
        return categoriaRepository.findById(id);
    }

    public Categoria save(Categoria obj){
        return categoriaRepository.save(obj);
    }

    public void deleteById(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria update(Categoria obj){
        Categoria newObj = categoriaRepository.getById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setTag(obj.getTag());
        newObj.setIdiomas(obj.getIdiomas());

        return categoriaRepository.save(newObj);

    }
    public boolean verificaServiceCategoria(Long id){
        return categoriaRepository.existsById(id);
    }








}
