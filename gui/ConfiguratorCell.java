package gui;

import java.util.HashMap;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import gui.eventHandler.FrameRemoveHandler;
public class ConfiguratorCell extends CustomCell{
    private ImageView image;
    private Label name;
    private TextField duration;
    private Button remove;
    private Button up;
    private Button down;
    private HashMap<String, EventHandler> handler;
    private gui.eventHandler.FrameRemoveHandler remover;
    private ConfiguratorCell(){}
    public ConfiguratorCell(HashMap<String, EventHandler> h, Image img, String n, int d ){
        
        super();
        handler = h;
        this.maxWidth(150);
        this.setMaxWidth(USE_PREF_SIZE);
        System.out.println(this.maxWidthProperty());
        
        
        //set up the preview
        image = new ImageView(img);
        image.maxHeight(63);
        this.setTopAnchor(image, 2.0);
        this.setBottomAnchor(image, 2.0);
        this.setLeftAnchor(image, 15.0);
        
        //set up the input for the duration
        duration = new TextField(String.valueOf(d));
        duration.prefWidth(35);
        this.setLeftAnchor(duration, 67.0);
        this.setBottomAnchor(duration, 2.0);
        this.setRightAnchor(duration, 14.0);
        
        //set up the Label for the Filename
        name = new Label(n);
        name.maxWidth(186);
        name.setMaxWidth(USE_PREF_SIZE);
        name.prefWidth(186);
        name.setWrapText(true);
        this.setTopAnchor(name, 2.0);
        this.setLeftAnchor(name, 77.0);
        this.setRightAnchor(name, 14.0);
        //set up the "remove Button
        remove = new Button("x");
        remove.setOnAction(handler.get("remove"));
        
        this.setLeftAnchor(remove,2.0);
        this.setTopAnchor(remove,2.0);
        this.setBottomAnchor(remove,2.0);
        
        //set up the up Button
        up = new Button("^");
        up.setOnAction(handler.get("up"));
        this.setRightAnchor(up,2.0);
        this.setTopAnchor(up,2.0);
        this.setBottomAnchor(up,33.0);
        
        //set up the down Button
        down = new Button("v");
        this.setRightAnchor(down,2.0);
        this.setTopAnchor(down, 33.0);
        this.setBottomAnchor(down,2.0);
        
        
        
        
        
        this.getChildren().addAll(image, name, duration, remove, up, down); 
    }
}