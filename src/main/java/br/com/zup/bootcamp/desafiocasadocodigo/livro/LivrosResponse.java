package br.com.zup.bootcamp.desafiocasadocodigo.livro;

import java.util.List;

public class LivrosResponse {

    private Long id;
    private String nome;

    public LivrosResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
