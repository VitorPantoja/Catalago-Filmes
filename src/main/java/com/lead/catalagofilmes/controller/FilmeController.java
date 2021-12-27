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
                return new ResponseEntity<String>("Lista de filmes vazia", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<Filme>>(filmes, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            Optional<Filme> obj = filmeService.findById(id);
            if (!obj.isPresent()){
                return new ResponseEntity<String>("Filme não encontrado", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(obj);
        }catch (Exception e){
            return new ResponseEntity<String>("Filme não encontrado", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/Cat/{id}")
    public ResponseEntity<?> findByCategoria(@PathVariable Long id){
        try{
            List<Filme> filmes = filmeService.findByCategoria(id);
            if (filmes.isEmpty()){
                return new ResponseEntity<String>("Categoria não encontrada", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(filmes);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update")
    @Transactional
    public ResponseEntity<?> updateFilme(@RequestBody @Validated Filme obj){
        try {
            if (!filmeService.verificaServiceFilme(obj.getId())){
                return new ResponseEntity<String>("Não foi encontrado o filme especificado",HttpStatus.NOT_FOUND);
            }
            Filme atualizaFilme = filmeService.update(obj);
            return ResponseEntity.ok().body(atualizaFilme);
        }catch (Exception e){
            return new ResponseEntity<String>("Erro em atulizar o filme", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteFilme(@PathVariable Long id){
        try {
            if (!filmeService.verificaServiceFilme(id)){
                return new ResponseEntity<String>("Não foi encontrado o filme especificado",HttpStatus.NOT_FOUND);
            }
            filmeService.deleteById(id);
            return new ResponseEntity<String>("Filme de id "+ id +" excluído com sucesso", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Erro ao deletar filme",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/findByname/{filme}")
    public ResponseEntity<?> findById(@PathVariable String filme){
        try{
            List<Filme> filmes = filmeService.searchName(filme);
            if(filmes.isEmpty()){
                return new ResponseEntity<String>("Não foi encontrado o filme especificado",HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(filmes);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> salvaFilme(@RequestBody @Validated Filme filme){
        try {
            Filme newFilme = filmeService.save(filme);
            return ResponseEntity.ok().body(newFilme);
        }catch (Exception e){
            return new ResponseEntity<String>("Erro ao salvar o filme", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
