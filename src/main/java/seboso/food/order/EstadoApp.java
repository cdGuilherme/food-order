package seboso.food.order;

import java.util.Scanner;

public class EstadoApp {
    // Import do scanner para ler as entradas do usuário
    Scanner s = new Scanner(System.in);


    // Enums //
    // ////////


    // Tela
    public enum Tela {
        TELA_INICIAL,
        NOVO_PEDIDO,
        LISTA_PEDIDOS,
        TELA_CARDAPIO,
        VER_PEDIDO,
        TELA_PAGAMENTO,
        SAIR
    }

    // Método de limpeza de tela
    public enum MetodoLimpeza {
        QUEBRAR_LINHAS,
        LIMPAR_TELA,
        AMBOS
    }

    // Formas de pagamento
    public enum FormasPagamento {
        DINHEIRO,
        PIX,
        DEBITO,
        CREDITO
    }


    // Variáveis //
    // ////////////


    // TODO:
    // - Mudar os public's para private e acessar e armazenar os dados utilizando suas classes
    public String nome; // Nome do usuário
    public String cep;
    public String endereco;
    public String numero;
    public String bairro;
    public String cidade;
    public boolean enderecoConfirmado = false;

    public boolean delivery; // Pedido é delivery ou cliente retira no balcão
    public int input; // Input do usuário para navegar o programa pelo console
    public double total;

    public Tela telaAtual = Tela.TELA_INICIAL;
    public MetodoLimpeza metodoLimpeza = MetodoLimpeza.AMBOS;
    public FormasPagamento formaPagamento;


    // Métodos //
    // //////////


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
