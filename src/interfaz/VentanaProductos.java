package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaProductos extends JFrame {

    private JPanel contentPane;
    private JTextField txtNombre;
    private JTextField txtExistencias;
    private JTextField txtUnidad;
    private JTextField txtPrecio;
    private JTextField txtCodigo;
    private JTable table;

    public VentanaProductos() {

        setTitle("Productos");
        setBounds(100, 100, 750, 550);

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

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(420, 80, 120, 35);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(420, 130, 120, 35);
        contentPane.add(btnEliminar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 270, 660, 180);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
    }
}