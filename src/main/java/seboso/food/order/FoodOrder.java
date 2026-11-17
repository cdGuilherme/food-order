// Main

package seboso.food.order;

import java.util.Scanner;

public class FoodOrder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String nome; // Nome do usuário
        int input = 0; // Input do usuário para navegar o programa pelo console

        System.out.println("<< SEBOSO'S FOOD >>");

        System.out.print("Para iniciar um pedido informe o seu nome: ");
        nome = s.nextLine();
        System.out.println("Seja bem-vindo de volta " + nome + "!");

        do {
            System.out.println("Você gostaria de comer aqui ou levar?");
            System.out.println("1 - Comer aqui");
            System.out.println("2 - Levar");

            // Usuário digita uma opção
            input = Utils.ReceberInput();
            if (!(input == 1) && !(input == 2)) {
                System.out.println("Opção inválida!");
            }
        } while (!(input == 1) && !(input == 2));

        System.out.println("<< Cardápio >>");
        System.out.println("1 - Lanches");
        System.out.println("2 - Bebidas");
        System.out.println("3 - Adicionais");
    }
}
