package seboso.food.order;

import java.util.ArrayList;

public class Bebida extends Produto{
    private String preparo;
    
    Bebida(int opcao, String nome, double preco, String preparo) {
        super(opcao, nome, preco);
        setPreparo(preparo);
    }

    @Override
    public void modoPreparo(ArrayList<Adicional> adicionais) {}

    @Override
    public void modoPreparo() {
        System.out.println(preparo);
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }
}
