package seboso.food.order;

public class Comanda implements ComandaInterface {
    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private Integer mesa;
    private boolean delivery;

    public Comanda(Cliente cliente, Produto produto, int quantidade) {
        this(cliente, produto, quantidade, null, false);
    }

    public Comanda(Cliente cliente, Produto produto, int quantidade, int mesa) {
        this(cliente, produto, quantidade, mesa, false);
    }

    public Comanda(Cliente cliente, Produto produto, int quantidade, boolean delivery) {
        this(cliente, produto, quantidade, null, delivery);
    }

    public Comanda(Cliente cliente, Produto produto, int quantidade, Integer mesa, boolean delivery) {
        setCliente(cliente);
        setProduto(produto);
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        this.produto = produto;
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
        return produto.getPreco() * quantidade;
    }

    @Override
    public void alterarQuantidade(int quantidade) {
        setQuantidade(quantidade);
    }

    @Override
    public String getDescricao() {
        String local = delivery ? "Delivery" : (mesa == null ? "Mesa não informada" : "Mesa " + mesa);
        return quantidade + "x " + produto.getNome() + " - " + local;
    }

    @Override
    public String toString() {
        return getDescricao() + " | Total: R$ " + String.format("%.2f", calcularTotal());
    }
}
