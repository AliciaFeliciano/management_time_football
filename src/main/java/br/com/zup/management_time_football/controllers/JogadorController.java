package br.com.zup.management_time_football.controllers;

import br.com.zup.management_time_football.models.Jogador;
import br.com.zup.management_time_football.controllers.dtos.JogadorRegisterDTO;
import br.com.zup.management_time_football.services.JogadorService;
import br.com.zup.management_time_football.services.mappers.JogadorMapper;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public Jogador JogadorRegister(@RequestBody @Valid JogadorRegisterDTO jogadorRegisterDTO) {
        return jogadorService.saveJogador(JogadorMapper.fromJogadorRegisterDTO(jogadorRegisterDTO));
    }


}
