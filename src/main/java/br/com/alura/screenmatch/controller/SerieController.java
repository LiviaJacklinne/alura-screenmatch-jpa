package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping
    public List<SerieDTO> obterSeries () {
        return service.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5Series () {
        return service.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentos () {
        return service.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterSeriePorId (@PathVariable Long id) {
        return service.obterSeriePorId(id);
    }
}
