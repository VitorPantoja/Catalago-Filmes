package com.lead.catalagofilmes.services;
import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements Serializable {

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
        return categoriaRepository.save(obj);

    }
    public boolean verificaServiceCategoria(Long id){
        return categoriaRepository.existsById(id);
    }

}
