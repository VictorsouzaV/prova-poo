package br.com.starlog.exception;


public class codigoCategoriaInvalidoException extends Exception{
    public codigoCategoriaInvalidoException(String message) throws IllegalArgumentException{
        throw new IllegalArgumentException(message);
    }
}
