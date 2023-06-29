package br.com.NexusSolutions.WebProjectClinicaMedica.Model.Servico;

import br.com.NexusSolutions.WebProjectClinicaMedica.Exception.NaoEncontradoException;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoServico {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private ModelMapper modelMapper;

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

    public MedicoResponse buscar(Long id) throws NaoEncontradoException {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Registro não encontrado "));
        return modelMapper.map(medico, MedicoResponse.class);
    }

    public Boolean apagar(Long id) throws NaoEncontradoException {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Registro não encontrado !"));
        medicoRepository.deleteById(id);
        return true;
    }

    public Boolean apagar(MedicoDeleteRequest medicoDeleteRequest) throws NaoEncontradoException {
        medicoRepository.findById(medicoDeleteRequest.getId())
                .orElseThrow(() -> new NaoEncontradoException("Registro não encontrado !"));
        medicoRepository.delete(modelMapper.map(medicoDeleteRequest, Medico.class));
        return true;
    }

    @Transactional
    public MedicoResponse alterar(MedicoRequest medicoRequest) throws NaoEncontradoException {
        Medico medico = medicoRepository.findById(medicoRequest.getId()).
                orElseThrow(() -> new NaoEncontradoException("Registro não encontrado !"));
        medico.setNome(medicoRequest.getNome());
        medico.setCelular(medicoRequest.getCelular());
        return modelMapper.map(medico, MedicoResponse.class);
    }

    @Transactional
    public MedicoResponse alterar(Long id, MedicoRequest medicoRequest) throws NaoEncontradoException {
        Medico medico = medicoRepository.findById(id).
                orElseThrow(() -> new NaoEncontradoException("Registro não encontrado !"));
        medico.setNome(medicoRequest.getNome());
        return modelMapper.map(medico, MedicoResponse.class);
    }
}
