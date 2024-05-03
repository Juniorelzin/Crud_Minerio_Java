import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TelaCadastro t = new TelaCadastro();
        t.setContentPane(t.telaPrincipal);
        t.setTitle("Tela Minérios");
        t.setSize(400,300);
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}