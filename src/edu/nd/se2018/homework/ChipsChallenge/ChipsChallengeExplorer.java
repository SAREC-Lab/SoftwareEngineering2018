package edu.nd.se2018.homework.ChipsChallenge;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import edu.nd.se2018.homework.ChipsChallenge.*;

public class ChipsChallengeExplorer extends Application{
	
	//boolean[][] wallMap;
	Pane root;
	final int dimensions = 25;
	final int wallCount = 10;
	final int scalingFactor = 26;
	Image chipImage;
	ImageView chipImageView;
	//Image pirateImage;
	//ImageView pirateImageView;
	ChipsMap chipsMap;
	Scene scene;
	Chip chip;
	//List<PirateShip> pirates;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mapStage) throws Exception {
		chipsMap = new ChipsMap();
		//wallMap = chipsMap.getMap();
		
		root = new AnchorPane();
		chipsMap.drawMap(root.getChildren(), scalingFactor);
		chipsMap.placeWalls(root.getChildren(), scalingFactor);
		
		chip = new Chip(chipsMap);
		
//		pirates = new LinkedList<PirateShip>();
//		int pirateCount = 2;
//		for(int j = 0; j< pirateCount; j++)
//			pirates.add(new PirateShip(chipsMap));
		
		// register observers of the ship
//		for(PirateShip pirate: pirates)
			//ship.addObserver(pirate);
		// Load images on map
		loadChipImage();
//		for(PirateShip pirate: pirates) {
//			pirate.setImageView();
//		}
		// set scene
		scene = new Scene(root,650,650);
		mapStage.setTitle("Chips Challenge");
		mapStage.setScene(scene);
		mapStage.show();
		startPlaying();
	}
	
	private void startPlaying() {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						chip.goEast();
						chipImage = new Image("images\\chipRight.png",scalingFactor, scalingFactor, false, true);
						chipImageView.setImage(chipImage);
						break;
					case LEFT:
						chip.goWest();
						chipImage = new Image("images\\chipLeft.png",scalingFactor, scalingFactor, false, true);
						chipImageView.setImage(chipImage);
						break;
					case UP:
						chip.goNorth();
						chipImage = new Image("images\\chipBack.png",scalingFactor, scalingFactor, false, true);
						chipImageView.setImage(chipImage);
						break;
					case DOWN:
						chip.goSouth();
						chipImage = new Image("images\\chipFront.png",scalingFactor, scalingFactor, false, true);
						chipImageView.setImage(chipImage);
						break;
					default:
						break;
				} 
				chipImageView.setX(chip.getChipLocation().x*scalingFactor);
				chipImageView.setY(chip.getChipLocation().y*scalingFactor);
			}
		});
		
	}

	private void loadChipImage(){
    	
    	Image chipImage = new Image("images\\chipFront.png",scalingFactor, scalingFactor, false, true);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLocation().x*scalingFactor);
		chipImageView.setY(chip.getChipLocation().y*scalingFactor);
		
		root.getChildren().add(chipImageView);
//		for (PirateShip pirate: pirates)
//			root.getChildren().add(pirate.getImageView());
    }
}
