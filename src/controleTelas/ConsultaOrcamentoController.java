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
import classes.Telefone;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import modelosTabelas.TabelaOrcamento;

/**
 * FXML Controller class
 *
 * @author Adriano
 */
public class ConsultaOrcamentoController implements Initializable {

    @FXML
    private AnchorPane paneFilho;
    @FXML
    private Button btGeraOs;
    @FXML
    private Button btFinalizar;
    @FXML
    private TextField tfKm;
    @FXML
    private TableView<TabelaOrcamento> tbOrcamentos;
    @FXML
    private TableColumn<TabelaOrcamento, String> tbOrcamentoColunaPlaca;
    @FXML
    private TableColumn<TabelaOrcamento, String> tbOrcamentoColunaInicio;
    @FXML
    private TableColumn<TabelaOrcamento, String> tbOrcamentoColunaDefeito;
    @FXML
    private TableColumn<TabelaOrcamento, Double> tbOrcamentoColunaTotal;
    @FXML
    private TableColumn<TabelaOrcamento, String> tbOrcamentoColunaTelefone;

    ArrayList<Orcamento> orcamentos;
    ArrayList<Pessoa> pessoas;
    ArrayList<Carro> carros;
    ArrayList<Telefone> telefones;

    ReadWrite rw = new ReadWrite();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        orcamentos = rw.readOrcamento();
        pessoas = rw.readPessoa();
        carros = rw.readCarro();
        telefones = rw.readTelefone();

        iniciaTablelaOrcamento();

    }

    @FXML
    private void acaoBtGeraOs(ActionEvent event) {
    }

    @FXML
    private void acaoBtFinalizar(ActionEvent event) {

        TabelaOrcamento tabelaOrcamentoSelecionada = tbOrcamentos.getSelectionModel().getSelectedItem();

        if (tabelaOrcamentoSelecionada != null) {
            finalizaOrcamento(tabelaOrcamentoSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Orcamento");
        }

    }

    private void finalizaOrcamento(TabelaOrcamento tabelaOrca) {

        for (int i = 0; i < orcamentos.size(); i++) {

            if (tabelaOrca.getIdOrcamento() == orcamentos.get(i).getId()) {

                orcamentos.get(i).setStatus(false);
                rw.writeOrcamento(orcamentos);
                iniciaTablelaOrcamento();

            }

        }

    }

    private void iniciaTablelaOrcamento() {

        tbOrcamentoColunaPlaca.setCellValueFactory(new PropertyValueFactory("placa"));
        tbOrcamentoColunaInicio.setCellValueFactory(new PropertyValueFactory("inicio"));
        tbOrcamentoColunaDefeito.setCellValueFactory(new PropertyValueFactory("defeito"));
        tbOrcamentoColunaTotal.setCellValueFactory(new PropertyValueFactory("total"));
        tbOrcamentoColunaTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        tbOrcamentos.setItems(atualizaTabelaPeca());

    }

    public ObservableList<TabelaOrcamento> atualizaTabelaPeca() {

        return FXCollections.observableArrayList(carregaTabela());
    }

    //carrega dados da tabela
    private ArrayList<TabelaOrcamento> carregaTabela() {

        ArrayList<TabelaOrcamento> tabelas = new ArrayList();

        for (int i = 0; i < orcamentos.size(); i++) {

            TabelaOrcamento tabela = new TabelaOrcamento();

            if (orcamentos.get(i).isStatus()) {

                tabela.setDefeito(orcamentos.get(i).getDescricaoProblema());
                tabela.setInicio(orcamentos.get(i).getDataAtual());
                tabela.setTotal(orcamentos.get(i).getValorTotalOrcamento());
                tabela.setIdOrcamento(orcamentos.get(i).getId());
                tabela.setIdCarro(orcamentos.get(i).getIdCarro());

                for (int j = 0; j < carros.size(); j++) {

                    if (tabela.getIdCarro() == carros.get(j).getId()) {

                        tabela.setPlaca(carros.get(j).getPlaca());
                        tabela.setIdPessoa(carros.get(j).getIdPessoa());

                        for (int k = 0; k < telefones.size(); k++) {

                            if (tabela.getIdPessoa() == telefones.get(k).getId()) {

                                tabela.setTelefone(telefones.get(k).getNumero());
                            }
                        }

                    }

                }
                tabelas.add(tabela);
            }

        }

        return tabelas;
    }

}
