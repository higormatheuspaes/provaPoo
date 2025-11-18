import java.io.*;

// Classe com atributo transient
class Usuario implements Serializable {                         
    private static final long serialVersionUID = 1L;             // Obrigatório para controle

    String login;                                                // Será serializado
    transient String senha;                                      // NÃO será serializada

    public Usuario(String l, String s) {                         // Construtor
        login = l;                                               // Define login
        senha = s;                                               // Define senha
    }
}

public class Exemplo5_Transient {
    public static void main(String[] args) throws Exception {

        Usuario u = new Usuario("admin", "12345");               // Cria usuário

        ObjectOutputStream out =
            new ObjectOutputStream(new FileOutputStream("user.obj")); // Abre arquivo

        out.writeObject(u);                                      // Serializa objeto
        out.close();                                             // Fecha

        System.out.println("Usuário gravado!");

        ObjectInputStream in =
            new ObjectInputStream(new FileInputStream("user.obj")); // Lê arquivo

        Usuario lido = (Usuario) in.readObject();                // Desserializa
        in.close();                                              // Fecha

        System.out.println("Login lido: " + lido.login);         // OK
        System.out.println("Senha lida: " + lido.senha);         // Será NULL!
    }
}
