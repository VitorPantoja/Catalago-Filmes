package com.lead.catalagofilmes.controller;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.services.CategoriaService;
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
@RequestMapping(value = "/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;


    @ResponseBody
    @GetMapping (value = "/All")
    public ResponseEntity<?> findAll(){
        try {
            List<Categoria> categorias = categoriaService.findAll();
            if (categorias.isEmpty()){
                throw new Exception("Erro, sem categorias cadastradas");
            }

            return ResponseEntity.ok().body(categorias);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ResponseBody
    @GetMapping(value = "/id{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Categoria> obj = categoriaService.findById(id);
        try {
            if (!obj.isPresent()){
                return new ResponseEntity<String>("A categoria especificada não foi encontrada", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(obj);
        } catch (Exception e){
            return new ResponseEntity<String>("Categoria especificada não foi encontrada",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/categoriaUP")
    @Transactional
    public ResponseEntity<?> updateCategoria(@RequestBody @Validated Categoria obj){
        try {

            if (categoriaService.verificaServiceCategoria(obj.getId())){
                return new ResponseEntity<String>("Não foi encontrado a categoria especificada", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(categoriaService.update(obj));
        } catch (Exception e){
            return new ResponseEntity<String>("Erro em atualizar a categoria",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/categoriaDel/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            categoriaService.deleteById(id);
            return new ResponseEntity<String>("Categoria de id"+ id + " foi excluída com sucesso",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Erro ao deletar categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> salvaCategoria(@RequestBody @Validated Categoria categoria){
        try {
            return ResponseEntity.ok().body(categoriaService.save(categoria));
        }catch (Exception e){
            return new ResponseEntity<String>("Erro ao salvar categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
