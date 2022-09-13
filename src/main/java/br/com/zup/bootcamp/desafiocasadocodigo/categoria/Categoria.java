package br.com.zup.bootcamp.desafiocasadocodigo.categoria;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints =
@UniqueConstraint(name = "UK_nome",columnNames = {"nome"}))
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Deprecated // HIBERNATE
    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
