/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Adriano
 */
public class Principal extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // atenção para colocar a tela de login como iniciau comentar as linhas 72 73 na classe
        //trabalho no pacote controleTelas.
        Parent root = FXMLLoader.load(getClass().getResource("/telas/Login.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);

        //inicia maiximizado
//        stage.setMaximized(true);
        //retira botão de fechar
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
