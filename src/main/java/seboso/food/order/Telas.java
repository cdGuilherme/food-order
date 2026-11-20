package seboso.food.order;

public class Telas {
    // Desenha a logo do restaurante
    // https://www.asciiart.eu/text-to-ascii-art
    public static void DesenharLogo() {
        System.out.println(" ____            __                               __                   ");
        System.out.println("/\\  _`\\         /\\ \\                             /\\ \\                  ");
        System.out.println("\\ \\,\\L\\_\\     __\\ \\ \\____    ___     ____    ___ \\ \\/      ____        ");
        System.out.println(" \\/_\\__ \\   /'__`\\ \\ '__`\\  / __`\\  /',__\\  / __`\\\\/      /',__\\       ");
        System.out.println("   /\\ \\L\\ \\/\\  __/\\ \\ \\L\\ \\/\\ \\L\\ \\/\\__, `\\/\\ \\L\\ \\      /\\__, `\\      ");
        System.out.println("   \\ `\\____\\ \\____\\\\ \\_,__/\\ \\____/\\/\\____/\\ \\____/      \\/\\____/      ");
        System.out.println("    \\/_____/\\/____/ \\/___/  \\/___/  \\/___/  \\/___/        \\/___/       ");
        System.out.println(" ____                    __       _____            __                  ");
        System.out.println("/\\  _`\\                 /\\ \\     /\\  __`\\         /\\ \\                 ");
        System.out.println("\\ \\ \\L\\_\\___     ___    \\_\\ \\    \\ \\ \\/\\ \\  _ __  \\_\\ \\     __   _ __  ");
        System.out.println(" \\ \\  _\\/ __`\\  / __`\\  /'_` \\    \\ \\ \\ \\ \\/\\`'__\\/'_` \\  /'__`\\/\\`'__\\");
        System.out.println("  \\ \\ \\/\\ \\L\\ \\/\\ \\L\\ \\/\\ \\L\\ \\    \\ \\ \\_\\ \\ \\ \\//\\ \\L\\ \\/\\  __/\\ \\ \\/ ");
        System.out.println("   \\ \\_\\ \\____/\\ \\____/\\ \\___,_\\    \\ \\_____\\ \\_\\\\ \\___,_\\ \\____\\\\ \\_\\ ");
        System.out.println("    \\/_/\\/___/  \\/___/  \\/__,_ /     \\/_____/\\/_/ \\/__,_ /\\/____/ \\/_/ ");
        System.out.println();
    }


    // Tela inicial
    public static void TelaInicial(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("Seja bem-vindo ao restaurante Seboso's Food Order!\n");

        System.out.println("Por favor, selecione uma opção:");
        System.out.println("1 - Iniciar um novo pedido");
        System.out.println("2 - Ver a lista de pedidos");
        System.out.println("0 - Sair");
        System.out.print("Sua escolha: ");
        estado.input = Utils.ReceberInputInt();

        switch (estado.input) {
            case 1 -> estado.telaAtual = EstadoApp.Tela.NOVO_PEDIDO;
            case 2 -> estado.telaAtual = EstadoApp.Tela.LISTA_PEDIDOS;
            case 0 -> estado.telaAtual = EstadoApp.Tela.SAIR;
            default -> Utils.PrintOpcaoInvalida();
        }

        System.out.println();
    }


    // Tela de novo pedido
    public static void NovoPedido(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Novo Pedido >>\n");

        // Pede o nome do usuário
        do {
            System.out.print("Por favor informe o seu nome: ");
            estado.nome = estado.s.nextLine();
        } while (estado.nome.isEmpty());

        // Pergunta se quer delivery ou retira no balcão
        do {
            System.out.println("\nOlá " + estado.nome + "! Você gostaria de pedir por delivery ou retirar o pedido no balcão?");
            System.out.println("1 - Delivery");
            System.out.println("2 - Retirar no balcão");
            System.out.println("0 - Voltar");
            System.out.print("Sua escolha: ");
            estado.input = Utils.ReceberInputInt();
            if (estado.input == 0) {
                estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
                return;
            }
            if (estado.input < 1 || estado.input > 2)
                Utils.PrintOpcaoInvalida();
        } while (estado.input < 1 || estado.input > 2);

        // Decide se é delivery ou retira no balcão
        if (estado.input == 2)
            estado.delivery = false;

        // Teste
        if (estado.delivery)
            System.out.println("Vai pedir delivery");
        else
            System.out.println("Vai retirar no balcão");

        Utils.EsperarEnter();
        estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
    }


    // Tela de lista de pedidos
    public static void ListaPedidos(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Lista de Pedidos >>\n");

        Utils.EsperarEnter();
        estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
    }
}
