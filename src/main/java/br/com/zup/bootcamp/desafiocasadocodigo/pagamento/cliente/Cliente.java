package br.com.zup.bootcamp.desafiocasadocodigo.pagamento.cliente;

import br.com.zup.bootcamp.desafiocasadocodigo.estado.Estado;
import br.com.zup.bootcamp.desafiocasadocodigo.país.Pais;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String cidade;

    @ManyToOne(optional = false)
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String telefone;

    public Cliente(String nome, String sobrenome, String email, String documento, String endereco, String complemento, String cidade, Pais pais, Estado estado, String cep, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
    }

    @Deprecated // HIBERNATE
    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
}
