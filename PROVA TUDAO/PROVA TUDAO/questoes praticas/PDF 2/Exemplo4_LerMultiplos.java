import java.io.*;

public class Exemplo4_LerMultiplos {
    public static void main(String[] args) {

        try {
            ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("multi.obj")); // Abre arquivo

            while (true) {                                   // Lê até acabar
                Object obj = in.readObject();                // Lê objeto genérico
                System.out.println("Lido: " + obj);          // Imprime o toString()
            }

        } catch (EOFException e) {                           // Fim do arquivo
            System.out.println("Fim do arquivo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
