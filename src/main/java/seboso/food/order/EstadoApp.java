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
    
    public Comanda comandaAtual;
    private int proximoNumeroComanda = 1;

    public boolean delivery; // Pedido é delivery ou cliente retira no balcão
    public int input; // Input do usuário para navegar o programa pelo console
    public double total; // Valor total do pedido atual

    public MetodoLimpeza metodoLimpeza = MetodoLimpeza.AMBOS; // Como é feito a limpeza da tela
    public Tela telaAtual = Tela.TELA_INICIAL; // Funcionamento do state machine
    public FormasPagamento formaPagamento; // Forma de pagamento atualmente selecionada
    
    // Fila compartilhada de comandos <- inclementado agora
    public ArrayList<Comanda> filaComanda = new ArrayList<>();

    
    // cozinheiros de cada setor
    public Cozinheiro cozinheiroGrelha;
    public Cozinheiro cozinheiroBar;
    public Cozinheiro cozinheiroConfeitaria;
    
    
    
    // Construtor //
    // ////////////
    public EstadoApp() 
    {
        // Inicializa os cozinheiros compartilhando a mesma fila
        cozinheiroGrelha = new Cozinheiro("Cozinheiro da Grelha", filaComanda);
        cozinheiroBar = new Cozinheiro("Cozinheiro do Bar", filaComanda);
        cozinheiroConfeitaria = new Cozinheiro("Cozinheiro da Confeitaria", filaComanda);

        // Cria os setores
        Cozinha grelha = new Cozinha(cozinheiroGrelha, "grelha");
        Cozinha bar = new Cozinha(cozinheiroBar, "bar");
        Cozinha confeitaria = new Cozinha(cozinheiroConfeitaria, "confeitaria");

        // Vincula cada cozinheiro ao seu setor
        cozinheiroGrelha.setCozinha(grelha);
        cozinheiroBar.setCozinha(bar);
        cozinheiroConfeitaria.setCozinha(confeitaria);
    }
    
    // Métodos //
    // //////////

    // OBS MÉTODOS:
    // - Mudar essa implementação atual de limpar os dados do usuário para seus respectivos getters e setters
    
    public void iniciarNovaComanda() {
        comandaAtual = new Comanda(proximoNumeroComanda++);
        comandaAtual.setDelivery(delivery);
    }
    
    public void encaminharComanda(Comanda comanda)
    {
        if(comanda == null)
        {
            System.out.println("Não foi possivel enviar. Comanda invalida");
            return;
        }
        
        filaComanda.add(comanda);

        System.out.println("\nComanda " + comanda.getComanda() + " encaminhada para a cozinha!");

        cozinheiroGrelha.executarFuncao();
        cozinheiroBar.executarFuncao();
        cozinheiroConfeitaria.executarFuncao();
    }

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
