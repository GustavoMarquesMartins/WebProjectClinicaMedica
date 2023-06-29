package br.com.NexusSolutions.WebProjectClinicaMedica.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NaoEncontradoException extends BaseException {

    private final HttpStatus status = HttpStatus.NOT_FOUND;
    private String mensagem;

    public NaoEncontradoException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public NaoEncontradoException() {
        super();
    }
}
