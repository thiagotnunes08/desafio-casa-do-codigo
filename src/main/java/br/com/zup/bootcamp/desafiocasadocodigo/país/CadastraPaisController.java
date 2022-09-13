package br.com.zup.bootcamp.desafiocasadocodigo.país;

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
@RequestMapping("api/paises")
public class CadastraPaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastra(@Valid @RequestBody NovoPaisRequest request, UriComponentsBuilder uriComponentsBuilder){

        if (repository.existsByNome(request.getNome())){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"País já existente!");
        }

        Pais novoPais = request.toModel();

        repository.save(novoPais);

        URI location = uriComponentsBuilder.path("api/paises/{id}").buildAndExpand(novoPais.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
