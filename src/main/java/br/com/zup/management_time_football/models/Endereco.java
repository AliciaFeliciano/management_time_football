package br.com.zup.management_time_football.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String email;
    private String telefone;

    public Endereco() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getLogradouro() {return logradouro;}

    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}

    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
