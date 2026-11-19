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
    private int porcaoMedia;
    Adicional(String nome, double preco) {
        super(nome, preco);
    }

    public int getPorcaoMedia() {
        return porcaoMedia;
    }

    public void setPorcaoMedia(int porcaoMedia) {
        this.porcaoMedia = porcaoMedia;
    }
    
}
