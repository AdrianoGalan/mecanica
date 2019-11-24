/*
Classe tem por objetivo o controle das telas.
contém os botões de navegação.

 */
package controleTelas;

import LerGravar.RWUsuario;
import classes.Usuario;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import util.Util;


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
    private Label lbHora;
    @FXML
    private Label lbData;
    @FXML
    private MenuItem btCadasCarro;
    @FXML
    private Button btInicio;
    @FXML
    private MenuItem btFluxoDeCaixa;
    @FXML
    private MenuItem btDre;
    @FXML
    private Button btSair;

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
        carregaTela("/telas/ConsultaOS.fxml");
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

    @FXML
    private void acaoBtFluxoDeCaixa(ActionEvent event) {            
            carregaTela("/telas/Dfc.fxml");
    }

    @FXML
    private void acaoBtDre(ActionEvent event) {
        carregaTela("/telas/Dre.fxml");
    }

    @FXML
    private void acaoBtSair(ActionEvent event) {
       

        // validar para sair
        Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType btSim = new ButtonType("Sim");
        ButtonType btNao = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogo.setHeaderText("Deseja Sair Programa?");
        dialogo.setTitle("Fechar");
        dialogo.getButtonTypes().setAll(btSim, btNao);
        dialogo.showAndWait().ifPresent(b -> {

            if (b == btSim) {
                System.exit(0);
            }

        });
    }

}
