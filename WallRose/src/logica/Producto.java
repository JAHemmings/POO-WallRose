package logica;

public class Producto {

    private int consecutivo;
    private String nombre;
    private int existencias;
    private double unidad;
    private double precio;
    private int codigo;

    public Producto(int consecutivo, String nombre, int existencias, double unidad,  double precio, int codigo) {

        this.consecutivo = consecutivo;
        this.nombre = nombre;
        this.existencias = existencias;
        this.unidad = unidad;
        this.precio = precio;
        this.codigo = codigo;
    }
    
    public void agregarProducto(String nombre, int existencias, double unidad, double precio) {

this.nombre = nombre;
this.existencias = existencias;
this.unidad = unidad;
this.precio = precio;
}

public void editarProducto(String nombre, int existencias, double unidad, double precio) {

this.nombre = nombre;
this.existencias = existencias;
this.unidad = unidad;
this.precio = precio;
}

public int getConsecutivo() {
return consecutivo;
}

public String getNombre() {
return nombre;
}

public int getExistencias() {
return existencias;
}

public double getUnidad() {
return unidad;
}

public double getPrecio() {
return precio;
}

public int getCodigo() {
return codigo;
}

@Override
public String toString() {
return nombre + " - ₡" + precio;
}
}