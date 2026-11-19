package seboso.food.order;

public class Sobremesa extends Produto {
    private String preparo;
    public Sobremesa(String nome, double preco, String preparo) {
        super(nome, preco);
        setPreparo(preparo);
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }
}
