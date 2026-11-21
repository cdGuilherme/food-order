
package seboso.food.order;

import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class Lanche extends Produto {
    private String pao;
    private String hamburguer;
    private String queijo;
    private String salada;
    
    Lanche(int opcao, String nome, double preco, String pao, String hamburguer, String queijo, String salada) {
        super(opcao, nome,preco);
        setPao(pao);
        setHamburguer(hamburguer);
        setQueijo(queijo);
        setSalada(salada);
    }

    @Override
    public void modoPreparo(ArrayList<Adicional> adicionais) {
        System.out.println("Modo de preparo: "+ getNome());
        System.out.println("Pegue o pão "+ getPao() + " parta ao meio e sele na chapa");
        System.out.println("Pese o hamburguer de "+ getHamburguer() +" e frite na chapa até dourar por fora");
        System.out.println("Quando estiver perto de acabar o hamburguer, pegue o queijo "+ getQueijo() +"e coloque por cima abafando com uma tampa para derreter");
        if (adicionais != null) {
            for (Adicional atual : adicionais) {
                atual.modoPreparo(null);
            }
        }
        System.out.println("Pega a salada "+  getSalada());
        System.out.println("Finaliza montando tudo!");
    }

    @Override
    public void modoPreparo() {}

    public String getPao() {
        return pao;
    }

    public void setPao(String pao) {
        this.pao = pao;
    }

    public String getHamburguer() {
        return hamburguer;
    }

    public void setHamburguer(String hamburguer) {
        this.hamburguer = hamburguer;
    }

    public String getQueijo() {
        return queijo;
    }

    public void setQueijo(String queijo) {
        this.queijo = queijo;
    }

    public String getSalada() {
        return salada;
    }

    public void setSalada(String salada) {
        this.salada = salada;
    }
}
