package seboso.food.order;

public class Telas {
    // Desenha a logo do restaurante
    // https://www.asciiart.eu/text-to-ascii-art
    public static void DesenharLogo() {
        // @formatter:off
        String str =
            " ____            __                               __\n" +
            "/\\  _`\\         /\\ \\                             /\\ \\\n" +
            "\\ \\,\\L\\_\\     __\\ \\ \\____    ___     ____    ___ \\ \\/      ____\n" +
            " \\/_\\__ \\   /'__`\\ \\ '__`\\  / __`\\  /',__\\  / __`\\\\/      /',__\\\n" +
            "   /\\ \\L\\ \\/\\  __/\\ \\ \\L\\ \\/\\ \\L\\ \\/\\__, `\\/\\ \\L\\ \\      /\\__, `\\\n" +
            "   \\ `\\____\\ \\____\\\\ \\_,__/\\ \\____/\\/\\____/\\ \\____/      \\/\\____/\n" +
            "    \\/_____/\\/____/ \\/___/  \\/___/  \\/___/  \\/___/        \\/___/\n" +
            " ____                    __       _____            __\n" +
            "/\\  _`\\                 /\\ \\     /\\  __`\\         /\\ \\\n" +
            "\\ \\ \\L\\_\\___     ___    \\_\\ \\    \\ \\ \\/\\ \\  _ __  \\_\\ \\     __   _ __\n" +
            " \\ \\  _\\/ __`\\  / __`\\  /'_` \\    \\ \\ \\ \\ \\/\\`'__\\/'_` \\  /'__`\\/\\`'__\\\n" +
            "  \\ \\ \\/\\ \\L\\ \\/\\ \\L\\ \\/\\ \\L\\ \\    \\ \\ \\_\\ \\ \\ \\//\\ \\L\\ \\/\\  __/\\ \\ \\/\n" +
            "   \\ \\_\\ \\____/\\ \\____/\\ \\___,_\\    \\ \\_____\\ \\_\\\\ \\___,_\\ \\____\\\\ \\_\\\n" +
            "    \\/_/\\/___/  \\/___/  \\/__,_ /     \\/_____/\\/_/ \\/__,_ /\\/____/ \\/_/\n\n";
        System.out.print(str);
        // @formatter:on
    }


    // Desenha o QR code do pix
    // https://lillibridge.io/ascii-qr/
    public static void DesenharQRcode() {
        // @formatter:off
        String str =
            "█▀▀▀▀▀█ ▀▄▄███▄▀  █▄   ▀  █▀▀▀▀▀█\n" +
            "█ ███ █ ▄▄▀▄█ ▀▀██▀▀ █▄▀  █ ███ █\n" +
            "█ ▀▀▀ █ ██▄ ▄  ▄▀█ ▀▄██▄▄ █ ▀▀▀ █\n" +
            "▀▀▀▀▀▀▀ █ ▀▄▀ █ ▀▄█▄█▄▀ █ ▀▀▀▀▀▀▀\n" +
            "▀▄  ▀▄▀█▀ █▄▀  █▄█▄ ▀███ █▀▀▀█▄ █\n" +
            "▀ █ █▀▀█▀ ▄ ▄█▀▀▄ ▀▄▄ ▄▀▄█▄  ▀ ▀ \n" +
            "█ ██▄▄▀▄▀ █▄▀▀▄ ▀▄▄▄▄ ▀▀█▄▀█ ▀▄ ▀\n" +
            "▄▄█▄█▀▀▄  ██▀▄██▄██ ▀█ █▀██▄▀  ▀ \n" +
            "██ ▀██▀▄██▄ ▀  ▄▄▀█▀█▀█▄█ ▀ ▀█▄█ \n" +
            "▀▄█▀█ ▀█  █ ██ █▀█▄ ██▀▀██▄█ ▀ █ \n" +
            "█ ▀▄ █▀▀ ▀ ▀▄▀▀ ▄▄▀█▀ ▄   █▀▀█▄▄ \n" +
            "   ▄██▀█▄ ▄▀▀▄▀ ▀▄██▄█▄▀▀█▄ ▄▄▀█▄\n" +
            "▀▀▀ ▀ ▀▀▄ ██ █████  ▀██▄█▀▀▀█▀▄▀ \n" +
            "█▀▀▀▀▀█ ▀▀▀▄  ██▄ ▀▄  ▄ █ ▀ █▀  ▄\n" +
            "█ ███ █ ▀▄▄▀██▀ ▀ ▄█▄ ▀▄▀▀████▄▄▀\n" +
            "█ ▀▀▀ █  ▀ ▄█▄▀█▄▄█ ▀█ ▄▄▀█▀▀▀   \n" +
            "▀▀▀▀▀▀▀ ▀ ▀      ▀ ▀▀▀▀▀▀▀▀  ▀  ▀\n\n";
        System.out.print(str);
        // @formatter:on
    }


