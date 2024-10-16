package br.com.zup.management_time_football.services.mappers;

import br.com.zup.management_time_football.controllers.dtos.JogadorRegisterDTO;
import br.com.zup.management_time_football.models.Jogador;

public class JogadorMapper {

    public static Jogador fromJogadorRegisterDTO(JogadorRegisterDTO jogadorRegisterDTO){
        Jogador jogador = new Jogador();
        jogador.setNome(jogadorRegisterDTO.getNome());
        jogador.setCpf(jogadorRegisterDTO.getCpf());
        jogador.setIdade(jogadorRegisterDTO.getIdade());
        jogador.setSexo(jogadorRegisterDTO.getSexo());
        jogador.setSexo(jogadorRegisterDTO.getSexo());

        return jogador;
    }

}
