package com.projeto.projeto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.projeto.Repository.PersonagemRepository;
import com.projeto.projeto.Service.PersonagemService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.net.URI;

import com.projeto.projeto.model.MensagemDTO;
import com.projeto.projeto.model.Personagem;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController // controller do rest
@RequestMapping(value = "/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @Autowired
    private PersonagemRepository personagemRepository;

    @GetMapping()
    public ResponseEntity<List<Personagem>> findAll() {
        return ResponseEntity.ok().body(personagemService.findAll());
    }

    @GetMapping(value = "/{pIdPersonagem}")
    public ResponseEntity<Personagem> findById(@PathVariable Integer pIdPersonagem) {
        return ResponseEntity.ok().body(personagemService.findById(pIdPersonagem));
    }

    @PostMapping(value = "/{pIdPersonagem}")
    public ResponseEntity<Personagem> inserePersonagem(@RequestBody Personagem personagem,
            @PathVariable Integer pIdPersonagem) {
        Personagem vNovPersonagem = personagemService.inserePersonagem(personagem);

        URI vUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/personagem/{pIdPersonagem}")
                .buildAndExpand(vNovPersonagem.getIdPersonagem()).toUri();

        return ResponseEntity.created(vUri).body(vNovPersonagem);
    }

    @PutMapping("/{pIdPersonagem}")
    public ResponseEntity<Personagem> updatePersonagem(@PathVariable Integer pIdPersonagem,
            @RequestBody Personagem pPersonagem) {

        Personagem pPersoAtual = personagemRepository
                .findById(pIdPersonagem)
                .orElseThrow();

        if (pPersonagem.getCaracteristicas() != null) {
            pPersoAtual.setCaracteristicas(pPersonagem.getCaracteristicas());
        }

        if (pPersonagem.getNome() != null) {
            pPersoAtual.setNome(pPersonagem.getNome());
        }

        personagemRepository.save(pPersoAtual);

        return ResponseEntity.ok().body(pPersoAtual);
    }

    @DeleteMapping("/{pIdPersonagem}")
    public ResponseEntity<MensagemDTO> deletePersonagem(@PathVariable Integer pIdPersonagem){
        personagemService.deletePersonagem(pIdPersonagem);

        return ResponseEntity.ok().body(new MensagemDTO("ok", "Funcionario "+ pIdPersonagem + " deletado com sucesso"));
    }

}