    // Tela inicial
    public static void TelaInicial(EstadoApp estado) {
        estado.LimparDadosPedido(); // Limpa os dados do pedido anterior
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
        estado.nome = Utils.ReceberInputTexto(estado.s, "Por favor informe o seu nome ou digite 0 para voltar: ");
        if (estado.nome == null) {
            estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
            return;
        }

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
            if (estado.input < 1 || estado.input > 2) Utils.PrintOpcaoInvalida();
        } while (estado.input < 1 || estado.input > 2);

        // Decide se é delivery ou retira no balcão
        if (estado.input == 2) estado.delivery = false;

        estado.telaAtual = EstadoApp.Tela.TELA_CARDAPIO;
    }


    // Tela de lista de pedidos
    public static void ListaPedidos(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Lista de Pedidos >>\n");

        Utils.EsperarEnter();
        estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
    }


    // Tela do cardápio
    public static void TelaCardapio(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Cardápio >>\n");

        // Inicialização do cardápio
        Cardapio cardapio = new Cardapio();

        // Exibindo na tela
        cardapio.iniciarCardapio();
        cardapio.imprimirCardapio();

        System.out.printf("Total: R$ %.2f", estado.total);

        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Ver pedido");
        System.out.println("0 - Cancelar pedido");
        System.out.print("Sua escolha: ");
        estado.input = Utils.ReceberInputInt();

        switch (estado.input) {
            case 1 -> estado.telaAtual = EstadoApp.Tela.VER_PEDIDO;
            case 0 -> estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
            default -> Utils.PrintOpcaoInvalida();
        }
    }


    // Tela de ver pedido
    public static void VerPedido(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Meu Pedido >>");

        // ...

        System.out.printf("\nTotal: R$ %.2f", estado.total);

        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Finalizar pedido");
        System.out.println("0 - Voltar");
        System.out.print("Sua escolha: ");
        estado.input = Utils.ReceberInputInt();

        switch (estado.input) {
            case 1 -> estado.telaAtual = EstadoApp.Tela.TELA_PAGAMENTO;
            case 0 -> estado.telaAtual = EstadoApp.Tela.TELA_CARDAPIO;
            default -> Utils.PrintOpcaoInvalida();
        }
    }


    // Tela de finalizar o pedido
    public static void TelaPagamento(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Pagamento >>");

        // Pede o endereço do usuário caso é delivery
        if (estado.delivery) {
            if (!estado.enderecoConfirmado) {
                // @formatter:off
                String input;
                System.out.println("\nVamos precisar do seu endereço para realizar a entrega, ou digite 0 para voltar");

                // CEP
                input = Utils.ReceberInputTexto(estado.s, "Digite seu CEP: ");
                if (input == null) { estado.telaAtual = EstadoApp.Tela.VER_PEDIDO; return; }
                estado.cep = input;

                // Nome da rua
                input = Utils.ReceberInputTexto(estado.s, "Digite o nome da rua: ");
                if (input == null) { estado.telaAtual = EstadoApp.Tela.VER_PEDIDO; return; }
                estado.endereco = input;

                // Número
                input = Utils.ReceberInputTexto(estado.s, "Digite o número e complemento se houver: ");
                if (input == null) { estado.telaAtual = EstadoApp.Tela.VER_PEDIDO; return; }
                estado.numero = input;

                // Bairro
                input = Utils.ReceberInputTexto(estado.s, "Digite o nome do bairro: ");
                if (input == null) { estado.telaAtual = EstadoApp.Tela.VER_PEDIDO; return; }
                estado.bairro = input;

                // Cidade
                input = Utils.ReceberInputTexto(estado.s, "Digite a cidade: ");
                if (input == null) { estado.telaAtual = EstadoApp.Tela.VER_PEDIDO; return; }
                estado.cidade = input;
                // @formatter:on
                System.out.println();
            }

            // Exibindo o endereço digitado
            System.out.println("Seu endereço:");
            System.out.println("CEP: " + estado.cep);
            System.out.println("Endereço: Rua " + estado.endereco + ", nº" + estado.numero + " - " + estado.bairro + ", " + estado.cidade + "/" + estado.uf);
            System.out.println();

            do {
                // Confirmação do endereço
                System.out.println("Os dados estão corretos?");
                System.out.println("1 - Sim, continuar");
                System.out.println("2 - Não, revisar");
                System.out.println("0 - Voltar");
                System.out.print("Sua escolha: ");

                estado.input = Utils.ReceberInputInt();

                if (estado.input == 0) {
                    estado.telaAtual = EstadoApp.Tela.VER_PEDIDO;
                    return;
                }

                if (estado.input == 2) {
                    estado.enderecoConfirmado = false;
                    return;
                }

                if (estado.input == 1) estado.enderecoConfirmado = true;

                if (estado.input < 1 || estado.input > 2) Utils.PrintOpcaoInvalida();
            } while (estado.input < 1 || estado.input > 2);
        }

        // Valor total
        System.out.printf("\nTotal: R$ %.2f\n", estado.total);

        // Forma de pagamento
        do {
            System.out.println("\nSelecione uma forma de pagamento:");
            System.out.println("1 - Dinheiro");
            System.out.println("2 - Pix");
            System.out.println("3 - Débito");
            System.out.println("4 - Crédito");
            System.out.println("0 - Voltar");

            System.out.print("Sua escolha: ");
            estado.input = Utils.ReceberInputInt();

            if (estado.input < 0 || estado.input > 4) Utils.PrintOpcaoInvalida();
        } while (estado.input < 0 || estado.input > 4);

        switch (estado.input) {
            case 1 -> estado.formaPagamento = EstadoApp.FormasPagamento.DINHEIRO;
            case 2 -> estado.formaPagamento = EstadoApp.FormasPagamento.PIX;
            case 3 -> estado.formaPagamento = EstadoApp.FormasPagamento.DEBITO;
            case 4 -> estado.formaPagamento = EstadoApp.FormasPagamento.CREDITO;
            case 0 -> {
                estado.telaAtual = EstadoApp.Tela.VER_PEDIDO;
                return;
            }
        }

        switch (estado.formaPagamento) {
            case DINHEIRO -> {
                System.out.println("\nForma de pagamento dinheiro selecionado com sucesso!");
                Utils.EsperarEnter();
            }
            case PIX -> {
                System.out.println("\nPor favor escaneie o QR code para realizar o pagamento:\n");
                Telas.DesenharQRcode();
                System.out.println("Aguardando confirmação...");
                Utils.EsperarEnter();
                System.out.println("Pagamento realizado com sucesso!");
                Utils.EsperarEnter();
            }
            case DEBITO -> {
                System.out.println("\nAproxime ou insira o cartão de débito...");
                Utils.EsperarEnter();
                System.out.println("Pagamento realizado com sucesso!");
                Utils.EsperarEnter();
            }
            case CREDITO -> {
                System.out.println("\nAproxime ou insira o cartão de crédito...");
                Utils.EsperarEnter();
                System.out.println("Pagamento realizado com sucesso!");
                Utils.EsperarEnter();
            }
        }

        // O pedido deve ser adicionado a lista de pedidos aqui...

        estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
    }
}
