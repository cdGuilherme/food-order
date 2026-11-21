package seboso.food.order;

import java.util.ArrayList;

public class Adicional extends Produto{
    private String preparo;
    Adicional(int opcao, String nome, double preco, String preparo) {
        super(opcao, nome, preco);
        this.preparo = preparo;
    }

    @Override
    public void modoPreparo() {
        System.out.println(preparo);
    }

    @Override
    public void modoPreparo(ArrayList<Adicional> adicionais) {}
}
