package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class VentanaDetalleCliente extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public VentanaDetalleCliente() {

        setTitle("Detalle Cliente");
        setBounds(100, 100, 650, 450);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Órdenes del Cliente");
        lblTitulo.setBounds(30, 20, 200, 25);
        contentPane.add(lblTitulo);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 70, 560, 260);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
    }
}