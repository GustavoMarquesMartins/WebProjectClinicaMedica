package br.com.NexusSolutions.WebProjectClinicaMedica.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class RegraDeNegocioException extends BaseException {
    private final HttpStatus status = HttpStatus.BAD_REQUEST;
    private final String mensagem;
    private final List<String> campos;
}