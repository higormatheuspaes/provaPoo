import java.io.*;                                // Importa classes de IO

public class Ex3_LerBinario {
    public static void main(String[] args) throws Exception {

        FileInputStream fis =                    // Cria um fluxo para leitura binária
                new FileInputStream("dados.bin");// Abre o arquivo criado anteriormente

        int b;                                   // Variável para armazenar cada byte lido

        while ((b = fis.read()) != -1) {         // Lê byte a byte até chegar ao final (-1)
            System.out.println("Byte lido: " + b);  // imprime o valor do byte lido
        }

        fis.close();                              // Fecha o arquivo
    }
}
