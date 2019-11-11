/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.ReadWrite;
import classes.Pessoa;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Adriano
 */
public class ConsultaClienteController implements Initializable {

    @FXML
    private ListView<Pessoa> lvClientes;
    @FXML
    private TextField tfBuscaCliente;
    
    private  ArrayList<Pessoa> pessoas;
    @FXML
    private Button btAtualizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        lvClientes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        ReadWrite rw = new ReadWrite();

        pessoas = rw.readPessoa();

        povoarListView(pessoas);

    }

    @FXML
    private void acaoDigitar(KeyEvent event) {
        
        ArrayList<Pessoa> filtro = new ArrayList();
        
        for (int i = 0; i < pessoas.size(); i++) {
            
            if(pessoas.get(i).getNome().contains(tfBuscaCliente.getText())){
                
                filtro.add(pessoas.get(i));
                
            }
            
        }
        
        povoarListView(filtro);
    }
    
    @FXML
    private void acaoBtAtualizar(ActionEvent event) {
        
        Pessoa p = lvClientes.getSelectionModel().getSelectedItem();
        
    }

    private void povoarListView(List<Pessoa> pessoa) {

        lvClientes.getItems().clear();

        for (Pessoa p : pessoa) {

            if (p != null) {

                lvClientes.getItems().add(p);

            }

        }

    }



  

}
