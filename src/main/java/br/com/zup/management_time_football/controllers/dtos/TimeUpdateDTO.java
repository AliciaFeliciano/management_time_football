package br.com.zup.management_time_football.controllers.dtos;

import br.com.zup.management_time_football.models.Jogador;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class TimeUpdateDTO {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 3)
    private String nome;

    @NotNull
    private String cidade;
    @NotNull
    private String estado;

    @NotNull
    private List<Jogador> jogadores;

    public TimeUpdateDTO() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public List<Jogador> getJogadores() {return jogadores;}

    public void setJogadores(List<Jogador> jogadores) {this.jogadores = jogadores;}

}

