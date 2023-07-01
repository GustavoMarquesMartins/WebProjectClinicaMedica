package br.com.NexusSolutions.Administrativo.Exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ResponseException {
    private String originalError;
    private int httpCode;
    private String mensagem;
    private List<String> campos;
}
