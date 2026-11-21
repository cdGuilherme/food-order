package seboso.food.order;

public class PedidoSobremesa {
    
    private Sobremesa sobremesa;
    private boolean acucar;

    PedidoSobremesa(Sobremesa sobremesa) {
        this(sobremesa, false);
    }

    PedidoSobremesa(Sobremesa sobremesa, boolean acucar) {
        setSobremesa(sobremesa);
        setAcucar(acucar);
    }
    
    public void fazerSobremesa()
    {
        sobremesa.modoPreparo();
        if(this.acucar )
        {
            System.out.println("Adicionar COM açucar");
        }
        else
        {
            System.out.println("preparar SEM açucar");
        }
    }

    public Sobremesa getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(Sobremesa sobremesa) {
        this.sobremesa = sobremesa;
    }

    public boolean isAcucar() {
        return acucar;
    }

    public void setAcucar(boolean acucar) {
        this.acucar = acucar;
    }

    public double getPreco() {
        return sobremesa.getPreco();
    }
}
