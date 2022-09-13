package br.com.zup.bootcamp.desafiocasadocodigo.pagamento.cliente;

import br.com.zup.bootcamp.desafiocasadocodigo.estado.EstadoRepository;
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
@RequestMapping("/api/clientes")
public class NovoClienteController {

    @Autowired
    private final PaisRepository paisRepository;

    @Autowired
    private final EstadoRepository estadoRepository;

    @Autowired
    private final ClienteRepository clienteRepository;

    public NovoClienteController(PaisRepository paisRepository, EstadoRepository estadoRepository, ClienteRepository clienteRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@Valid @RequestBody NovoClienteRequest request, UriComponentsBuilder uriComponentsBuilder) {

        if (clienteRepository.existsByEmail(request.getEmail())){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"email já existente no sistema!");
        }

        Cliente novoCliente = request.toModel(paisRepository,estadoRepository);

        clienteRepository.save(novoCliente);

        URI location = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(novoCliente.getId()).toUri();


        return ResponseEntity.created(location).body(new ClienteResponse(novoCliente));
    }
}
