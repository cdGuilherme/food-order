// Main //
//////////

// TODO:
// - Colocar as informações do usuário em uma classe abstrata pessoa

package seboso.food.order;

import java.util.Scanner;

public class FoodOrder {
    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();

        cardapio.iniciarCardapio();
        cardapio.imprimirCardapio();
        Scanner s = new Scanner(System.in);

        // Variáveis //
        ///////////////

        String nome; // Nome do usuário
        boolean vaiComerAqui = false; // Comer aqui ou levar
        int input; // Input do usuário para navegar o programa pelo console

        // Início do programa, pede o nome do usuário
        System.out.println("<< SEBOSO'S FOOD >>");
        System.out.print("Para iniciar um pedido informe o seu nome: ");
        nome = s.nextLine();
        System.out.println("Seja bem-vindo de volta " + nome + "!\n");

        // Pergunta para o usuário se vai comer aqui ou levar
        do {
            System.out.println("Você gostaria de comer aqui ou levar?");
            System.out.println("1 - Comer aqui");
            System.out.println("2 - Levar");

            // Usuário seleciona uma das opções fornecidas
            System.out.print("Sua escolha: ");
            input = Utils.ReceberInputInt();

            if (input < 1 || input > 2)
                System.out.println("Opção inválida!");
            System.out.println();
        } while (input < 1 || input > 2);
        if (input == 1)
            vaiComerAqui = true;

        System.out.println("<< Cardápio >>");
        System.out.println("1 - Lanches");
        System.out.println("2 - Bebidas");
        System.out.println("3 - Adicionais");

        Utils.QuebrarLinhas(100);
        Utils.LimparTela(); 

        System.out.println("Teste");
    }
}
