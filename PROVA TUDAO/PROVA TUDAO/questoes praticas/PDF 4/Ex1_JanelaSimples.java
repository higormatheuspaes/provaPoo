import javax.swing.*;                              // Importa biblioteca Swing

public class Ex1_JanelaSimples {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Minha Janela");  // Cria a janela
        janela.setSize(400, 200);                    // Define largura e altura
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha app ao clicar no X
        janela.setVisible(true);                     // Torna a janela visível
    }
}
