package ar.com.ada.creditos.exceptions;

import ar.com.ada.creditos.entities.Cliente;

public class ClienteDNIException extends ClienteInfoException{

    public ClienteDNIException(Cliente cliente, String mensaje) {
        super(cliente, mensaje);
        //TODO Auto-generated constructor stub
    }
    
}
