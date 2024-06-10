package com.br.BackendRPWPFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.BackendRPWPFlix.model.Filme;
import com.br.BackendRPWPFlix.repository.FilmeRepository;

@RestController
@RequestMapping("/cfilme")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    // Método responsável por disponibilizar o método HTTP GET - http://localhost:8080/cfilme/filme
    @GetMapping("/filme")
    public List<Filme> listar() {
        // Cria o objeto para ordenação descendente a partir do id.
        Sort sortBy = Sort.by(Sort.Direction.DESC, "id");
        return filmeRepository.findAll(sortBy);
    }
}
