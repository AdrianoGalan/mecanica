/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.ReadWrite;
import classes.Endereco;
import classes.Pessoa;
import classes.Telefone;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import sun.awt.PeerEvent;
import util.Util;

/**
 * FXML Controller class
 *
 * @author Laboratorio101
 */
public class AtualizarClienteController implements Initializable {

    @FXML
    private TextField tfBairro;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfCep;
    @FXML
    private TextField tfNumero;
    @FXML
    private TextField tfRua;
    @FXML
    private TextField tfTelefone2;
    @FXML
    private TextField tfTelefone1;
    @FXML
    private TextField tfCpf;
    @FXML
    private TextField tfNome;
    @FXML
    private Button btAtualizar;
    @FXML
    private Label lbErro;
    @FXML
    private AnchorPane paneFilho;

    private ArrayList<Pessoa> pessoas;
    private ArrayList<Endereco> enderecos;
    private ArrayList<Telefone> telefones;
    private Pessoa pessoa;
    private Endereco endereco;
    private Telefone telefone;

    ReadWrite rw = new ReadWrite();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Util.mascaraCEP(tfCep);
        Util.mascaraTelCelular(tfTelefone1);
        Util.mascaraTelFixo(tfTelefone2);
        Util.apenasNumeros(true, tfNumero, 4);
        Util.apenasNumeros(false, tfEstado, 1);

        pessoa = Util.getPessoaAtualizar();

        tfCpf.setText(pessoa.getCpf());
        tfCpf.setEditable(false);
        tfNome.setText(pessoa.getNome());

        pessoas = rw.readPessoa();
        enderecos = rw.readEndereco();
        telefones = rw.readTelefone();

        povoaCampos();

    }

    @FXML
    private void acaoBtatualizar(ActionEvent event) {
        
        if(validaCampos()){
            if(atualizar()){
                
                JOptionPane.showMessageDialog(null, "Cliente atualizado");
                
                carregaTela("/telas/Inicio.fxml");
                
            }
        }

       
    }

    private boolean atualizar() {
        
         pessoa.setNome(tfNome.getText());

        telefone.setNumero(tfTelefone1.getText());
        telefone.setDdd("11");
        telefone.setId(pessoa.getId());

        endereco.setRua(tfRua.getText());
        endereco.setNumero(tfNumero.getText());
        endereco.setCep(tfCep.getText());
        endereco.setBairro(tfBairro.getText());
        endereco.setEstado(tfEstado.getText());
        endereco.setCidade(tfCidade.getText());
        endereco.setId(pessoa.getId());

        for (int i = 0; i < pessoas.size(); i++) {

            if (pessoas.get(i).getId() == pessoa.getId()) {

                pessoas.set(i, pessoa);
            }
        }
        for (int i = 0; i < enderecos.size(); i++) {

            if (enderecos.get(i).getId() == endereco.getId()) {

                enderecos.set(i, endereco);
            }

        }
        for (int i = 0; i < telefones.size(); i++) {

            if (telefones.get(i).getId() == telefone.getId()) {

                telefones.set(i, telefone);
            }

            rw.writePessoa(pessoas);
            rw.writeEndereco(enderecos);
            rw.writeTelefone(telefones);
            return true;
        }
        
        return false;

    }

    private void povoaCampos() {

        for (int i = 0; i < enderecos.size(); i++) {

            if (enderecos.get(i).getIdPessoa() == pessoa.getId()) {
                tfBairro.setText(enderecos.get(i).getBairro());
                tfCep.setText(enderecos.get(i).getCep());
                tfCidade.setText(enderecos.get(i).getCidade());
                tfEstado.setText(enderecos.get(i).getEstado());
                tfNumero.setText(enderecos.get(i).getNumero());
                tfRua.setText(enderecos.get(i).getRua());
                endereco = enderecos.get(i);
            }
        }

        for (int i = 0; i < telefones.size(); i++) {

            if (telefones.get(i).getId() == pessoa.getId()) {
                tfTelefone1.setText(telefones.get(i).getNumero());
                telefone = telefones.get(i);
            }
        }

    }

    private boolean validaCampos() {

        if (!tfNome.getText().equals("")) {
            lbErro.setText("");
            if (!tfCpf.getText().equals("")) {
                lbErro.setText("");
                if (!tfTelefone1.getText().equals("")) {
                    lbErro.setText("");
                    if (!tfRua.getText().equals("")) {
                        lbErro.setText("");
                        if (!tfNumero.getText().equals("")) {
                            lbErro.setText("");
                            if (!tfCep.getText().equals("")) {
                                lbErro.setText("");
                                if (!tfBairro.getText().equals("")) {
                                    lbErro.setText("");
                                    if (!tfCidade.getText().equals("")) {
                                        lbErro.setText("");

                                        return true;
                                        //validou

                                    } else {
                                        lbErro.setText("DIGITE UMA CIDADE");
                                    }
                                } else {
                                    lbErro.setText("DIGITE UM NUMERO");
                                }
                            } else {
                                lbErro.setText("DIGITE UM CEP");
                            }

                        } else {
                            lbErro.setText("DIGITE UM NUMERO");
                        }

                    } else {
                        lbErro.setText("DIGITE UMA RUA");
                    }

                } else {
                    lbErro.setText("DIGITE UM TELEFONE");
                }

            } else {
                if (tfCpf.getText().equals("")) {
                    lbErro.setText("DIGITE O CPF");
                } else {

                }
            }

        } else {
            lbErro.setText("DIGITE UM NOME");
        }

        return false;
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
