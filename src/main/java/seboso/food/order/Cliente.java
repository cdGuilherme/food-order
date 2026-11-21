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

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep == null) {
            throw new IllegalArgumentException("CEP inválido.");
        }

        String cepNumerico = cep.replaceAll("[^0-9]", "");

        if (!cepNumerico.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP deve conter exatamente 8 números.");
        }

        this.cep = cepNumerico;
    }

    public Cliente(String nome) {
        super(nome);
    }

    @Override
    public void executarFuncao() {
        System.out.println(nome + " está chamando o garçom.");
    }
}