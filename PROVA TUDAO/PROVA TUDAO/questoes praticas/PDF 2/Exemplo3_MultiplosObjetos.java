import java.io.*;

public class Exemplo3_MultiplosObjetos {
    public static void main(String[] args) throws Exception {

        ObjectOutputStream out =
            new ObjectOutputStream(new FileOutputStream("multi.obj")); // Abre arquivo

        out.writeObject(new Pessoa("Ana", 30));       // 1º objeto Pessoa
        out.writeObject(new Pessoa("Carlos", 28));    // 2º objeto Pessoa
        out.writeObject("Uma mensagem");              // String também é serializável
        out.writeObject(Integer.valueOf(500));        // Integer também é serializável

        out.close();                                  // Fecha

        System.out.println("Objetos gravados!");
    }
}
