package com.br.BackendRPWPFlix.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.BackendRPWPFlix.exception.ResourceNotFoundException;
import com.br.BackendRPWPFlix.model.Filme;
import com.br.BackendRPWPFlix.repository.FilmeRepository;

@CrossOrigin(origins="http://localhost:4200")//porta angular
@RestController
@RequestMapping("/cfilme")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    /**
     * Disponibiliza o método HTTP GET para listar todos os filmes.
     * URL: http://localhost:8080/cfilme/filme
     * @return Lista de filmes ordenada de forma descendente por ID.
     */
    @GetMapping("/filme")
    public List<Filme> listar() {
        // Cria o objeto para ordenação descendente a partir do id.
        Sort sortBy = Sort.by(Sort.Direction.DESC, "id");
        return filmeRepository.findAll(sortBy);
    }

    /**
     * Disponibiliza o método HTTP GET para consultar um filme por ID.
     * URL: http://localhost:8080/cfilme/filme/{id}
     * @param id ID do filme a ser consultado.
     * @return Filme consultado ou erro 404 se não encontrado.
     */
    @GetMapping("/filme/{id}")
    public ResponseEntity<Filme> consultar(@PathVariable Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado: " + id));
        return ResponseEntity.ok(filme);
    }

    /**
     * Disponibiliza o método HTTP DELETE para excluir um filme por ID.
     * URL: http://localhost:8080/cfilme/filme/{id}
     * @param id ID do filme a ser excluído.
     * @return Confirmação de exclusão ou erro 404 se não encontrado.
     */
    @DeleteMapping("/filme/{id}")
    public ResponseEntity<Map<String, Boolean>> excluir(@PathVariable Long id) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado: " + id));

        filmeRepository.delete(filme);

        Map<String, Boolean> retorno = new HashMap<>();
        retorno.put("Filme excluído", Boolean.TRUE);
        return ResponseEntity.ok(retorno);
    }

    /**
     * Disponibiliza o método HTTP POST para inserir um novo filme.
     * URL: http://localhost:8080/cfilme/filme
     * @param filme Objeto filme a ser inserido.
     * @return Filme inserido.
     */
    @PostMapping("/filme")
    public Filme inserir(@RequestBody Filme filme) {
        return filmeRepository.save(filme);
    }

    /**
     * Disponibiliza o método HTTP PUT para alterar um filme existente por ID.
     * URL: http://localhost:8080/cfilme/filme/{id}
     * @param id ID do filme a ser alterado.
     * @param filme Objeto filme com as novas informações.
     * @return Filme atualizado ou erro 404 se não encontrado.
     */
    @PutMapping("/filme/{id}")
    public ResponseEntity<Filme> alterar(@PathVariable Long id, @RequestBody Filme filme) {
        Filme filmeConsult = filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado: " + id));

        filmeConsult.setId(filme.getId());
        filmeConsult.setAnolancamento(filme.getAnolancamento());
        filmeConsult.setDiretor(filme.getDiretor());
        filmeConsult.setDuracao(filme.getDuracao());
        filmeConsult.setGenero(filme.getGenero());
        filmeConsult.setTitulo(filme.getTitulo());

        Filme filmeAtualizado = filmeRepository.save(filmeConsult);
        return ResponseEntity.ok(filmeAtualizado);
    }
}
