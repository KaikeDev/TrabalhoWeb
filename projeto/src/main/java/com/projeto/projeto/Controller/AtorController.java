package com.projeto.projeto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projeto.Service.AtorService;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping(value = "/ator")
@RestController
public class AtorController {

    @Autowired
    AtorService atorService;

    @GetMapping
    public String getMethodName() {
        return "ola";
    }
    


}
