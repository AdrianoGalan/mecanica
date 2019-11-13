/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Laboratorio101
 */
public class Orcamento {

    private int id;
    private int idCarro;
    private String descricaoProblema;
    private double valorTotalPecas;
    private double valorTotalMaoObra;
    private double valorTotalOrcamento;
    private String dataAtual;
    private String horaAtual;
    private boolean status;

    public Orcamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public String getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(String horaAtual) {
        this.horaAtual = horaAtual;
    }

    public double getValorTotalPecas() {
        return valorTotalPecas;
    }

    public void setValorTotalPecas(double valorTotalPecas) {
        this.valorTotalPecas = valorTotalPecas;
    }

    public double getValorTotalMaoObra() {
        return valorTotalMaoObra;
    }

    public void setValorTotalMaoObra(double valorTotalMaoObra) {
        this.valorTotalMaoObra = valorTotalMaoObra;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String salvar() {
        return id + ";" + idCarro + ";" + descricaoProblema + ";" + valorTotalPecas + ";" + valorTotalMaoObra + ";" + valorTotalOrcamento + ";" + dataAtual + ";" + horaAtual + ";" + status;
    }

    public double getValorTotalOrcamento() {
        return valorTotalOrcamento;
    }

    public void setValorTotalOrcamento(double valorTotalOrcamento) {
        this.valorTotalOrcamento = valorTotalOrcamento;
    }

}
