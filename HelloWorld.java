  
 import gui.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        AnchorPane root = null;
        try {root = FXMLLoader.load(getClass().getResource("AnimationBuilder.fxml"));}
        catch (Exception e) {
            System.out.println(e);
            return;
        }
    
        Scene scene = new Scene(root, 600, 400);
    
        stage.setTitle("Animation bearbeiten");
        stage.setScene(scene);
        stage.show();
    }
}