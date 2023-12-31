package br.com.NexusSolutions.Administrativo.Model.DTO;

import br.com.NexusSolutions.Administrativo.Model.Domain.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder // Anotação do Lombok para gerar um construtor padrão Builder
@Getter // Anotação do Lombok para gerar os métodos getters
@Setter // Anotação do Lombok para gerar os métodos setters
@NoArgsConstructor // Anotação do Lombok para gerar um construtor sem argumentos
@AllArgsConstructor // Anotação do Lombok para gerar um construtor com todos os argumentos
@JsonIgnoreProperties(ignoreUnknown = true) // Anotação do Jackson para ignorar propriedades desconhecidas
public class MedicoRequest {
    private Long id; // Identificador único do médico
    private String nome; // Nome do médico
    private Funcionario funcionario;
    private String celular; // Número de celular do médico
}
