package com.projeto.projeto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.projeto.projeto.Service.AtorService;
import com.projeto.projeto.model.Ator;
import com.projeto.projeto.model.MensagemDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RequestMapping(value = "/ator")
@RestController
public class AtorController {

    @Autowired
    AtorService atorService;


    @GetMapping()   
    public ResponseEntity<List<Ator>> findAll() {
        return ResponseEntity.ok().body(atorService.findAll());
    }
    
    @GetMapping(value="/{pIdAtor}")
    public ResponseEntity<Ator> findById(@PathVariable Integer pIdAtor) {
        return ResponseEntity.ok().body(atorService.findById(pIdAtor));
    }
    
    @PostMapping
    public ResponseEntity<Ator> insAtor(@RequestBody Ator pAtor) {
        atorService.insAtor(pAtor);

        return ResponseEntity.ok().body(pAtor);
    }
    
    @PutMapping("/{pIdAtor}")
    public ResponseEntity<Ator> updAtor(@PathVariable Integer pIdAtor, @RequestBody Ator pAtor) {
        Ator vAtor = atorService.updAtor(pIdAtor, pAtor);
        
        return ResponseEntity.ok().body(vAtor);
    }

    @DeleteMapping(value = "/{pIdAtor}")
    public ResponseEntity<MensagemDTO> delAtor(@PathVariable Integer pIdAtor) {
            return atorService.delAtor(pIdAtor);
    }
}
