package application;
	
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.*;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;


public class OceanExplorer extends Application {
	ObservableList<Node> root = FXCollections.observableArrayList();
	int scale = 24;
	int[][] oceanGrid; 
	Ship ship = new Ship();
	Pane pane = new Pane();
	Scene ocean = new Scene(pane,600,600);
	
	LinkedList<pirateShip> pirates = new LinkedList<pirateShip>();
	// standard ship
	Image _ship = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/src/edu/nd/se2018/homework/hwk4/src/application/ColumbusShip.png", 25, 25, true, true);
	ImageView shipImage = new ImageView(_ship);
	@Override
	public void start(Stage primaryStage) {
		try {
			// build the pane
			primaryStage.setScene(ocean);
			primaryStage.show();
			
			// draw the ocean on the scene
			OceanMap oceanMap = new OceanMap();
			oceanMap.placeIslands();
			oceanGrid = oceanMap.drawMap(root, scale);
			
			
			// put the grid on the scene
			pane.getChildren().addAll(root);
			
			// put on the boat image
			shipImage.setX(ship.getX());
			shipImage.setY(ship.getY());
			//pane.getChildren().add(shipImage);
			pane.getChildren().add(shipImage);
			
			
			// put the pirate ships on the scene
			int numpirates = 1;
			for(int i = 0; i < numpirates;i++) {
				pirates.add(new pirateShip(oceanGrid));
			}
			for(pirateShip pirate:pirates) {
				pirate.getImageView().setX(pirate.getX());
				pirate.getImageView().setY(pirate.getY());
				pane.getChildren().add(pirate.getImageView());
				ship.addObserver(pirate);
				pirate.defineRes(oceanGrid);// inform the hunters where the islands are as they get made
			}
			
			// play the game
			startGame();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
    private void startGame(){
    	// Create a keypressed handler
        ocean.setOnKeyPressed(new EventHandler<KeyEvent>(){
        	
        	@Override
        	public void handle(KeyEvent ke) {
        	switch(ke.getCode()){
        		case RIGHT:
        			ship.goEast(oceanGrid);
        			break;
        		case LEFT:
        			ship.goWest(oceanGrid);
        			break;
        		case UP:
        			ship.goNorth(oceanGrid);
        			break;
        		case DOWN:
        			ship.goSouth(oceanGrid);
        			break;
        		default:
        			break;
        	}
        	
        	shipImage.setX(ship.getX());
        	shipImage.setY(ship.getY());
        	
        }
        });
    }
	
	
	public static void main(String[] args) {
		launch(args);
		

		
		
	}
}
