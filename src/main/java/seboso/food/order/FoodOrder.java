// Main

package seboso.food.order;

import java.util.Scanner;
import java.util.InputMismatchException;

public class FoodOrder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String nome; // Nome do usuário
        int input; // Input do usuário para navegar o programa pelo console

        System.out.println("<< SEBOSO'S FOOD >>");

        System.out.print("Para iniciar um pedido informe o seu nome: ");
        nome = s.nextLine();
        System.out.println("Seja bem-vindo de volta " + nome + "!");

        do {
            System.out.println("Você gostaria de comer aqui ou levar?");
            System.out.println("1 - Comer aqui");
            System.out.println("2 - Levar");
            System.out.println("0 - Sair");

            // Usuário digita uma opção
            input = Utils.ReceberInput();

            System.out.println();

            switch (input) {
                // Comer aqui
                case 1 -> {
                    System.out.println("Opção selecionada: Comer aqui");
                    Utils.EsperarEnter();
                }


                // Levar
                case 2 -> {
                    System.out.println("Opção selecionada: Levar");
                    Utils.EsperarEnter();
                }


                // Sair
                case 0 -> {
                }


                // Opção inválida
                default -> {
                    System.out.println("Opção inválida!");
                    Utils.EsperarEnter();
                }
            }
        } while (input != 0);
    }
}
