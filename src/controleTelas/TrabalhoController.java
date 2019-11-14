/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import LerGravar.RWUsuario;
import classes.Usuario;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import util.Util;

/**
 * FXML Controller class
 *
 * @author Adriano
 */
public class TrabalhoController implements Initializable {

    @FXML
    private Button btNovoOrcamento;
    @FXML
    private Pane PanePrincipal;
    @FXML
    private MenuItem bTCadasCliente;
    @FXML
    private MenuItem btCadasOrcamento;
    @FXML
    private MenuItem bTConsultaCliente;
    @FXML
    private MenuItem btConsultaOrcamento;
    @FXML
    private MenuItem btConsultaOS;
    @FXML
    private MenuItem btConsultaOrcamento1;
    @FXML
    private MenuItem btConsultaOS1;
    @FXML
    private Label lbHora;
    @FXML
    private Label lbData;
    @FXML
    private MenuItem btCadasCarro;
    @FXML
    private Button btInicio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //codigo temporario para trabalhar sem a tela de login
         ArrayList<Usuario> usuarios = RWUsuario.lerUsuario();
         Util.setUsuarioAtual(usuarios.get(0));
         //fim codigo temporario
        
        carregaTela("/telas/Inicio.fxml");
        
     
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    @FXML
    private void acaoBtNovoOrcamento(ActionEvent event) {
        carregaTela("/telas/CadastroOrcamento.fxml");

    }

    @FXML
    private void acaoBtCadasCliente(ActionEvent event) {

        carregaTela("/telas/CadastroCliente.fxml");

    }

    @FXML
    private void acaoBtCadasOrcamento(ActionEvent event) {

        carregaTela("/telas/CadastroOrcamento.fxml");
    }

    @FXML
    private void acaoBtConsultaCliente(ActionEvent event) {

        carregaTela("/telas/ConsultaCliente.fxml");
    }

    @FXML
    private void acaoBtConsultaOrcamento(ActionEvent event) {
        
        carregaTela("/telas/ConsultaOrcamento.fxml");
    }

    @FXML
    private void acaoBtConsultaOS(ActionEvent event) {
        carregaTela("/telas/Dre.fxml");
    }

    @FXML
    private void acaoBtCadasCarro(ActionEvent event) {

        carregaTela("/telas/CadastroCarro.fxml");
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

            PanePrincipal.getChildren().setAll(a);
 } catch (IOException ex) {
            Logger.getLogger(TrabalhoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }

    private void atualizaHoras() {

        ArrayList<String> dataHora = Util.atualizaHoras();
       
        
        lbData.setText(dataHora.get(0));
        lbHora.setText(dataHora.get(1));

    }

    @FXML
    private void acaoBtInicio(ActionEvent event) {
        
        carregaTela("/telas/Inicio.fxml");
    }

}
