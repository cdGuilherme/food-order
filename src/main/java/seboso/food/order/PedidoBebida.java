package seboso.food.order;

public class PedidoBebida {
    private char tamanho;
    private Bebida bebida;

    PedidoBebida(Bebida bebida) {
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

    public void setTamanho(int tamanho) {
        switch (tamanho) {
            case 1 -> {
                this.tamanho = 'P';
            }
            case 2 -> {
                this.tamanho = 'M';
            }
            case 3 -> {
                this.tamanho = 'G';
            }
        }
    }

    public double getPreco(char tamanho) {
        switch (tamanho) {
            case 'P' -> {
                return bebida.getPreco();
            }
            case 'M' -> {
                return bebida.getPreco() + 3;
            }
            case 'G' -> {
                return bebida.getPreco() + 6;
            }
        }
        return 0;
    }
}
