package br.com.zup.bootcamp.desafiocasadocodigo.pagamento.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    boolean existsByEmail(String email);
}
