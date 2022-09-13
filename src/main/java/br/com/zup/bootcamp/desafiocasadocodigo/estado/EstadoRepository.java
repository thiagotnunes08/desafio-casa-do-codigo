package br.com.zup.bootcamp.desafiocasadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado,Long> {
    boolean existsByNome(String nome);
}
