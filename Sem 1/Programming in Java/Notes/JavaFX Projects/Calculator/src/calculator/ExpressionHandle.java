/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

/**
 *
 * @author srijan
 * @version 1.0
 */
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
public class ExpressionHandle implements EventHandler<ActionEvent>{
    TextField tf;
    Button b;
    ExpressionHandle(TextField tf, Button b){
        this.tf = tf;
        this.b = b;
    }
    public void handle(ActionEvent e){
        String s = tf.getText();
        s = s + b.getText();
        tf.setText(s);
    }
}
