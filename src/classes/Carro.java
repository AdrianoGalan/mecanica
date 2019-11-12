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
public class Carro {

    private int id;
    private int idPessoa;
    private String placa;
    private String modelo;
    private String fabricante;
    private String motor;
    private String ano;
    private int km;
    private boolean status;

    public Carro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo.toUpperCase();
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante.toUpperCase();
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor.toUpperCase();
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano.toUpperCase();
    }

    public String salvar() {

        return id + ";" + idPessoa + ";" + placa + ";" + modelo + ";" + fabricante + ";" + motor + ";" + ano + ";" + km + ";" + status;
    }

    @Override
    public String toString() {

        if (status) {

            return "placa: " + placa + ", modelo: " + modelo + ", fabricante: " + fabricante + ", motor: " + motor + ", ano: " + ano;

        } else {
            return "placa: " + placa + ", modelo: " + modelo + ", fabricante: " + fabricante + ", motor: " + motor + ", ano: " + ano + " CARRO INATIVO";
        }

    }

}
