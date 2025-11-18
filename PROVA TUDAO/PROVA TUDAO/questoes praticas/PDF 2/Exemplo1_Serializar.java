import java.io.*;

// Classe serializável
class Pessoa implements Serializable {              // TORNA a classe serializável
    private static final long serialVersionUID = 1L; // Versão da classe para compatibilidade

    String nome;                                    // Atributo nome
    int idade;                                      // Atributo idade

    public Pessoa(String n, int i) {                // Construtor
        nome = n;                                   // Define o nome
        idade = i;                                  // Define a idade
    }
}

public class Exemplo1_Serializar {
    public static void main(String[] args) throws Exception {

        Pessoa p = new Pessoa("Lucas", 22);         // Cria objeto Pessoa

        FileOutputStream fos = new FileOutputStream("pessoa.obj"); // Abre arquivo binário
        ObjectOutputStream out = new ObjectOutputStream(fos);      // Stream para objetos

        out.writeObject(p);                         // GRAVA o objeto no arquivo
        out.close();                                // Fecha o stream

        System.out.println("Objeto gravado com sucesso!");
    }
}
