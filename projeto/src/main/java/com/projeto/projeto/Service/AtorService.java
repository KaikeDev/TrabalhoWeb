package com.projeto.projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.projeto.Repository.AtorRepository;
import com.projeto.projeto.model.Ator;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    
    public List<Ator> findAll(){
        return atorRepository.findAll();
    }
}
