package br.com.zup.bootcamp.desafiocasadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/livros")
public class ListarLivrosController {

    @Autowired
    private final LivroRepository livroRepository;

    public ListarLivrosController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public ResponseEntity<?> lista(){

        List<LivrosResponse> listaLivros = livroRepository.findAll()
                .stream().map(livro -> (new LivrosResponse(livro.getId(), livro.getTitulo()))).toList();

        return ResponseEntity.ok().body(listaLivros);

    }
}
