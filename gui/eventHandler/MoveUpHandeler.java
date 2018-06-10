package gui.eventHandler;

import gui.Controller;
import gui.CustomCell;
import javafx.event.*;
import javafx.scene.Node;
public class MoveUpHandeler implements EventHandler<ActionEvent>{
    private Controller controller;
    public MoveUpHandeler(Controller c){
        controller = c;
    }
    public void handle(ActionEvent e){
        Node source = (Node) e.getSource();
        controller.moveSelected( (CustomCell) source.getParent(), -1);
    };
}