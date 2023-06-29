package br.com.NexusSolutions.WebProjectClinicaMedica.Model.Repository;

import br.com.NexusSolutions.WebProjectClinicaMedica.Model.Domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
