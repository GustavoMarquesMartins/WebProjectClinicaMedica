package br.com.NexusSolutions.Administrativo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseException handleException(RegraDeNegocioException regraDeNegocioException) {
        return ResponseException.builder()
                .mensagem(regraDeNegocioException.getMensagem())
                .campos(regraDeNegocioException.getCampos())
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseException handleException(NaoEncontradoException naoEncontradoException) {
        return ResponseException.builder()
                .httpCode(naoEncontradoException.getStatus().value())
                .originalError(naoEncontradoException.getMessage())
                .mensagem(naoEncontradoException.getMensagem())
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseException handleException(Exception exception) {
        return ResponseException.builder()
                .httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .originalError(exception.getMessage())
                .mensagem("Erro inesperado!")
                .campos(null)
                .build();
    }

}
