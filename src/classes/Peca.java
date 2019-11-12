/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Adriano
 */
public class Peca {

    private int idOrcamento;
    private String nome;
    private double preco;

    public Peca() {
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String salvar() {
        return idOrcamento + ";" + nome + ";" + preco;
    }

    @Override
    public String toString() {
        return  nome + "   R$" + preco;
    }
    
    
    

}
