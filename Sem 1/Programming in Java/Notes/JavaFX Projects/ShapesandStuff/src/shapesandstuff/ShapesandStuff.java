/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shapesandstuff;

/**
 *
 * @author srijan
 */

import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
public class ShapesandStuff extends Application{

    @Override
    public void start(Stage pstage){
        /* Blue Cross
        Rectangle r = new Rectangle();
        Rectangle s = new Rectangle();
        r.setX(100.0);
        r.setY(100.0);
        r.setWidth(100.0);
        r.setHeight(300.0);
        s.setX(50.0);
        s.setY(120.0);
        s.setWidth(300.0);
        s.setHeight(100.0);
        r.setFill(Color.BLUE);
        s.setFill(Color.BLUE);*/
        
        Polygon pent = new Polygon();
        double x = 100.0;
        double y = 100.0;
        double r = 100.0;
        
        for(int i = 0; i < 5; i++){
            double angle = Math.toRadians(360 / 5 * i);
            double xi = x + Math.cos(angle) * r;
            double yi = y + Math.sin(angle) * r;
            pent.getPoints().addAll(xi, yi);
        }
        pent.setFill(Color.RED);
        
        StackPane root = new StackPane();
        root.getChildren().add(pent);
        //root.getChildren().add(r);
        Scene sc = new Scene(root, 500, 500);
        pstage.setScene(sc);
        pstage.setTitle("Plus");
        pstage.show();
        
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
