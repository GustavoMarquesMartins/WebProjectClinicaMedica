package br.com.NexusSolutions.Agendamento.Model.Servico;

import br.com.NexusSolutions.Agendamento.Model.Domain.AgendarConsulta;
import br.com.NexusSolutions.Agendamento.Model.DTO.AgendarConsultaRequest;
import br.com.NexusSolutions.Agendamento.Model.DTO.AgendarConsultaResponse;
import br.com.NexusSolutions.Agendamento.Model.Repository.AgendarConsultaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendarConsultaServico {


    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AgendarConsultaRepository agendarConsultaRepository;

    public AgendarConsultaResponse salvar(AgendarConsultaRequest agendarConsultaRequest) {
        return salvarRetornarResponse(agendarConsultaRequest);
    }

    public AgendarConsultaResponse salvarRetornarResponse(AgendarConsultaRequest agendarConsultaRequest) {
        AgendarConsulta agendarConsultaCreated = agendarConsultaRepository
                .save(modelMapper.map(agendarConsultaRequest, AgendarConsulta.class));
        return modelMapper.map(agendarConsultaCreated, AgendarConsultaResponse.class);
    }

}
