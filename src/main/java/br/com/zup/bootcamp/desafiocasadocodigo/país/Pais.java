package br.com.zup.bootcamp.desafiocasadocodigo.país;

import br.com.zup.bootcamp.desafiocasadocodigo.estado.Estado;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    @Deprecated // HIBERNATE
    public Pais() {
    }

    public Long getId() {
        return id;
    }
}
