package edu.nd.sarec.drag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DragApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("drag.fxml"));
        primaryStage.setTitle("Drag FXML Application");
        Scene scene = new Scene(parent,800,500);
        primaryStage.setScene(scene);
        primaryStage.show();  
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
