/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    }

    @FXML
    private void acaoBtConsultaOS(ActionEvent event) {
    }

    public void carregaTela(String nomeTela) {

        //carrega tela
        try {

            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(nomeTela));

            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);

            PanePrincipal.getChildren().setAll(a);

        } catch (IOException ex) {
            //  Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void atualizaHoras() {

        LocalDateTime dt = LocalDateTime.now();
        String mes = "" + dt.getMonth();
        String mes1 = "" + dt.getMonth();
        mes1 = mes.substring(0,1);
        mes = mes.substring(1,3);
        mes = mes1 + mes.toLowerCase();
        String dataAtual = dt.getDayOfMonth() + " " + mes + ". de " + dt.getYear();
        String horaAtual = (dt.getHour()-1) + ":" + dt.getMinute();
        lbData.setText(dataAtual);
        lbHora.setText(horaAtual);

    }

}
