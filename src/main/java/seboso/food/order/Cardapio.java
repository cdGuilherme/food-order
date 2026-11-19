package seboso.food.order;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Lanche> lanches = new ArrayList<>();
    private ArrayList<Bebida> bebidas = new ArrayList<>();
    private ArrayList<Adicional> adicionais = new ArrayList<>();
    private ArrayList<Sobremesa> sobremesas = new ArrayList<>();
    
    public void iniciarCardapio() {
        lanches.add(new Lanche("Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));
        lanches.add(new Lanche("Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));
        lanches.add(new Lanche("Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));
        lanches.add(new Lanche("Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));
        lanches.add(new Lanche("Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface roxa"));

        adicionais.add(new Adicional("Bacon", 5.99,"Frite o bacon em uma frigideira com peso em cima pra manter reta."));
        adicionais.add(new Adicional("Bacon", 5.99,"Frite o bacon em uma frigideira com peso em cima pra manter reta."));
        adicionais.add(new Adicional("Bacon", 5.99,"Frite o bacon em uma frigideira com peso em cima pra manter reta."));
        adicionais.add(new Adicional("Bacon", 5.99,"Frite o bacon em uma frigideira com peso em cima pra manter reta."));
        adicionais.add(new Adicional("Bacon", 5.99,"Frite o bacon em uma frigideira com peso em cima pra manter reta."));

        bebidas.add(new Bebida("Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));
        bebidas.add(new Bebida("Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));
        bebidas.add(new Bebida("Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));
        bebidas.add(new Bebida("Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));
        bebidas.add(new Bebida("Limonada", 15.99, "Bata o limão sem o miolo com casca no liquidificador, coe com uma peneira, e adicione açucar"));

        sobremesas.add(new Sobremesa("Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
        sobremesas.add(new Sobremesa("Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
        sobremesas.add(new Sobremesa("Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
        sobremesas.add(new Sobremesa("Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
        sobremesas.add(new Sobremesa("Petit Gateau", 12.49, "Derreta o chocolate e a manteiga, bata os ovos e o açucar, junte a massa, asse entre 5 a 12 min"));
    }

    public void imprimirCardapio() {
        System.out.println("Lanches:");
        for (Lanche atual : lanches) {
            System.out.println(atual.getNome() + " R$" + atual.getPreco());
        }
        System.out.println("");
        System.out.println("Bebidas:");
        for (Bebida atual : bebidas) {
            System.out.println(atual.getNome() +" R$" + atual.getPreco());
        }
        System.out.println("");
        System.out.println("Adicionais:");
        for (Adicional atual : adicionais) {
            System.out.println(atual.getNome() +" R$"+ atual.getPreco());
        }
        System.out.println("");
    }
}
