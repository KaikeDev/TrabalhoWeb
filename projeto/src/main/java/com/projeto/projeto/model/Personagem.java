package com.projeto.projeto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Personagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonagem;

    @NotNull(message = "Nome do personagem não pode ser nulo!")
    @NotBlank(message = "Nome do personagem não pode ser branco!")
    private String nome;

    private String caracteristicas;

    @OneToMany(mappedBy="personagemAtor")
    private List<Ator> atores = new ArrayList<>();

    @ManyToMany()
    @JoinTable(
            name = "personagem_obra",
            joinColumns = @JoinColumn(name = "id_personagem"),
            inverseJoinColumns = @JoinColumn(name = "id_obra"),
            uniqueConstraints = @UniqueConstraint(name = "personagem_obra_unique", columnNames = {"id_personagem","id_obra"})
    )

    private List<Obra> obras;

}
