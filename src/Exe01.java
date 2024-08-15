import java.util.Scanner;

public class Exe01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro numero: ");
        int num1 = scanner.nextInt();
        System.out.println("Digite o segundo numero: ");
        int num2 = scanner.nextInt();
        System.out.println("Resultado: " + (num1 + num2));
        scanner.close();
    }
}
