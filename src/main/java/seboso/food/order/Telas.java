// Telas

package seboso.food.order;

public class Telas {
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
    }


    // Tela de novo pedido
    public static void NovoPedido(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Novo Pedido >>\n");

        // Pede o nome do usuário
        String nome = Utils.ReceberInputTexto(estado.s, "Por favor informe o seu nome ou digite 0 para voltar: ");
        estado.cliente.setNome(nome);
        estado.comanda.setCliente(estado.cliente);
        if (estado.cliente.getNome() == null) {
            estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
            return;
        }

        // Pergunta se quer delivery ou retira no balcão
        do {
            System.out.println("\nOlá " + estado.cliente.getNome() + "! Você gostaria de pedir por delivery ou retirar o pedido no balcão?");
            System.out.println("1 - Delivery");
            System.out.println("2 - Retirar no balcão");
            System.out.println("0 - Voltar");
            System.out.print("Sua escolha: ");
            estado.input = Utils.ReceberInputInt();

            switch (estado.input) {
                case 1 -> {
                    estado.comanda.setDelivery(true);
                    estado.telaAtual = EstadoApp.Tela.TELA_ENDERECO;
                    return;
                }
                case 2 -> {
                    estado.comanda.setDelivery(false);
                }
                default -> {
                    Utils.PrintOpcaoInvalida();
                }
            }
        } while (estado.input < 1 || estado.input > 2);

        estado.telaAtual = EstadoApp.Tela.TELA_CARDAPIO;
    }


    // Tela para pedir o endereço do usuário
    public static void TelaEndereco(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Preencher Endereço >>\n");

        // Pede o endereço do usuário caso é delivery
        if (estado.comanda.isDelivery()) {
            if (!estado.enderecoConfirmado) {
                // @formatter:off
                String input;
                System.out.println("Vamos precisar do seu endereço para realizar a entrega, ou digite 0 para cancelar");

                // CEP
                try {
                    input = Utils.ReceberInputTexto(estado.s, "Digite seu CEP: ");
                    if (input == null) { estado.telaAtual = EstadoApp.Tela.NOVO_PEDIDO; return; }
                    estado.cliente.setCep(input);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    Utils.EsperarEnter();
                    return;
                }

                // Nome da rua
                input = Utils.ReceberInputTexto(estado.s, "Digite o nome da rua: ");
                if (input == null) { estado.telaAtual = EstadoApp.Tela.NOVO_PEDIDO; return; }
                estado.cliente.setRua(input);

                // Número
                input = Utils.ReceberInputTexto(estado.s, "Digite o número e complemento se houver: ");
                if (input == null) { estado.telaAtual = EstadoApp.Tela.NOVO_PEDIDO; return; }
                estado.cliente.setNumero(input);

                // Bairro
                input = Utils.ReceberInputTexto(estado.s, "Digite o nome do bairro: ");
                if (input == null) { estado.telaAtual = EstadoApp.Tela.NOVO_PEDIDO; return; }
                estado.cliente.setBairro(input);

                // Cidade
                input = Utils.ReceberInputTexto(estado.s, "Digite a cidade: ");
                if (input == null) { estado.telaAtual = EstadoApp.Tela.NOVO_PEDIDO; return; }
                estado.cliente.setCidade(input);
                // @formatter:on
                System.out.println();
            }

            // Exibindo o endereço digitado
            System.out.println("Seu endereço:");
            System.out.println("CEP: " + estado.cliente.getCep());
            System.out.println("Endereço: Rua " + estado.cliente.getRua() + ", nº" + estado.cliente.getNumero() + " - " + estado.cliente.getBairro() + ", " + estado.cliente.getCidade() + "/" + estado.uf);
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
                    estado.telaAtual = EstadoApp.Tela.NOVO_PEDIDO;
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

        estado.telaAtual = EstadoApp.Tela.TELA_CARDAPIO;
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

        System.out.printf("\nValor Frete: R$ %.2f\n", estado.comanda.calcularFrete());
        System.out.printf("Subtotal:    R$ %.2f\n", estado.comanda.calcularTotal());
        System.out.printf("Total:       R$ %.2f\n", estado.comanda.calcularTotal() + estado.comanda.calcularFrete());

        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Ver pedido");
        System.out.println("11 a 15 - Escolher um lanche");
        System.out.println("21 a 25 - Escolher uma bebida ");
        System.out.println("31 a 35 - Escolher uma sobremesa");
        System.out.println("0 - Cancelar pedido");
        System.out.print("Sua escolha: ");
        estado.input = Utils.ReceberInputInt();

        // Usuário seleciona uma das opções válidas no cardápio
        if (cardapio.opcaoValida(estado.input)) {
            if (estado.input < 40) {
                System.out.print("\nOpção selecionada: ");
                cardapio.imprimirOpcao(estado.input);

                switch ((estado.input - 1) / 10) {
                    // Usuário seleciona um lanche
                    case 1 -> {
                        Lanche lanche = cardapio.getLanche(estado.input);
                        PedidoLanche pedidoLanche = new PedidoLanche(lanche);

                        System.out.println("\nSelecione um adicional ou 0 para finalizar:");
                        cardapio.imprimirAdicionais();

                        do {
                            System.out.print("Sua escolha: ");
                            estado.input = Utils.ReceberInputInt();
                            // Usuário seleciona um adicional
                            if (estado.input >= 41 && estado.input <= 45) {
                                pedidoLanche.setAdicionais(cardapio.getAdicional(estado.input));
                                System.out.println("Adicional adicionado com sucesso!\n");
                            }
                        } while (estado.input >= 41 && estado.input <= 45);

                        estado.comanda.setLanche(pedidoLanche);
                    }

                    // Usuário seleciona uma bebida
                    case 2 -> {
                        Bebida bebida = cardapio.getBebida(estado.input);
                        PedidoBebida pedidoBebida = new PedidoBebida(bebida);

                        System.out.println("\nEscolha o tamanho da bebida:");
                        System.out.printf("1 - Pequena R$ %.2f\n", pedidoBebida.getPreco('P'));
                        System.out.printf("2 - Média R$ %.2f\n", pedidoBebida.getPreco('M'));
                        System.out.printf("3 - Grande R$ %.2f\n", pedidoBebida.getPreco('G'));

                        do {
                            System.out.print("Sua escolha: ");
                            estado.input = Utils.ReceberInputInt();
                            // Usuário seleciona um tamanho
                            if (estado.input >= 1 && estado.input <= 3) {
                                pedidoBebida.setTamanho(estado.input);
                            } else {
                                Utils.PrintOpcaoInvalida();
                            }
                        } while (estado.input < 1 || estado.input > 3);

                        estado.comanda.setBebida(pedidoBebida);
                    }

                    // Usuário seleciona uma sobremesa
                    case 3 -> {
                        Sobremesa sobremesa = cardapio.getSobremesa(estado.input);
                        PedidoSobremesa pedidoSobremesa = new PedidoSobremesa(sobremesa);

                        System.out.println("\nVocê gostaria de pedir sem açúcar?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");

                        do {
                            System.out.print("\nSua escolha: ");
                            estado.input = Utils.ReceberInputInt();
                            // Usuário seleciona se quer com ou sem açucar
                            pedidoSobremesa.setAcucar(estado.input == 2);
                        } while (estado.input < 1 || estado.input > 2);

                        estado.comanda.setSobremesa(pedidoSobremesa);
                    }
                }

                estado.total = estado.comanda.calcularTotal();

                Utils.EsperarEnter();
                return;
            }
        }

        // Usuário seleciona uma opção de navegação
        switch (estado.input) {
            case 1 -> estado.telaAtual = EstadoApp.Tela.VER_PEDIDO;
            case 0 -> estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
            default -> Utils.PrintOpcaoInvalida();
        }
    }


    // Tela de ver o pedido
    public static void VerPedido(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Meu Pedido >>\n");

        estado.comanda.getDescricao(false);

        System.out.printf("\nTotal: R$ %.2f\n", estado.comanda.calcularTotal() + estado.comanda.calcularFrete());

        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Finalizar pedido");
        System.out.println("0 - Voltar");
        System.out.print("Sua escolha: ");
        estado.input = Utils.ReceberInputInt();

        switch (estado.input) {
            case 1 -> {
                if (estado.comanda.calcularTotal() == 0) {
                    System.out.println("Comanda vazia!");
                    Utils.EsperarEnter();
                    estado.telaAtual = EstadoApp.Tela.TELA_CARDAPIO;
                } else {
                    estado.telaAtual = EstadoApp.Tela.TELA_PAGAMENTO;
                }
            }
            case 0 -> estado.telaAtual = EstadoApp.Tela.TELA_CARDAPIO;
            default -> Utils.PrintOpcaoInvalida();
        }
    }


    // Tela de pagamento
    public static void TelaPagamento(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Pagamento >>");

        // Valor total
        System.out.printf("\nTotal: R$ %.2f\n", estado.comanda.calcularTotal() + estado.comanda.calcularFrete());

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

        // OBS FINALIZAÇÃO DO PAGAMENTO:
        // - O pedido atual deve ser adicionado a lista de pedidos com suas informações
        // - Armazenar também o tempo em que o pedido foi finalizado para calcular o tempo até a finalização do pedido

        // Adiciona o pedido finalizado à lista e atualiza a quantidade de pedidos
        // Adiciona o pedido finalizado à lista de pedidos
        estado.comandas.add(estado.comanda);

        // Atualiza a quantidade de pedidos
        estado.qtdPedidos++;

        // Encaminha a comanda para os setores da cozinha
        estado.encaminharComanda(estado.comanda);

        Utils.EsperarEnter();

        estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
    }


    // Tela de lista de pedidos
    public static void ListaPedidos(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Lista de Pedidos >>\n");

        // OBS LISTA PEDIDOS:
        // - Aqui deve ser exibido todos os pedidos da fila de pedidos
        // - Deverá também ter a opção do usuário selecionar o pedido pela numeração da comanda para ver detalhes

        if (estado.comandas.isEmpty()) {
            System.out.println("Nenhum pedido finalizado.");
        } else {
            for (Comanda comanda : estado.comandas) {
                System.out.printf("%d - Pedido %s - R$ %.2f%n", comanda.getComanda(), comanda.getCliente().getNome(), comanda.calcularTotal() + comanda.calcularFrete());
            }
        }

        System.out.print("\nSelecione um pedido pela comanda ou digite 0 para sair: ");
        estado.input = Utils.ReceberInputInt();

        if (estado.input == 0) {
            estado.telaAtual = EstadoApp.Tela.TELA_INICIAL;
            return;
        }

        estado.comandaSelecionada = null;
        for (Comanda comanda : estado.comandas) {
            if (comanda.getComanda() == estado.input) {
                estado.comandaSelecionada = comanda;
                break;
            }
        }

        if (estado.comandaSelecionada != null) {
            estado.telaAtual = EstadoApp.Tela.DETALHES_PEDIDO;
        } else {
            Utils.PrintOpcaoInvalida();
        }
    }


    // Tela de detalhes do pedido
    public static void DetalhesPedido(EstadoApp estado) {
        Utils.LimparConsole(estado);
        Telas.DesenharLogo();

        System.out.println("<< Detalhes do Pedido >>\n");

        // OBS DETALHES DO PEDIDO:
        // - Aqui deve ter as informações do pedido
        // - Exibir a etapa atual se for cozinha, ou tempo estimado até entrega se saiu da cozinha e for delivery

        if (estado.comandaSelecionada != null) {
            estado.comandaSelecionada.getDescricao(true);
        }

        Utils.EsperarEnter();
        estado.telaAtual = EstadoApp.Tela.LISTA_PEDIDOS;
    }


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
}
