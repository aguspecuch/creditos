package ar.com.ada.creditos.entities;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

@Entity
@Table (name = "prestamo")
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestamo_id")
    private int prestamoId;

    private BigDecimal importe;

    private int cuotas;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    private Cliente cliente;

    @Column(name = "estado_id")
    private int estadoId;

    @OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL)
    private List<Cancelacion> cancelaciones = new ArrayList<>();

    public int getPrestamoId() {
        return prestamoId;
    }
    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }
    
    public BigDecimal getImporte() {
        return importe;
    }
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
    public int getCuotas() {
        return cuotas;
    }
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        cliente.agregarPrestamo(this);
    }

    // ENUMERADO

    public EstadoPrestamoEnum getEstadoId() {

        return EstadoPrestamoEnum.parse(this.estadoId);
    }

    public void setEstadoId(EstadoPrestamoEnum estadoId) {
        this.estadoId = estadoId.getValue();
    }
    
    public enum EstadoPrestamoEnum {
        SOLICITADO(1), 
        RECHAZADO(2),
        PENDIENTE_APROBACION(3),
        APROBADO(4),
        INCOBRABLE(5),
        CANCELADO(6),
        PREAPROBADO(100);

        private final int value;

        // NOTE: Enum constructor tiene que estar en privado
        private EstadoPrestamoEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static EstadoPrestamoEnum parse(int id) {
            EstadoPrestamoEnum status = null; // Default
            for (EstadoPrestamoEnum item : EstadoPrestamoEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }
}
