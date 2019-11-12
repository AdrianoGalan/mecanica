/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.ReadWrite;
import classes.Carro;
import classes.Orcamento;
import classes.Peca;
import classes.Pessoa;
import classes.Servico;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Adriano
 */
public class CadastroOrcamentoController implements Initializable {

    @FXML
    private TextField tfPlacaCarro;
    @FXML
    private Button btConsultaPlaca;
    @FXML
    private Label lbNome;
    @FXML
    private Label lbCarro;
    @FXML
    private TextArea taDescricaoProblema;
    @FXML
    private ListView<Servico> lwServicos;
    private ListView<Peca> lwPecas;
    @FXML
    private TextField tfServico;
    @FXML
    private TextField tfPrecoServico;
    @FXML
    private Button btAddServico;
    @FXML
    private TextField tfPrecoPeca;
    @FXML
    private TextField tfPeca;
    @FXML
    private Button btAddPeca;
    @FXML
    private Button btRemoveServico;
    @FXML
    private Button btRemovePeca;

    private ReadWrite rw = new ReadWrite();

    private Orcamento orcamento = new Orcamento();
   

    private ArrayList<Peca> pecas = new ArrayList();
    private ArrayList<Servico> servicos = new ArrayList();
    @FXML
    private TableView<Peca> tbPecas;
    @FXML
    private TableColumn<Peca, String> tbPecaCoDescricao;
    @FXML
    private TableColumn<Peca, Double> tbPecaCoPreco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        orcamento.setIdCarro(-1);

        ArrayList<Orcamento> orcamentos = rw.readOrcamento();
        if (orcamentos == null) {
            orcamento.setId(1);
        } else {
            orcamento.setId(orcamentos.size() + 1);
        }
//        
//         tbPecas.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                
//                            
//            }
//        });

    }

    @FXML
    private void acaoBtConsultaPlaca(ActionEvent event) {

        Carro carro;
        Pessoa pessoa;

        if (!tfPlacaCarro.getText().isEmpty()) {
            carro = consultaPorPlaca(tfPlacaCarro.getText());
            pessoa = consultaPorId(carro.getIdPessoa());
            orcamento.setIdCarro(carro.getId());
            lbNome.setText(pessoa.getNome());
            lbCarro.setText(carro.getModelo());
        } else {
            JOptionPane.showMessageDialog(null, "Digite a placa do carro");
        }
    }

    @FXML
    private void acaoBtAddServico(ActionEvent event) {
    }

    @FXML
    private void acaoBtAddPeca(ActionEvent event) {

        if (orcamento.getIdCarro() != -1) {
            if (!tfPeca.getText().isEmpty()) {
                if (!tfPrecoPeca.getText().isEmpty()) {

                    Peca peca = new Peca();

                    peca.setIdOrcamento(orcamento.getId());
                    peca.setNome(tfPeca.getText());
                    try {

                        peca.setPreco(Double.parseDouble(tfPrecoPeca.getText()));
                        pecas.add(peca);
                        iniTablela();

                        tfPeca.setText("");
                        tfPrecoPeca.setText("");

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "Preço invalido");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Digite o Preço da Peça");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite o nome da Peça");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite a Placa do carro");
        }

    }

    @FXML
    private void acaoBtRemoveServico(ActionEvent event) {

    }

    @FXML
    private void acaoBtRemovePeca(ActionEvent event) {
        
       Peca pecaSelecionada =  tbPecas.getSelectionModel().getSelectedItem();
        
       

       
                int id = -1;
             

                if (pecaSelecionada != null) {
                    for (int i = 0; i < pecas.size(); i++) {
                        if (pecaSelecionada.getNome().equals(pecas.get(i).getNome())) {
                            id = i;
                            break;
                        }
                    }
                    if (id != -1) {
                        pecas.remove(id);
                    }
                    iniTablela();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma peça");
                }


    }

    private Carro consultaPorPlaca(String placa) {

        ArrayList<Carro> carros = rw.readCarro();

        for (int i = 0; i < carros.size(); i++) {

            if (carros.get(i).getPlaca().equalsIgnoreCase(placa)) {
                return carros.get(i);
            }

        }

        return null;

    }

    private Pessoa consultaPorId(int id) {

        ArrayList<Pessoa> pessoa = rw.readPessoa();

        for (int i = 0; i < pessoa.size(); i++) {

            if (pessoa.get(i).getId() == id) {
                return pessoa.get(i);
            }

        }

        return null;

    }

    private void iniTablela() {

        tbPecaCoDescricao.setCellValueFactory(new PropertyValueFactory("nome"));
        tbPecaCoPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        tbPecas.setItems(atualizaTabela());

    }

    public ObservableList<Peca> atualizaTabela() {

        return FXCollections.observableArrayList(pecas);
    }

}
