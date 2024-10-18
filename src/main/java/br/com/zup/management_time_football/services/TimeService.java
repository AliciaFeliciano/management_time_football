package br.com.zup.management_time_football.services;

import br.com.zup.management_time_football.models.Time;
import br.com.zup.management_time_football.repositories.TimeRepository;
import br.com.zup.management_time_football.models.Jogador;
import br.com.zup.management_time_football.repositories.JogadorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Transactional
    public Time saveTime(Time time) {
        return timeRepository.save(time);
    }

    public List<Time> showAllTimes() {
        return timeRepository.findAll();
    }

    public Time findTime(Long id) {
        return timeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Time não encontrado"));
    }

    @Transactional
    public Time updateTime(Time time) {
        findTime(time.getId());
        return timeRepository.save(time);
    }

    public void deleteTime(Long id) {
        findTime(id);
        timeRepository.deleteById(id);
    }

    @Transactional
    public Time MaximoDeJogadores(Long timeId, Jogador jogador) {
        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new EntityNotFoundException("Time não encontrado"));

        Jogador jogadorGerenciado = jogadorRepository.findById(jogador.getId())
                .orElseThrow(() -> new EntityNotFoundException("Jogador não encontrado"));

        if (time.getJogadores().size() >= 5) {
            throw new IllegalArgumentException("Limite máximo de 5 jogadores por time atingido.");
        }

        time.getJogadores().add(jogadorGerenciado);
        return timeRepository.save(time);
    }

}
