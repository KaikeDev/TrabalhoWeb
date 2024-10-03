package com.projeto.projeto.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Ator implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAtor;

    @NotNull(message = "Nome do ator não pode ser nulo!")
    @NotBlank(message = "Nome do ator não pode ser branco!")
    private String nome;

    @NotNull(message = "Idade não pode ser nulo!")
    @NotBlank(message = "Idade não pode ser branco!")
    private int idade;

    @ManyToOne
    @JoinColumn(name = "id_personagem")
    private Personagem personagemAtor;
}
