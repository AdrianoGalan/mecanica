package classes;

/**
 *
 * @author Laboratorio101
 */
public class Dre {

    private double vendas;
    private double imposto;
    private double custos;
    private double despesas;
    private double lucroBruto;
    private double vendasLiquidas;
    private double lucroOperacional;
    private double lucroLiquido;
    private String data;

    public Dre() {
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getCustos() {
        return custos;
    }

    public void setCustos(double custos) {
        this.custos = custos;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }

    public double getLucroBruto() {
        return lucroBruto;
    }

    public void setLucroBruto(double lucroBruto) {
        this.lucroBruto = lucroBruto;
    }

    public double getVendasLiquidas() {
        return vendasLiquidas;
    }

    public void setVendasLiquidas(double vendasLiquidas) {
        this.vendasLiquidas = vendasLiquidas;
    }

    public double getLucroOperacional() {
        return lucroOperacional;
    }

    public void setLucroOperacional(double lucroOperacional) {
        this.lucroOperacional = lucroOperacional;
    }

    public double getLucroLiquido() {
        return lucroLiquido;
    }

    public void setLucroLiquido(double lucroLiquido) {
        this.lucroLiquido = lucroLiquido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

   
    public String salvar() {
        return  vendas + ";" + imposto + ";" + custos + ";" + despesas + ";" + lucroBruto + ";" + vendasLiquidas + ";" + lucroOperacional + ";" + lucroLiquido + ";" + data;
    }
    
    

}
