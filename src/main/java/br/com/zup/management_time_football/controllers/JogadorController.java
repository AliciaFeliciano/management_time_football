package br.com.zup.management_time_football.controllers;

import br.com.zup.management_time_football.controllers.dtos.JogadorUpdateDTO;
import br.com.zup.management_time_football.models.Jogador;
import br.com.zup.management_time_football.controllers.dtos.JogadorRegisterDTO;
import br.com.zup.management_time_football.services.JogadorService;
import br.com.zup.management_time_football.services.mappers.JogadorMapper;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogador JogadorRegister(@RequestBody @Valid JogadorRegisterDTO jogadorRegisterDTO) {
        return jogadorService.saveJogador(JogadorMapper.fromJogadorRegisterDTO(jogadorRegisterDTO));
    }

    @GetMapping()
    public List<Jogador> showAllJogador() {
       return jogadorService.showAllJogador();

    }

    @GetMapping("/{id}")
    public Jogador findJogadorById(@PathVariable Long id) {
        return jogadorService.findJogador(id);
    }

    @PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable Long id, @RequestBody @Valid JogadorUpdateDTO jogadorUpdateDTO) {
        return jogadorService.updateJogador(JogadorMapper.fromJogadorUpdateDTO(jogadorUpdateDTO));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJogador(@PathVariable Long id) {
        jogadorService.deleteJogador(id);
    }
}
