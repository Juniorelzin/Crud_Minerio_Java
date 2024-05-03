import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaCadastro extends JFrame{
    private ArrayList<Minerio> minerios = new ArrayList<Minerio>();
    public JPanel telaPrincipal;
    private JTextField txtNome;
    private JTextField txtValor;
    private JButton btnEnviar;
    private JTextArea textArea;
    private JButton btnMostrar;


    public TelaCadastro() {
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                int valor = Integer.parseInt(txtValor.getText());
                Minerio M = new Minerio(nome, valor);
                minerios.add(M);

                String mostrar = "";
                for (int i = 0; i < minerios.size(); i++) {


                    mostrar += (" Nome: " + minerios.get(i).getNome() +"\n" + " Valor: " + minerios.get(i).getValor()+"\n\n");
                }
                textArea.setText(mostrar);

            }
        });

    }
}
