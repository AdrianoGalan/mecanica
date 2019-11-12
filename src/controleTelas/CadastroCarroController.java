/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.ReadWrite;
import classes.Carro;
import classes.Pessoa;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import util.Util;

/**
 * FXML Controller class
 *
 * @author Adriano
 */
public class CadastroCarroController implements Initializable {

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
    private Button btCadastra;
    @FXML
    private Label lbErro;
    @FXML
    private Label lbOk;
    @FXML
    private ListView<Pessoa> lvClientes;
    @FXML
    private TextField tfBuscaCliente;

    private ArrayList<Pessoa> pessoas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Util.mascaraPlaca(tfPlaca);

        lvClientes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        ReadWrite rw = new ReadWrite();

        pessoas = rw.readPessoa();

        povoarListView(pessoas);
    }

    @FXML
    private void acaoBtCadastra(ActionEvent event) {

        Pessoa pessoa = lvClientes.getSelectionModel().getSelectedItem();
        ReadWrite rw = new ReadWrite();
        ArrayList<Carro> carros = rw.readCarro();

        if (pessoa != null) {
            if (validarCampos()) {

                Carro carro = new Carro();
                carro.setPlaca(tfPlaca.getText());
                carro.setAno(tfAno.getText());
                carro.setModelo(tfModelo.getText());
                carro.setFabricante(tfFabricante.getText());
                carro.setMotor(tfMotor.getText());
                carro.setKm(Integer.parseInt(tfKm.getText()));
                carro.setStatus(true);
                carro.setId(pessoa.getId());
                
                carros.add(carro);
                
               if(rw.writeCarro(carros)){
                   
                   limparCampos();
                   JOptionPane.showMessageDialog(null, "Carro salvar");
                  
                   
                   
               }else{
                   JOptionPane.showMessageDialog(null, "Erro ao salvar");
               }
                
                
                
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Cliente");
        }

    }

    @FXML
    private void acaoDigitar(KeyEvent event) {

        ArrayList<Pessoa> filtro = new ArrayList();

        for (int i = 0; i < pessoas.size(); i++) {

            if (pessoas.get(i).getNome().contains(tfBuscaCliente.getText().toUpperCase())) {

                filtro.add(pessoas.get(i));

            }

        }

        povoarListView(filtro);
    }

    private void povoarListView(List<Pessoa> pessoa) {

        lvClientes.getItems().clear();

        for (Pessoa p : pessoa) {

            if (p != null) {

                lvClientes.getItems().add(p);

            }

        }

    }

    private boolean validarCampos() {

        if (!tfPlaca.getText().equals("")) {
            lbErro.setText("");
            if (!tfAno.getText().equals("")) {
                lbErro.setText("");
                if (!tfModelo.getText().equals("")) {
                    lbErro.setText("");
                    if (!tfFabricante.getText().equals("")) {
                        lbErro.setText("");
                        if (!tfMotor.getText().equals("")) {
                            lbErro.setText("");
                            if (!tfKm.getText().equals("")) {
                                lbErro.setText("");
                                return true;
                                //validou
                            } else {
                                lbErro.setText("DIGITE O KM");
                            }
                        } else {
                            lbErro.setText("DIGITE UM MOTOR");
                        }
                    } else {
                        lbErro.setText("DIGITE UM FABRICANTE");
                    }
                } else {
                    lbErro.setText("DIGITE O MODELO");
                }
            } else {
                lbErro.setText("DIGITE UM NUMERO");
            }
        } else {
            lbErro.setText("DIGITE UM NUMERO");
        }
        return false;

    }
    
      private void limparCampos() {

        tfPlaca.setText("");
        tfModelo.setText("");
        tfFabricante.setText("");
        tfMotor.setText("");
        tfAno.setText("");
        tfKm.setText("");

    }

}
