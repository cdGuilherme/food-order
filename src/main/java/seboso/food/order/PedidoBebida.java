package seboso.food.order;

public class PedidoBebida {
    private char tamanho;
    private Bebida bebida;

    PedidoBebida(char tamanho, Bebida bebida) {
        setTamanho(tamanho);
        setBebida(bebida);
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public double getPreco() {
        return bebida.getPreco();
    }
}
