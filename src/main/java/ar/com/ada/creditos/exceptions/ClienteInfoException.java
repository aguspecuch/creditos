package ar.com.ada.creditos.exceptions;

import ar.com.ada.creditos.entities.*;

public class ClienteInfoException extends Exception{
    
    private Cliente cliente;
    
    public ClienteInfoException(Cliente cliente, String mensaje){
        super(cliente.getNombre() + ":" + mensaje); // ¿De donde sale ese constructor?
        this.cliente = cliente;                     // ¿Las exceptions no tienen getters y setters?
    }
}
