import java.io.*;

public class Ex5_ReadPrimitivos {
    public static void main(String[] args) throws Exception {

        DataInputStream in =                          // Cria um stream para ler primitivos
            new DataInputStream(                      // Encadeado a FileInputStream
                new FileInputStream("info.dat"));     // Abre o arquivo gravado antes

        double preco = in.readDouble();               // Lê o double na ordem correta
        boolean ok = in.readBoolean();                // Lê o boolean
        String nome = in.readUTF();                   // Lê a string UTF

        System.out.println(preco + ", " + ok + ", " + nome);   // Exibe os valores lidos

        in.close();                                   // Fecha o stream
    }
}
