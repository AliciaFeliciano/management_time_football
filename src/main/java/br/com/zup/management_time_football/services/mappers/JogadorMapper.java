package br.com.zup.management_time_football.services.mappers;

import br.com.zup.management_time_football.controllers.dtos.JogadorRegisterDTO;
import br.com.zup.management_time_football.controllers.dtos.JogadorUpdateDTO;
import br.com.zup.management_time_football.models.Jogador;

public class JogadorMapper {

    public static Jogador fromJogadorRegisterDTO(JogadorRegisterDTO jogadorRegisterDTO){
        Jogador jogador = new Jogador();
        jogador.setNome(jogadorRegisterDTO.getNome());
        jogador.setCpf(jogadorRegisterDTO.getCpf());
        jogador.setIdade(jogadorRegisterDTO.getIdade());
        jogador.setSexo(jogadorRegisterDTO.getSexo());
        jogador.setDataNasc(jogadorRegisterDTO.getDataNasc());

        return jogador;
    }
    public static Jogador fromJogadorUpdateDTO(JogadorUpdateDTO jogadorUpdateDTO) {
        Jogador jogador = new Jogador();
        jogador.setNome(jogadorUpdateDTO.getNome());
        jogador.setCpf(jogadorUpdateDTO.getCpf());
        jogador.setIdade(jogadorUpdateDTO.getIdade());
        jogador.setSexo(jogadorUpdateDTO.getSexo());
        jogador.setDataNasc(jogadorUpdateDTO.getDataNasc());

        return jogador;
    }

}
