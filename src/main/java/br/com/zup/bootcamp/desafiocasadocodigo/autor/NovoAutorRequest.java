package br.com.zup.bootcamp.desafiocasadocodigo.autor;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoAutorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toModel() {
        return new Autor(nome,email,descricao);
    }
}
