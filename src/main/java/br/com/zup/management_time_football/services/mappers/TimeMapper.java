package br.com.zup.management_time_football.services.mappers;

import br.com.zup.management_time_football.controllers.dtos.TimeRegisterDTO;
import br.com.zup.management_time_football.controllers.dtos.TimeUpdateDTO;
import br.com.zup.management_time_football.models.Jogador;
import br.com.zup.management_time_football.models.Time;
import br.com.zup.management_time_football.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TimeMapper {

    @Autowired
    private static JogadorRepository jogadorRepository;



    public static Time fromTimeRegisterDTO(TimeRegisterDTO timeRegisterDTO, JogadorRepository jogadorRepository) {
        Time time = new Time();
        time.setNome(timeRegisterDTO.getNome());
        time.setCidade(timeRegisterDTO.getCidade());
        time.setEstado(timeRegisterDTO.getEstado());

        List<Jogador> jogadores = timeRegisterDTO.getJogadoresId().stream()
                .map(jogadorId -> jogadorRepository.findById(jogadorId)
                        .orElseThrow(() -> new RuntimeException("Jogador não encontrado")))
                .collect(Collectors.toList());

        time.setJogadores(jogadores);
        return time;
    }

    public static Time fromTimeUpdateDTO(TimeUpdateDTO timeUpdateDTO, Time timeExistente) {
        timeExistente.setNome(timeUpdateDTO.getNome());
        timeExistente.setCidade(timeUpdateDTO.getCidade());
        timeExistente.setEstado(timeUpdateDTO.getEstado());
        timeExistente.setJogadores(timeUpdateDTO.getJogadores());
        return timeExistente;
    }
}
