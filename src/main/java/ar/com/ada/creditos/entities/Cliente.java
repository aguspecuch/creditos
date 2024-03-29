package ar.com.ada.creditos.entities;

import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NaturalId;

import ar.com.ada.creditos.exceptions.ClienteDNIException;
import ar.com.ada.creditos.exceptions.ClienteNombreException;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int clienteId;
    private String nombre;
    @NaturalId
    private int dni;
    private String direccion;
    @Column(name = "direccion_alternativa")
    private String direccionAlternativa;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE) 
    private List<Prestamo> prestamos = new ArrayList<>();

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente() {
    }

    // toString es un metodo 'default' de todos los objetos que da un nombre largo y
    // feo.
    // Se hace un override para cambiarlo y que de un nombre mas lindo.
    @Override
    public String toString() {
        return "Cliente [id=" + clienteId + ", dni=" + dni + ", nombre=" + nombre + "]";
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ClienteNombreException {

        if (nombre.equals("")) {
            throw new ClienteNombreException(this, "no ingreso un nombre valido");
        }

        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) throws ClienteDNIException {

        if (dni < 0) {
            // no se ejecuta nada mas despues del throw
            throw new ClienteDNIException(this, "ocurrio un error con el DNI");
        }

        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionAlternativa() {
        return direccionAlternativa;
    }

    public void setDireccionAlternativa(String direccionAlternativa) {
        this.direccionAlternativa = direccionAlternativa;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void agregarPrestamo(Prestamo prestamo){
        this.prestamos.add(prestamo);
    }
}
