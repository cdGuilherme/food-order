/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seboso.food.order;

/**
 *
 * @author Alunos
 */

import java.math.BigDecimal;

public abstract class Produto {
    private String nome;
    private double preco;
    private String preparo;

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

    protected String getPreparo() {
        return preparo;
    }

    protected void setPreparo(String preparo) {
        this.preparo = preparo;
    }
}
