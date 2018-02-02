/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author claytoncornett
 */
public class CheckerboardViewController implements Initializable, Startable {
    
    private Stage stage;
    
    @FXML
    public AnchorPane anchorPane;
    
    
    private Color lightcolor = Color.RED;
    private Color darkcolor = Color.BLACK;
    
     private int numRows = 8;
    private  int numCols = 8;
    private double boardWidth = 600.0;
    private double boardHeight = 600.0;
    
    boolean next = true;
    
    private CheckerBoard checkerboard;
    
   private GridPane gridPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void start(Stage stage){
        
     
        this.stage = stage;
        boardWidth = stage.getWidth();
        boardHeight = stage.getHeight();
     
       checkerboard = new CheckerBoard(numRows,numCols,anchorPane.getWidth(), anchorPane.getHeight());
       


       this.stage.widthProperty().addListener(new ChangeListener<Number>() {
         @Override 
     public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
          refresh();
     }
        });
       
       this.stage.heightProperty().addListener(new ChangeListener<Number>() {
         @Override 
     public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
          refresh();
     }
        });
       
       
       
       ChangeListener<Number> changeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
           refresh();
        };
       
    
       
       
       refresh();
      
     
    }
    
    
    
    private void handleRefresh(ActionEvent event){
        System.out.println("Refresh");
        refresh();
    }
    
    private void handleClear(ActionEvent event){
        System.out.println("Clear");
         clearGridPane();
    }
    
    
    
    private void handleAbout(ActionEvent event){
        System.out.println("About");
    }
    
    @FXML
    private void sixteenAction(){
        numRows = 16;
        numCols = 16;
        refresh();
    }
    @FXML
    private void tenAction(){
        numRows = 10;
        numCols = 10;
        refresh();
    }
    @FXML
    private void eightAction(){
        numRows = 8;
        numCols = 8;
        refresh();
    }
    @FXML
    private void threeAction(){
        numRows = 3;
        numCols = 3;
        refresh();
    }
    @FXML
    private void defaultAction(){
       
        lightcolor = Color.RED;
        darkcolor = Color.BLACK;
        refresh();
    }
    @FXML
    private void blueAction(){ 
        
        lightcolor = Color.SKYBLUE;
        darkcolor = Color.DARKBLUE;
        refresh();
    }
    
    private void refresh(){
        
        boardWidth = anchorPane.getWidth();
        boardHeight = anchorPane.getHeight();
        
        checkerboard = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightcolor, darkcolor);
        
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(checkerboard.build());
       
        
   
    }
    
    
    private void clearGridPane(){
        gridPane.getChildren().clear();
    }

}
