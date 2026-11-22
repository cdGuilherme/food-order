package seboso.food.order;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Lanche> lanches = new ArrayList<>();
    private ArrayList<Bebida> bebidas = new ArrayList<>();
    private ArrayList<Adicional> adicionais = new ArrayList<>();
    private ArrayList<Sobremesa> sobremesas = new ArrayList<>();

    public void iniciarCardapio() {
        lanches.add(new Lanche(11, "Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));
        lanches.add(new Lanche(12, "Clássico", 28.99, "Australiano", "carne bovina", "Prato", "Alface e tomate"));
        lanches.add(new Lanche(13, "Frango Grelhado", 31.99, "de Batata", "filé de frango", "Muçarela", "Alface americana e cenoura ralada"));
        lanches.add(new Lanche(14, "Vegetariano", 29.99, "Integral", "grão-de-bico", "Coalho", "Rúcula e tomate seco"));
        lanches.add(new Lanche(15, "Smash Duplo", 34.99, "Brioche", "carne bovina smash", "American", "Cebola caramelizada e picles"));
        lanches.add(new Lanche(16, "Hambúrguer Gourmet", 39.99, "Brioche artesanal", "costela e fraldinha", "Gorgonzola", "Rúcula e cebola roxa"));

        adicionais.add(new Adicional(41, "Bacon", 5.99, "Frite o bacon em uma frigideira com peso em cima para mantê-lo reto."));
        adicionais.add(new Adicional(42, "Ovo", 3.99, "Frite o ovo na chapa com a gema no ponto e coloque sobre o hambúrguer."));
        adicionais.add(new Adicional(43, "Cebola Empanada", 6.49, "Corte a cebola em anéis, empane e frite em óleo quente até dourar, escorra em papel toalha."));
        adicionais.add(new Adicional(44, "Cheddar Cremoso", 4.99, "Aqueça o cheddar em banho-maria até ficar cremoso e espalhe por cima do hambúrguer."));
        adicionais.add(new Adicional(45, "Molho Especial", 2.99, "Misture maionese, mostarda, ketchup e uma pitada de páprica e espalhe no pão."));
        adicionais.add(new Adicional(46, "Queijo Extra", 3.49, "Coloque uma fatia extra de queijo muçarela sobre o hambúrguer ainda na chapa para derreter."));

        bebidas.add(new Bebida(21, "Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira e adicione açúcar"));
        bebidas.add(new Bebida(22, "Suco de Laranja", 12.99, "Esprema as laranjas, coe para tirar o bagaço e sirva com bastante gelo"));
        bebidas.add(new Bebida(23, "Coca-Cola lata", 9.99, "Sirva bem gelado em copo com gelo e uma rodela de limão"));
        bebidas.add(new Bebida(24, "Milkshake de Chocolate", 19.99, "Bata no liquidificador sorvete de baunilha, leite e calda de chocolate até ficar cremoso"));
        bebidas.add(new Bebida(25, "Chá preto gelado", 11.99, "Prepare o chá preto, adoce, deixe esfriar, e sirva com gelo"));

        sobremesas.add(new Sobremesa(31, "Petit Gâteau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açúcar, junte a massa, asse entre 5 a 12 min"));
        sobremesas.add(new Sobremesa(32, "Pudim de Leite", 9.99, "Caramelize o açúcar na forma, bata leite condensado, leite e ovos no liquidificador, asse em banho-maria por 1h e leve à geladeira"));
        sobremesas.add(new Sobremesa(33, "Brownie com Sorvete", 14.99, "Aqueça o brownie, coloque uma bola de sorvete de creme por cima e finalize com calda de chocolate"));
        sobremesas.add(new Sobremesa(34, "Torta de Limão", 11.99, "Monte a base de biscoito com manteiga, cubra com o creme de limão e finalize com suspiro dourado no maçarico"));
        sobremesas.add(new Sobremesa(35, "Churros", 10.49, "Frite a massa em óleo quente até dourar, passe no açúcar com canela e recheie com doce de leite"));
    }

    public void imprimirCardapio() {
        System.out.println("Lanches:");
        for (Lanche atual : lanches) {
            System.out.printf("%d - %s R$ %.2f\n", atual.getOpcao(), atual.getNome(), atual.getPreco());
        }
        System.out.println("");
        System.out.println("Bebidas:");
        for (Bebida atual : bebidas) {
            System.out.printf("%d - %s R$ %.2f a R$ %.2f\n", atual.getOpcao(), atual.getNome(), atual.getPreco(), (atual.getPreco() + 6));
        }
        System.out.println("");
        System.out.println("Sobremesas:");
        for (Sobremesa atual : sobremesas) {
            System.out.printf("%d - %s R$ %.2f\n", atual.getOpcao(), atual.getNome(), atual.getPreco());
        }
    }

    public void imprimirLanches() {
        System.out.println("Lanches:");
        for (Lanche atual : lanches) {
            System.out.printf("%d - %s R$ %.2f\n", atual.getOpcao(), atual.getNome(), atual.getPreco());
        }
    }

    public void imprimirBebidas() {
        System.out.println("Bebidas:");
        for (Bebida atual : bebidas) {
            System.out.printf("%d - %s R$ %.2f a R$ %.2f\n", atual.getOpcao(), atual.getNome(), atual.getPreco(), (atual.getPreco() + 6));
        }
    }

    public void imprimirSobremesas() {
        System.out.println("Sobremesas:");
        for (Sobremesa atual : sobremesas) {
            System.out.printf("%d - %s R$ %.2f\n", atual.getOpcao(), atual.getNome(), atual.getPreco());
        }
    }

    public void imprimirAdicionais() {
        System.out.println("Adicionais:");
        for (Adicional atual : adicionais) {
            System.out.printf("%d - %s R$ %.2f\n", atual.getOpcao(), atual.getNome(), atual.getPreco());
        }
    }

    public void imprimirOpcao(int opcao) {
        switch ((opcao - 1) / 10) {
            case 1 -> {
                for (Lanche atual : lanches) {
                    if (opcao == atual.getOpcao()) {
                        System.out.println(atual.getNome());
                        return;
                    }
                }
            }
            case 2 -> {
                for (Bebida atual : bebidas) {
                    if (opcao == atual.getOpcao()) {
                        System.out.println(atual.getNome());
                        return;
                    }
                }
            }
            case 3 -> {
                for (Sobremesa atual : sobremesas) {
                    if (opcao == atual.getOpcao()) {
                        System.out.println(atual.getNome());
                        return;
                    }
                }
            }
            case 4 -> {
                for (Adicional atual : adicionais) {
                    if (opcao == atual.getOpcao()) {
                        System.out.printf("%s R$ %.2f\n", atual.getNome(), atual.getPreco());
                        return;
                    }
                }
            }
        }
    }


    // Retorna true se a opção é válida ou false se não
    public boolean opcaoValida(int opcao) {
        switch ((opcao - 1) / 10) {
            case 1 -> {
                for (Lanche atual : lanches) {
                    if (opcao == atual.getOpcao()) {
                        return true;
                    }
                }
            }
            case 2 -> {
                for (Bebida atual : bebidas) {
                    if (opcao == atual.getOpcao()) {
                        return true;
                    }
                }
            }
            case 3 -> {
                for (Sobremesa atual : sobremesas) {
                    if (opcao == atual.getOpcao()) {
                        return true;
                    }
                }
            }
            case 4 -> {
                for (Adicional atual : adicionais) {
                    if (opcao == atual.getOpcao()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    // Retorna o lanche selecionado
    public Lanche getLanche(int opcao) {
        for (Lanche atual : lanches) {
            if (opcao == atual.getOpcao()) {
                return atual;
            }
        }
        return null;
    }

    // Retorna a bebida selecionada
    public Bebida getBebida(int opcao) {
        for (Bebida atual : bebidas) {
            if (opcao == atual.getOpcao()) {
                return atual;
            }
        }
        return null;
    }

    // Retorna a sobremesa selecionada
    public Sobremesa getSobremesa(int opcao) {
        for (Sobremesa atual : sobremesas) {
            if (opcao == atual.getOpcao()) {
                return atual;
            }
        }
        return null;
    }

    // Retorna o adicional selecionado
    public Adicional getAdicional(int opcao) {
        for (Adicional atual : adicionais) {
            if (opcao == atual.getOpcao()) {
                return atual;
            }
        }
        return null;
    }
}