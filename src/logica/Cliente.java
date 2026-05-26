package logica;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String id;
    private String nombre;
    private String email;
    private List<Orden> ordenes;
    public Cliente(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.ordenes = new ArrayList<>();
    }

    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
    }

    public double calcularTotal() {
        double total = 0;
        for (Orden o : ordenes) {
            total += o.calcularTotal();
        }

        return total;
    }
    
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    @Override
    public String toString() {
        return nombre;
    }
}