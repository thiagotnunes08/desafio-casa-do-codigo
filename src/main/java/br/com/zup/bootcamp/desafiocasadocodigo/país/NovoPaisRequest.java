package br.com.zup.bootcamp.desafiocasadocodigo.país;

import br.com.zup.bootcamp.desafiocasadocodigo.estado.Estado;
import br.com.zup.bootcamp.desafiocasadocodigo.estado.EstadoRequest;

import javax.validation.constraints.NotBlank;


public class NovoPaisRequest {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toModel(){
        return new Pais(nome);
    }
}
