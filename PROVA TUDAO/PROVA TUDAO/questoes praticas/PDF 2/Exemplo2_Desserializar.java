import java.io.*;

public class Exemplo2_Desserializar {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("pessoa.obj"); // Abre arquivo
        ObjectInputStream in = new ObjectInputStream(fis);       // Stream de objetos

        Pessoa p = (Pessoa) in.readObject();    // Lê o objeto e faz casting
        in.close();                             // Fecha o stream

        System.out.println("Nome: " + p.nome);  // Imprime nome
        System.out.println("Idade: " + p.idade); // Imprime idade
    }
}
