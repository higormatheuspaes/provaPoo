import java.io.File;
import java.util.Scanner;

public class Ex4_LerNumeros {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File("numeros.txt")); // Abre arquivo com números

        int idade = sc.nextInt();                          // Lê um inteiro
        double salario = sc.nextDouble();                  // Lê um double
        String nome = sc.next();                           // Lê uma palavra (token)

        System.out.println("Idade: " + idade);
        System.out.println("Salário: " + salario);
        System.out.println("Nome: " + nome);

        sc.close();
    }
}
