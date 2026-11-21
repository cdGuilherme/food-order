package seboso.food.order;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Produto {
    private int opcao;
    private String nome;
    private double preco;
    
    Produto(int opcao, String nome, double preco) {
        setOpcao(opcao);
        setNome(nome);
        setPreco(preco);
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        nome = nome.substring(0,1).toUpperCase() + nome.substring(1);
        this.nome = nome;
    }

    protected double getPreco() {
        return preco;
    }

    protected void setPreco(double preco) {
        BigDecimal valor = BigDecimal.valueOf(preco).stripTrailingZeros();
        if (valor.scale() > 2) {
            throw new IllegalArgumentException("O preço deve ter no máximo duas casas decimais.");
        }

        this.preco = preco;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    abstract public void modoPreparo(ArrayList<Adicional> adicionais);
    abstract public void modoPreparo();
}
