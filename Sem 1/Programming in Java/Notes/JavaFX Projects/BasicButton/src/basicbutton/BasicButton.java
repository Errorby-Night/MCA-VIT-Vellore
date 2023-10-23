/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basicbutton;

/**
 *
 * @author srijan
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
public class BasicButton extends Application{
    @Override
    public void start(Stage pstage){
        Button b1 = new Button("Click ME!");
        TextField tf = new TextField();
        b1.setOnAction(new EHandler(tf));
        GridPane root = new GridPane();
        root.addRow(6, b1);
        root.addRow(5, tf);
        Scene sc = new Scene(root, 150, 150);
        pstage.setScene(sc);
        pstage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
