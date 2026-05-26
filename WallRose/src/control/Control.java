package control;

import java.util.ArrayList;
import java.util.List;

import logica.Cliente;
import logica.Linea;
import logica.Orden;
import logica.Producto;

public class Control {

    private static Control instancia;
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Orden> ordenes;
    private int consecutivoProducto;
    private int consecutivoOrden;

    private Control() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        ordenes = new ArrayList<>();
        consecutivoProducto = 1;
        consecutivoOrden = 1;
    }

    public static Control getInstancia() {
        if (instancia == null) {
            instancia = new Control();
        }
        return instancia;
    }

    public void agregarCliente(String id, String nombre, String email) {
        Cliente c = new Cliente(id, nombre, email);
        clientes.add(c);
    }

    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    public void agregarProducto(String nombre, int existencias, double unidad, double precio, int codigo) {
        Producto p = new Producto(consecutivoProducto, nombre, existencias, unidad, precio, codigo);
        productos.add(p);
        consecutivoProducto++;
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public Producto buscarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
    
    public Orden crearOrden(Cliente cliente) {
        Orden orden = new Orden(consecutivoOrden, cliente);
        cliente.agregarOrden(orden);
        ordenes.add(orden);
        consecutivoOrden++;
        return orden;
    }

    public void agregarLinea(Orden orden, Producto producto, double cantidad) {
        Linea linea = new Linea(orden.getLineas().size() + 1, producto, cantidad);
        orden.agregarLinea(linea);
    }

    public List<Orden> obtenerOrdenes() {
        return ordenes;
    }
}