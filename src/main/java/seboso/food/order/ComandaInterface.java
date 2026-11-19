package seboso.food.order;

public interface ComandaInterface {
    double calcularTotal();
    void alterarQuantidade(int quantidade);
    boolean isDelivery();
    String getDescricao();
}
