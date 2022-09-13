package br.com.zup.bootcamp.desafiocasadocodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
    boolean existsByTitulo(String titulo);
}
