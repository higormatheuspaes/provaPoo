import java.io.File;
import java.util.Scanner;

public class Ex3_LerTexto {
    public static void main(String[] args) throws Exception {

        File f = new File("dados.txt");               // Aponta para o arquivo
        Scanner sc = new Scanner(f);                  // Scanner para leitura linha a linha

        while (sc.hasNextLine()) {                    // Enquanto houver linhas
            String linha = sc.nextLine();             // Lê uma linha
            System.out.println(linha);                // Exibe no console
        }

        sc.close();                                   // Fecha o arquivo
    }
}
    