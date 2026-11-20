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
        SAIR
    }

    // Método de limpeza de tela
    public enum MetodoLimpeza {
        QUEBRAR_LINHAS,
        LIMPAR_TELA,
        AMBOS
    }


    // Variáveis //
    // ////////////

    // TODO:
    // - Mudar os public's para private e acessar e armazenar os dados utilizando suas classes
    public String nome; // Nome do usuário
    public boolean delivery = true; // Pedido é delivery ou cliente retira no balcão
    public int input = -1; // Input do usuário para navegar o programa pelo console
    public Tela telaAtual = Tela.TELA_INICIAL;
    public MetodoLimpeza metodoLimpeza = MetodoLimpeza.AMBOS;
}
