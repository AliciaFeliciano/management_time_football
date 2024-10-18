package br.com.zup.management_time_football.services;

import br.com.zup.management_time_football.models.Jogador;
import br.com.zup.management_time_football.models.Time;
import br.com.zup.management_time_football.repositories.JogadorRepository;
import br.com.zup.management_time_football.repositories.TimeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final TimeRepository timeRepository;


    public JogadorService(JogadorRepository jogadorRepository, TimeRepository timeRepository) {
        this.jogadorRepository = jogadorRepository;
        this.timeRepository = timeRepository;
    }

    public Jogador saveJogador(Jogador jogador, Long timeId) {

        if (jogadorRepository.existsByCpf(jogador.getCpf())) {
            throw new IllegalArgumentException("Já existe um jogador cadastrado com esse CPF.");
        }


        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new IllegalArgumentException("Time não encontrado"));


        jogador.setTime(time);



        return jogadorRepository.save(jogador);
    }



    public List<Jogador> showAllJogador() {
        return jogadorRepository.findAll();
    }


    public Jogador findJogador(Long id) {
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogador não encontrado"));
    }

    @Transactional
    public Jogador updateJogador(Jogador jogador) {

        Jogador jogadorDB = findJogador(jogador.getId());

        if (!jogadorDB.getCpf().equals(jogador.getCpf())) {
            if (jogadorRepository.existsByCpf(jogador.getCpf())) {
                throw new IllegalArgumentException("Já existe um jogador cadastrado com esse CPF.");
            }
            jogadorDB.setCpf(jogador.getCpf());
        }

        jogadorDB.setNome(jogador.getNome());
        jogadorDB.setIdade(jogador.getIdade());
        jogadorDB.setSexo(jogador.getSexo());
        jogadorDB.setDataNasc(jogador.getDataNasc());
        jogadorDB.setEndereco(jogador.getEndereco());

        return jogadorRepository.save(jogadorDB);
    }

    @Transactional
    public void deleteJogador(Long id) {
        Jogador jogador = findJogador(id);
        jogadorRepository.deleteById(jogador.getId());
    }
}
