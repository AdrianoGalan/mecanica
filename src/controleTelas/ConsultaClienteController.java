/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.ReadWrite;
import classes.Carro;
import classes.Pessoa;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import util.Util;

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
    @FXML
    private Button btAtualizar;
    @FXML
    private Button btDesativarCarro;
    @FXML
    private Button btBucar;
   
    @FXML
    private TableView<Carro> tvCarrosCliente;
    @FXML
    private TableColumn<Carro, String> tcPlaca;
    @FXML
    private TableColumn<Carro, String> tcModelo;
    @FXML
    private TableColumn<Carro, String> tcFabricante;
    @FXML
    private TableColumn<Carro, String> tcMotor;
    @FXML
    private TableColumn<Carro, String> tcAno;
    @FXML
    private TableColumn<Carro, Double> tcKm;
    @FXML
    private TableColumn<Carro, String> tcStatus;

    private ArrayList<Pessoa> pessoas;
    private ReadWrite rw;
    @FXML
    private AnchorPane paneFilho;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        lvClientes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        rw = new ReadWrite();

        pessoas = rw.readPessoa();

        povoarListViewPessoa(pessoas);

    }

    @FXML
    private void acaoDigitar(KeyEvent event) {

        ArrayList<Pessoa> filtro = new ArrayList();

        for (int i = 0; i < pessoas.size(); i++) {

            if (pessoas.get(i).getNome().contains(tfBuscaCliente.getText().toUpperCase())) {

                filtro.add(pessoas.get(i));

            }

        }

        povoarListViewPessoa(filtro);
    }

    @FXML
    private void acaoBtAtualizar(ActionEvent event) {

        Pessoa p = lvClientes.getSelectionModel().getSelectedItem();
        
        if(p != null){
        Util.setPessoaAtualizar(p);
        
        
        carregaTela("/telas/AtualizarCliente.fxml");
        }else{
            JOptionPane.showMessageDialog(null, "selecione cliente");
        }
    }

    private void povoarListViewPessoa(List<Pessoa> pessoa) {

        lvClientes.getItems().clear();

        for (Pessoa p : pessoa) {

            if (p != null) {

                lvClientes.getItems().add(p);

            }

        }

    }

    @FXML
    private void acaoBtDesativarCarro(ActionEvent event) {
        Pessoa p = lvClientes.getSelectionModel().getSelectedItem();
        Carro c = tvCarrosCliente.getSelectionModel().getSelectedItem();
        ArrayList<Carro> carros = rw.readCarro();
        int id = -1;
        if (p != null) {

            if (c != null) {

                for (int i = 0; i < carros.size(); i++) {
                    if (carros.get(i).getPlaca().equals(c.getPlaca())) {
                        id = i;
                    }
                }

                if (c.isStatus()) {

                    c.setStatus(false);

                    carros.set(id, c);
                } else {
                    c.setStatus(true);
                    carros.set(id, c);
                }

                rw.writeCarro(carros);
                filtraCarros();

            } else {
                JOptionPane.showMessageDialog(null, "Selecione um carro");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente");
        }

    }

    @FXML
    private void acaoBtBuscar(ActionEvent event) {

        filtraCarros();
    }

    public void filtraCarros() {

        Pessoa p = lvClientes.getSelectionModel().getSelectedItem();
        ArrayList<Carro> carros = rw.readCarro();
        ArrayList<Carro> filtro = new ArrayList();

        if (p != null) {
           
            tfBuscaCliente.setText(p.getNome());
            for (int i = 0; i < carros.size(); i++) {
                if (carros.get(i).getIdPessoa() == p.getId()) {
                    filtro.add(carros.get(i));
                }
            }
            iniTablela(filtro);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente");
        }

    }

    private void iniTablela(ArrayList<Carro> carros) {

        tcPlaca.setCellValueFactory(new PropertyValueFactory("placa"));
        tcModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        tcFabricante.setCellValueFactory(new PropertyValueFactory("fabricante"));
        tcMotor.setCellValueFactory(new PropertyValueFactory("motor"));
        tcAno.setCellValueFactory(new PropertyValueFactory("ano"));
        tcKm.setCellValueFactory(new PropertyValueFactory("km"));
        tcStatus.setCellValueFactory(new PropertyValueFactory("status"));
        tvCarrosCliente.setItems(atualizaTabela(carros));

    }

    public ObservableList<Carro> atualizaTabela(ArrayList<Carro> carros) {

        return FXCollections.observableArrayList(carros);
    }
    
    public void carregaTela(String nomeTela) {

        //carrega tela
        AnchorPane a;
        try {
            a = (AnchorPane) FXMLLoader.load(getClass().getResource(nomeTela));

            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);

            paneFilho.getChildren().setAll(a);
        } catch (IOException ex) {
            Logger.getLogger(TrabalhoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
