package br.com.zup.bootcamp.desafiocasadocodigo.autor;

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
@RequestMapping("api/autores")

public class NovoAutorController {

    @Autowired
    private final AutorRepository repository;

    public NovoAutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoAutorRequest request,UriComponentsBuilder uriComponentsBuilder){

        if (repository.existsByEmail(request.getEmail())){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"email já cadastrado no sistema!");
        }

        Autor novoAutor = request.toModel();

        repository.save(novoAutor);

        URI location = uriComponentsBuilder.path("api/autores/{id}").buildAndExpand(novoAutor.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
