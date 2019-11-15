/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.ReadWrite;
import classes.Dre;
import classes.Orcamento;
import classes.OrdemServico;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Laboratorio101
 */
public class DreController implements Initializable {

    @FXML
    private AnchorPane paneFilho;
    @FXML
    private Label lbDre;
    @FXML
    private TextField tfCustos;
    @FXML
    private TextField tfDespesasOperacionais;
    @FXML
    private Label lbVendas;
    @FXML
    private Label lbImpostoSobreVendas;
    @FXML
    private Label lbVendasLiquidas;
    @FXML
    private Label lbLucroBruto;
    @FXML
    private Label lbCustosOperacionais;
    @FXML
    private Label lbDespesasOperacionais;
    @FXML
    private Label lbLucroLiquido;
    @FXML
    private TextField tfVendas;
    @FXML
    private TextField tfImpostoSobreVendas;
    @FXML
    private TextField tfVendasLiquidas;
    @FXML
    private TextField tfLucroBruto;
    @FXML
    private TextField tfLucroLiquido;

    Dre dre;

    ArrayList<OrdemServico> oss;
    ArrayList<Orcamento> orcamentos;

    ReadWrite rw = new ReadWrite();
    @FXML
    private Button btCalcular;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        dre = rw.readDre();

        oss = rw.readOs();
        orcamentos = rw.readOrcamento();
        calculos(dre.getDespesas(), dre.getCustos());
        carregaValoresTela();
        
        rw.writeDre(dre);
        
      

    }

    public double somaOss() {

        double soma = 0;

        for (int i = 0; i < oss.size(); i++) {

            if (!oss.get(i).isStatus()) {

                soma = soma + orcamentos.get(oss.get(i).getIdOrcamento() - 1).getValorTotalOrcamento();

            }

        }

        return soma;

    }

    private void calculos(double desp, double cus) {

        dre.setVendas(somaOss());
        dre.setImposto(dre.getVendas() * 0.15);
        dre.setVendasLiquidas(dre.getVendas() - dre.getImposto());

        dre.setCustos(cus);
        dre.setDespesas(desp);

        dre.setLucroBruto(dre.getVendasLiquidas() - dre.getCustos());

        dre.setLucroLiquido(dre.getLucroBruto() - dre.getDespesas());

    }

    private void carregaValoresTela() {

        tfVendas.setText(String.valueOf(dre.getVendas()));
        tfImpostoSobreVendas.setText(String.valueOf(dre.getImposto()));
        tfVendasLiquidas.setText(String.valueOf(dre.getVendasLiquidas()));
        tfCustos.setText(String.valueOf(dre.getCustos()));
        tfDespesasOperacionais.setText(String.valueOf(dre.getDespesas()));
        tfLucroBruto.setText(String.valueOf(dre.getLucroBruto()));
        tfLucroLiquido.setText(String.valueOf(dre.getLucroLiquido()));

    }

    @FXML
    private void acaoBtcalcular(ActionEvent event) {
        
        if(!tfCustos.getText().isEmpty() && !tfDespesasOperacionais.getText().isEmpty()){
            
            double custo = Double.parseDouble(tfCustos.getText());
            double desp = Double.parseDouble(tfDespesasOperacionais.getText());
            
            calculos(desp, custo);
            carregaValoresTela();
            
            rw.writeDre(dre);
            
        }
    }

}
