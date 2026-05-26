package logica;

public class Linea {

    private int numero;
    private Producto producto;
    private double cantidad;
    private double precioUnitario;

    public Linea(int numero, Producto producto, double cantidad) {
        this.numero = numero;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio();
    }

    public double calcularCosto() {
        return cantidad * precioUnitario;
    }

    public int getNumero() {
        return numero;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}