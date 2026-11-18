/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seboso.food.order;

/**
 *
 * @author Alunos
 */


public class Cliente extends Pessoa {

    private int idade;
    private String cpf;
    private String telefone;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;

    public Cliente(String nome) {
        super(nome);
    }

    @Override
    public void executarFuncao() {
        System.out.println(nome + " está chamando o garçom.");
    }
}