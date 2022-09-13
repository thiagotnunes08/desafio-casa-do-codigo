package br.com.zup.bootcamp.desafiocasadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/livros")
public class DetalhesDoLivroController {

    @Autowired
    private final LivroRepository repository;


    public DetalhesDoLivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalha(@PathVariable Long id){

        Livro livro = repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"livro não foi encontrado!"));

        return ResponseEntity.ok(new DetalhesDoLivroResponse(livro));

    }
}
