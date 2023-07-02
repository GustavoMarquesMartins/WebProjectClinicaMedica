package br.com.NexusSolutions.Administrativo.Exception;

// Classe BaseException que estende a classe Exception
public class BaseException extends Exception {

    // Construtor da classe BaseException que recebe uma mensagem como argumento
    public BaseException(String mensagem) {
        super(mensagem); // Chama o construtor da classe pai Exception passando a mensagem como argumento
    }

    // Construtor padrão da classe BaseException sem argumentos
    public BaseException() {
        super(); // Chama o construtor padrão da classe pai Exception
    }
}
