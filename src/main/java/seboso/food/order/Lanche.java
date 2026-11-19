
package seboso.food.order;

/**
 *
 * @author Alunos
 */
public class Lanche extends Produto{
    private String pao;
    private String hamburguer;
    private String queijo;
    private String salada;
    private String adicional;
    
    Lanche(String nome, double preco, String pao, String hamburguer, String queijo, String salada) {
        super(nome,preco);
        setPao(pao);
        setHamburguer(hamburguer);
        setQueijo(queijo);
        setSalada(salada);
    }
    
    public void fazerLanche() {
        System.out.println("Modo de preparo: "+ getNome());
        System.out.println("Pegue o pão "+ getPao() + " parta ao meio e sele na chapa");
        System.out.println("Pese o hamburguer de "+ getHamburguer() +" e frite na chapa até dourar por fora");
        System.out.println("Quando estiver perto de acabar o hamburguer, pegue o queijo "+ getQueijo() +"e coloque por cima abafando com uma tampa para derreter");
        if (adicional != null) {
            System.out.println("Faça o "+ getAdicional());
            System.out.println("Monte o Lanche colocando o pão, hamburguer com o queijo, adicional, salada "+ getSalada() +" e feche o pão");
        } else {
            System.out.println("Monte o Lanche colocando o pão, hamburguer com o queijo, salada "+ getSalada() +" e feche o pão");
        }
    }

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

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }
    
    
}
