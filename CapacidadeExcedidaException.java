package br.com.starlog.exception;

import javax.naming.LimitExceededException;

public class CapacidadeExcedidaException extends Exception {
    public CapacidadeExcedidaException(String message) throws LimitExceededException{
        throw new LimitExceededException(message);
    }
}
