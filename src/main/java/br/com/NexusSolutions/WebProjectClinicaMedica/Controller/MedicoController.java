package br.com.NexusSolutions.WebProjectClinicaMedica.Controller;

import br.com.NexusSolutions.WebProjectClinicaMedica.Exception.NaoEncontradoException;
import br.com.NexusSolutions.WebProjectClinicaMedica.Model.HTTP.MedicoDeleteRequest;
import br.com.NexusSolutions.WebProjectClinicaMedica.Model.HTTP.MedicoRequest;
import br.com.NexusSolutions.WebProjectClinicaMedica.Model.HTTP.MedicoResponse;
import br.com.NexusSolutions.WebProjectClinicaMedica.Model.Servico.MedicoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoServico medicoServico;

    @GetMapping("teste")
    public void teteDeConexao() {
        System.out.println("deu certo sua conexao");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MedicoResponse cadastrar(@RequestBody MedicoRequest medicoRequest) {
        return medicoServico.cadastrar(medicoRequest);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<MedicoResponse> obterTodos() {
        return medicoServico.buscarTodos();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public MedicoResponse obter(@PathVariable("id") Long id) throws NaoEncontradoException {
        return medicoServico.buscar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public Boolean deletar(@PathVariable("id") Long id) throws NaoEncontradoException {
        return medicoServico.apagar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping()
    public Boolean deletar(@RequestBody MedicoDeleteRequest medicoDeleteRequest) throws NaoEncontradoException {
        return medicoServico.apagar(medicoDeleteRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping()
    public MedicoResponse alterar(@RequestBody MedicoRequest medicoRequest) throws NaoEncontradoException {
        return medicoServico.alterar(medicoRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "{id}")
    public MedicoResponse alterar(@PathVariable("id") Long id, @RequestBody MedicoRequest medicoRequest) throws NaoEncontradoException {
        return medicoServico.alterar(id, medicoRequest);
    }
}
