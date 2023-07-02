package br.com.NexusSolutions.Administrativo.Model.DTO;

import br.com.NexusSolutions.Administrativo.Model.Domain.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicoDeleteRequest {
    private Long id;
    private String nome;
    private Funcionario funcionario;
    private String celular;
}
