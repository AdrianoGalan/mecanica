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
public class Endereco {
    
    private int id;
    private int idPessoa;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;

    public Endereco() {
    }
    
    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }
    

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua.toUpperCase();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.toUpperCase();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado.toUpperCase();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

 
    public String salvar() {
        return id + ";" + cep + ";" + rua + ";" + bairro + ";" + cidade + ";" + estado + ";" + numero;
    }
    
    

    
    
    
    
}
