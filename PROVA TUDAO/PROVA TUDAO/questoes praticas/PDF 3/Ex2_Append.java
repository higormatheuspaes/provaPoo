import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Ex2_Append {
    public static void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream("dados.txt", true); // Abre com APPEND
        PrintWriter pw = new PrintWriter(fos);                          // Embala no PrintWriter

        pw.println("Linha adicionada posteriormente.");                 // Nova linha

        pw.close();                                                     // Fecha
    }
}
