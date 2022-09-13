package br.com.zup.bootcamp.desafiocasadocodigo.país;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais,Long> {
    boolean existsByNome(String nome);
}
