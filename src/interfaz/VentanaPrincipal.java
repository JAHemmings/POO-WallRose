package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

    private JPanel contentPane;

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

        setTitle("Sistema de Órdenes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 350);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnClientes = new JButton("Clientes");
        btnClientes.setBounds(170, 50, 180, 40);
        contentPane.add(btnClientes);

        JButton btnProductos = new JButton("Productos");
        btnProductos.setBounds(170, 120, 180, 40);
        contentPane.add(btnProductos);

        JButton btnOrdenes = new JButton("Órdenes");
        btnOrdenes.setBounds(170, 190, 180, 40);
        contentPane.add(btnOrdenes);
    }
}