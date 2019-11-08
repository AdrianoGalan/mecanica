/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.RWPessoa;
import classes.Carro;
import classes.Endereco;
import classes.Pessoa;
import classes.Telefone;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Adriano
 */
public class CadastroClienteController implements Initializable {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfCpf;
    @FXML
    private TextField tfTelefone1;
    @FXML
    private TextField tfTelefone2;
    @FXML
    private TextField tfRua;
    @FXML
    private TextField tfNumero;
    @FXML
    private TextField tfBairro;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfCep;
    @FXML
    private Button btCadastra;
    @FXML
    private TextField tfPlaca;
    @FXML
    private TextField tfModelo;
    @FXML
    private TextField tfFabricante;
    @FXML
    private TextField tfMotor;
    @FXML
    private TextField tfAno;
    @FXML
    private TextField tfKm;
    @FXML
    private Label lbErro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void acaoBtCadastra(ActionEvent event) {

    }

    private void criaPessoa() {
        
        RWPessoa rw = new RWPessoa();
        
        
        
        ArrayList<Pessoa> pessoas = rw.read("txt/pessoas.txt");

        int id;
        
        if(pessoas == null){
            id = 1;
        }else{
            id = pessoas.size()-1;
        }
        Pessoa pessoa = new Pessoa(id);

        
        Endereco endereco = new Endereco();

        Telefone telefone = new Telefone();
        Telefone telefone1 = new Telefone();

        Carro carro = new Carro();

        if (!tfNome.getText().equals("")) {
            pessoa.setNome(tfNome.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UM NOME");
        }

        if (!tfCpf.getText().equals("")) {
            pessoa.setCpf(tfNome.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE O CPF");
        }

        if (!tfTelefone1.getText().equals("")) {
            telefone.setNumero(Integer.parseInt(tfTelefone1.getText()));
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UM TELEFONE");
        }

        if (!tfTelefone2.getText().equals("")) {
            telefone1.setNumero(Integer.parseInt(tfTelefone2.getText()));
            lbErro.setText("");
        }

        if (!tfRua.getText().equals("")) {
            endereco.setRua(tfRua.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UMA RUA");
        }

        if (!tfNumero.getText().equals("")) {
            endereco.setNumero(tfNumero.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UM NUMERO");
        }

        if (!tfCep.getText().equals("")) {
            endereco.setCep(tfCep.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UM CEP");
        }

        if (!tfBairro.getText().equals("")) {
            endereco.setBairro(tfBairro.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UM NUMERO");
        }

        if (!tfCidade.getText().equals("")) {
            endereco.setCidade(tfCidade.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UMA CIDADE");
        }

        if (!tfPlaca.getText().equals("")) {
            carro.setPlaca(tfPlaca.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UM NUMERO");
        }

        if (!tfAno.getText().equals("")) {
            carro.setAno(Integer.parseInt(tfAno.getText()));
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UM NUMERO");
        }

        if (!tfModelo.getText().equals("")) {
            carro.setModelo(tfModelo.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE O MODELO");
        }

        if (!tfFabricante.getText().equals("")) {
            carro.setFabricante(tfFabricante.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UM FABRICANTE");
        }

        if (!tfMotor.getText().equals("")) {
            carro.setMotor(tfMotor.getText());
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE UM MOTOR");
        }

        if (!tfKm.getText().equals("")) {
            carro.setKm(Integer.parseInt(tfKm.getText()));
            lbErro.setText("");
        } else {
            lbErro.setText("DIGITE O KM");
        }
    }

}
