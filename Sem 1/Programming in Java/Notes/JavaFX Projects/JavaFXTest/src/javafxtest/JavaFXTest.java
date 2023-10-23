/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxtest;

/**
 *
 * @author srija
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
public class JavaFXTest extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Label label = new Label("Fuck You");
        StackPane root = new StackPane();
        root.getChildren().add(label);
        Scene ob = new Scene(root, 500, 500);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(ob);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
