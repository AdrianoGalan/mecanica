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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void acaoBtCadastra(ActionEvent event) {
              criaPessoa();

    }

    private void criaPessoa() {

        ReadWrite rw = new ReadWrite();

        ArrayList<Pessoa> pessoas = rw.readPessoa(ARQUIVOPESSOA);

        int id;

        if (pessoas == null) {
            pessoas = new ArrayList();
            id = 1;

        } else {
            id = pessoas.size()+1;
        }
        
        Pessoa pessoa = new Pessoa(id);
        Endereco endereco = new Endereco();
        Telefone telefone = new Telefone();
        Telefone telefone1 = new Telefone();
        Carro carro = new Carro();
//        
         if (!tfTelefone2.getText().equals("")) {
            telefone1.setNumero(Integer.parseInt(tfTelefone2.getText()));
            telefone1.setId(pessoa.getId());
            
        }

        if (validaCampos()) {
            pessoa.setNome(tfNome.getText());
            pessoa.setCpf(tfCpf.getText());
            telefone.setNumero(Integer.parseInt(tfTelefone1.getText()));
            telefone.setId(pessoa.getId());
            endereco.setRua(tfRua.getText());
            endereco.setNumero(tfNumero.getText());
            endereco.setCep(tfCep.getText());
            endereco.setBairro(tfBairro.getText());
            endereco.setCidade(tfCidade.getText());
            endereco.setId(pessoa.getId());
            carro.setPlaca(tfPlaca.getText());
            carro.setAno(Integer.parseInt(tfAno.getText()));
            carro.setModelo(tfModelo.getText());
            carro.setFabricante(tfFabricante.getText());
            carro.setMotor(tfMotor.getText());
            carro.setKm(Integer.parseInt(tfKm.getText()));
            carro.setAtivo(true);
            carro.setId(pessoa.getId());
        }
        pessoas.add(pessoa);
        rw.writePessoa(ARQUIVOPESSOA,pessoas);

       

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

}
