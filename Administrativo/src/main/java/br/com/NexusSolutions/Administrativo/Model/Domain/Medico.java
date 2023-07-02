package br.com.NexusSolutions.Administrativo.Model.Domain;

import jakarta.persistence.*;
import lombok.*;

@Entity // Indica que a classe é uma entidade persistente
@Table(name = "medicos") // Especifica o nome da tabela correspondente a esta entidade como "medicos"
@Builder // Gera um construtor Builder para facilitar a criação de instâncias
@Getter // Gera métodos getter para os atributos
@Setter // Gera métodos setter para os atributos
@NoArgsConstructor // Gera um construtor vazio
@AllArgsConstructor // Gera um construtor que aceita todos os argumentos dos atributos
@Data // Gera automaticamente os métodos toString, equals, hashCode, entre outros
public class Medico {
    @Id // Indica que o atributo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração do valor do 'id'
    private Long id; // Identificador único do médico

    private String nome; // Nome do médico

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // Associação muitos-para-um com a entidade 'Funcionario'
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    // Coluna de junção referenciando a chave primária da tabela 'funcionarios'
    private Funcionario funcionario; // Funcionário associado ao médico

    private String celular; // Número de celular do médico;
}
