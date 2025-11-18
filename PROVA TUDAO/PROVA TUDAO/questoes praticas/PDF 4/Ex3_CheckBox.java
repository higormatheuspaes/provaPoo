import javax.swing.*;
import java.awt.*;
import java.awt.event.*;                             // Eventos

public class Ex3_CheckBox {
    public static void main(String[] args) {
        JFrame f = new JFrame("Preferências");      // Cria janela
        f.setSize(300, 150);                         // Define tamanho
        f.setLayout(new FlowLayout());               // Layout simples

        JCheckBox chk = new JCheckBox("Receber notificações");  // Criar checkbox

        // Evento quando o estado do CheckBox mudar
        chk.addItemListener(new ItemListener() {     // Escuta mudanças
            public void itemStateChanged(ItemEvent e) {
                if (chk.isSelected())                // Verifica marcado
                    System.out.println("Ativado");
                else
                    System.out.println("Desativado");
            }
        });

        f.add(chk);                                  // Adiciona componente
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
