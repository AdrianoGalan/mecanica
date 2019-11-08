/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

}
