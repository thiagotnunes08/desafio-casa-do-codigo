package br.com.zup.bootcamp.desafiocasadocodigo.livro;

import br.com.zup.bootcamp.desafiocasadocodigo.autor.Autor;
import br.com.zup.bootcamp.desafiocasadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(uniqueConstraints =
@UniqueConstraint(name = "UK_titulo",columnNames = {"titulo"}))
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;


    @Column(nullable = false)
    private String resumo;


    @Column(nullable = false)
    private String sumario;


    @Column(nullable = false)
    private BigDecimal preco;


    @Column(nullable = false)
    private Integer numeroDePaginas;


    @Column(nullable = false)
    private String isbn;


    @Column(nullable = false)
    private LocalDate dataPublicacao;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Categoria categoria;

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas, String isbn, LocalDate dataPublicacao, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    @Deprecated //HIBERNATE
    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
