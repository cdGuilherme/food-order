/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seboso.food.order;

/**
 *
 * @author Alunos
 */
public class Adicional extends Produto{
    private String preparo;
    Adicional(String nome, double preco, String preparo) {
        super(nome, preco);
        this.preparo = preparo;
    }
    public String getPreparo() {
        return preparo;
    }
}
