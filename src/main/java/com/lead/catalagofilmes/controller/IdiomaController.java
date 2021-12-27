package com.lead.catalagofilmes.controller;
import com.lead.catalagofilmes.models.Idioma;
import com.lead.catalagofilmes.services.IdiomaService;
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
@RequestMapping(value = "/idiomas")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @ResponseBody
    @GetMapping(value = "/All")
    public ResponseEntity<?> findAll(){
        try{
            List<Idioma> idiomas = idiomaService.findAll();
            if (idiomas.isEmpty()){
                throw new Exception("Erro, não existem idiomas cadastrados");
            }
            return ResponseEntity.ok().body(idiomas);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @GetMapping(value = "/idioma/{id}")
    public ResponseEntity<?> findByid(@PathVariable Long id){
        try {
            Optional<Idioma> obj = idiomaService.findById(id);
            if (!obj.isPresent()){
                return new ResponseEntity<String>("Idioma não encontrado",HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(obj);
        }catch (Exception e){
            return new ResponseEntity<String>("Idioma não encontrado",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteIdioma(@PathVariable Long id){
        try {
            if(!idiomaService.verificaServiceIdioma(id)){
                return new ResponseEntity<String>("Idioma não encontrado",HttpStatus.NOT_FOUND);
            }
            idiomaService.deleteById(id);
            return new ResponseEntity<String>("Idioma de id "+ id +" foi excluído com sucesso", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Erro ao deletar idioma",HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> salvaCategoria(@RequestBody @Validated Idioma idioma){
        try {
            return ResponseEntity.ok().body(idiomaService.save(idioma));
        } catch (Exception e){
            return new ResponseEntity<String>("Erro em salvar o idioma", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/update")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Validated Idioma obj){
        try {
            if (!idiomaService.verificaServiceIdioma(obj.getId())){
                return  new ResponseEntity<String>("Não foi encontrado o idioma especificado",HttpStatus.NOT_FOUND);
            }
            Idioma salvaIdioma = idiomaService.update(obj);
            return ResponseEntity.ok().body(salvaIdioma);
        } catch (Exception e){
            return new ResponseEntity<String>("Erro a atualizar o idioma", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
