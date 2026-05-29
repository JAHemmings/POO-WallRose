package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import control.Control;
import logica.Cliente;
import logica.Linea;
import logica.Orden;
import logica.Producto;

public class VentanaOrdenes extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JComboBox<Cliente> comboClientes;
    private DefaultTableModel modelo;
    private Control control;
    private Orden ordenActual;

    public VentanaOrdenes() {
        control = Control.getInstancia();

        setTitle("Órdenes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(30, 30, 100, 25);
        contentPane.add(lblCliente);

        comboClientes = new JComboBox<>();
        comboClientes.setBounds(120, 30, 220, 25);
        contentPane.add(comboClientes);

        JButton btnCrearOrden = new JButton("Crear Orden");
        btnCrearOrden.setBounds(400, 30, 150, 35);
        contentPane.add(btnCrearOrden);

        JButton btnAgregarLinea = new JButton("Agregar Línea");
        btnAgregarLinea.setBounds(580, 30, 150, 35);
        contentPane.add(btnAgregarLinea);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 120, 700, 280);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnTerminar = new JButton("Terminar Orden");
        btnTerminar.setBounds(290, 430, 180, 40);
        contentPane.add(btnTerminar);

        modelo = new DefaultTableModel();
        modelo.addColumn("Línea");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Subtotal");

        table.setModel(modelo);

        cargarClientes();

        btnCrearOrden.addActionListener(e -> {
            crearOrden();
        });

        btnAgregarLinea.addActionListener(e -> {
            agregarLinea();
        });

        btnTerminar.addActionListener(e -> {
            terminarOrden();
        });
    }

    public void cargarClientes() {
        comboClientes.removeAllItems();
        for (Cliente c : control.obtenerClientes()) {
            comboClientes.addItem(c);
        }
    }

    public void crearOrden() {
        Cliente cliente =(Cliente) comboClientes.getSelectedItem();
        if (cliente == null) {
            JOptionPane.showMessageDialog(this,"Debe seleccionar un cliente");
            return;
        }
        ordenActual = control.crearOrden(cliente);
        modelo.setRowCount(0);
        JOptionPane.showMessageDialog(this,"Orden creada correctamente");
    }

    public void agregarLinea() {
        if (ordenActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear una orden");
            return;
        }

        try {
            String codigoTexto = JOptionPane.showInputDialog(this, "Código del producto");
            int codigo = Integer.parseInt(codigoTexto);
            Producto producto = control.buscarProducto(codigo);
            if (producto == null) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
                return;
            }

            String cantidadTexto = JOptionPane.showInputDialog(this,"Cantidad");
            double cantidad = Double.parseDouble(cantidadTexto);
            control.agregarLinea(ordenActual, producto, cantidad);
            cargarLineas();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar línea");
        }
    }

    public void cargarLineas() {
        modelo.setRowCount(0);
        for (Linea l : ordenActual.getLineas()) {
            Object[] fila = {
                    l.getNumero(),
                    l.getProducto().getNombre(),
                    l.getCantidad(),
                    l.calcularCosto()
            };
            modelo.addRow(fila);
        }
    }

    public void terminarOrden() {
        if (ordenActual == null) {
            JOptionPane.showMessageDialog(this,"No hay orden activa");
            return;
        }

        JOptionPane.showMessageDialog(this, "Orden terminada\nTotal: "+ ordenActual.calcularTotal());
        ordenActual = null;
        modelo.setRowCount(0);
    }
}
}
