package seboso.food.order;

import java.util.ArrayList;

public class PedidoLanche {
    private Lanche lanche;
    private ArrayList<Adicional> adicionais = new ArrayList<>();

    PedidoLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public void fazerLanche() {
        lanche.modoPreparo(adicionais);
    }

    public double getPreco() {
        double totalAdicionais = 0;
        for (Adicional atual : adicionais) {
            totalAdicionais += atual.getPreco();
        }
        return lanche.getPreco() + totalAdicionais;
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

    public void setAdicionais(Adicional adicional) {
        this.adicionais.add(adicional);
    }
}
