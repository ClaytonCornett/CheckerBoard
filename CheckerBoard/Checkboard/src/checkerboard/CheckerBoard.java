/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.util.Random;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author claytoncornett
 */
public class CheckerBoard {
    
    
    private AnchorPane anchorpane = new AnchorPane();
    
   
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    private int height;
    private int width;
    
     private int numRows = 8;
    private int numCols = 8;
    private double boardWidth = 600;
    private double boardHeight = 600;
    
  
    private double rectangleWidth;
    private double rectangleHeight;
    
    
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
       
        this.rectangleWidth = boardWidth / numCols;
        this.rectangleHeight = boardHeight / numRows;
        
       
        
        
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        
        this(numRows, numCols, boardWidth, boardHeight);
        
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        
        }
    
    
    public AnchorPane build() {
        anchorpane = new AnchorPane();
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
               
                Rectangle rectangle = new Rectangle((j*rectangleWidth), (i*rectangleHeight), rectangleWidth, rectangleHeight);
                
                Color color =  (j % 2) == (i % 2) ? lightColor : darkColor;
                
                rectangle.setFill(color);
                anchorpane.getChildren().add(rectangle);
            }
        }
        
        return anchorpane;
    }
    
    
    public int getNumRows(){
        return numRows;
        
    }
    
    public int getNumCols(){
        return numCols;
        
    }
    
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
    public int getRectangleWidth(){
        return width;
    }
    public int getRectangleHeight(){
        return height;
    }
    
    

    
    
}
