/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.ReadWrite;
import classes.Carro;
import classes.Orcamento;
import classes.OrdemServico;
import classes.Pessoa;
import classes.Telefone;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import modelosTabelas.TabelaOrcamento;
import modelosTabelas.TabelaOrdemServico;

/**
 * FXML Controller class
 *
 * @author Laboratorio101
 */
public class ConsultaOSController implements Initializable {

    @FXML
    private AnchorPane paneFilho;
    @FXML
    private TableView<TabelaOrdemServico> tbConsultaOs;
    @FXML
    private TableColumn<TabelaOrdemServico, String> tbConsultaColPlaca;
    @FXML
    private TableColumn<TabelaOrdemServico, String> tbConsultaColNome;
    @FXML
    private TableColumn<TabelaOrdemServico, String> tbConsultaColTelefone;
    @FXML
    private TableColumn<TabelaOrdemServico, String> tbConsultaColDefeito;
    @FXML
    private TableColumn<TabelaOrdemServico, String> tbConsultaColData;
    @FXML
    private TableColumn<TabelaOrdemServico, Double> tbConsultaColValor;
    
    
    ArrayList<Orcamento> orcamentos;
    ArrayList<Pessoa> pessoas;
    ArrayList<Carro> carros;
    ArrayList<Telefone> telefones;
    ArrayList<OrdemServico> oss;

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
        oss = rw.readOs();
        
        iniciaTablelaOrcamento();
  
    }    
    
    
    private void iniciaTablelaOrcamento() {

        tbConsultaColPlaca.setCellValueFactory(new PropertyValueFactory("placa"));
        tbConsultaColNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tbConsultaColTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        tbConsultaColDefeito.setCellValueFactory(new PropertyValueFactory("defeito"));
        tbConsultaColData.setCellValueFactory(new PropertyValueFactory("data"));
        tbConsultaColValor.setCellValueFactory(new PropertyValueFactory("valor"));
        tbConsultaOs.setItems(atualizaTabelaOs());

    }

    public ObservableList<TabelaOrdemServico> atualizaTabelaOs() {

        return FXCollections.observableArrayList(carregaTabela());
    }
    
    
        
    

    //carrega dados da tabela
    private ArrayList<TabelaOrdemServico> carregaTabela() {

        ArrayList<TabelaOrdemServico> tabelas = new ArrayList();

        for (int i = 0; i < oss.size(); i++) {

            TabelaOrdemServico tabela = new TabelaOrdemServico();

            if (oss.get(i).isStatus()) {

               tabela.setIdCarro(oss.get(i).getIdCarro());
               tabela.setIdOrcamento(oss.get(i).getIdOrcamento());
               tabela.setIdPessoa(oss.get(i).getIdPessoa());
      

                for (int j = 0; j < carros.size(); j++) {

                    if (tabela.getIdCarro() == carros.get(j).getId()) {

                        tabela.setPlaca(carros.get(j).getPlaca());
                        

                        for (int k = 0; k < telefones.size(); k++) {

                            if (tabela.getIdPessoa() == telefones.get(k).getId()) {

                                tabela.setTelefone(telefones.get(k).getNumero());
                                
                                for (int l = 0; l < pessoas.size(); l++) {
                                    
                                    if(tabela.getIdPessoa() == pessoas.get(l).getId()){
                                        tabela.setNome(pessoas.get(l).getNome());
                                   
                                        for (int m = 0; m < orcamentos.size(); m++) {
                                            
                                            if(tabela.getIdOrcamento() == orcamentos.get(m).getId()){
                                                
                                                tabela.setData(orcamentos.get(m).getDataAtual());
                                                tabela.setDefeito(orcamentos.get(m).getDescricaoProblema());
                                                tabela.setValor(orcamentos.get(m).getValorTotalOrcamento());
                                            }
                                        }
                                    
                                    }
                                }
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
