/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basicbutton;

/**
 *
 * @author srijan
 */

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
//import javafx.event.Event;
import javafx.event.EventHandler;
public class EHandler implements EventHandler<ActionEvent>{
    TextField tf;
    
    EHandler(TextField tf){
        this.tf = tf;
    }
    @Override
    public void handle(ActionEvent e){
        tf.setText("Fuck You Nigga!");
    }
}