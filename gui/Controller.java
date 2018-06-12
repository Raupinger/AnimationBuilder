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
import store.Frame;
public class Controller {
    @FXML private TextField path;
    @FXML public ListView picker;
    @FXML public ListView<Frame> configurator;
    ObservableList<CustomCell> available;
    ObservableList<Frame> selected;
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

        selected = FXCollections.observableArrayList(
            new Frame("shiggy Master.png", 100), new Frame("shiggy halb.png", 200));

        configurator = new ListView<Frame>(selected);
        Callback cb = new Callback<ListView<Frame>, ListCell<Frame>>()  {
                @Override public ListCell<Frame> call(ListView<Frame> list) {
                    System.out.println("Cell Factory");
                    return new ConfiguratorCell(handlerSelected, "images/");
                }
            };

        configurator.setCellFactory(cb );


        configurator.setPlaceholder(new Label(":-("));
        configurator.refresh();
        System.out.println(configurator);

    }
    
                 private ListCell<Frame> call(ListView<Frame> list) {
                    System.out.println("Cell Factory");
                    return new ConfiguratorCell(handlerSelected, "images/");
                }

    @FXML public void test(ActionEvent event) {
        System.out.print("pfad: ");
        System.out.println(path.getText());
        System.out.println(event);

        picker.setItems(available);
    }

    public void removeFromSelected(Frame f) {
        selected.removeAll(f);
    }

    public void moveSelected(Frame f, int amount) {
        if(amount < 0 || amount >= selected.size()){return;}
        //amount = 0;
        amount = selected.indexOf(f) + amount;
        Frame previus = selected.get(amount);
        selected.add(amount, f);
        selected.set(amount + 1, previus);
        configurator.setItems(selected);
    }

    @FXML public void refresh() {

        selected = FXCollections.observableArrayList(
            new Frame("shiggy Master.png", 100), new Frame("shiggy halb.png", 200));
        

        configurator.setItems(selected);
        configurator.setCellFactory(new Callback<ListView<Frame>, ListCell<Frame>>() {
        @Override public ListCell<Frame> call(ListView<Frame> list) {
        System.out.println("Factory");
            return new ConfiguratorCell(handlerSelected, "images/");
        }
        });
         
        //configurator.refresh();
        System.out.println("wie neu!");
    }
}
