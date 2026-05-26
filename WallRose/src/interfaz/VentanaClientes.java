package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaClientes extends JFrame {

    private JPanel contentPane;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEmail;
    private JTable table;

    public VentanaClientes() {

        setTitle("Clientes");
        setBounds(100, 100, 700, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(30, 30, 80, 25);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(120, 30, 180, 25);
        contentPane.add(txtId);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(30, 70, 80, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 70, 180, 25);
        contentPane.add(txtNombre);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 110, 80, 25);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(120, 110, 180, 25);
        contentPane.add(txtEmail);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(350, 30, 120, 35);
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(350, 80, 120, 35);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(350, 130, 120, 35);
        contentPane.add(btnEliminar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 210, 620, 200);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
    }
}