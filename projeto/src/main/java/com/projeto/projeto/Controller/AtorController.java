package com.projeto.projeto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


import com.projeto.projeto.Repository.AtorRepository;
import com.projeto.projeto.Service.AtorService;
import com.projeto.projeto.model.Ator;

import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping(value = "/ator")
@RestController
public class AtorController {

    @Autowired
    AtorService atorService;

    @Autowired
    private AtorRepository atorRepository;

    @GetMapping()   
    public ResponseEntity<List<Ator>> findAll() {
        return ResponseEntity.ok().body(atorService.findAll());
    }
    


}
