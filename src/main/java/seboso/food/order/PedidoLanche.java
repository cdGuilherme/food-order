package seboso.food.order;

import java.util.ArrayList;

public class PedidoLanche {
    private Lanche lanche;
    private ArrayList<Adicional> adicionais = new ArrayList<>();

    public PedidoLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public void addAdicionais(Adicional adicional) {
        adicionais.add(adicional);
    }

    public void fazerLanche() {
        lanche.fazerLanche(adicionais);
    }
}
