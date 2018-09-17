package edu.nd.se2018.homework.ColumbusGame;

import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	
	boolean[][] islandMap;
	Pane root;
	final int dimensions = 10;
	final int islandCount = 10;
	final int scalingFactor = 50;
	Image shipImage;
	ImageView shipImageView;
	Image pirateImage;
	ImageView pirateImageView;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	List<PirateShip> pirates;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mapStage) throws Exception {
		
		oceanMap = new OceanMap();
		//islandMap = oceanMap.getMap();
		
		root = new AnchorPane();
		oceanMap.drawMap(root.getChildren(), scalingFactor);
		oceanMap.placeIslands(root.getChildren(), scalingFactor);
		
		ship = new Ship(oceanMap);
		
		pirates = new LinkedList<PirateShip>();
		int pirateCount = 2;
		for(int j = 0; j< pirateCount; j++)
			pirates.add(new PirateShip(oceanMap));
		
		// register observers of the ship
		for(PirateShip pirate: pirates)
			ship.addObserver(pirate);
		// Load images on map
		loadShipImage();
		for(PirateShip pirate: pirates) {
			pirate.setImageView();
		}
		// set scene
		scene = new Scene(root,500,500);
		mapStage.setTitle("Christopher Columbus Sails the Ocean Blue");
		mapStage.setScene(scene);
		mapStage.show();
		startSailing();
	}
	
	private void startSailing() {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				} 
				shipImageView.setX(ship.getShipLocation().x*scalingFactor);
				shipImageView.setY(ship.getShipLocation().y*scalingFactor);
			}
		});
		
	}
	
	private void loadShipImage(){
    	
    	Image shipImage = new Image("images\\ColumbusShip.png",scalingFactor, scalingFactor, false, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x*scalingFactor);
		shipImageView.setY(ship.getShipLocation().y*scalingFactor);
		
		root.getChildren().add(shipImageView);
		for (PirateShip pirate: pirates)
			root.getChildren().add(pirate.getImageView());
    }
	
}