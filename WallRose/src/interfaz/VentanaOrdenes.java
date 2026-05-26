package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaOrdenes extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public VentanaOrdenes() {

        setTitle("Órdenes");
        setBounds(100, 100, 800, 550);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(30, 30, 100, 25);
        contentPane.add(lblCliente);

        JComboBox comboClientes = new JComboBox();
        comboClientes.setBounds(120, 30, 220, 25);
        contentPane.add(comboClientes);

        JButton btnCrearOrden = new JButton("Crear Orden");
        btnCrearOrden.setBounds(400, 30, 150, 35);
        contentPane.add(btnCrearOrden);

        JButton btnAgregarLinea = new JButton("Agregar Línea");
        btnAgregarLinea.setBounds(580, 30, 150, 35);
        contentPane.add(btnAgregarLinea);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 120, 700, 280);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnTerminar = new JButton("Terminar Orden");
        btnTerminar.setBounds(290, 430, 180, 40);
        contentPane.add(btnTerminar);
    }
}