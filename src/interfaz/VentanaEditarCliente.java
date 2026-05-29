package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import logica.Cliente;

public class VentanaEditarCliente extends JFrame {
    private JPanel contentPane;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEmail;
    private Cliente cliente;

    public VentanaEditarCliente(Cliente cliente) {

        this.cliente = cliente;

        setTitle("Editar Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(40, 40, 100, 25);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(150, 40, 220, 25);
        contentPane.add(txtId);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(40, 90, 100, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 90, 220, 25);
        contentPane.add(txtNombre);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(40, 140, 100, 25);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 140, 220, 25);
        contentPane.add(txtEmail);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(90, 220, 120, 40);
        contentPane.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 220, 120, 40);
        contentPane.add(btnCancelar);

        cargarDatos();


        btnGuardar.addActionListener(e -> {
        	guardarCambios();
        	});

        btnCancelar.addActionListener(e -> {
            dispose();
        });
    }

    public void cargarDatos() {
        txtId.setText(cliente.getId());
        txtNombre.setText(cliente.getNombre());
        txtEmail.setText(cliente.getEmail());
    }

    public void guardarCambios() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String email = txtEmail.getText();

        if (id.isEmpty() || nombre.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Email inválido");
            return;
        }

        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setEmail(email);

        JOptionPane.showMessageDialog(this,"Cliente actualizado correctamente");

        dispose();
    }
}
