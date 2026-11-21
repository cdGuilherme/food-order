package seboso.food.order;

import java.util.ArrayList;


public class Cozinheiro extends Pessoa {
    
    private ArrayList<Comanda> listaComanda;

    private Cozinha cozinha;
    // construtores
    
        // Caso ele só passe o nome
        Cozinheiro(String nome) {
            super(nome);
            this.listaComanda = new ArrayList<>();
        }


        // caso já queira passar junto com a lista
        Cozinheiro(String nome, ArrayList<Comanda> pedidos)
        {
            super(nome);
            if(pedidos == null){
                this.listaComanda = new ArrayList<>();
            }else
            {
                this.listaComanda = pedidos;
            }
        }
        
        //construtor passando o nome e a cozinha
        
        Cozinheiro(String nome, Cozinha cozinha)
        {
            super(nome);
            this.listaComanda = new ArrayList<>();
            setCozinha(cozinha);
        }
        
        // Construtor completo recebendo nome, a fila compartilhada e a cozinha
        Cozinheiro(String nome, ArrayList<Comanda> pedidos, Cozinha cozinha) {
            super(nome);
            if (pedidos == null) {
                this.listaComanda = new ArrayList<>();
            } else {
                this.listaComanda = pedidos;
            }
            setCozinha(cozinha);
        }
        
        // getter do listaComanda
        
        public ArrayList<Comanda> getListaComanda()
        {
            return this.listaComanda;
        }
        
        public void setListaComanda(ArrayList<Comanda> listaComanda)
        {
            if (listaComanda == null) {
                this.listaComanda = new ArrayList<>();
            } else {
                this.listaComanda = listaComanda;
            }
        }
        
        public Cozinha getCozinha()
        {
            return this.cozinha;
        }
        
        public void setCozinha(Cozinha cozinha)
        {
            this.cozinha = cozinha;
        }

    // puxa o que foi montado e preparado lá na Classe Pessoa
        @Override
        public void executarFuncao() {
            if(this.cozinha != null)
            {
                this.cozinha.processarProximoComanda();
            }
            else
            {
                System.out.println("Cozinheiro " + this.getNome() + " ainda não está alocado em nenhuma cozinha/setor.");
            }
        }
        
        // adicionar comanda
        // obrigatóriamente vc tem que passar a comanda para ele
        public void adicionarComanda(Comanda comanda)
        {
            // quando passado, ele verifica se a lista está vazia
            // caso esteja
            if(this.listaComanda == null)
            {
                // ele inclementa isso
                this.listaComanda = new ArrayList<>();
            }
            
            // caso contrário(aqui seria o else)
            // ele adicionar o que foi passado para o ArrayList
            this.listaComanda.add(comanda);
        }
        
        
}
