import java.io.*;

public class Ex4_WritePrimitivos {
    public static void main(String[] args) throws Exception {

        DataOutputStream out =                        // Cria um stream para gravar primitivos
            new DataOutputStream(                     // Encadeado a FileOutputStream
                new FileOutputStream("info.dat"));    // Arquivo final será "info.dat"

        out.writeDouble(25.75);                       // Grava um double no arquivo
        out.writeBoolean(true);                       // Grava um boolean
        out.writeUTF("FURB");                         // Grava uma String com codificação UTF

        out.close();                                  // Fecha o stream mais externo
    }
}
