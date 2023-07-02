package br.com.NexusSolutions.Agendamento.Controller;

import br.com.NexusSolutions.Agendamento.Model.DTO.AgendarConsultaRequest;
import br.com.NexusSolutions.Agendamento.Model.DTO.AgendarConsultaResponse;
import br.com.NexusSolutions.Agendamento.Model.Servico.AgendarConsultaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendarConsultaServico agendarConsultaServico;
    @GetMapping
    public void teste() {
        System.out.println("sua conexao fui realizada com sucesso ");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AgendarConsultaResponse salvar(@RequestBody AgendarConsultaRequest agendarConsultaRequest){
        return agendarConsultaServico.salvar(agendarConsultaRequest);
    }
}
