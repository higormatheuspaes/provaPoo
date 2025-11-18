import javax.swing.*;                               // Componentes GUI
import java.awt.*;                                   // Layouts

public class Ex2_ComponentesBasicos {
    public static void main(String[] args) {
        JFrame f = new JFrame("Dados do Usuário");   // Cria janela
        f.setSize(350, 200);                         // Tamanho
        f.setLayout(new FlowLayout());               // Layout simples

        JLabel lbl = new JLabel("Nome:");            // Texto estático
        JTextField txt = new JTextField(15);         // Campo digitável
        JButton btn = new JButton("Enviar");         // Botão

        f.add(lbl);                                  // Adiciona label
        f.add(txt);                                  // Adiciona campo
        f.add(btn);                                  // Adiciona botão

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);                          // Exibe interface
    }
}
