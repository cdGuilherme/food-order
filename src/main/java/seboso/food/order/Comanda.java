package seboso.food.order;

import java.util.ArrayList;
import java.util.Random;

import java.util.Collections;
import java.util.List;

public class Comanda implements ComandaInterface {
    private int numComanda;
    private Cliente cliente;
    
    private ArrayList<PedidoLanche> lanche = new ArrayList<>();
    private ArrayList<PedidoBebida> bebida = new ArrayList<>();
    private ArrayList<PedidoSobremesa> sobremesa = new ArrayList<>();
    
    private int mesa;
    private boolean delivery;
    private double valorFrete;
    
    /////////////////////////////////////////////////////////////////////
    ///////////////////////  STATUS TERMINADOS//////////////////////////
    ///////////////////////////////////////////////////////////////////
    
    private boolean grelhaFinalizada = true;
    private boolean barFinalizado = true;
    private boolean confeitariaFinalizada = true;

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
        this.grelhaFinalizada = false;
    }

    public void setBebida(PedidoBebida bebida) {
        this.bebida.add(bebida);
        this.barFinalizado = false;
    }

    public void setSobremesa(PedidoSobremesa sobremesa) {
        this.sobremesa.add(sobremesa);
        this.confeitariaFinalizada = false;
    }

    public int getKm() {
        return km;
    }

    public double getValorKm() {
        return valorKm;
    }
    
    
    // FINALIZADOS || GET

    public boolean getGrelhaFinalizada() {
        return grelhaFinalizada;
    }

    public boolean getBarFinalizado() {
        return barFinalizado;
    }

    public boolean getConfeitariaFinalizada() {
        return confeitariaFinalizada;
    }
    
    // FINALIZADOS || SET

    public void setGrelhaFinalizada(boolean grelhaFinalizada) {
        this.grelhaFinalizada = grelhaFinalizada;
    }

    public void setBarFinalizado(boolean bebida) {
        this.barFinalizado = bebida;
    }

    public void setConfeitariaFinalizada(boolean sobremesa) {
        this.confeitariaFinalizada = sobremesa;
    }

    // get Listas
    
    public List<PedidoLanche> getLanches()
    {
        return Collections.unmodifiableList(new ArrayList<>(lanche));
    }
    
    public List<PedidoBebida> getBebida()
    {
        return Collections.unmodifiableList(new ArrayList<>(bebida));
    }
    
    public List<PedidoSobremesa> getSobremesa()
    {
        return Collections.unmodifiableList(new ArrayList<>(sobremesa));
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
            valorBebidas += atual.getPreco();
        }
        for (PedidoSobremesa atual : sobremesa) {
            valorSobremesa += atual.getPreco();
        }
        if (delivery) {
            this.valorFrete = valorKm * km;
            return valorBebidas + valorSobremesa + valorLanches + this.valorFrete;
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
            System.out.println("Valor Total: R$" + calcularTotal());
        } else {
            //  delivery == true) valor frete e total
            // Print da comanda e Cliente
            System.out.println("Pedido: " + getComanda() + " " + getCliente().getNome() + "\n");

            // Print do pedido resumido
            // Lanches
            for (PedidoLanche atual : lanche) {
                System.out.println(atual.getNome());
            }
            // Bebidas
            for (PedidoBebida atual : bebida) {
                System.out.println(atual.getBebida().getNome());
            }
            // Sobremesas
            for (PedidoSobremesa atual : sobremesa) {
                System.out.println(atual.getSobremesa().getNome());
            }
            
            
            // Se for delivery
            if (delivery) {
                System.out.println("Frete:\n");
                System.out.println("Valor Frete: R$" + getValorKm() + "\n");
            }
            
            
            // Valor total da compra
            System.out.println("Valor Total: R$" + calcularTotal());
        }
        
        
    }
    
    
    
    // Estar finalizado
    
    public boolean isFinish()
    {
        return this.grelhaFinalizada && this.barFinalizado && this.confeitariaFinalizada;
    }
    
}
