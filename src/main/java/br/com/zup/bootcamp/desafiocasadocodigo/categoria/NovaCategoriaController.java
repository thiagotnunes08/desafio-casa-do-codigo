package br.com.zup.bootcamp.desafiocasadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/categorias")
public class NovaCategoriaController {

    @Autowired
    private final CategoriaRepository repository;

    public NovaCategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@Valid @RequestBody NovaCategoriaRequest request, UriComponentsBuilder uriComponentsBuilder) {


        if (repository.existsByNome(request.getNome())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Categoria já existente no sistema!");
        }

        Categoria novaCategoria = request.toModel();


        repository.save(novaCategoria);

        URI location = uriComponentsBuilder.path("api/categorias/{id}").buildAndExpand(novaCategoria.getId()).toUri();


        return ResponseEntity.created(location).build();

    }
}
