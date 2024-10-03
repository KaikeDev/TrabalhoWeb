package com.projeto.projeto.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Obra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObra;

    @NotNull(message = "Nome da obra não pode ser nulo!")
    @NotBlank(message = "Nome da obra não pode ser branco!")
    private String titulo;

    private int anoLancamento;

     @ManyToOne
    @JoinColumn(name = "id_Categoria")
    private Categoria categoriaObra;

    @ManyToOne
    @JoinColumn(name = "id_Local")
    private Local localObra;


    @ManyToMany(mappedBy = "obras")
    private List<Personagem> personagens;
}
