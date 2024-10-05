package com.projeto.projeto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.projeto.model.Personagem;

import com.projeto.projeto.Repository.PersonagemRepository;
import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> findAll() {
        return personagemRepository.findAll();
    }

    public Personagem findById(Integer pIdPersonagem) {
        Personagem vPersonagem = personagemRepository
                .findById(pIdPersonagem)
                .orElseThrow();

        return vPersonagem;
    }

    public Personagem inserePersonagem(Personagem vPersonagem) {

        return personagemRepository.save(vPersonagem);

    }

    public Personagem updatePersonagem(Personagem pPersonagem) {
        Personagem vPersonagem = personagemRepository
                .findById(pPersonagem.getIdPersonagem())
                .orElseThrow();

        if (pPersonagem.getCaracteristicas() != null) {
            vPersonagem.setCaracteristicas(pPersonagem.getCaracteristicas());
        }

        if (pPersonagem.getNome() != null) {
            vPersonagem.setNome(pPersonagem.getNome());
        }

        return personagemRepository.save(vPersonagem);
    }

    public void deletePersonagem(Integer pIdPersonagem){
            personagemRepository
            .findById(pIdPersonagem)
            .orElseThrow();

            personagemRepository.deleteById(pIdPersonagem);
    }
}
