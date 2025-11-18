import java.io.*;                                // Importa todas as classes de entrada/saída

public class Ex2_GravarBinario {
    public static void main(String[] args) throws Exception {

        File f = new File("dados.bin");          // Cria um objeto File apontando para "dados.bin"

        FileOutputStream fos =                   // Cria um fluxo para gravação binária
                new FileOutputStream(f);         // Caso o arquivo exista, será sobrescrito

        fos.write(10);                           // Grava o byte 10
        fos.write(20);                           // Grava o byte 20
        fos.write(30);                           // Grava o byte 30

        fos.close();                             // Fecha o arquivo liberando o recurso
    }
}
