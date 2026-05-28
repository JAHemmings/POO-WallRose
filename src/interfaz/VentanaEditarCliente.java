package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaEditarCliente extends JFrame {

    private JPanel contentPane;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEmail;

    public VentanaEditarCliente() {

        setTitle("Editar Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 350);

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
        txtId.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(40, 90, 100, 25);
        contentPane.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 90, 220, 25);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(40, 140, 100, 25);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 140, 220, 25);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(90, 220, 120, 40);
        contentPane.add(btnGuardar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(250, 220, 120, 40);
        contentPane.add(btnLimpiar);

        btnGuardar.addActionListener(e -> {
            guardarCliente();
        });

        btnLimpiar.addActionListener(e -> {
            limpiarCampos();
        });
    }

    public void cargarDatos(String id, String nombre, String email) {
        txtId.setText(id);
        txtNombre.setText(nombre);
        txtEmail.setText(email);
    }

    public boolean validarEmail() {
        String email = txtEmail.getText();
        return email.contains("@") && email.contains(".");
    }

    public boolean validarId() {
        return !txtId.getText().trim().isEmpty();
    }

    public void guardarCliente() {

        if (!validarId()) {
            mostrarError("El ID es obligatorio");
            return;
        }

        if (!validarEmail()) {
            mostrarError("Email inválido");
            return;
        }

        JOptionPane.showMessageDialog(this, "Cliente guardado correctamente");
    }

    public void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtEmail.setText("");
    }

    public void mostrarError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
