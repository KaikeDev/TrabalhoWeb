package com.projeto.projeto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.projeto.Repository.AtorRepository;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    
}
