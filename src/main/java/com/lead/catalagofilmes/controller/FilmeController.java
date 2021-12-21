package com.lead.catalagofilmes.controller;

import com.lead.catalagofilmes.models.Filme;
import com.lead.catalagofilmes.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @ResponseBody
    @GetMapping(value = "/All")
    public ResponseEntity<?> findAll(){
        try{
            List<Filme> filmes = filmeService.findAll();
            if (filmes.isEmpty()){
                throw new Exception("Lista de filmes vazia");
            }
            return ResponseEntity.ok().body(filmes);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ResponseBody
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            Optional<Filme> obj = filmeService.findById(id);
            if (!obj.isPresent()){
                throw new Exception("Filme não encontrado");
            }
            return ResponseEntity.ok().body(obj);
        }catch (Exception e){
            return new ResponseEntity<>("Filme não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/Cat{id}")
    public ResponseEntity<?> findByCategoria(@PathVariable Long id){
        try{
            List<Filme> filmes = filmeService.findByCategoria(id);
            if (filmes.isEmpty()){
                return new ResponseEntity<>("Categoria não encontrada", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(filmes);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update")
    @Transactional
    public ResponseEntity<?> updateFilme(@RequestBody @Validated Filme obj){
        try {
            if (filmeService.verificaServiceFilme(obj.getId())){
                return new ResponseEntity<>("Não foi encontrado o filme especificado",HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(filmeService.update(obj));
        }catch (Exception e){
            return new ResponseEntity<String>("Erro em atulizar o filme", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete{id}")
    public ResponseEntity<?> deleteFilme(@PathVariable Long id){
        try {
            filmeService.deleteById(id);
            return new ResponseEntity<>("Filme de id"+ id +" excluído com sucesso", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Erro ao deletar filme",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/findByname{filme}")
    public ResponseEntity<List<Filme>> findById(@PathVariable String filme){
        List<Filme> list = filmeService.searchName(filme);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> salvaFilme(@RequestBody @Validated Filme filme){
        try {
            Filme newFilme = filmeService.save(filme);
            return ResponseEntity.ok().body(newFilme);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao salvar o filme", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
