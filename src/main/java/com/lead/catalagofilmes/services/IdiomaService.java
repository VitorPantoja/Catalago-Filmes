package com.lead.catalagofilmes.services;

import com.lead.catalagofilmes.models.Idioma;
import com.lead.catalagofilmes.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdiomaService {

    @Autowired
    private IdiomaRepository idiomaRepository;

    public List<Idioma> findAll(){
        return idiomaRepository.findAll();
    }

    public Idioma findById(Long id){
        Optional<Idioma> obj = idiomaRepository.findById(id);
        return obj.get();
    }

    public Idioma save(Idioma idioma){
        return idiomaRepository.save(idioma);
    }

    public void deleteById(Long id){
        idiomaRepository.deleteById(id);
    }

    public Idioma update(Long id, Idioma obj){
        Idioma newObj = idiomaRepository.getById(id);
        updateData(newObj, obj);
        return idiomaRepository.save(newObj);
    }

    private void updateData(Idioma newObj, Idioma obj) {
        newObj.setTag(obj.getTag());
        newObj.setNome(obj.getNome());
    }


}
