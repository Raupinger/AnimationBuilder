package gui;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.collections.*;
import java.util.HashMap;
import javafx.util.Callback;
import javafx.scene.image.*;
import gui.ConfiguratorCell;
import gui.eventHandler.*;
public class Controller {
    @FXML private TextField path;
    @FXML public ListView picker;
    @FXML public ListView configurator;
    ObservableList<CustomCell> available;
    ObservableList<CustomCell> selected;
    private HashMap<String, EventHandler> handlerSelected;
    private gui.eventHandler.FrameRemoveHandler remover;
    public Controller() {
        handlerSelected = new HashMap();
        handlerSelected.put("remove", new gui.eventHandler.FrameRemoveHandler(this));
        handlerSelected.put("up", new gui.eventHandler.MoveUpHandeler(this));
        remover =  new gui.eventHandler.FrameRemoveHandler(this);

        picker = new ListView();
        available = FXCollections.observableArrayList(
            new PickerCell(new Image("images/shiggy Master.png"), "Extra langer Dateiname, um zu testen, wie es reagiert, wenn der Dateiname sehr lang ist"), new PickerCell(new Image("images/shiggy halb.png"), "File 2"));

        picker.setPlaceholder(new Label(":-("));
        picker.refresh();
        System.out.println("inizialisiert");
        System.out.println(picker.getCellFactory());

        configurator = new ListView();
        selected = FXCollections.observableArrayList(
            new ConfiguratorCell(handlerSelected, new Image("images/shiggy Master.png"), "Extra langer Dateiname, um zu testen, wie es reagiert, wenn der Dateiname sehr lang ist", 105), new ConfiguratorCell(handlerSelected, new Image("images/shiggy halb.png"), "File 2", 100));

        configurator.setPlaceholder(new Label(":-("));
        configurator.refresh();
        System.out.println(configurator);

    }

    @FXML public void test(ActionEvent event) {
        System.out.print("pfad: ");
        System.out.println(path.getText());
        System.out.println(event);

        picker.setItems(available);
    }

    public void removeFromSelected(CustomCell cell) {
        selected.removeAll(cell);
    }

    public void moveSelected(CustomCell cell, int amount) {
        if(amount < 0 || amount >= selected.size()){return;}
        //amount = 0;
        amount = selected.indexOf(cell) + amount;
        CustomCell previus = selected.get(amount);
        selected.add(amount, cell);
        selected.set(amount + 1, previus);
        configurator.setItems(selected);
    }

    @FXML public void refresh() {

        selected = FXCollections.observableArrayList(
            new ConfiguratorCell(handlerSelected, new Image("images/shiggy Master.png"), "Extra langer Dateiname, um zu testen, wie es reagiert, wenn der Dateiname sehr lang ist", 105), new ConfiguratorCell(handlerSelected, new Image("images/shiggy halb.png"), "File 2", 100));

        configurator.setItems(selected);
        System.out.println("wie neu!");
    }
}
