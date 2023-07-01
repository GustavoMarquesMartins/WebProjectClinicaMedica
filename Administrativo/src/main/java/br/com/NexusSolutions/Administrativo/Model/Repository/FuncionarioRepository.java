package br.com.NexusSolutions.Administrativo.Model.Repository;

import br.com.NexusSolutions.Administrativo.Model.Domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
