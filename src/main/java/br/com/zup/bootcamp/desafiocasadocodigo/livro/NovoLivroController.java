package br.com.zup.bootcamp.desafiocasadocodigo.livro;

import br.com.zup.bootcamp.desafiocasadocodigo.autor.Autor;
import br.com.zup.bootcamp.desafiocasadocodigo.autor.AutorRepository;
import br.com.zup.bootcamp.desafiocasadocodigo.categoria.Categoria;
import br.com.zup.bootcamp.desafiocasadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/livros")
public class NovoLivroController {

    @Autowired
    private final CategoriaRepository categoriaRepository;
    @Autowired

    private final AutorRepository autorRepository;
    @Autowired

    private final LivroRepository livroRepository;

    public NovoLivroController(CategoriaRepository categoriaRepository,
                               AutorRepository autorRepository,
                               LivroRepository livroRepository) {

        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }


    @PostMapping("/categoria/{categoriaId}/autor/{autorId}")
    public ResponseEntity<?> cadastra(@Valid @RequestBody NovoLivroRequest request,
                                      @PathVariable Long categoriaId,
                                      @PathVariable Long autorId, UriComponentsBuilder uriComponentsBuilder){

        if (livroRepository.existsByTitulo(request.getTitulo())){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"titulo já existente no sistema!");
        }

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "categoria não encontrada!"));

        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"autor não encontrado!"));


        Livro novoLivro = request.toModel(categoria,autor);

        livroRepository.save(novoLivro);

        URI location = uriComponentsBuilder.path("api/livros/{livroId}/categoria/{categoriaId}/autor/{autorId}")
                .buildAndExpand(novoLivro.getId(),categoria.getId(),autor.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
