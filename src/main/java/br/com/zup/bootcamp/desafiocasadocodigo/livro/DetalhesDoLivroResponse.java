package br.com.zup.bootcamp.desafiocasadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhesDoLivroResponse {

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroDePaginas;

    private String isbn;

    private LocalDate dataPublicacao;

    private String autor;

    private String categoria;

    public DetalhesDoLivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.autor = livro.getAutor().getNome();
        this.categoria = livro.getCategoria().getNome();
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

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }
}
