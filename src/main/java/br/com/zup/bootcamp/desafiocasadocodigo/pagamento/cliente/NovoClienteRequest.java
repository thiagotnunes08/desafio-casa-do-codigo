package br.com.zup.bootcamp.desafiocasadocodigo.pagamento.cliente;

import br.com.zup.bootcamp.desafiocasadocodigo.compartilhado.CPForCNPJ;
import br.com.zup.bootcamp.desafiocasadocodigo.estado.Estado;
import br.com.zup.bootcamp.desafiocasadocodigo.estado.EstadoRepository;
import br.com.zup.bootcamp.desafiocasadocodigo.país.Pais;
import br.com.zup.bootcamp.desafiocasadocodigo.país.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoClienteRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @Email
    @NotBlank
    private String email;
    @CPForCNPJ
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long paisId;
    private Long estadoId;
    @NotBlank
    private String cep;
    @NotBlank
    private String telefone;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSobrenome() {
        return sobrenome;
    }



    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Pais possivelPais = paisRepository.findById(paisId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "País não encontrado!"));

        Optional<Estado> possivelEstado = estadoRepository.findById(estadoId);

        if (possivelEstado.isPresent()) {

            Estado estado = possivelEstado.get();

            return new Cliente(nome, sobrenome, email, documento, endereco, complemento, cidade, possivelPais, estado, cep, telefone);
        }


        return new Cliente(nome, sobrenome, email, documento, endereco, complemento, cidade, possivelPais, null, cep, telefone);

    }

}
