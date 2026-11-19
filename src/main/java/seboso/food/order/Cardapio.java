package seboso.food.order;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Lanche> lanches = new ArrayList<>();
    private ArrayList<Bebida> bebidas = new ArrayList<>();
    private ArrayList<Adicional> adicionais = new ArrayList<>();
    
    public void adicionarLanche(String nome, double preco, String pao, String hamburguer, String queijo, String salada) {
        Lanche novoLanche = new Lanche(nome, preco, pao, hamburguer, queijo, salada);
        lanches.add(novoLanche);
    }
    
    public void adicionarBebida(String nome, double preco, char tamanho, String preparo) {
        Bebida novaBebida = new Bebida(nome, preco, tamanho);
        bebidas.add(novaBebida);
    }
    
    public void adicionarAdicional(String nome, double preco, String preparo) {
        Adicional novoAdicional = new Adicional(nome, preco, preparo);
        adicionais.add(novoAdicional);
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
