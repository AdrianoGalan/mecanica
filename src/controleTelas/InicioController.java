/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTelas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import util.Util;

/**
 * FXML Controller class
 *
 * @author Adriano
 */
public class InicioController implements Initializable {

    @FXML
    private AnchorPane paneFilho;
    @FXML
    private Label lbNomrUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lbNomrUsuario.setText(Util.getUsuarioAtual().getNome());
       
    }    
    
}
