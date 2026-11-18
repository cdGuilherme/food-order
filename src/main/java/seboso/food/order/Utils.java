// Funções úteis para a execução do programa //
// ////////////////////////////////////////////

package seboso.food.order;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    // Pausa o programa até o usuário apertar <ENTER>
    public static void EsperarEnter() {
        Scanner s = new Scanner(System.in);
        System.out.print("Pressione <ENTER> para continuar...");
        s.nextLine();
    }


    // Recebe um input do usuário do tipo int, com tratamento de dados para evitar crashar o programa
    public static int ReceberInputInt() {
        Scanner s = new Scanner(System.in);
        int input;
        try {
            input = s.nextInt();
        } catch (InputMismatchException e) {
            // Usuário digita outra coisa sem ser um número inteiro
            input = -1;
            s.nextLine();
        }
        return input;
    }
}
