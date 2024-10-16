package br.com.zup.management_time_football.repositories;


import br.com.zup.management_time_football.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepositorie extends JpaRepository<Jogador, Long> {
}
