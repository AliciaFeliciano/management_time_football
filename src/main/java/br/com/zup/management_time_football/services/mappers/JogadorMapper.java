package br.com.zup.management_time_football.services.mappers;

import br.com.zup.management_time_football.controllers.dtos.JogadorRegisterDTO;
import br.com.zup.management_time_football.controllers.dtos.JogadorUpdateDTO;
import br.com.zup.management_time_football.models.Endereco;
import br.com.zup.management_time_football.models.Jogador;
import br.com.zup.management_time_football.models.Time;

public class JogadorMapper {

    public static Jogador fromJogadorRegisterDTO(JogadorRegisterDTO jogadorRegisterDTO) {
        Jogador jogador = new Jogador();
        jogador.setId(jogadorRegisterDTO.getId());
        jogador.setNome(jogadorRegisterDTO.getNome());
        jogador.setCpf(jogadorRegisterDTO.getCpf());
        jogador.setIdade(jogadorRegisterDTO.getIdade());
        jogador.setSexo(jogadorRegisterDTO.getSexo());
        jogador.setDataNasc(jogadorRegisterDTO.getDataNasc());

        if (jogadorRegisterDTO.getEndereco() != null) {
            Endereco endereco = EnderecoMapper.fromEnderecoRegisterDTO(jogadorRegisterDTO.getEndereco());
            jogador.setEndereco(endereco);
        }

        return jogador;
    }


    public static Jogador fromJogadorUpdateDTO(JogadorUpdateDTO jogadorUpdateDTO) {
        Jogador jogador = new Jogador();
        jogador.setId(jogadorUpdateDTO.getId());
        jogador.setNome(jogadorUpdateDTO.getNome());
        jogador.setCpf(jogadorUpdateDTO.getCpf());
        jogador.setIdade(jogadorUpdateDTO.getIdade());
        jogador.setSexo(jogadorUpdateDTO.getSexo());
        jogador.setDataNasc(jogadorUpdateDTO.getDataNasc());

        if (jogadorUpdateDTO.getEndereco() != null) {
            Endereco endereco = new Endereco();
            endereco.setId(jogadorUpdateDTO.getEndereco().getId());
            jogador.setEndereco(endereco);
        }

        return jogador;
    }
}
