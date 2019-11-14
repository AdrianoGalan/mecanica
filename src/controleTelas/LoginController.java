/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.RWUsuario;
import classes.Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.Util;

/**
 * FXML Controller class
 *
 * @author drico
 */
public class LoginController implements Initializable {

    @FXML
    private Button bTEntrar;
    @FXML
    private Label erroLogin;
    @FXML
    private TextField texUsuario;
    @FXML
    private TextField texSenha;
    @FXML
    private Label fechar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void clickBotaoEntrar(ActionEvent event) {

        entrar();

    }

    @FXML
    private void clickFechar(MouseEvent event) {

        System.exit(0);
    }

    @FXML
    private void clickEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            entrar();

        }
    }

    private void carregaTelaTrabalho() {
        try {

            Stage stage = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("/telas/Trabalho.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);

            //inicia maiximizado
//            stage.setMaximized(true);
            //retira botão de fechar
//            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

            // fecha tela do login
            bTEntrar.getScene().getWindow().hide();

        } catch (IOException ex) {
            //   Logger.getLogger(FXMLTelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validaUsuarioSenha(ArrayList<Usuario> usuarios) {

        try {

            for (Usuario usuario : usuarios) {
                if (texUsuario.getText().equals(usuario.getUsuario())) {
                    if (texSenha.getText().equals(usuario.getSenha())) {
                       
                        Util.setUsuarioAtual(usuario);
                        return true;
                    } else {
                        erroLogin.setText("Senha invalida");
                        return false;
                    }
                }
            }
            erroLogin.setText("Usuario inexistente");
            return false;

        } catch (Exception e) {
            return false;
        }

    }

    private void entrar() {

        ArrayList<Usuario> usuarios = RWUsuario.lerUsuario();

        try {

            if (!texUsuario.getText().isEmpty()) {
                if (!texSenha.getText().isEmpty()) {
                    if (validaUsuarioSenha(usuarios)) {
                       
                       Util.log.UsuarioAtual = texUsuario;
                       carregaTelaTrabalho();
                    }

                } else {

                    erroLogin.setText("Digite uma senha");
                }

            } else {
                erroLogin.setText("Digite um usuario");
            }

        } catch (Exception e) {

            System.out.println("arquivo bichado");
        }

    }

}
