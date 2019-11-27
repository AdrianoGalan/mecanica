/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

public class Dfc {

    private double vendasAVista;
    private double aumentoCapital;
    private double totalEntrada;
    private double compraAtivos;
    private double despesasCustos;
    private double totalSaida;
    private double saldoAnterior;
    private double caixaGerado;
    private double saldoFinal;
    private String data;

    public Dfc() {
    }

    public double getVendasAVista() {
        return vendasAVista;
    }

    public void setVendasAVista(double vendasAVista) {
        this.vendasAVista = vendasAVista;
    }

    public double getAumentoCapital() {
        return aumentoCapital;
    }

    public void setAumentoCapital(double aumentoCapital) {
        this.aumentoCapital = aumentoCapital;
    }

    public double getTotalEntrada() {
        return totalEntrada;
    }

    public void setTotalEntrada() {
        this.totalEntrada = this.aumentoCapital + this.vendasAVista;
    }

    public double getCompraAtivos() {
        return compraAtivos;
    }

    public void setCompraAtivos(double compraAtivos) {
        this.compraAtivos = compraAtivos;
    }

    public double getDespesasCustos() {
        return despesasCustos;
    }

    public void setDespesasCustos(double despesasCustos) {
        this.despesasCustos = despesasCustos;
    }

    public double getTotalSaida() {
        return totalSaida;
    }

    public void setTotalSaida() {
        this.totalSaida = this.compraAtivos + this.despesasCustos;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getCaixaGerado() {
        return caixaGerado;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }
    
    public void setCaixaGerado(){
        
        this.caixaGerado = this.totalEntrada - this.totalSaida;
        
    }
    public void setSaldoFinal(){
        
        this.saldoFinal = this.caixaGerado + this.saldoAnterior;
        
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String salvar() {
        return  aumentoCapital + ";" + compraAtivos;
    }

}
