package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import control.Control;
import logica.Producto;

public class VentanaProductos extends JFrame {

    private JPanel contentPane;

    private JTextField txtNombre;
    private JTextField txtExistencias;
    private JTextField txtUnidad;
    private JTextField txtPrecio;
    private JTextField txtCodigo;
    private JTable table;
    private DefaultTableModel modelo;
    private Control control;

    public VentanaProductos() {
        control = Control.getInstancia();

        setTitle("Productos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(30, 30, 100, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 30, 200, 25);
        contentPane.add(txtNombre);

        JLabel lblExistencias = new JLabel("Existencias");
        lblExistencias.setBounds(30, 70, 100, 25);
        contentPane.add(lblExistencias);

        txtExistencias = new JTextField();
        txtExistencias.setBounds(140, 70, 200, 25);
        contentPane.add(txtExistencias);

        JLabel lblUnidad = new JLabel("Unidad");
        lblUnidad.setBounds(30, 110, 100, 25);
        contentPane.add(lblUnidad);

        txtUnidad = new JTextField();
        txtUnidad.setBounds(140, 110, 200, 25);
        contentPane.add(txtUnidad);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(30, 150, 100, 25);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(140, 150, 200, 25);
        contentPane.add(txtPrecio);

        JLabel lblCodigo = new JLabel("Código");
        lblCodigo.setBounds(30, 190, 100, 25);
        contentPane.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(140, 190, 200, 25);
        contentPane.add(txtCodigo);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(420, 30, 120, 35);
        contentPane.add(btnAgregar);

        JButton btnDetalle = new JButton("Detalle");
        btnDetalle.setBounds(420, 80, 120, 35);
        contentPane.add(btnDetalle);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(420, 130, 120, 35);
        contentPane.add(btnLimpiar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 270, 660, 180);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Existencias");
        modelo.addColumn("Unidad");
        modelo.addColumn("Precio");
        table.setModel(modelo);


        btnAgregar.addActionListener(e -> {
            agregarProducto();
        });

        btnDetalle.addActionListener(e -> {
            verDetalle();
        });

        btnLimpiar.addActionListener(e -> {
            limpiarCampos();
        });

        cargarTabla();
    }

    public void agregarProducto() {
        try {
            String nombre = txtNombre.getText();
            int existencias = Integer.parseInt(txtExistencias.getText());
            double unidad = Double.parseDouble(txtUnidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());
            int codigo = Integer.parseInt(txtCodigo.getText());
            control.agregarProducto(nombre, existencias, unidad, precio, codigo);
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Producto agregado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al agregar producto");
        }
    }

    public void cargarTabla() {
        modelo.setRowCount(0);
        for (Producto p : control.obtenerProductos()) {
            Object[] fila = {
                    p.getCodigo(),
                    p.getNombre(),
                    p.getExistencias(),
                    p.getUnidad(),
                    p.getPrecio()
            };

            modelo.addRow(fila);
        }
    }

    public void verDetalle() {
        int fila = table.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto");

            return;
        }

        Producto producto = control.obtenerProductos().get(fila);
        VentanaDetalleProducto ventana = new VentanaDetalleProducto(producto);
        ventana.setVisible(true);
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtExistencias.setText("");
        txtUnidad.setText("");
        txtPrecio.setText("");
        txtCodigo.setText("");
    }
}
