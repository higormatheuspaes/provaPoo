import java.io.PrintWriter;

public class Ex5_UTF8 {
    public static void main(String[] args) throws Exception {

        PrintWriter pw = new PrintWriter("utf8.txt", "UTF-8");  // Define charset UTF-8

        pw.println("Texto com acentuação: áéíóú ç ã õ");        // Teste de acentos
        pw.println("UTF-8 evita perda de caracteres!");         

        pw.close();                                              // Fecha arquivo
    }
}
