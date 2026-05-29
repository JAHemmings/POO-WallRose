package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import logica.Producto;


public class VentanaDetalleProducto extends JFrame {

    private JPanel contentPane;

    private JTextField txtNombre;
    private JTextField txtExistencias;
    private JTextField txtUnidad;
    private JTextField txtPrecio;
    private JTextField txtCodigo;

    private Producto producto;

    public VentanaDetalleProducto(Producto producto) {

        this.producto = producto;

        setTitle("Detalle Producto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 450);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(40, 40, 100, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(160, 40, 220, 25);
        contentPane.add(txtNombre);

        JLabel lblExistencias = new JLabel("Existencias");
        lblExistencias.setBounds(40, 90, 100, 25);
        contentPane.add(lblExistencias);

        txtExistencias = new JTextField();
        txtExistencias.setBounds(160, 90, 220, 25);
        contentPane.add(txtExistencias);

        JLabel lblUnidad = new JLabel("Unidad");
        lblUnidad.setBounds(40, 140, 100, 25);
        contentPane.add(lblUnidad);

        txtUnidad = new JTextField();
        txtUnidad.setBounds(160, 140, 220, 25);
        contentPane.add(txtUnidad);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(40, 190, 100, 25);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(160, 190, 220, 25);
        contentPane.add(txtPrecio);

        JLabel lblCodigo = new JLabel("Código");
        lblCodigo.setBounds(40, 240, 100, 25);
        contentPane.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(160, 240, 220, 25);
        contentPane.add(txtCodigo);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(170, 320, 120, 40);
        contentPane.add(btnCerrar);

        cargarDatos();

        btnCerrar.addActionListener(e -> {
            dispose();
        });
    }

    public void cargarDatos() {
        txtNombre.setText(producto.getNombre());
        txtExistencias.setText(String.valueOf(producto.getExistencias()));
        txtUnidad.setText(String.valueOf(producto.getUnidad()));
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtCodigo.setText(String.valueOf(producto.getCodigo()));
        
        txtNombre.setEditable(false);
        txtExistencias.setEditable(false);
        txtUnidad.setEditable(false);
        txtPrecio.setEditable(false);
        txtCodigo.setEditable(false);
    }
}
