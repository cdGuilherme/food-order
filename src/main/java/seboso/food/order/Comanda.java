package seboso.food.order;

public class Comanda implements ComandaInterface {
    private Cliente cliente;
    private PedidoLanche lanche;
    private int quantidade;
    private Integer mesa;
    private boolean delivery;

    public Comanda(Cliente cliente, PedidoLanche lanche, int quantidade) {
        this(cliente, lanche, quantidade, null, false);
    }

    public Comanda(Cliente cliente, PedidoLanche lanche, int quantidade, int mesa) {
        this(cliente, lanche, quantidade, mesa, false);
    }

    public Comanda(Cliente cliente, PedidoLanche lanche, int quantidade, boolean delivery) {
        this(cliente, lanche, quantidade, null, delivery);
    }

    public Comanda(Cliente cliente, PedidoLanche lanche, int quantidade, Integer mesa, boolean delivery) {
        setCliente(cliente);
        setLanche(lanche);
        setQuantidade(quantidade);
        setMesa(mesa);
        setDelivery(delivery);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
        }
        this.cliente = cliente;
    }

    public PedidoLanche getlanche() {
        return lanche;
    }

    public void setLanche(PedidoLanche lanche) {
        if (lanche == null) {
            throw new IllegalArgumentException("O lanche não pode ser nulo.");
        }
        this.lanche = lanche;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
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

    @Override
    public double calcularTotal() {
        return lanche.getPreco() * quantidade;
    }

    @Override
    public void alterarQuantidade(int quantidade) {
        setQuantidade(quantidade);
    }

    @Override
    public String getDescricao() {
        String local = delivery ? "Delivery" : (mesa == null ? "Mesa não informada" : "Mesa " + mesa);
        return quantidade + "x " + lanche.getNome() + " - " + local;
    }

    @Override
    public String toString() {
        return getDescricao() + " | Total: R$ " + String.format("%.2f", calcularTotal());
    }
}
