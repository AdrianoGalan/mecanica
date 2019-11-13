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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import util.Util;

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
    // private ListView<Peca> lwPecas;
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
    @FXML
    private TableView<Peca> tbPecas;
    @FXML
    private TableColumn<Peca, String> tbPecaCoDescricao;
    @FXML
    private TableColumn<Peca, Double> tbPecaCoPreco;
    @FXML
    private TableView<Servico> tbServico;
    @FXML
    private Label lbTotalServico;
    @FXML
    private Label lbTotalPeca;
    @FXML
    private TableColumn<Servico, String> tbServicoCoDescricao;
    @FXML
    private TableColumn<Servico, Double> tbServicoCoPreco;

    private ReadWrite rw = new ReadWrite();

    private Orcamento orcamento = new Orcamento();

    private ArrayList<Peca> pecas;

    private ArrayList<Servico> servicos;

    ArrayList<Orcamento> orcamentos = rw.readOrcamento();
    @FXML
    private Label lbTotalOrcamento;
    @FXML
    private Button btSalvar;
    @FXML
    private AnchorPane paneFilho;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        pecas = rw.readPecas();
        servicos = rw.readServicos();

        orcamento.setIdCarro(-1);
        orcamento.setStatus(true);

        if (orcamentos == null) {

            orcamento.setId(1);
            orcamentos = new ArrayList();

        } else {
            orcamento.setId(orcamentos.size() + 1);
        }

    }

    @FXML
    private void acaoBtSalvar(ActionEvent event) {

      salvar();

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

        if (orcamento.getIdCarro() != -1) {
            if (!tfServico.getText().isEmpty()) {
                if (!tfPrecoServico.getText().isEmpty()) {

                    Servico servico = new Servico();

                    servico.setIdOrcamento(orcamento.getId());
                    servico.setDescricao(tfServico.getText());

                    try {
                        servico.setPreco(Double.parseDouble(tfPrecoServico.getText()));
                        servicos.add(servico);
                        iniciaTablelaServico();
                        tfServico.setText("");
                        tfPrecoServico.setText("");

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "Preço invalido");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Digite o Preço do Serviço");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite a descrição do Servico");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite a Placa do carro");
        }

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
                        iniciaTablelaPeca();

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

        Servico servicoSelecionada = tbServico.getSelectionModel().getSelectedItem();

        int id = -1;

        if (servicoSelecionada != null) {
            for (int i = 0; i < servicos.size(); i++) {
                if (servicoSelecionada.getDescricao().equals(servicos.get(i).getDescricao())) {
                    id = i;
                    break;
                }
            }
            if (id != -1) {
                servicos.remove(id);
            }
            iniciaTablelaServico();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Serviço");
        }

    }

    @FXML
    private void acaoBtRemovePeca(ActionEvent event) {

        Peca pecaSelecionada = tbPecas.getSelectionModel().getSelectedItem();

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
            iniciaTablelaPeca();
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

    private void iniciaTablelaPeca() {

        tbPecaCoDescricao.setCellValueFactory(new PropertyValueFactory("nome"));
        tbPecaCoPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        tbPecas.setItems(atualizaTabelaPeca());

        soma();

    }

    public ObservableList<Peca> atualizaTabelaPeca() {

        return FXCollections.observableArrayList(pecas);
    }

    private void iniciaTablelaServico() {

        tbServicoCoDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        tbServicoCoPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        tbServico.setItems(atualizaTabelaServico());

        soma();

    }

    public ObservableList<Servico> atualizaTabelaServico() {

        return FXCollections.observableArrayList(servicos);
    }

    // calcula soma total do orçamento
    private void soma() {

        double somaServico = 0;
        double somaPeca = 0;
        double somaOrcamento = 0;

        for (int i = 0; i < servicos.size(); i++) {

            somaServico = somaServico + servicos.get(i).getPreco();
        }

        lbTotalServico.setText(String.valueOf(somaServico));

        for (int i = 0; i < pecas.size(); i++) {

            somaPeca = somaPeca + pecas.get(i).getPreco();
        }

        lbTotalPeca.setText(String.valueOf(somaPeca));

        somaOrcamento = somaPeca + somaServico;

        lbTotalOrcamento.setText(String.valueOf(somaOrcamento));

    }

    // salva o orçamento 
    private void salvar() {

//        try {
        ArrayList<String> dataHora = Util.atualizaHoras();

        if (orcamento.getIdCarro() != -1) {
            if (!taDescricaoProblema.getText().isEmpty()) {

                orcamento.setDescricaoProblema(taDescricaoProblema.getText());
                orcamento.setValorTotalMaoObra(Double.parseDouble(lbTotalServico.getText()));
                orcamento.setValorTotalPecas(Double.parseDouble(lbTotalPeca.getText()));
                orcamento.setValorTotalOrcamento(Double.parseDouble(lbTotalOrcamento.getText()));
                orcamento.setDataAtual(dataHora.get(0));
                orcamento.setHoraAtual(dataHora.get(1));

                orcamentos.add(orcamento);
                if (rw.writeOrcamento(orcamentos) && rw.writePecas(pecas) && rw.writeServicos(servicos)) {
                   
                    JOptionPane.showMessageDialog(null, "Orçamento Salvo");

                       carregaTela("/telas/Inicio.fxml");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Digite a descrição do defeito");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Digite a Placa do carro");
        }

//        } catch (Exception e) {
//            
//            JOptionPane.showMessageDialog(null, "Erro ao salvar");
//        }
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
