package edu.nd.se2018.homework.hwk3;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import edu.nd.se2018.homework.hwk3.OceanMap;

public class OceanExplorer extends Application {
	AnchorPane root;
	Scene scene;
	OceanMap oceanMap;
	ImageView shipImageView;
	Image shipImage;
	Ship shipObject;
	

	@Override
	public void start(Stage oceanStage) throws Exception {
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 500, 500);
		oceanMap = new OceanMap();
		
		oceanMap.setIslands();
		oceanMap.drawMap(root.getChildren(), 50);
		
		// Load Images
		shipImage = new Image("/images/ColumbusShip.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oceanMap.getShipLocation()[0]*50);
		shipImageView.setY(oceanMap.getShipLocation()[1]*50);
		root.getChildren().add(shipImageView);
		
		//shipObject = new Ship();
		shipObject = oceanMap.ship;
		
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ocean");
		oceanStage.show();
		
		startSailing(scene);
	}

	private void startSailing(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						shipObject.goEast();
						break;
					case LEFT:
						shipObject.goWest();
						break;
					case UP:
						shipObject.goNorth();
						break;
					case DOWN:
						shipObject.goSouth();
						break;
					default:
						break;
				}
				
				shipImageView.setX(shipObject.getLocation()[0]*50);
				shipImageView.setY(shipObject.getLocation()[1]*50);
				
			}
			
		});
		
	}

	public static void main(String[] args) {
		launch(args);
		

	}
}
