package seboso.food.order;

import java.util.ArrayList;

public class testeCozinha {
    public static void main(String[] args) {
        
        ////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////  PARA APENAS TESTES  /////////////////////////////
        //////////////////////////////////////////////////////////////////////////////
        
        // Fila única compartilhada
        ArrayList<Comanda> filaCompartilhada = new ArrayList<>();

        // Criando os 3 cozinheiros
        Cozinheiro joao = new Cozinheiro("João", filaCompartilhada);
        Cozinheiro pedro = new Cozinheiro("Pedro", filaCompartilhada);
        Cozinheiro carlos = new Cozinheiro("Carlos", filaCompartilhada);

        // Criando as 3 cozinhas e colocando as respectivos cozinheiros
        Cozinha grelha = new Cozinha(joao, "grelha");
        Cozinha bar = new Cozinha(pedro, "bar");
        Cozinha confeitaria = new Cozinha(carlos, "confeitaria");

        joao.setCozinha(grelha);
        pedro.setCozinha(bar);
        carlos.setCozinha(confeitaria);

        // montando a comanda
        Comanda c1 = new Comanda(101);
        c1.setLanche(new PedidoLanche(new Lanche(11, "Picanha", 42.99, "Italiano", "Picanha", "Cheddar", "Alface"), new ArrayList<>()));
        c1.setBebida(new PedidoBebida('G', new Bebida(21, "Limonada", 15.99, "Bater limão e coar")));
        c1.setSobremesa(new PedidoSobremesa(new Sobremesa(31, "Petit Gateau", 12.49, "Assar por 10 min")));

        filaCompartilhada.add(c1);

        // 5. Executa os 3 setores em sequência e observa a fila
        joao.executarFuncao();
        pedro.executarFuncao();
        carlos.executarFuncao();
    }
}
