package chip;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import chip.LevelMapLayouts;
import chip.Chip;

public class Simulation extends Application {
	
	final int scale = 25;
	
	Map map = new Map();
	Chip chip = new Chip(300, 300);
	LevelMapLayouts mapLevelLayout = new LevelMapLayouts();
	
	public Simulation(){
					
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
		map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
		map.drawMap(root.getChildren(), map.dimensions, chip);
		chip.drawChip(root.getChildren());
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)+1][chip.getPositionY()/scale] == 0) {
						chip.moveRight();
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)+1][chip.getPositionY()/scale] == 6) {
						chip.moveRight();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1BlueKeyXPosition][mapLevelLayout.level1BlueKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1BlueKeyWallXPosition][mapLevelLayout.level1BlueKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)+1][chip.getPositionY()/scale] == 7) {
						chip.moveRight();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1RedKeyXPosition][mapLevelLayout.level1RedKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1RedKeyWallXPosition][mapLevelLayout.level1RedKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)+1][chip.getPositionY()/scale] == 8) {
						chip.moveRight();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1YellowKeyXPosition][mapLevelLayout.level1YellowKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1YellowKeyWallXPosition][mapLevelLayout.level1YellowKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)+1][chip.getPositionY()/scale] == 9) {
						chip.moveRight();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1GreenKeyXPosition][mapLevelLayout.level1GreenKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1GreenKeyWallXPosition][mapLevelLayout.level1GreenKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)+1][chip.getPositionY()/scale] == 10) {
						chip.moveRight();
						mapLevelLayout.level1MapLayout[chip.getPositionX()/scale][chip.getPositionY()/scale] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
						chip.numKeysGathered++;
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)+1][chip.getPositionY()/scale] == 11) {
						System.exit(0);
					}
					break;
				case LEFT:
					if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)-1][chip.getPositionY()/scale] == 0) {
						chip.moveLeft();
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)-1][chip.getPositionY()/scale] == 6) {
						chip.moveLeft();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1BlueKeyXPosition][mapLevelLayout.level1BlueKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1BlueKeyWallXPosition][mapLevelLayout.level1BlueKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)-1][chip.getPositionY()/scale] == 7) {
						chip.moveLeft();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1RedKeyXPosition][mapLevelLayout.level1RedKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1RedKeyWallXPosition][mapLevelLayout.level1RedKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)-1][chip.getPositionY()/scale] == 8) {
						chip.moveLeft();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1YellowKeyXPosition][mapLevelLayout.level1YellowKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1YellowKeyWallXPosition][mapLevelLayout.level1YellowKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)-1][chip.getPositionY()/scale] == 9) {
						chip.moveLeft();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1GreenKeyXPosition][mapLevelLayout.level1GreenKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1GreenKeyWallXPosition][mapLevelLayout.level1GreenKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)-1][chip.getPositionY()/scale] == 10) {
						chip.moveLeft();
						mapLevelLayout.level1MapLayout[chip.getPositionX()/scale][chip.getPositionY()/scale] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
						chip.numKeysGathered++;
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)-1][chip.getPositionY()/scale] == 11) {
						System.exit(0);
					}
					break;
				case UP:
					if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale-1] == 0) {
						chip.moveUp();
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale-1] == 6) {
						chip.moveUp();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1BlueKeyXPosition][mapLevelLayout.level1BlueKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1BlueKeyWallXPosition][mapLevelLayout.level1BlueKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale-1] == 7) {
						chip.moveUp();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1RedKeyXPosition][mapLevelLayout.level1RedKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1RedKeyWallXPosition][mapLevelLayout.level1RedKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale-1] == 8) {
						chip.moveUp();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1YellowKeyXPosition][mapLevelLayout.level1YellowKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1YellowKeyWallXPosition][mapLevelLayout.level1YellowKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale-1] == 9) {
						chip.moveUp();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1GreenKeyXPosition][mapLevelLayout.level1GreenKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1GreenKeyWallXPosition][mapLevelLayout.level1GreenKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale-1] == 10) {
						chip.moveUp();
						mapLevelLayout.level1MapLayout[chip.getPositionX()/scale][chip.getPositionY()/scale] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
						chip.numKeysGathered++;
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale-1] == 11) {
						System.exit(0);
					}
					break;
				case DOWN:
					if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale+1] == 0) {
						chip.moveDown();
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale+1] == 6) {
						chip.moveDown();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1BlueKeyXPosition][mapLevelLayout.level1BlueKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1BlueKeyWallXPosition][mapLevelLayout.level1BlueKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale+1] == 7) {
						chip.moveDown();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1RedKeyXPosition][mapLevelLayout.level1RedKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1RedKeyWallXPosition][mapLevelLayout.level1RedKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale+1] == 8) {
						chip.moveDown();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1YellowKeyXPosition][mapLevelLayout.level1YellowKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1YellowKeyWallXPosition][mapLevelLayout.level1YellowKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale+1] == 9) {
						chip.moveDown();
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1GreenKeyXPosition][mapLevelLayout.level1GreenKeyYPosition] = 0;
						mapLevelLayout.level1MapLayout[mapLevelLayout.level1GreenKeyWallXPosition][mapLevelLayout.level1GreenKeyWallYPosition] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale+1] == 10) {
						chip.moveDown();
						mapLevelLayout.level1MapLayout[chip.getPositionX()/scale][chip.getPositionY()/scale] = 0;
						map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
						chip.numKeysGathered++;
					}
					else if (mapLevelLayout.getLevel1MapLayout()[(chip.getPositionX()/scale)][chip.getPositionY()/scale+1] == 11) {
						System.exit(0);
					}
					break;
				default:
					break;
				}
				if (chip.numKeysGathered >= 4) {
					mapLevelLayout.level1MapLayout[mapLevelLayout.level1NextLevelWallXPosition][mapLevelLayout.level1NextLevelWallYPosition] = 0;
					map.setMapLevel(mapLevelLayout.getLevel1MapLayout());
				}
				map.drawMap(root.getChildren(), map.dimensions, chip);
				chip.getImageView().toFront();
			}
		});
	}
		
}