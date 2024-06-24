package com.br.BackendRPWPFlix.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.BackendRPWPFlix.exception.ResourceNotFoundException;
import com.br.BackendRPWPFlix.model.Filme;
import com.br.BackendRPWPFlix.repository.FilmeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin(origins = "http://localhost:4200") // porta angular
@RestController
@RequestMapping("/cfilme")
@Api(value = "Filme Controller", tags = "Filme")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("/filme")
    @ApiOperation(value = "Lista todos os filmes cadastrados", response = List.class)
    public List<Filme> listar() {
        Sort sortBy = Sort.by(Sort.Direction.DESC, "id");
        return filmeRepository.findAll(sortBy);
    }

    @GetMapping("/filme/{id}")
    @ApiOperation(value = "Consulta um filme pelo ID", response = Filme.class)
    public ResponseEntity<Filme> consultar(
            @ApiParam(value = "ID do filme a ser consultado", required = true) @PathVariable Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado: " + id));
        return ResponseEntity.ok(filme);
    }

    @DeleteMapping("/filme/{id}")
    @ApiOperation(value = "Exclui um filme pelo ID")
    public ResponseEntity<Map<String, Boolean>> excluir(
            @ApiParam(value = "ID do filme a ser excluído", required = true) @PathVariable Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado: " + id));

        filmeRepository.delete(filme);

        Map<String, Boolean> retorno = new HashMap<>();
        retorno.put("Filme excluído", Boolean.TRUE);
        return ResponseEntity.ok(retorno);
    }

    @PostMapping("/filme")
    @ApiOperation(value = "Insere um novo filme", response = Filme.class)
    public Filme inserir(
            @ApiParam(value = "filme a ser inserido", required = true) @Validated @RequestBody Filme filme) {
        return filmeRepository.save(filme);
    }

    @PutMapping("/filme/{id}")
    @ApiOperation(value = "Atualiza um filme pelo ID", response = Filme.class)
    public ResponseEntity<Filme> alterar(
            @ApiParam(value = "ID do filme a ser atualizado", required = true) @PathVariable Long id,
            @ApiParam(value = "filme com as novas informações", required = true) @Validated @RequestBody Filme filme) {
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
