package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Cliente;
import logica.Orden;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class VentanaDetalleCliente extends JFrame {

    private JPanel contentPane;

    private JTable table;

    private DefaultTableModel modelo;

    private Cliente cliente;

    public VentanaDetalleCliente(Cliente cliente) {

        this.cliente = cliente;

        setTitle("Detalle Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 450);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Órdenes del Cliente: " + cliente.getNombre());

        lblTitulo.setBounds(30, 20, 300, 25);

        contentPane.add(lblTitulo);

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setBounds(30, 70, 560, 260);

        contentPane.add(scrollPane);

        table = new JTable();

        scrollPane.setViewportView(table);

        modelo = new DefaultTableModel();
        modelo.addColumn("Número Orden");
        modelo.addColumn("Cantidad Líneas");

        table.setModel(modelo);

        cargarOrdenes();
    }

    public void cargarOrdenes() {
        modelo.setRowCount(0);
        for (Orden o : cliente.getOrdenes()) {
            Object[] fila = {
                    o.getNumero(),
                    o.getLineas().size()
            };
            modelo.addRow(fila);
        }
    }
}
