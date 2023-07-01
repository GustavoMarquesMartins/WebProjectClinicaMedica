package br.com.NexusSolutions.Administrativo.Model.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "funcionarios") // Indica que a classe é uma entidade persistente com o nome "funcionarios"
@Builder // Fornece um construtor de objeto builder para a classe
@Getter // Gera automaticamente os métodos getters para os atributos da classe
@Setter // Gera automaticamente os métodos setters para os atributos da classe
@NoArgsConstructor // Gera um construtor sem argumentos para a classe
@AllArgsConstructor // Gera um construtor com todos os argumentos para a classe
@Data // Gera automaticamente os métodos equals, hashCode, toString e outros

public class Funcionario {
    @Id // Indica que o atributo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura a estratégia de geração de valor automático para a chave primária
    private Long id;

    @Column(name = "nome_funcionario", nullable = false)
    // Mapeia o atributo para uma coluna no banco de dados com o nome "nome_funcionario" e que não pode ser nulo
    private String nomeFuncionario;

    @Column(name = "data_nascimento", nullable = false)
    // Mapeia o atributo para uma coluna no banco de dados com o nome "data_nascimento" e que não pode ser nulo
    private LocalDate dataNascimento;
}
