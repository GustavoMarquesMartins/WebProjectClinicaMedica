package br.com.NexusSolutions.Administrativo.Model.DTO;

import br.com.NexusSolutions.Administrativo.Model.Domain.Funcionario;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder // Gera um padrão Builder para a classe
@Getter // Gera os métodos getters para os atributos da classe
@Setter // Gera os métodos setters para os atributos da classe
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos
@JsonInclude(JsonInclude.Include.NON_NULL) // Define que propriedades nulas não devem ser incluídas no JSON resultante

public class MedicoResponse {
    private String nome; // Nome do médico
    private Funcionario funcionario; // Funcionário associado ao médico
    private String celular; // Número de celular do médico
}
