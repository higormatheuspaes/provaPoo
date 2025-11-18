import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex4_EventoBotao {
    public static void main(String[] args) {
        JFrame f = new JFrame("Soma");               // Janela
        f.setSize(300, 200);
        f.setLayout(new FlowLayout());

        JTextField n1 = new JTextField(5);           // Campo 1
        JTextField n2 = new JTextField(5);           // Campo 2
        JButton btn = new JButton("Somar");          // Botão
        JLabel resultado = new JLabel("Resultado:"); // Texto

        f.add(new JLabel("N1:")); f.add(n1);         // Adiciona campos
        f.add(new JLabel("N2:")); f.add(n2);
        f.add(btn);
        f.add(resultado);

        // Evento do botão
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(n1.getText());   // Lê valor 1
                int b = Integer.parseInt(n2.getText());   // Lê valor 2
                int r = a + b;                            // Soma
                resultado.setText("Resultado: " + r);     // Mostra resultado
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
