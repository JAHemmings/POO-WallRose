package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orden {

    private int numero;
    private LocalDateTime fecha;
    private EstadoOrden estado;
    private Cliente cliente;
    private List<Linea> lineas;

    public Orden(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
        this.estado = EstadoOrden.PENDIENTE;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea(Linea linea) {
        lineas.add(linea);
    }
    public double calcularSubTotal() {
        double total = 0;

        for (Linea l : lineas) {
            total += l.calcularCosto();
        }

        return total;
    }

    public double calcularImpuesto() {
        return calcularSubTotal() * 0.13;
    }

    public double calcularTotal() {
        return calcularSubTotal() + calcularImpuesto();
    }

    public void terminarOrden() {
        estado = EstadoOrden.TERMINADA;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    @Override
    public String toString() {
        return "Orden #" + numero + " - " + estado;
    }
}