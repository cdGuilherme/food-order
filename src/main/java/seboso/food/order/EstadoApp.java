// Variáveis globais e state machine

package seboso.food.order;

import java.util.Scanner;

public class EstadoApp {
    // Import do scanner para ler as entradas do usuário
    Scanner s = new Scanner(System.in);


    // Enums //
    // ////////


    // Telas disponíveis para serem selecionadas pelo state machine
    public enum Tela {
        TELA_INICIAL, NOVO_PEDIDO, TELA_CARDAPIO, VER_PEDIDO, TELA_PAGAMENTO, LISTA_PEDIDOS, DETALHES_PEDIDO, SAIR
    }

    // Métodos disponíveis para limpeza de tela
    public enum MetodoLimpeza {
        QUEBRAR_LINHAS, LIMPAR_TELA, AMBOS
    }

    // Formas de pagamento disponíveis
    public enum FormasPagamento {
        DINHEIRO, PIX, DEBITO, CREDITO
    }


    // Variáveis //
    // ////////////

    // OBS VARIÁVEIS GLOBAIS
    // - Mudar a implementação atual dessas variáveis para utilizarem os getters e setters de suas classes respectivas

    public String nome; // Nome do usuário
    public String cep;
    public String endereco;
    public String numero;
    public String bairro;
    public String cidade;
    public String uf = "SP";
    public boolean enderecoConfirmado = false;

    public boolean delivery; // Pedido é delivery ou cliente retira no balcão
    public int input; // Input do usuário para navegar o programa pelo console
    public double total; // Valor total do pedido atual

    public MetodoLimpeza metodoLimpeza = MetodoLimpeza.AMBOS; // Como é feito a limpeza da tela
    public Tela telaAtual = Tela.TELA_INICIAL; // Funcionamento do state machine
    public FormasPagamento formaPagamento; // Forma de pagamento atualmente selecionada


    // Métodos //
    // //////////

    // OBS MÉTODOS:
    // - Mudar essa implementação atual de limpar os dados do usuário para seus respectivos getters e setters

    // Limpa os dados do pedido do usuário
    public void LimparDadosPedido() {
        nome = null;
        cep = null;
        endereco = null;
        numero = null;
        bairro = null;
        cidade = null;

        enderecoConfirmado = false;
        delivery = true;
        formaPagamento = null;
        total = 0.0;
        input = -1;
    }
}
