package gui;


import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

public class PickerCell extends CustomCell{
    private ImageView image;
    private Label name;
    private Button button;
    private PickerCell(){}
    public PickerCell(Image img, String n){
        
        super();
        
        this.maxWidth(130);
        image = new ImageView(img);
        name = new Label(n);
        button = new Button("+");
        image.prefHeight(62);
        name.maxWidth(186);
        name.prefWidth(186);
        name.setWrapText(true);
        /*
        this.setTopAnchor(image, name.getHeight() + 8.0);
        //this.setBottomAnchor(image, 2.0);
        this.setLeftAnchor(image, 2.0);
        this.setTopAnchor(name, 2.0);
        this.setLeftAnchor(name, 2.0);
        this.setBottomAnchor(button, 2.0);
        this.setLeftAnchor(button, 65.0);
        */
        this.getChildren().addAll(image, name, button); 
    }
}