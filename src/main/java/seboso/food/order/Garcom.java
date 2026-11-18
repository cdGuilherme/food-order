/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seboso.food.order;

public class Garcom extends Pessoa {

    public Garcom(String nome) {
        super(nome);
    }

    @Override
    public void executarFuncao() {
        System.out.println(nome + " está anotando o pedido.");
    }
}