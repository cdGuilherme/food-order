package seboso.food.order;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Lanche> lanches = new ArrayList<>();
    private ArrayList<Bebida> bebidas = new ArrayList<>();
    private ArrayList<Adicional> adicionais = new ArrayList<>();
    
    public void adicionarLanche(String nome, double preco, String preparo) {
        Lanche novoLanche = new Lanche(nome, preco, preparo);
        lanches.add(novoLanche);
    }

    public void imprimirCardapio() {
        System.out.println(lanches);
    }
}
