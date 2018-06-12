package gui;

import store.Frame;
import java.util.HashMap;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import gui.eventHandler.FrameRemoveHandler;
public class ConfiguratorCell extends ListCell<Frame>{
    private ImageView image;
    private Label name;
    private TextField duration;
    private Button remove;
    private Button up;
    private Button down;
    private HashMap<String, EventHandler> handler;
    private gui.eventHandler.FrameRemoveHandler remover;
    private String prefix;
    private AnchorPane pane;
    public ConfiguratorCell(HashMap<String, EventHandler> h, String p){
        handler = h;
        prefix = p;
        setText("-_-");
        System.out.println("-_-");
    }
    @Override protected void updateItem(Frame item, boolean empty){
        String n = item.getName();
        int d = item.getDuration();
        super.updateItem(item,empty);
        
        this.maxWidth(150);
        this.setMaxWidth(USE_PREF_SIZE);
        System.out.println(this.maxWidthProperty());
        
        
        //set up the preview
        image = new ImageView(prefix + name);
        image.maxHeight(63);
        
        pane.setTopAnchor(image, 2.0);
        pane.setBottomAnchor(image, 2.0);
        pane.setLeftAnchor(image, 15.0);
        
        //set up the input for the duration
        duration = new TextField(String.valueOf(d));
        duration.prefWidth(35);
        
        pane.setLeftAnchor(duration, 67.0);
        pane.setBottomAnchor(duration, 2.0);
        pane.setRightAnchor(duration, 14.0);
        
        //set up the Label for the Filename
        name = new Label(n);
        name.maxWidth(186);
        name.setMaxWidth(USE_PREF_SIZE);
        name.prefWidth(186);
        name.setWrapText(true);
        
        pane.setTopAnchor(name, 2.0);
        pane.setLeftAnchor(name, 77.0);
        pane.setRightAnchor(name, 14.0);
        
        //set up the "remove Button
        remove = new Button("x");
        remove.setOnAction(handler.get("remove"));
        
        pane.setLeftAnchor(remove,2.0);
        pane.setTopAnchor(remove,2.0);
        pane.setBottomAnchor(remove,2.0);
        
        //set up the up Button
        up = new Button("^");
        up.setOnAction(handler.get("up"));
        
        pane.setRightAnchor(up,2.0);
        pane.setTopAnchor(up,2.0);
        pane.setBottomAnchor(up,33.0);
        
        //set up the down Button
        down = new Button("v");
        
        pane.setRightAnchor(down,2.0);
        pane.setTopAnchor(down, 33.0);
        pane.setBottomAnchor(down,2.0);
        
        
        
        
        
        pane.getChildren().addAll(image, name, duration, remove, up, down); 
        setGraphic(pane);
        setText("-_-");
        System.out.println("updated");
    }
}