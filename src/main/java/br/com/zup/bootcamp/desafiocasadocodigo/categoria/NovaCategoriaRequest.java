package br.com.zup.bootcamp.desafiocasadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
