package com.lead.catalagofilmes.services;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.models.Filme;
import com.lead.catalagofilmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private CategoriaService categoriaService;

    public List<Filme> findAll(){
        return filmeRepository.findAll();
    }

    public Optional<Filme> findById(Long id){

        return filmeRepository.findById(id);
    }

    public Filme save(Filme obj){
        return filmeRepository.save(obj);
    }

    public void deleteById(Long id){
        filmeRepository.deleteById(id);
    }

    public Filme update(Filme obj){
        Filme newObj = filmeRepository.getById(obj.getId());
        newObj.setIdiomas(obj.getIdiomas());
        newObj.setSinopse(obj.getSinopse());
        newObj.setImagem(obj.getImagem());
        newObj.setDuração(obj.getDuração());
        newObj.setTitulo(obj.getTitulo());
        newObj.setDataDelançamento(obj.getDataDelançamento());
        newObj.setCategoria(obj.getCategoria());
        return filmeRepository.save(newObj);
    }

    public List<Filme> searchName(String nome_filme){
        return filmeRepository.searchName(nome_filme);
    }

    public List<Filme> findByCategoria(Long id){
        Optional<Categoria> categoria = categoriaService.findById(id);
        List<Filme> filmes = new ArrayList<>();
        if(categoria != null){
            filmes = filmeRepository.findByCategoria(categoria.get());
            return filmes;
        }
        return null;
    }

    public boolean verificaServiceFilme(Long id){
        return filmeRepository.existsById(id);
    }



}
