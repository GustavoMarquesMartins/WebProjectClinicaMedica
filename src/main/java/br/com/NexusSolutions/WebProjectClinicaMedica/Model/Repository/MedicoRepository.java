package br.com.NexusSolutions.WebProjectClinicaMedica.Model.Repository;

import br.com.NexusSolutions.WebProjectClinicaMedica.Model.Domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Interface que define o repositório para a entidade Medico
    // Extende a interface JpaRepository fornecida pelo Spring Data JPA

    // A interface JpaRepository já fornece métodos prontos para realizar operações de persistência
    // Esses métodos incluem operações de CRUD (Create, Read, Update, Delete) no banco de dados

    // Medico: Tipo de entidade que o repositório manipula (neste caso, a entidade Medico)
    // Long: Tipo de dado do identificador (chave primária) da entidade Medico

    // Ao estender a interface JpaRepository, o MedicoRepository herda métodos como save, findById, findAll, delete, etc.
    // Esses métodos podem ser usados para realizar operações de persistência no banco de dados para a entidade Medico

    // O Spring Data JPA se encarrega de implementar automaticamente esses métodos com base nas convenções de nomenclatura e nas anotações presentes na entidade Medico
}
