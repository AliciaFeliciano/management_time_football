package br.com.zup.management_time_football.controllers.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class TimeRegisterDTO {

        @NotNull
        @Size(min = 3, message = "Nome é obrigatório")
        private String nome;

        @NotNull
        @Size(min = 3, message = "Cidade é obrigatória")
        private String cidade;

        @NotNull
        @Size(min = 2, message = "Estado é obrigatório")
        private String estado;

        @NotNull
        private List<Long> jogadoresId;

        public TimeRegisterDTO() {}

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getCidade() {
                return cidade;
        }

        public void setCidade(String cidade) {
                this.cidade = cidade;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public List<Long> getJogadoresId() {
                return jogadoresId;
        }

        public void setJogadoresId(List<Long> jogadoresId) {
                this.jogadoresId = jogadoresId;
        }
}
