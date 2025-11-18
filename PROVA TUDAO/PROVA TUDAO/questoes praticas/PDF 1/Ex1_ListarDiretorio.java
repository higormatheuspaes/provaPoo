import java.io.File;              // Importa a classe File, usada para manipular arquivos e diretórios

public class Ex1_ListarDiretorio {
    public static void main(String[] args) {

        File dir = new File("C:\\Windows");     // Cria um objeto File apontando para o diretório C:\Windows

        File[] itens = dir.listFiles();         // Lista todos os arquivos e subpastas dentro do diretório
        for (File f : itens) {                  // Percorre cada item retornado

            if (f.isDirectory()) {              // Verifica se o item atual é um diretório
                System.out.println("[DIR]  " + f.getName());   // Imprime o nome da pasta
            } else {                             // Caso contrário, é um arquivo
                System.out.println("[ARQ]  " + f.getName()      // Imprime o nome do arquivo
                    + " - " + f.length() + " bytes");           // E o seu tamanho em bytes
            }
        }
    }
}
