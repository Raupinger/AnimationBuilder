package gui.eventHandler;

import gui.Controller;
import gui.CustomCell;
import javafx.event.*;
import javafx.scene.Node;
public class FrameRemoveHandler implements EventHandler<ActionEvent>{
    private gui.Controller controller;
    public FrameRemoveHandler(Controller c){
        controller = c;
    }
    public void handle(ActionEvent e){
        Node source = (Node) e.getSource();
        controller.removeFromSelected( (CustomCell) source.getParent());
    }
}