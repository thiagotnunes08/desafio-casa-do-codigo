package br.com.zup.bootcamp.desafiocasadocodigo.autor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints =
@UniqueConstraint(name = "UK_email",columnNames = {"email"}))
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false,length = 400)
    private String descricao;
    @Column(nullable = false)
    private final LocalDateTime criadoEm = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
    @Deprecated // HIBERNATE
    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
