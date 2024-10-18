package br.com.zup.management_time_football.controllers;

import br.com.zup.management_time_football.controllers.dtos.TimeRegisterDTO;
import br.com.zup.management_time_football.models.Jogador;
import br.com.zup.management_time_football.models.Time;
import br.com.zup.management_time_football.services.TimeService;
import br.com.zup.management_time_football.services.mappers.TimeMapper;
import br.com.zup.management_time_football.repositories.JogadorRepository; // Import necessário
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;
    private final JogadorRepository jogadorRepository;

    @Autowired
    public TimeController(TimeService timeService, JogadorRepository jogadorRepository) {
        this.timeService = timeService;
        this.jogadorRepository = jogadorRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Time criarTime(@RequestBody @Valid TimeRegisterDTO timeRegisterDTO) {
        Time time = TimeMapper.fromTimeRegisterDTO(timeRegisterDTO, jogadorRepository);
        return timeService.saveTime(time);
    }

    @GetMapping
    public List<Time> showAllTimes() {
        return timeService.showAllTimes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> findTimeById(@PathVariable Long id) {
        Time time = timeService.findTime(id);
        return ResponseEntity.ok(time);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> updateTime(@PathVariable Long id, @RequestBody @Valid Time time) {
        time.setId(id);
        Time updatedTime = timeService.updateTime(time);
        return ResponseEntity.ok(updatedTime);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTime(@PathVariable Long id) {
        timeService.deleteTime(id);
    }

    @PutMapping("/{timeId}/jogadores")
    public ResponseEntity<Time> MaximoJogadores(@PathVariable Long timeId, @RequestBody Jogador jogador) {
        Time timeAtualizado = timeService.MaximoDeJogadores(timeId, jogador);
        return ResponseEntity.ok(timeAtualizado);
    }
}
