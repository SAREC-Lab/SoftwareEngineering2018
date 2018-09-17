package edu.nd.se2018.homework.ColumbusGame;

import java.awt.event.ActionEvent;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class OceanExplorer extends Application{
	// globals
	Scene scene;
	Pane root;
	int scale = 20;
	
	// global ship vars
	Ship ship;
	PirateShip pirateShip1;
    PirateShip pirateShip2;
	ImageView shipImageView = new ImageView();
	ImageView pirateShipImageView1 = new ImageView();
	ImageView pirateShipImageView2 = new ImageView();
	
	public static void main(String [ ] args) {
		// Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutdown hook")));
		launch(args);
	}
	
	public void exitApplication(ActionEvent event) {
		Platform.exit();
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		// TODO Auto-generated method stub
		// Step 2b
		root = new AnchorPane();
		OceanMap oceanMap = new OceanMap();
		// Step 2c
		scene = new Scene(root, 500, 500);
		oceanStage.setTitle("Ship Explorer");
		oceanStage.setScene(scene);
		oceanMap = OceanMap.getInstance();
		oceanMap.drawMap(root.getChildren(), scale);
		
		// Ship
		ship = new Ship(oceanMap);
		Image shipImage = new Image(getClass().getResource("/images/ColumbusShip.png").toExternalForm(),25,25,true,true);
		shipImageView.setImage(shipImage);
        shipImageView.setX(ship.getShipLocation().x * scale);
        shipImageView.setY(ship.getShipLocation().y * scale);
        root.getChildren().add(shipImageView);
        
        // Pirate Ships
		pirateShip1 = new PirateShip(oceanMap);
		pirateShip2 = new PirateShip(oceanMap);
        ship.addObserver(pirateShip1);
		ship.addObserver(pirateShip2);
		Image pirateShipImage1 = new Image(getClass().getResource("/images/pirateship.gif").toExternalForm(),25,25,true,true);
        pirateShipImageView1.setImage(pirateShipImage1);
        pirateShipImageView1.setX(pirateShip1.getPirateShipLocation().x * scale);
        pirateShipImageView1.setY(pirateShip1.getPirateShipLocation().y * scale);
        root.getChildren().add(pirateShipImageView1);
        
        Image pirateShipImage2 = new Image(getClass().getResource("/images/pirateship.gif").toExternalForm(),25,25,true,true);
        pirateShipImageView2.setImage(pirateShipImage2);
        pirateShipImageView2.setX(pirateShip2.getPirateShipLocation().x * scale);
        pirateShipImageView2.setY(pirateShip2.getPirateShipLocation().y * scale);
        root.getChildren().add(pirateShipImageView2);
		
		// Show
		oceanStage.show();
		
		this.startSailing();
		
		if(ship.getShipLocation() == pirateShip1.getPirateShipLocation()) {
			exitApplication(null);
		}
		if(ship.getShipLocation() == pirateShip2.getPirateShipLocation()) {
			exitApplication(null);
		}
		
	}
	
	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) { 
				switch(ke.getCode()) {
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
				
				// Update image location (view)
				shipImageView.setX(ship.getShipLocation().x*scale);
				shipImageView.setY(ship.getShipLocation().y*scale);
				pirateShipImageView1.setX(pirateShip1.getPirateShipLocation().x*scale);
				pirateShipImageView1.setY(pirateShip1.getPirateShipLocation().y*scale);
				pirateShipImageView2.setX(pirateShip2.getPirateShipLocation().x*scale);
				pirateShipImageView2.setY(pirateShip2.getPirateShipLocation().y*scale);
			}
		});
	}
}
