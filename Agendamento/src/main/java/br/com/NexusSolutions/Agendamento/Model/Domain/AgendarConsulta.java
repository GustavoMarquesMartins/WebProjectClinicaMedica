package br.com.NexusSolutions.Agendamento.Model.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "agendarconsultas")
public class AgendarConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_paciente")
    private String nomePaciente;
    @Column(name = "nome_medico")
    private String nomeMedico;
    @Column(name = "data_agendamento")
    private LocalDate dataDeAgendamento;
}
