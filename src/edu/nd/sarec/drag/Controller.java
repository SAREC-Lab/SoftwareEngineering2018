package edu.nd.sarec.drag;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Controller implements Initializable {
    @FXML
    ImageView player, drone1,drone2;
    
    @FXML
    ArrayList<ImageView> drones = new ArrayList<ImageView>();

    private double startDragX;
    private double startDragY;
    private double xoff = 20.0;
    private double yoff = 20.0;
    
    @FXML private GridPane myRoot;
    
    @FXML
    private Button addDrone;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {    	
        player.setOnMousePressed(e -> {       	
            startDragX = player.getLayoutX();
            startDragY = player.getLayoutY(); 	
        });

        player.setOnMouseDragged(e -> {
        	player.setTranslateX(e.getSceneX() - startDragX -xoff);
            player.setTranslateY(e.getSceneY() - startDragY- yoff);
        });
        
        player.setOnMouseReleased(e -> {
        	player.setLayoutX(e.getSceneX());
            player.setLayoutX(e.getSceneX());
        });
        
        myRoot.setOnMousePressed(e->{
        	System.out.println("Mouse pressed: " + e.getSceneX() + " " + e.getSceneY());
        });                   
    }
       
    @FXML
    protected void addNewDrone(ActionEvent event) {
        ImageView imgView = new ImageView();
        imgView.setFitHeight(42.0);
        imgView.setFitWidth(98.0);
        imgView.setLayoutX(10.0);
        imgView.setLayoutY(10.0);
        imgView.setPreserveRatio(true);
        imgView.setPickOnBounds(true);
        imgView.setImage(new Image("figures\\drone1.png"));    
        myRoot.getChildren().add(imgView);        
    }

}
