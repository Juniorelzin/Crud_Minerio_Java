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
    private JButton btnRemover;
    private JButton btnLocalizar;
    private JButton btnMostrar;
    private JButton btnEditar;

    private Minerio alvo = null;

    private void mostrarTodos(){

        String mostrar = "";
        for (int i = 0; i < minerios.size(); i++) {

            mostrar += (" Nome: " + minerios.get(i).getNome() +"\n" + " Valor:  " + minerios.get(i).getValor()+"\n\n");
        }
        textArea.setText(mostrar);
    }
    private void limparInputs(){
        txtNome.setText("");
        txtValor.setText("");
    }


    public TelaCadastro() {

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                int valor = Integer.parseInt(txtValor.getText());
                Minerio M = new Minerio(nome, valor);
                minerios.add(M);

                mostrarTodos();
                limparInputs();

            }
        });

        btnLocalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = txtNome.getText();

                for (int i = 0; i < minerios.size(); i++) {
                    String compararNome = minerios.get(i).getNome();

                    if(compararNome.equals(nome)){
                        alvo = minerios.get(i);
                        String mostrarNome = alvo.getNome();
                        String mostrarValor = Integer.toString(alvo.getValor());
                        txtNome.setText(mostrarNome);
                        txtValor.setText(mostrarValor);
                    }
                }

            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(alvo != null) {
                    alvo.setNome(txtNome.getText());
                    alvo.setValor(Integer.parseInt(txtValor.getText()));

                    mostrarTodos();
                    limparInputs();
                    alvo = null;
                }else{
                    JOptionPane.showMessageDialog(null, "Procura primeiro seu bosta!!");
                }
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();

                for (int i = 0; i < minerios.size(); i++) {
                    String comparar = minerios.get(i).getNome();
                    System.out.println(comparar);
                    if(comparar.equals(nome)){
                        int index = i;
                        minerios.remove(index);
                    }
                }
                mostrarTodos();
                limparInputs();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodos();
            }
        });

    }
}
