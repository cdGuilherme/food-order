/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seboso.food.order;

import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class Bebida extends Produto{
    private String preparo;
    
    Bebida(String nome, double preco, String preparo) {
        super(nome, preco);
        setPreparo(preparo);
    }

    @Override
    public void modoPreparo(ArrayList<Adicional> adicionais) {}

    @Override
    public void modoPreparo() {
        System.out.println(preparo);
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }
}
