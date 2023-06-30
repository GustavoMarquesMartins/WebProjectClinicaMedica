package br.com.NexusSolutions.WebProjectClinicaMedica.validations;

import br.com.NexusSolutions.WebProjectClinicaMedica.Exception.RegraDeNegocioException;
import br.com.NexusSolutions.WebProjectClinicaMedica.Model.HTTP.MedicoRequest;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@Builder
public class MedicoValidacao {
    @Autowired
    private MedicoRequest medicoRequest;
    public void validarParametros(MedicoRequest medicoRequest) throws RegraDeNegocioException {
        List<String> camposObrigatorios = new ArrayList<>();
        if (medicoRequest.getNome() == null || medicoRequest.getNome().isEmpty()) {
            camposObrigatorios.add("nomeMedico");
        }
        if (medicoRequest.getFuncionario() == null) {
            camposObrigatorios.add("Funcionario");
        }
        if (medicoRequest.getCelular() == null || medicoRequest.getCelular().isEmpty()) {
            camposObrigatorios.add("Celular");
        }
        if (!camposObrigatorios.isEmpty()) {
            throw new RegraDeNegocioException("preencha os campos obrigátorios!", camposObrigatorios);
        }
    }
}
