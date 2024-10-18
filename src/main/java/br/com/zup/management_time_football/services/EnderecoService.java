package br.com.zup.management_time_football.services;

import br.com.zup.management_time_football.models.Endereco;
import br.com.zup.management_time_football.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco atualizarEndereco(Long id, Endereco enderecoAtualizado) {
        Endereco enderecoExistente = enderecoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado."));


        enderecoExistente.setLogradouro(enderecoAtualizado.getLogradouro());
        enderecoExistente.setNumero(enderecoAtualizado.getNumero());
        enderecoExistente.setBairro(enderecoAtualizado.getBairro());
        enderecoExistente.setCidade(enderecoAtualizado.getCidade());
        enderecoExistente.setEstado(enderecoAtualizado.getEstado());
        enderecoExistente.setEmail(enderecoAtualizado.getEmail());
        enderecoExistente.setTelefone(enderecoAtualizado.getTelefone());

        return enderecoRepository.save(enderecoExistente);
    }

    public void deletarEndereco(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new IllegalArgumentException("Endereço não encontrado.");
        }
        enderecoRepository.deleteById(id);
    }
}
