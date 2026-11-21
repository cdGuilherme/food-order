package seboso.food.order;

import java.util.ArrayList;

public class Sobremesa extends Produto {
    private String preparo;
    public Sobremesa(int opcao, String nome, double preco, String preparo) {
        super(opcao, nome, preco);
        setPreparo(preparo);
    }

    @Override
    public void modoPreparo(ArrayList<Adicional> adicionais) {}

    @Override
    public void modoPreparo() {
        System.out.println(preparo);
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }
}
