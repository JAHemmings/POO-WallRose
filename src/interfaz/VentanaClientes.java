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
import logica.Cliente;


public class VentanaClientes extends JFrame {

    private JPanel contentPane;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEmail;

    private JTable table;
    private DefaultTableModel modelo;
    private Control control;

    public VentanaClientes() {
        control = Control.getInstancia();

        setTitle("Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 720, 500);
        setLocationRelativeTo(null);
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

        JButton btnDetalle = new JButton("Detalle");
        btnDetalle.setBounds(350, 130, 120, 35);
        contentPane.add(btnDetalle);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 220, 640, 200);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Email");

        table.setModel(modelo);


        btnAgregar.addActionListener(e -> {
            agregarCliente();
            });

        btnEditar.addActionListener(e -> {
            editarCliente();
        });

        btnDetalle.addActionListener(e -> {
            verDetalle();
        });

        cargarTabla();
    }

    public void agregarCliente() {

        try {
            String id = txtId.getText();
            String nombre = txtNombre.getText();
            String email = txtEmail.getText();
            if (id.isEmpty() || nombre.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos");
                return;
            }
            control.agregarCliente(id, nombre, email);
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Cliente agregado correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, "Error al agregar cliente");
        }
    }

    public void cargarTabla() {
        modelo.setRowCount(0);
        for (Cliente c : control.obtenerClientes()) {
            Object[] fila = { c.getId(), c.getNombre(), c.getEmail() };
            modelo.addRow(fila);
        }
    }

    public void editarCliente() {

        int fila = table.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,"Seleccione un cliente");
            return;
        }

        Cliente cliente = control.obtenerClientes().get(fila);

        VentanaEditarCliente ventana = new VentanaEditarCliente();

        ventana.cargarDatos(cliente.getId(), cliente.getNombre(), cliente.getEmail()
        );

        ventana.setVisible(true);
    }

    public void verDetalle() {

        int fila = table.getSelectedRow();
        if (fila == -1) {
        	JOptionPane.showMessageDialog(this, "Seleccione un cliente");
            return;
        }

        Cliente cliente = control.obtenerClientes().get(fila);

        VentanaDetalleCliente ventana = new VentanaDetalleCliente(cliente);

        ventana.setVisible(true);
    }

    public void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtEmail.setText("");}
}
