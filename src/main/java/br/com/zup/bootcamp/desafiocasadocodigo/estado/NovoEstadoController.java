package br.com.zup.bootcamp.desafiocasadocodigo.estado;

import br.com.zup.bootcamp.desafiocasadocodigo.país.PaisRepository;
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
@RequestMapping("/api/estados")
public class NovoEstadoController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@Valid @RequestBody EstadoRequest request, UriComponentsBuilder uriComponentsBuilder){

        if (estadoRepository.existsByNome(request.getNome())){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Estado já existente!");
        }

        Estado novoEstado = request.toModel(paisRepository);

        estadoRepository.save(novoEstado);

        URI location = uriComponentsBuilder.path("/estados/{id}").buildAndExpand(novoEstado.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
