package seboso.food.order;

public class Comanda implements ComandaInterface {
    private Cliente cliente;
    private PedidoLanche lanche;
    private int qtdLanches;
    private PedidoBebida bebida;
    private int qtdBebidas;
    private PedidoSobremesa sobremesa;
    private int qtdSobremesas;
    private Integer mesa;
    private boolean delivery;

    Comanda(Cliente cliente, PedidoLanche lanche, int qtdLanches, PedidoBebida bebida, int qtdBebidas, PedidoSobremesa sobremesa, int qtdSobremesas) {
        this.cliente = cliente;
        this.lanche = lanche;
        this.qtdLanches = qtdLanches;
        this.bebida = bebida;
        this.qtdBebidas = qtdBebidas;
        this.sobremesa = sobremesa;
        this.qtdSobremesas = qtdSobremesas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PedidoLanche getlanche() {
        return lanche;
    }

    public int getQuantidade() {
        return qtdLanches;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        if (mesa != null && mesa <= 0) {
            throw new IllegalArgumentException("O número da mesa deve ser positivo.");
        }
        this.mesa = mesa;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
        if (delivery) {
            mesa = null;
        }
    }

    private void setQuantidade(int qtdLanches) {
        if (qtdLanches <= 0) {
            throw new IllegalArgumentException("O número deve ser maior que 0");
        }
        this.qtdLanches = qtdLanches;
    }

    @Override
    public double calcularTotal() {
        double valorLanche = lanche == null ? 0.0 : lanche.getPreco() * qtdLanches;
        double valorBebidas = bebida == null ? 0.0 : bebida.getPreco() * qtdBebidas;
        double valorSobremesa = sobremesa == null ? 0.0 : sobremesa.getPreco() * qtdSobremesas;
        return valorLanche + valorBebidas + valorSobremesa;
    }

    @Override
    public void alterarQuantidade(int qtdLanches) {
        setQuantidade(qtdLanches);
    }

    @Override
    public String getDescricao() {
        String local = delivery ? "Delivery" : (mesa == null ? "Mesa não informada" : "Mesa " + mesa);
        return qtdLanches + "x " + lanche.getNome() + " - " + local;
    }

    @Override
    public String toString() {
        return getDescricao() + " | Total: R$ " + String.format("%.2f", calcularTotal());
    }
}
