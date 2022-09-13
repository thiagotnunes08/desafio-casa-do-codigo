package br.com.zup.bootcamp.desafiocasadocodigo.estado;

import br.com.zup.bootcamp.desafiocasadocodigo.país.Pais;
import br.com.zup.bootcamp.desafiocasadocodigo.país.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    private String nome;
    @NotNull
    private Long paisId;

    public Long getPaisId() {
        return paisId;
    }

    public String getNome() {
        return nome;
    }

    public Estado toModel(PaisRepository paisRepository) {

        Pais pais = paisRepository.findById(paisId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "País não encontrado ou não existente"));

        return new Estado(nome,pais);

    }
}
