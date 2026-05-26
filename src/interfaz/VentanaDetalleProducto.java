package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaDetalleProducto extends JFrame {

    private JPanel contentPane;

    private JTextField txtNombre;
    private JTextField txtExistencias;
    private JTextField txtUnidad;
    private JTextField txtPrecio;
    private JTextField txtCodigo;

    public VentanaDetalleProducto() {

        setTitle("Detalle Producto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 450);

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
        txtNombre.setColumns(10);

        JLabel lblExistencias = new JLabel("Existencias");
        lblExistencias.setBounds(40, 90, 100, 25);
        contentPane.add(lblExistencias);

        txtExistencias = new JTextField();
        txtExistencias.setBounds(160, 90, 220, 25);
        contentPane.add(txtExistencias);
        txtExistencias.setColumns(10);

        JLabel lblUnidad = new JLabel("Unidad");
        lblUnidad.setBounds(40, 140, 100, 25);
        contentPane.add(lblUnidad);

        txtUnidad = new JTextField();
        txtUnidad.setBounds(160, 140, 220, 25);
        contentPane.add(txtUnidad);
        txtUnidad.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(40, 190, 100, 25);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(160, 190, 220, 25);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblCodigo = new JLabel("Código");
        lblCodigo.setBounds(40, 240, 100, 25);
        contentPane.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(160, 240, 220, 25);
        contentPane.add(txtCodigo);
        txtCodigo.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(90, 320, 120, 40);
        contentPane.add(btnGuardar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(260, 320, 120, 40);
        contentPane.add(btnLimpiar);
    }
}