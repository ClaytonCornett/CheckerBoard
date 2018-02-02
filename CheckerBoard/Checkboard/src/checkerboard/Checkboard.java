/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author claytoncornett
 */
public class Checkboard extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckerboardView.fxml"));
        Parent root = loader.load();
        CheckerboardViewController controller = loader.getController();
        
      //  Object oc = (Object)controller;
        Initializable ic = (Initializable)controller;
        
        
      //  Parent root = FXMLLoader.load(getClass().getResource("RandomGridFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        controller.start(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
