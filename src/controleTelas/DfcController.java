/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.ReadWrite;
import classes.Dfc;
import classes.Dre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class DfcController implements Initializable {

    @FXML
    private AnchorPane paneFilho;
    @FXML
    private Label lbDre;
    @FXML
    private TextField tfDespesaCusto;
    @FXML
    private TextField tfTotalSaida;
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
    private TextField tfAumentoCapital;
    @FXML
    private TextField tfTotalEntrada;
    @FXML
    private TextField tfCompraAtivo;
    @FXML
    private TextField tfCaixaGerado;
    @FXML
    private Button btCalcular;
    @FXML
    private Label lbDre1;
    @FXML
    private Label lbVendas1;
    @FXML
    private TextField tfSaldoFinal;
    @FXML
    private Label lbLucroLiquido1;
    @FXML
    private TextField tfSaldoAnterios;
    @FXML
    private Label lbVendas2;

    private ReadWrite rw = new ReadWrite();

    private Dre dre;
    private Dfc dfc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dfc = rw.readDfc();
        tfCompraAtivo.setText(String.valueOf(dfc.getCompraAtivos()));
        tfAumentoCapital.setText(String.valueOf(dfc.getAumentoCapital()));

        calcula();

    }

    @FXML
    private void acaoBtcalcular(ActionEvent event) {
        calcula();
    }

    private void preencheCampos() {

        tfCaixaGerado.setText(String.valueOf(dfc.getCaixaGerado()));
        tfDespesaCusto.setText(String.valueOf(dfc.getDespesasCustos()));
        tfVendas.setText(String.valueOf(dfc.getVendasAVista()));
        tfSaldoFinal.setText(String.valueOf(dfc.getSaldoFinal()));
        tfTotalEntrada.setText(String.valueOf(dfc.getTotalEntrada()));
        tfTotalSaida.setText(String.valueOf(dfc.getTotalSaida()));
        tfCompraAtivo.setText(String.valueOf(dfc.getCompraAtivos()));
        tfAumentoCapital.setText(String.valueOf(dfc.getAumentoCapital()));

        rw.writeDfc(dfc);

    }

    private void calcula() {
        tfSaldoAnterios.setText("10000");

        dre = rw.readDre();
        dfc.setSaldoAnterior(Double.parseDouble(tfSaldoAnterios.getText()));
        dfc.setVendasAVista(dre.getVendasLiquidas());
        dfc.setDespesasCustos(dre.getCustos() + dre.getDespesas());
        try {

            dfc.setAumentoCapital(Double.parseDouble(tfAumentoCapital.getText()));
            dfc.setCompraAtivos(Double.parseDouble(tfCompraAtivo.getText()));

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Valor invalido");
        }

        dfc.setTotalEntrada();
        dfc.setTotalSaida();
        dfc.setCaixaGerado();
        dfc.setSaldoFinal();

        preencheCampos();

    }

}
