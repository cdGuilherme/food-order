package seboso.food.order;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    // Funções úteis para a execução do programa //
    // ////////////////////////////////////////////


    // Pausa o programa até o usuário apertar <ENTER>
    public static void EsperarEnter() {
        Scanner s = new Scanner(System.in);
        System.out.print("Pressione <ENTER> para continuar...");
        s.nextLine();
    }


    public static int ReceberInput() {
        Scanner s = new Scanner(System.in);
        int input;
        try {
            // Usuário seleciona uma das opções fornecidas
            System.out.print("Sua escolha: ");
            input = s.nextInt();
        } catch (InputMismatchException e) {
            // Usuário digita outra coisa sem ser um número inteiro
            input = -1;
            s.nextLine();
        }
        return input;
    }
}
