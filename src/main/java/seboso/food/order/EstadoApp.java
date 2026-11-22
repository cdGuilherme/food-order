// Variáveis globais e state machine

package seboso.food.order;

import java.util.Scanner;
import java.util.ArrayList;

public class EstadoApp {
    // Import do scanner para ler as entradas do usuário
    Scanner s = new Scanner(System.in);

    // Enums //
    // ////////


    // Telas disponíveis para serem selecionadas pelo state machine
    public enum Tela {
        TELA_INICIAL, NOVO_PEDIDO, TELA_ENDERECO, TELA_CARDAPIO, VER_PEDIDO, TELA_PAGAMENTO, LISTA_PEDIDOS, DETALHES_PEDIDO, COZINHA, DETALHES_COZINHA, SAIR
    }

    // Métodos disponíveis para limpeza de tela
    public enum MetodoLimpeza {
        QUEBRAR_LINHAS, LIMPAR_TELA, AMBOS
    }

    // Formas de pagamento disponíveis
    public enum FormasPagamento {
        DINHEIRO, PIX, DEBITO, CREDITO
    }


    // Variáveis e Objetos //
    // //////////////////////

    // OBS VARIÁVEIS GLOBAIS
    // - Mudar a implementação atual dessas variáveis para utilizarem os getters e setters de suas classes respectivas

    public int qtdPedidos = 0;

    // Comandas finalizadas e pedido atualmente em edição
    public ArrayList<Comanda> comandas = new ArrayList<>();
    public Comanda comanda = new Comanda(qtdPedidos + 1);
    public Comanda comandaSelecionada;
    public Cliente cliente = new Cliente("a");

    // Fila compartilhada de comandas da cozinha
    public ArrayList<Comanda> filaComanda = new ArrayList<>();

    // Cozinheiros internos do sistema
    public Cozinheiro cozinheiroGrelha;
    public Cozinheiro cozinheiroBar;
    public Cozinheiro cozinheiroConfeitaria;

    public String uf = "SP";
    public boolean enderecoConfirmado = false;

    public boolean delivery; // Pedido é delivery ou cliente retira no balcão
    public int input; // Input do usuário para navegar o programa pelo console
    public double total = comanda.calcularTotal(); // Valor total do pedido atual

    public MetodoLimpeza metodoLimpeza = MetodoLimpeza.AMBOS; // Como é feito a limpeza da tela
    public Tela telaAtual = Tela.TELA_INICIAL; // Funcionamento do state machine
    public FormasPagamento formaPagamento; // Forma de pagamento atualmente selecionada


    // Métodos //
    // //////////

    // OBS MÉTODOS:
    // - Mudar essa implementação atual de limpar os dados do usuário para seus respectivos getters e setters
    public EstadoApp() {

        // INICIALIZANDO OS COZINHEIROS
        cozinheiroGrelha = new Cozinheiro("Cozinheiro da Grelha", filaComanda);
        cozinheiroBar = new Cozinheiro("Cozinheiro do Bar", filaComanda);
        cozinheiroConfeitaria = new Cozinheiro("Cozinheiro da Confeitaria", filaComanda);

        // JÁ CRIA OS SETORES
        Cozinha grelha = new Cozinha(cozinheiroGrelha, "grelha");
        Cozinha bar = new Cozinha(cozinheiroBar, "bar");
        Cozinha confeitaria = new Cozinha(cozinheiroConfeitaria, "confeitaria");

        // COLOCA UMA COZINHEIRO PARA CADA SETOR JÁ
        cozinheiroGrelha.setCozinha(grelha);
        cozinheiroBar.setCozinha(bar);
        cozinheiroConfeitaria.setCozinha(confeitaria);
    }

    public void encaminharComanda(Comanda comanda) {

        if (comanda == null) {
            System.out.println("Não foi possível enviar. Comanda inválida.");
            return;
        }

        filaComanda.add(comanda);

        System.out.println(
            "\nComanda " + comanda.getComanda()
            + " encaminhada para a cozinha!"
        );

        /*
        cozinheiroGrelha.executarFuncao();
        cozinheiroBar.executarFuncao();
        cozinheiroConfeitaria.executarFuncao();

         */
    }


    // Exibir passo a passo da cozinha
    public void exibirPassoAPasso() {
        cozinheiroGrelha.executarFuncao();
        cozinheiroBar.executarFuncao();
        cozinheiroConfeitaria.executarFuncao();
    }


    // Limpa os dados do pedido do usuário
    public void LimparDadosPedido() {
        comanda = new Comanda(qtdPedidos + 1);
        cliente = new Cliente("a");

        cliente.setNome("a");
        cliente.setCep("00000000");
        cliente.setRua("a");
        cliente.setNumero("20, abc");
        cliente.setBairro("a");
        cliente.setCidade("a");

        enderecoConfirmado = false;
        delivery = true;
        formaPagamento = null;
        total = comanda.calcularTotal() + comanda.calcularFrete();
        input = -1;
    }
}
