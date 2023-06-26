package br.com.NexusSolutions.WebProjectClinicaMedica.Model.HTTP;

import br.com.NexusSolutions.WebProjectClinicaMedica.Model.Domain.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
