package br.com.NexusSolutions.Agendamento.Model.Repository;

import br.com.NexusSolutions.Agendamento.Model.Domain.AgendarConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendarConsultaRepository extends JpaRepository<AgendarConsulta, Long> {
}
