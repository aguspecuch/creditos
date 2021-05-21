package ar.com.ada.creditos.exceptions;

import ar.com.ada.creditos.entities.Cliente;

public class ClienteNombreException extends ClienteInfoException {

    public ClienteNombreException(Cliente cliente, String mensaje) {
        super(cliente, mensaje);
        //TODO Auto-generated constructor stub
    }
    
}
