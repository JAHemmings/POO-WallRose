package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.Control;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {
    private JPanel contentPane;
    private Control control;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal frame = new VentanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaPrincipal() {

        control = Control.getInstancia();

        setTitle("Sistema de Órdenes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 420);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Sistema de Gestión");

        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));

        lblTitulo.setBounds(150, 40, 320, 40);
        contentPane.add(lblTitulo);

        JButton btnClientes = new JButton("Clientes");
        btnClientes.setBounds(200, 120, 180, 45);
        contentPane.add(btnClientes);

        JButton btnProductos = new JButton("Productos");
        btnProductos.setBounds(200, 190, 180, 45);
        contentPane.add(btnProductos);

        JButton btnOrdenes = new JButton("Órdenes");
        btnOrdenes.setBounds(200, 260, 180, 45);
        contentPane.add(btnOrdenes);

        btnClientes.addActionListener(e -> {
            VentanaClientes ventana = new VentanaClientes();
            ventana.setVisible(true);});

        btnProductos.addActionListener(e -> {
            VentanaProductos ventana = new VentanaProductos();
            ventana.setVisible(true);});

        btnOrdenes.addActionListener(e -> {
            VentanaOrdenes ventana = new VentanaOrdenes();
            ventana.setVisible(true);});
    }
}
