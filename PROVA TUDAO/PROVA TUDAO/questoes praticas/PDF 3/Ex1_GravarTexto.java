import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Ex1_GravarTexto {
    public static void main(String[] args) throws Exception {

        PrintWriter pw = new PrintWriter("dados.txt");     // Abre arquivo texto (sobrescreve)

        pw.println("Linha 1: Olá mundo!");                  // Escreve texto com quebra de linha
        pw.println("Linha 2: Testando gravação");           // Outra linha
        pw.println(123);                                    // Pode escrever números
        pw.printf("Preço: %.2f%n", 10.50);                  // Formatação estilo printf

        pw.close();                                         // Fecha arquivo (obrigatório)
    }
}
