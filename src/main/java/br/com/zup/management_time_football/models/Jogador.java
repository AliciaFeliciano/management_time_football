package br.com.zup.management_time_football.models;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cpf;

    private String nome;
    private int idade;
    private String sexo;
    private LocalDate dataNasc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Jogador(){}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public @NotNull String getCpf() {return cpf;}

    public void setCpf(@NotNull String cpf) {this.cpf = cpf;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public int getIdade() {return idade;}

    public void setIdade(int idade) {this.idade = idade;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public LocalDate getDataNasc() {return dataNasc;}

    public void setDataNasc(LocalDate dataNasc) {this.dataNasc = dataNasc;}

    public Endereco getEndereco() {return endereco;}

    public void setEndereco(Endereco endereco) {this.endereco = endereco;}
}
