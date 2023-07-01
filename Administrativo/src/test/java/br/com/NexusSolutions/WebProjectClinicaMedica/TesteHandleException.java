package br.com.NexusSolutions.WebProjectClinicaMedica;

import br.com.NexusSolutions.Administrativo.Exception.RegraDeNegocioException;

import java.util.Arrays;
import java.util.List;

public class TesteHandleException {

    public void Teste() throws RegraDeNegocioException {

        System.out.println("ola");
        List<String> lista = Arrays.asList("camp", "mc");
        new RegraDeNegocioException("seu sistema deu errado ", lista);
    }

    public static void main(String args[]) {
        TesteHandleException teste = new TesteHandleException();
        try {
            teste.Teste();
        } catch (RegraDeNegocioException e) {
            System.out.println(e.getMensagem());
            System.out.println(e.getCampos());
        }
    }
}
