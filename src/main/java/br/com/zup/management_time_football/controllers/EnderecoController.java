package br.com.zup.management_time_football.controllers;

import br.com.zup.management_time_football.controllers.dtos.EnderecoRegisterDTO;
import br.com.zup.management_time_football.models.Endereco;
import br.com.zup.management_time_football.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody @Valid EnderecoRegisterDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setEmail(enderecoDTO.getEmail());
        endereco.setTelefone(enderecoDTO.getTelefone());

        Endereco novoEndereco = enderecoService.criarEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEndereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        List<Endereco> enderecos = enderecoService.listarEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Long id) {
        Endereco endereco = enderecoService.buscarEnderecoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado."));
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody @Valid EnderecoRegisterDTO enderecoDTO) {
        Endereco enderecoAtualizado = new Endereco();
        enderecoAtualizado.setLogradouro(enderecoDTO.getLogradouro());
        enderecoAtualizado.setNumero(enderecoDTO.getNumero());
        enderecoAtualizado.setBairro(enderecoDTO.getBairro());
        enderecoAtualizado.setCidade(enderecoDTO.getCidade());
        enderecoAtualizado.setEstado(enderecoDTO.getEstado());
        enderecoAtualizado.setEmail(enderecoDTO.getEmail());
        enderecoAtualizado.setTelefone(enderecoDTO.getTelefone());

        Endereco endereco = enderecoService.atualizarEndereco(id, enderecoAtualizado);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
