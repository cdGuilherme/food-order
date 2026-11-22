// Funções úteis para a execução do programa //
// ////////////////////////////////////////////

package seboso.food.order;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    // Pausa o programa até o usuário apertar <ENTER>
    public static void EsperarEnter() {
        Scanner s = new Scanner(System.in);
        System.out.print("Pressione <ENTER> para continuar...");
        s.nextLine();
    }


    // Recebe um input do usuário do tipo int, com tratamento de dados para evitar crashar o programa
    public static int ReceberInputInt() {
        Scanner s = new Scanner(System.in);
        int input;
        try {
            input = s.nextInt();
        } catch (InputMismatchException e) {
            // Usuário digita outra coisa sem ser um número inteiro
            input = -1;
            s.nextLine();
        }
        return input;
    }


    // Função de quebrar linhas
    public static void QuebrarLinhas(int qtdLinhas) {
        // Pode "limpar" a tela inserindo um valor alto de "\n" para simular uma limpeza de tela
        // Possui suporte para todos os terminais
        System.out.print("\n".repeat(Math.max(0, qtdLinhas)));
    }


    // Função de limpar a tela
    /*
    public static void LimparTela() {
        // Se o terminal conseguir interpretar comandos ANSI, uma limpeza real da tela será feita
        // Suporte limitado se testar no terminal de um IDE ou se usar o cmd do Windows
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // "\033[H": posiciona o cursor no início do terminal
        // "\033[2J": limpa a tela
    }
     */
    // Limpa o console caso suportado pelo terminal
    public static void LimparTela() {
        try {
            String sistema = System.getProperty("os.name").toLowerCase();
            if (sistema.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Não faz nada caso não seja possível limpar o console.
        }
    }


    // Método utilizado para limpeza de tela
    public static void LimparConsole(EstadoApp estado) {
        switch (estado.metodoLimpeza) {
            case QUEBRAR_LINHAS -> QuebrarLinhas(100);
            case LIMPAR_TELA -> LimparTela();
            case AMBOS -> {
                QuebrarLinhas(100);
                LimparTela();
            }
        }
    }


    // Exibe na tela opção inválida
    public static void PrintOpcaoInvalida() {
        System.out.println("Opção inválida!");
        Utils.EsperarEnter();
    }


    // Receber entrada de texto do usuário
    public static String ReceberInputTexto(Scanner s, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = s.nextLine();

            if (input.equals("0"))
                return null;

            if (input.isBlank())
                continue;

            return input;
        }
    }
}
