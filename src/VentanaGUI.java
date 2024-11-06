import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VentanaGUI {
    private JPanel principal;
    private JComboBox comboBox1;
    private JTextField txtNombre;
    private JList lsListaPacientes;
    private JButton btnRegistrar;
    private JButton btnAtender;
    DefaultListModel dlm=new DefaultListModel();
    Hospital hospital =new Hospital();

    public void llenarJlist(){
        dlm.removeAllElements();
        Stream<Paciente> ordenada= hospital.listarPacientes().stream().sorted();
        for(Paciente p: ordenada.collect(Collectors.toList())){
            dlm.addElement(p);
        }
        lsListaPacientes.setModel(dlm);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new VentanaGUI().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public VentanaGUI() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p=Integer.parseInt(comboBox1.getSelectedItem().toString());
                String nombre=txtNombre.getText();
                Paciente nuevo=new Paciente(p,nombre);
                hospital.encolar(nuevo);
                llenarJlist();
            }
        });


        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Paciente p=hospital.atender();
                    JOptionPane.showMessageDialog(null,"Paciente atendido: "+p.toString());
                    llenarJlist();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }
}
