package br.com.zup.bootcamp.desafiocasadocodigo.estado;

import br.com.zup.bootcamp.desafiocasadocodigo.país.Pais;

import javax.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @ManyToOne(optional = false)
    private Pais pais;

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated // HIBERNATE
    public Estado() {
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }


}
