package edu.nd.se2018.homework.homework4;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
	
	final int scale = 25;
	
	List<PirateShip> pirateShips;
	Ship ship;
	OceanMap map = new OceanMap();
	
	@SuppressWarnings("deprecation")
	public OceanExplorer(){
		
		pirateShips = new LinkedList<PirateShip>();
	
		ship = new Ship();
		
		int pirateShipCount = 2;
		
		// Create pirateShips
		for(int j = 0; j < pirateShipCount; j++) {
			pirateShips.add(new PirateShip(map));
		}
		
		for(PirateShip pirateShip: pirateShips) {
			ship.addObserver(pirateShip);
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		// Creating pane
		AnchorPane root = new AnchorPane(); 
		Scene scene = new Scene(root, 625, 625);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Root Scene");
		oceanStage.show();
		map.drawMap(root.getChildren(), map.dimensions);
		
		
		// Drawing ship
		Image shipImage = new Image("file:/Users/danielburns/Documents/School/Software Engineering Principles/eclipse_workspace/ColumbusGame/src/Images/ColumbusShip.png", 25, 25, true, true);
		ImageView shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x);
		shipImageView.setY(ship.getShipLocation().y);
		root.getChildren().add(shipImageView);
		for(PirateShip pirateShip: pirateShips) {
			root.getChildren().add(pirateShip.getImageView());
		}
		startSailing(scene, ship, shipImageView, map);
	}
	
	private void startSailing(Scene scene, Ship ship, ImageView shipImageView, OceanMap map) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					if (map.oceanGrid[ship.getShipLocation().x+1][ship.getShipLocation().y] == 0) {
						ship.goEast();
					}
					break;
				case LEFT:
					if (map.oceanGrid[ship.getShipLocation().x-1][ship.getShipLocation().y] == 0) {
						ship.goWest();
					}
					break;
				case UP:
					if (map.oceanGrid[ship.getShipLocation().x][ship.getShipLocation().y-1] == 0) {
						ship.goNorth();
					}
					break;
				case DOWN:
					if (map.oceanGrid[ship.getShipLocation().x][ship.getShipLocation().y+1] == 0) {
						ship.goSouth();
					}
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x*scale);
				shipImageView.setY(ship.getShipLocation().y*scale);
			}
			
		});
	}
	
}
