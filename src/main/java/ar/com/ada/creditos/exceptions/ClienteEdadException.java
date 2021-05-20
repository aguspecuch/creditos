package ar.com.ada.creditos.exceptions;

import ar.com.ada.creditos.entities.Cliente;

public class ClienteEdadException extends ClienteInfoException {

    public ClienteEdadException(Cliente cliente, String mensaje) {
        super(cliente, mensaje);
        //TODO Auto-generated constructor stub
    }
    
}
