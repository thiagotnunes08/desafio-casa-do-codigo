package br.com.zup.bootcamp.desafiocasadocodigo.livro;

import br.com.zup.bootcamp.desafiocasadocodigo.autor.Autor;
import br.com.zup.bootcamp.desafiocasadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @DecimalMin(value = "20")
    private BigDecimal preco;

    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    @ISBN
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

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

    public Livro toModel(Categoria categoria, Autor autor) {
        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataPublicacao, autor, categoria);
    }


}
