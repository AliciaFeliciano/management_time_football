package br.com.zup.management_time_football.services;

import br.com.zup.management_time_football.models.Jogador;
import br.com.zup.management_time_football.repositories.JogadorRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepositorie jogadorRepositorie;

    public Jogador saveJogador(Jogador jogador) {
        return jogadorRepositorie.save(jogador);
    }

    public List<Jogador> showAllJogador(){
        return jogadorRepositorie.findAll();
    }

}
