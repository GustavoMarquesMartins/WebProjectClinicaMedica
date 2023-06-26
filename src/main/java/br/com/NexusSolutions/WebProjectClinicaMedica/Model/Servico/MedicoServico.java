package br.com.NexusSolutions.WebProjectClinicaMedica.Model.Servico;

import br.com.NexusSolutions.WebProjectClinicaMedica.Model.Domain.Medico;
import br.com.NexusSolutions.WebProjectClinicaMedica.Model.HTTP.MedicoDeleteRequest;
import br.com.NexusSolutions.WebProjectClinicaMedica.Model.HTTP.MedicoRequest;
import br.com.NexusSolutions.WebProjectClinicaMedica.Model.HTTP.MedicoResponse;
import br.com.NexusSolutions.WebProjectClinicaMedica.Model.Repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServico {
    @Autowired
    private MedicoRepository medicoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public MedicoResponse cadastrar(MedicoRequest medicoRequest) {
        Medico medico = modelMapper.map(medicoRequest, Medico.class);
        Medico medicoCreated = medicoRepository.save(medico);
        return modelMapper.map(medicoCreated, MedicoResponse.class);
    }

    public List<MedicoResponse> buscarTodos() {
        List<Medico> listaMedicos = medicoRepository.findAll();
        return listaMedicos.stream()
                .map(ObjetoResponse -> modelMapper.map(ObjetoResponse, MedicoResponse.class))
                .collect(Collectors.toList());
    }

    public MedicoResponse buscar(Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        return modelMapper.map(medico, MedicoResponse.class);
    }

    public Boolean apagar(Long id) {
        medicoRepository.deleteById(id);
        return true;
    }

    public Boolean apagar(MedicoDeleteRequest medicoDeleteRequest) {
        medicoRepository.delete(modelMapper.map(medicoDeleteRequest, Medico.class));
        return true;
    }

    @Transactional
    public MedicoResponse alterar(MedicoRequest medicoRequest) {
        Medico medico = medicoRepository.getReferenceById(medicoRequest.getId());
        medico.setNome(medicoRequest.getNome());
        medico.setCelular(medicoRequest.getCelular());
        return modelMapper.map(medico, MedicoResponse.class);
    }

    @Transactional
    public MedicoResponse alterar(Long id, MedicoRequest medicoRequest) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.setNome(medicoRequest.getNome());
        return modelMapper.map(medico, MedicoResponse.class);
    }
}
