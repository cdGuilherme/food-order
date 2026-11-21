package seboso.food.order;

public interface ComandaInterface {
    double calcularTotal();
    boolean isDelivery();
    void getDescricao(boolean detalhada);
}
