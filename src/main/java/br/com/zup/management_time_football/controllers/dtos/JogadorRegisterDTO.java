package br.com.zup.management_time_football.controllers.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class JogadorRegisterDTO {
    @NotNull
    private Long id;

    @CPF(message = "cpf not valid")
    private String cpf;

    @Size(min = 3, message= "campo obrigatorio")
    private String nome;

    @Min(18)
    private int idade;

    @NotNull
    private String sexo;

    @NotNull
    private LocalDate dataNasc;

    @NotNull
    private EnderecoRegisterDTO endereco;

    @NotNull
    private Long timeId;

    public JogadorRegisterDTO() {}

    public @NotNull Long getId() {
        return id;
    }

    public void setId(@NotNull Long id) {
        this.id = id;
    }

    public String getCpf() {return cpf;}

    public void setCpf(@CPF(message = "cpf not valid") String cpf) {this.cpf = cpf;}

    public @Size(min = 3, message = "campo obrigatorio") String getNome() {
        return nome;
    }

    public void setNome(@Size(min = 3, message = "campo obrigatorio") String nome) {
        this.nome = nome;
    }

    @Min(18)
    public int getIdade() {
        return idade;
    }

    public void setIdade(@Min(18) int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public @NotNull LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(@NotNull LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public EnderecoRegisterDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRegisterDTO endereco) {
        this.endereco = endereco;
    }

    public Long getTimeId() {  // Mudança aqui
        return timeId;
    }

    public void setTimeId(Long timeId) {  // Mudança aqui
        this.timeId = timeId;
    }
}

