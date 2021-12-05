package com.lead.catalagofilmes.services;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.repository.CategoriaRepository;
import com.lead.catalagofilmes.repository.FilmeRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private FilmeRepository filmeRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.get();
    }

    public Categoria save(Categoria obj){
        return categoriaRepository.save(obj);
    }

    public void deleteById(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria update(Long id, Categoria obj){
        Categoria newObj = categoriaRepository.getById(id);
        updateData(newObj, obj);
        return categoriaRepository.save(newObj);
    }

    private void updateData(Categoria newObj, Categoria obj) {
        //obj.getFilmes().removeAll(obj.getFilmes());
        newObj.setNome(obj.getNome());
        newObj.setTag(obj.getTag());
        // newObj.setFilme(obj.getFilme());
        //newObj.removeFilme(obj.removeFilmeId(obj.getId()));
        // newObj.removeFilme(obj.getId());
        //newObj.getFilmes().removeIf(ob -> Objects.equals(ob.getId(), obj.getId()));
        //   newObj.setFilmes(obj.getFilmes());
        //newObj.setFilmes(null);
        newObj.setFilmes(obj.getFilmes());
      //  categoriaRepository.save(newObj);
        newObj.setIdiomas(obj.getIdiomas());
        //filmeRepository.deleteById(obj.getId());

    }




}
