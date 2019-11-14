/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Laboratorio101
 */
public class OrdemServico {
    
    private int id;
    private int idCarro;
    private int idOrcamento;
    private int idPessoa;
    private String servicoExecutado;
    private String dataFinalizada;
    private String kmAtual;
    private boolean status;

    public OrdemServico() {
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

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getServicoExecutado() {
        return servicoExecutado;
    }

    public void setServicoExecutado(String servicoExecutado) {
        this.servicoExecutado = servicoExecutado;
    }

    public String getDataFinalizada() {
        return dataFinalizada;
    }

    public void setDataFinalizada(String dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }

    public String getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(String kmAtual) {
        this.kmAtual = kmAtual;
    }

 
    public String salvar() {
        return id + ";" + idCarro + ";" + idOrcamento + ";" + idPessoa + ";" + servicoExecutado + ";" + dataFinalizada + ";" + kmAtual + ";" + status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
