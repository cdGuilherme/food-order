package seboso.food.order;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Lanche> lanches = new ArrayList<>();
    private ArrayList<Bebida> bebidas = new ArrayList<>();
    private ArrayList<Adicional> adicionais = new ArrayList<>();
    private ArrayList<Sobremesa> sobremesas = new ArrayList<>();

    public void iniciarCardapio() {
        lanches.add(new Lanche(11, "Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));
        lanches.add(new Lanche(12, "Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));
        lanches.add(new Lanche(13, "Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));
        lanches.add(new Lanche(14, "Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));
        lanches.add(new Lanche(15, "Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));

        adicionais.add(new Adicional(41, "Bacon", 5.99, "Frite o bacon em uma frigideira com peso em cima pra manter reta."));
        adicionais.add(new Adicional(42, "Bacon", 5.99, "Frite o bacon em uma frigideira com peso em cima pra manter reta."));
        adicionais.add(new Adicional(43, "Bacon", 5.99, "Frite o bacon em uma frigideira com peso em cima pra manter reta."));
        adicionais.add(new Adicional(44, "Bacon", 5.99, "Frite o bacon em uma frigideira com peso em cima pra manter reta."));
        adicionais.add(new Adicional(45, "Bacon", 5.99, "Frite o bacon em uma frigideira com peso em cima pra manter reta."));

        bebidas.add(new Bebida(21, "Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));
        bebidas.add(new Bebida(22, "Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));
        bebidas.add(new Bebida(23, "Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));
        bebidas.add(new Bebida(24, "Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));
        bebidas.add(new Bebida(25, "Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));

        sobremesas.add(new Sobremesa(31, "Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
        sobremesas.add(new Sobremesa(32, "Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
        sobremesas.add(new Sobremesa(33, "Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
        sobremesas.add(new Sobremesa(34, "Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
        sobremesas.add(new Sobremesa(35, "Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
    }

    public void imprimirCardapio() {
        System.out.println("Lanches:");
        for (Lanche atual : lanches) {
            System.out.println(atual.getOpcao() + " - " + atual.getNome() + " R$ " + atual.getPreco());
        }
        System.out.println("");
        System.out.println("Bebidas:");
        for (Bebida atual : bebidas) {
            System.out.printf("%d - %s R$ %.2f a R$ %.2f\n", atual.getOpcao(), atual.getNome(), atual.getPreco(), (atual.getPreco() + 6));
        }
        System.out.println("");
        System.out.println("Sobremesas:");
        for (Sobremesa atual : sobremesas) {
            System.out.println(atual.getOpcao() + " - " + atual.getNome() + " R$ " + atual.getPreco());
        }
    }

    public void imprimirLanches() {
        System.out.println("Lanches:");
        for (Lanche atual : lanches) {
            System.out.println(atual.getOpcao() + " - " + atual.getNome() + " R$ " + atual.getPreco());
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
            System.out.println(atual.getOpcao() + " - " + atual.getNome() + " R$ " + atual.getPreco());
        }
    }

    public void imprimirAdicionais() {
        System.out.println("Adicionais:");
        for (Adicional atual : adicionais) {
            System.out.println(atual.getOpcao() + " - " + atual.getNome() + " R$" + atual.getPreco());
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
                        System.out.println(atual.getNome() + " R$" + atual.getPreco());
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
