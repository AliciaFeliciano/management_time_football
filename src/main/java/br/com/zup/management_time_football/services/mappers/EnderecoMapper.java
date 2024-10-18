package br.com.zup.management_time_football.services.mappers;

import br.com.zup.management_time_football.controllers.dtos.EnderecoRegisterDTO;
import br.com.zup.management_time_football.controllers.dtos.EnderecoUpdateDTO;
import br.com.zup.management_time_football.models.Endereco;

public class EnderecoMapper {

    public static Endereco fromEnderecoRegisterDTO(EnderecoRegisterDTO enderecoRegisterDTO) {
        Endereco endereco = new Endereco();
        endereco.setBairro(enderecoRegisterDTO.getBairro());
        endereco.setCidade(enderecoRegisterDTO.getCidade());
        endereco.setEstado(enderecoRegisterDTO.getEstado());
        endereco.setLogradouro(enderecoRegisterDTO.getLogradouro());
        endereco.setNumero(enderecoRegisterDTO.getNumero());
        endereco.setEmail(enderecoRegisterDTO.getEmail());
        endereco.setTelefone(enderecoRegisterDTO.getTelefone());

        return endereco;
    }

    public static Endereco fromEnderecoUpdateDTO(EnderecoUpdateDTO enderecoUpdateDTO) {
        Endereco endereco = new Endereco();
        endereco.setId(enderecoUpdateDTO.getId());
        endereco.setBairro(enderecoUpdateDTO.getBairro());
        endereco.setCidade(enderecoUpdateDTO.getCidade());
        endereco.setEstado(enderecoUpdateDTO.getEstado());
        endereco.setLogradouro(enderecoUpdateDTO.getLogradouro());
        endereco.setNumero(enderecoUpdateDTO.getNumero());
        endereco.setEmail(enderecoUpdateDTO.getEmail());
        endereco.setTelefone(enderecoUpdateDTO.getTelefone());

        return endereco;
    }
}

