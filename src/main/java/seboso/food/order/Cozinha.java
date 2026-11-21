package seboso.food.order;

import java.util.ArrayList;

public class Cozinha {
    private Cozinheiro cozinheiro;
    
    private String setor;
    
    // construtor da classe Cozinheiro
    // passando como parametros os dois que temos
    Cozinha(Cozinheiro cozinheiro, String setor)
    {
        setCozinheiro(cozinheiro);
        setSetor(setor);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////  GETTERS || SETTERS  /////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    public Cozinheiro getCozinheiro()
    {
        return this.cozinheiro;
    }
    
    public String getSetor()
    {
        return this.setor;
    }
    
    
    
    public void setCozinheiro(Cozinheiro cozinheiro)
    {
        this.cozinheiro = cozinheiro;
    }
    
    public void setSetor(String setor)
    {
        this.setor = setor;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////  PROCESSOS  //////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    
    
    // verificar qual setor é
    
    public void processarProximoComanda()
    {
        ArrayList<Comanda> lista = this.cozinheiro.getListaComanda();
        
        if(lista == null || lista.isEmpty())
        {
            System.out.println("Setor " + this.setor + " (" + this.cozinheiro.getNome() + "): Não há pedidos na fila.");
            return;
        }
        
        // pegar o primeiro da fila
        Comanda comandaAtual = lista.get(0);
        
        System.out.println("Setor: " + this.setor + " || Cozinheiro: " + this.cozinheiro.getNome());
        
        System.out.println("Iniciando O Comando " + comandaAtual.getComanda());
        
        switch(this.setor.toLowerCase())
        {
            case "grelha":
                for(PedidoLanche grelha : comandaAtual.getLanches())
                {
                    grelha.fazerLanche();
                }
                
                comandaAtual.setGrelhaFinalizada(true);
            break;
            
            case "bar":
                for(PedidoBebida bebidas : comandaAtual.getBebida())
                {
                    System.out.println("Preparando bebida (" + bebidas.getTamanho() + "): " + bebidas.getBebida().getNome());
                    bebidas.getBebida().modoPreparo();
                }
                
                comandaAtual.setBarFinalizado(true);
            break;
            
            case "confeitaria":
                for(PedidoSobremesa sobremesa : comandaAtual.getSobremesa())
                {
                    sobremesa.getSobremesa().modoPreparo();
                }
                
                comandaAtual.setConfeitariaFinalizada(true);
            break;
            
            default:
                System.out.println("Não temos esse setor");
                
            return;
        }

        System.out.println("Setor " + this.setor + " concluiu seu trabalho na Comanda " + comandaAtual.getComanda() + ".");
        
        if (comandaAtual.isFinish()) {
            lista.remove(0);
            System.out.println("Comanda " + comandaAtual.getComanda() + " finalizada e removida da fila!\n");
        } else {
            System.out.println("Comanda " + comandaAtual.getComanda() + " permanece na fila aguardando os demais setores.\n");
        }
        
    }

}
