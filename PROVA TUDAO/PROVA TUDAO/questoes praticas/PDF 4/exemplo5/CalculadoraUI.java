import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraUI {             // Camada de apresentação
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();       // Acesso à camada de negócio

        JFrame f = new JFrame("Calc - Camadas");
        f.setSize(300, 200);
        f.setLayout(new FlowLayout());

        JTextField n1 = new JTextField(5);
        JTextField n2 = new JTextField(5);
        JButton btn = new JButton("Somar");
        JLabel resultado = new JLabel("Resultado:");

        f.add(new JLabel("N1:")); f.add(n1);
        f.add(new JLabel("N2:")); f.add(n2);
        f.add(btn);
        f.add(resultado);

        btn.addActionListener(new ActionListener() { // Evento do botão
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(n1.getText());  // Lê N1
                int b = Integer.parseInt(n2.getText());  // Lê N2
                int r = calc.somar(a, b);                // Chama a camada de negócio
                resultado.setText("Resultado: " + r);     // Exibe na GUI
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
