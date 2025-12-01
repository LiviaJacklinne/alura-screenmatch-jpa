package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    SerieRepository repository;

    public List<SerieDTO> obterTodasAsSeries() {
        return converteDados(repository.findAll());
    }

    public List<SerieDTO> obterTop5Series() {
        return converteDados(repository.findTop5ByOrderByAvaliacaoDesc());
    }

    private List<SerieDTO> converteDados(List<Serie> series) {
        return series.stream()
                .map(s -> new SerieDTO(
                        s.getId(), s.getTitulo(),  s.getTotalTemporadas(), s.getAvaliacao(),
                        s.getGenero(),  s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> obterLancamentos() {
        return converteDados(repository.findTop5ByOrderByEpisodiosDataLancamentoDesc());
    }

    public SerieDTO obterSeriePorId(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if(serie.isPresent()) {
            Serie s = serie.get();
            return new SerieDTO(s.getId(), s.getTitulo(),  s.getTotalTemporadas(), s.getAvaliacao(),
                    s.getGenero(),  s.getAtores(), s.getPoster(), s.getSinopse());
        }
        return null;
    }
}
