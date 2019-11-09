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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    final String ARQUIVOPESSOA = "txt/pessoas.txt";
    final String ARQUIVOENDERECO = "txt/enderecos.txt";
    final String ARQUIVOCARRO = "txt/carros.txt";
    final String ARQUIVOTELEFONE = "txt/telefones.txt";
    @FXML
    private TextField tfEstado;
    @FXML
    private Label lbCpfInvalido;

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
        
    }

    @FXML
    private void acaoBtCadastra(ActionEvent event) {
       if (validaCampos()) {
            criaPessoa();    
       }
    }

    private void criaPessoa() {

        ReadWrite rw = new ReadWrite();

        ArrayList<Pessoa> pessoas = rw.readPessoa(ARQUIVOPESSOA);
        ArrayList<Endereco> enderecos = rw.readEndereco(ARQUIVOENDERECO);
        ArrayList<Telefone> telefones = rw.readTelefone(ARQUIVOTELEFONE);
        ArrayList<Carro> carros = rw.readCarro(ARQUIVOCARRO);

        int id = pessoas.size() + 1;

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
        endereco.setCidade(tfCidade.getText());
        endereco.setId(pessoa.getId());

        carro.setPlaca(tfPlaca.getText());
        carro.setAno(tfAno.getText());
        carro.setModelo(tfModelo.getText());
        carro.setFabricante(tfFabricante.getText());
        carro.setMotor(tfMotor.getText());
        carro.setKm(Integer.parseInt(tfKm.getText()));
        carro.setAtivo(true);
        carro.setId(pessoa.getId());

        //adiciona objeto no vetor
        pessoas.add(pessoa);
        enderecos.add(endereco);
        telefones.add(telefone);
        carros.add(carro);

        //salva vetor no arquivo txt
        rw.writePessoa(ARQUIVOPESSOA, pessoas);
        rw.writeEndereco(ARQUIVOENDERECO, enderecos);
        rw.writeTelefone(ARQUIVOTELEFONE, telefones);
        rw.writeCarro(ARQUIVOCARRO, carros);
        limparCampos();
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
                lbErro.setText("DIGITE O CPF");
            }

        } else {
            lbErro.setText("DIGITE UM NOME");
        }
        return false;
    }
    
    private void limparCampos(){
        

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

}
