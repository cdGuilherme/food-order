/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seboso.food.order;

/**
 *
 * @author Alunos
 */
public class Bebida extends Produto{
    private int ml;
    
    Bebida(String nome, double preco, int ml, String preparo) {
        super.setNome(nome);
        super.setPreco(preco);
        super.setPreparo(preparo);
        this.ml = ml;
    }
}
