/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.ReadWrite;
import classes.Carro;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import util.Util;

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
    @FXML
    private TextField tfEstado;
    @FXML
    private Label lbCpfInvalido;
    @FXML
    private Label lbOk;
    @FXML
    private AnchorPane paneFilho;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Util.mascaraCEP(tfCep);
        Util.mascaraCPF(tfCpf);
        Util.mascaraPlaca(tfPlaca);
        Util.mascaraTelCelular(tfTelefone1);
        Util.mascaraTelFixo(tfTelefone2);
        Util.apenasNumeros(true,tfNumero, 4);
        Util.apenasNumeros(false,tfEstado,1);

    }

    @FXML
    private void acaoBtCadastra(ActionEvent event) {
        lbOk.setText("");
        if (validaCampos()) {
            criaPessoa();
            JOptionPane.showMessageDialog(null, "Salvo");
            carregaTela("/telas/Inicio.fxml");
        }
    }

    private void criaPessoa() {
        try {
            ReadWrite rw = new ReadWrite();

            ArrayList<Pessoa> pessoas = rw.readPessoa();
            ArrayList<Endereco> enderecos = rw.readEndereco();
            ArrayList<Telefone> telefones = rw.readTelefone();
            ArrayList<Carro> carros = rw.readCarro();

            int id = pessoas.size() + 1;
            int idCarro = carros.size() + 1;

            Pessoa pessoa = new Pessoa(id);
            Endereco endereco = new Endereco();
            Telefone telefone = new Telefone();
            Telefone telefone1 = new Telefone();
            Carro carro = new Carro();
//        
            if (!tfTelefone2.getText().equals("")) {
                telefone1.setNumero(tfTelefone2.getText());
                telefone1.setDdd("11");
                telefone1.setId(pessoa.getId());

            }

            pessoa.setNome(tfNome.getText());
            pessoa.setCpf(tfCpf.getText());

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

            carro.setId(idCarro);
            carro.setPlaca(tfPlaca.getText());
            carro.setAno(tfAno.getText());
            carro.setModelo(tfModelo.getText());
            carro.setFabricante(tfFabricante.getText());
            carro.setMotor(tfMotor.getText());
            carro.setKm(Integer.parseInt(tfKm.getText()));
            carro.setStatus(true);
            carro.setIdPessoa(pessoa.getId());

            //adiciona objeto no vetor
            pessoas.add(pessoa);
            enderecos.add(endereco);
            telefones.add(telefone);
            carros.add(carro);

            //salva vetor no arquivo txt
            rw.writePessoa(pessoas);
            rw.writeEndereco(enderecos);
            rw.writeTelefone(telefones);
            rw.writeCarro(carros);
            limparCampos();
            lbOk.setText("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validaCampos() {

        if (!tfNome.getText().equals("")) {
            lbErro.setText("");
            if (!tfCpf.getText().equals("")) {
                lbErro.setText("");
                lbCpfInvalido.setVisible(false);
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
                    lbCpfInvalido.setVisible(true);
                }
            }

        } else {
            lbErro.setText("DIGITE UM NOME");
        }
        return false;
    }

    private void limparCampos() {

        tfNome.setText("");
        tfCpf.setText("");
        tfTelefone1.setText("");
        tfTelefone2.setText("");
        tfRua.setText("");
        tfNumero.setText("");
        tfBairro.setText("");
        tfCep.setText("");
        tfCidade.setText("");
        tfPlaca.setText("");
        tfModelo.setText("");
        tfFabricante.setText("");
        tfMotor.setText("");
        tfAno.setText("");
        tfKm.setText("");

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
