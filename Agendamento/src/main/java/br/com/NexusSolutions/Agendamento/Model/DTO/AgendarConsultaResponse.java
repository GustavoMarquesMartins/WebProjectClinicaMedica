package br.com.NexusSolutions.Agendamento.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgendarConsultaResponse {
    private String nomePaciente;
    private String nomeMedico;
    private LocalDate dataDeAgendamento;
}
