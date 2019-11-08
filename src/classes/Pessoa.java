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
public class Pessoa {

    private int id;
    private String nome;
    private String cpf;
//    private int telefone;
//    private int telefone2;
//    private int endereco;
//    private int carro;

    public Pessoa() {
    }

    public Pessoa(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

//    public int getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(int telefone) {
//        this.telefone = telefone;
//    }
//
//    public int getTelefone2() {
//        return telefone2;
//    }
//
//    public void setTelefone2(int telefone2) {
//        this.telefone2 = telefone2;
//    }
//
//    public int getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(int endereco) {
//        this.endereco = endereco;
//    }
//
//    public int getCarro() {
//        return carro;
//    }
//
//    public void setCarro(int carro) {
//        this.carro = carro;
//    }

    public String salvar() {

        return id + ";" + nome + ";" + cpf + ";";
    }

    public void setId(int id) {
        this.id = id;
    }

}
