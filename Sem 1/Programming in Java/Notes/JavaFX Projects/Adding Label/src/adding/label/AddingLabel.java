/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adding.label;

/**
 *
 * @author srijan
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddingLabel extends Application{
    @Override
    public void start(Stage primaryStage){
        Label label = new Label("Test");
        StackPane root = new StackPane();
        root.getChildren().add(label);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TEST");
        primaryStage.show();
        
    }
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        launch(args);
    }
    
}
