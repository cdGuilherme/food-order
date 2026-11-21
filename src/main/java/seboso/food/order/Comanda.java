package seboso.food.order;

import java.util.ArrayList;
import java.util.Random;

public class Comanda implements ComandaInterface {
    private int numComanda;
    private Cliente cliente;
    private ArrayList<PedidoLanche> lanche = new ArrayList<>();
    private ArrayList<PedidoBebida> bebida = new ArrayList<>();
    private ArrayList<PedidoSobremesa> sobremesa = new ArrayList<>();
    private int mesa;
    private boolean delivery;
    private double valorFrete;

    // Número aleatório de km do pedido //
    // ///////////////////////////////////

    Random random = new Random();

    int km = random.nextInt(50) + 1;
    double valorKm = 2.5;

    Comanda(int numComanda) {
        this.numComanda = numComanda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getComanda() {
        return numComanda;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        if (mesa <= 0) {
            throw new IllegalArgumentException("O número da mesa deve ser positivo.");
        }
        this.mesa = mesa;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public void setLanche(PedidoLanche lanche) {
        this.lanche.add(lanche);
    }

    public void setBebida(PedidoBebida bebida) {
        this.bebida.add(bebida);
    }

    public void setSobremesa(PedidoSobremesa sobremesa) {
        this.sobremesa.add(sobremesa);
    }

    public int getKm() {
        return km;
    }

    public double getValorKm() {
        return valorKm;
    }

    public double calcularFrete() {
        if (isDelivery()) {
            return valorFrete = km * valorKm;
        }
        return valorFrete;
    }

    @Override
    public double calcularTotal() {
        double valorLanches = 0;
        double valorBebidas = 0;
        double valorSobremesa = 0;

        for (PedidoLanche atual : lanche) {
            valorLanches += atual.getPreco();
        }
        for (PedidoBebida atual : bebida) {
            valorBebidas += atual.getPreco(atual.getTamanho());
        }
        for (PedidoSobremesa atual : sobremesa) {
            valorSobremesa += atual.getPreco();
        }
        return valorLanches + valorBebidas + valorSobremesa;
    }

    @Override
    public void getDescricao(boolean detalhada) {
        if (detalhada) {

            // Print da comanda e Cliente
            System.out.println("Pedido: " + getComanda() + " " + getCliente().getNome() + "\n");

            // Print dos lanches
            for (PedidoLanche atual : lanche) {
                System.out.println(atual.getNome() + "\n");
                atual.getLanche().modoPreparo(atual.getAdicionais());
            }

            // print das bebidas
            for (PedidoBebida atual : bebida) {
                System.out.println(atual.getBebida().getNome() + "\n");
                atual.getBebida().modoPreparo();
            }

            // Print das sobremesas
            for (PedidoSobremesa atual : sobremesa) {
                System.out.println(atual.getSobremesa().getNome() + "\n");
                atual.getSobremesa().modoPreparo();
            }
            // Se for delivery
            if (delivery) {
                System.out.println("Frete:\n");
                System.out.println(getKm() + "km");
                System.out.println("Valor Frete: R$" + getValorKm() + "\n");
            }
            // Valor total da compra
            System.out.printf("Total: R$ %.2f\n", calcularTotal() + calcularFrete());
        } else {
            // Print da comanda e Cliente
            System.out.println("Pedido: " + getComanda() + " " + getCliente().getNome() + "\n");

            // Print do pedido resumido
            // Lanches
            System.out.println("- Lanches e adicionais:");
            for (PedidoLanche atual : lanche) {
                System.out.printf("%s: R$ %.2f\n", atual.getNome(), atual.getPreco());

                for (Adicional adicionalAtual : atual.getAdicionais()) {
                    System.out.printf("+%s\n", adicionalAtual.getNome());
                }
                System.out.println();
            }
            // Bebidas
            System.out.println("- Bebidas:");
            for (PedidoBebida atual : bebida) {
                System.out.printf("%s %c: R$ %.2f\n", atual.getBebida().getNome(), atual.getTamanho(), atual.getPreco(atual.getTamanho()));
            }
            System.out.println();
            // Sobremesas
            System.out.println("- Sobremesas:");
            for (PedidoSobremesa atual : sobremesa) {
                if (atual.isAcucar())
                    System.out.printf("%s com açúcar: R$ %.2f\n", atual.getSobremesa().getNome(), atual.getPreco());
                else
                    System.out.printf("%s sem açúcar: R$ %.2f\n", atual.getSobremesa().getNome(), atual.getPreco());
            }
            System.out.println();
            // Se for delivery
            if (delivery) {
                System.out.println("Frete:\n");
                System.out.println("Valor Frete: R$" + calcularFrete() + "\n");
            }
            // Valor total da compra
            System.out.printf("Subtotal: R$ %.2f\n", calcularTotal());
        }
    }
}
