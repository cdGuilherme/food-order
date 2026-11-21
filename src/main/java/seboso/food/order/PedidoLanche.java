package seboso.food.order;

import java.util.ArrayList;

public class PedidoLanche {
    private Lanche lanche;
    private ArrayList<Adicional> adicionais = new ArrayList<>();

    PedidoLanche(Lanche lanche) {
        this(lanche,null);
    }

    PedidoLanche(Lanche lanche, ArrayList<Adicional> adicionais) {
        this.lanche = lanche;
        if (adicionais != null) {
            this.adicionais.addAll(adicionais);
        }
    }

    public void fazerLanche() {
        lanche.modoPreparo(adicionais);
    }

    public double getPreco() {
        return lanche.getPreco();
    }

    public String getNome() {
        return lanche.getNome();
    }

    public Lanche getLanche() {
        return lanche;
    }

    public ArrayList<Adicional> getAdicionais() {
        return adicionais;
    }
}
