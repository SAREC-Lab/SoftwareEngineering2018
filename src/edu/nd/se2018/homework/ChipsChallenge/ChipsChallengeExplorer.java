package edu.nd.se2018.homework.ChipsChallenge;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ChipsChallengeExplorer extends Application{

	Pane root;
	final int dimensions = 25;
	final int wallCount = 10;
	final int scalingFactor = 26;
	public int pause = 0;
	boolean exitGame = false;
	Image chipImage;
	ImageView chipImageView;
	ChipsMap chipsMap;
	Scene scene;
	Chip chip;
	List<MoveableBlock> blocks;
	List<Key> keys;
	List<Door> doors;
	List<Monster> monsters;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mapStage) throws Exception {
		chipsMap = new ChipsMap();
		
		root = new AnchorPane();
		chipsMap.drawMap(root.getChildren(), scalingFactor);
		chipsMap.placeWalls(root.getChildren(), scalingFactor);
		chipsMap.placeHazards(root.getChildren(), scalingFactor);
		chip = new Chip(chipsMap, 12, 18);
		
		keys = new LinkedList<Key>();
		keys.add(new BlueKey(2,12,scalingFactor));
		
		doors = new LinkedList<Door>();
		doors.add(new BlueDoor(18,12,scalingFactor));
		
		blocks = new LinkedList<MoveableBlock>();
		blocks.add(new MoveableBlock(chipsMap, 2, 2));
		blocks.add(new MoveableBlock(chipsMap, 22, 2));
		
		monsters = new LinkedList<Monster>();
		monsters.add(new Monster(chipsMap,"Left",5,16,scalingFactor));
		monsters.add(new Monster(chipsMap,"Right",0,15,scalingFactor));
		
		// register observers of the ship
		for(Monster monster: monsters)
			chip.addObserver(monster);
		// Load images on map
		loadImages();
		
		for (Door door: doors)
			chipsMap.setDoor(door);
		
		for (MoveableBlock block: blocks)
			block.setImageView();
		// set scene
		scene = new Scene(root,650,650);
		mapStage.setTitle("Chips Challenge");
		mapStage.setScene(scene);
		mapStage.show();
		
		
		new AnimationTimer(){
			
			@Override
			public void handle(long now) {
				//Monster Movement
				if(pause > 50) {
					pause = 0;
				}
				
				if(pause == 0) {
					for(Monster monster: monsters) {
						monster.canMove();
						monster.move();
						monster.setImageView();
						if(chip.getChipLocation().x == monster.getX() && chip.getChipLocation().y == monster.getY()) {
							chip.killChip();
							chipImageView.setX(chip.getChipLocation().x*scalingFactor);
							chipImageView.setY(chip.getChipLocation().y*scalingFactor);
							chipsMap.killLife(root.getChildren());
						}
					}
				}
				
				pause+=1;
				// Chip lives
				if (chip.getChipLives() == 0 || exitGame) {
					mapStage.close();
				}
				
				// Go To level 2
				if (chipsMap.chipsGrid[chip.getChipLocation().x][chip.getChipLocation().y] == -1) {
					nextLevel();
				}
				// End of level 2
				if (chipsMap.chipsGrid[chip.getChipLocation().x][chip.getChipLocation().y] == -2) {
					mapStage.close();
				}
				
			}
		}.start();
		
		startPlaying();
	}
	
	private void startPlaying() {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						chip.goEast();
						for(MoveableBlock block: blocks) {
							if(block.getBlockLocation().x == chip.getChipLocation().x && block.getBlockLocation().y == chip.getChipLocation().y) {
								block.goEast();
							}
						}
						chipImage = new Image("images\\chipRight.png",scalingFactor, scalingFactor, false, true);
						chipImageView.setImage(chipImage);
						break;
					case LEFT:
						chip.goWest();
						for(MoveableBlock block: blocks) {
							if(block.getBlockLocation().x == chip.getChipLocation().x && block.getBlockLocation().y == chip.getChipLocation().y) {
								block.goWest();
							}
						}
						chipImage = new Image("images\\chipLeft.png",scalingFactor, scalingFactor, false, true);
						chipImageView.setImage(chipImage);
						break;
					case UP:
						chip.goNorth();
						for(MoveableBlock block: blocks) {
							if(block.getBlockLocation().y == chip.getChipLocation().y && block.getBlockLocation().x == chip.getChipLocation().x) {
								block.goNorth();
							}
						}
						chipImage = new Image("images\\chipBack.png",scalingFactor, scalingFactor, false, true);
						chipImageView.setImage(chipImage);
						break;
					case DOWN:
						chip.goSouth();
						for(MoveableBlock block: blocks) {
							if(block.getBlockLocation().y == chip.getChipLocation().y && block.getBlockLocation().x == chip.getChipLocation().x) {
								block.goSouth();
							}
						}
						chipImage = new Image("images\\chipFront.png",scalingFactor, scalingFactor, false, true);
						chipImageView.setImage(chipImage);
						break;
					case ESCAPE:
						exitGame = true;
						break;
					case TAB:
						//skip first level for testing
						nextLevel();
						break;
					default:
						break;
				} 
				/////////// Handle Blocks ////////////
				ArrayList<MoveableBlock> blockDelete = new ArrayList<MoveableBlock>();
				for(MoveableBlock block: blocks) {
					if(chipsMap.chipsGrid[block.getBlockLocation().x][block.getBlockLocation().y] == 2) {
						blockDelete.add(block);
					}
					block.setImageView();
				}
				// Remove Moveable Blocks
				for (MoveableBlock block: blockDelete) {
					chipsMap.setToGround(root.getChildren(), scalingFactor, block.getBlockLocation().x, block.getBlockLocation().y);
					blocks.remove(block);
					refreshBlockImages();
					refreshChipImage();
				}
				//////////// Handle Keys /////////////
				ArrayList<Key> keyDelete = new ArrayList<Key>();
				for(Key key: keys) {
					if((key.getKeyX() - chip.getChipLocation().x) == 0 && (key.getKeyY() - chip.getChipLocation().y) == 0) {
						chip.grabKey(key);
						keyDelete.add(key);
					}
				}
				
				for(Key key: keyDelete) {
					chipsMap.setToGround(root.getChildren(), scalingFactor, key.getKeyX(), key.getKeyY());
					keys.remove(key);
					refreshChipImage();
				}
				/////////////// Handle Doors ///////////////
				ArrayList<Door> doorDelete = new ArrayList<Door>();
				for(Door door: doors) {
					if( Math.abs(door.getDoorX() - chip.getChipLocation().x) < 2 && Math.abs(door.getDoorY() - chip.getChipLocation().y) < 2) {
						if(chip.unlockDoor(door)) {
							doorDelete.add(door);
						}
					}
				}
				
				for(Door door: doorDelete) {
					chipsMap.setToGround(root.getChildren(), scalingFactor, door.getDoorX(), door.getDoorY());
					root.getChildren().remove(door.getImageView());
					doors.remove(door);
					refreshBlockImages();
					refreshChipImage();
				}
				// Update chip position
				chipImageView.setX(chip.getChipLocation().x*scalingFactor);
				chipImageView.setY(chip.getChipLocation().y*scalingFactor);
			}
		});
		
	}
	
	private void refreshChipImage() {
		root.getChildren().remove(chipImageView);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLocation().x*scalingFactor);
		chipImageView.setY(chip.getChipLocation().y*scalingFactor);
		root.getChildren().add(chipImageView);
	}
	
	private void refreshBlockImages() {
		for (MoveableBlock block: blocks)
			root.getChildren().remove(block.getImageView());
		
		for (MoveableBlock block: blocks)
			root.getChildren().add(block.getImageView());
	}
	
	private void nextLevel() {
		// Delete all imageviews from root
		root.getChildren().clear();
		// delete all item arrays
		for(int i = monsters.size()-1; i >= 0; i--)
			monsters.remove(i);
		for (int i = doors.size()-1; i >= 0; i--)
			doors.remove(i);
		for (int i = blocks.size()-1; i >= 0; i--)
			blocks.remove(i);
		for (int i = keys.size()-1; i >= 0; i--)
			keys.remove(i);
		// call drawmap2, drawWalls2, etc on chipmap
		chipsMap.drawMap2(root.getChildren());
		chipsMap.placeWalls2(root.getChildren());
		chipsMap.placeHazards2(root.getChildren());
		// create all new items
		keys.add(new RedKey(24,16,scalingFactor));
		keys.add(new BlueKey(1,15,scalingFactor));
		
		doors.add(new RedDoor(20,1,scalingFactor));
		doors.add(new BlueDoor(6,1,scalingFactor));

		blocks.add(new MoveableBlock(chipsMap, 19, 5));
		blocks.add(new MoveableBlock(chipsMap, 14, 11));
		blocks.add(new MoveableBlock(chipsMap, 16, 19));

		monsters.add(new Monster(chipsMap,"Left",24,1,scalingFactor));
		monsters.add(new Monster(chipsMap,"Left",24,7,scalingFactor));
		monsters.add(new Monster(chipsMap,"Left",12,10,scalingFactor));
		monsters.add(new Monster(chipsMap,"Right",0,19,scalingFactor));
		monsters.add(new Monster(chipsMap,"Left",5,18,scalingFactor));
		monsters.add(new Monster(chipsMap,"Right",2,17,scalingFactor));
		monsters.add(new Monster(chipsMap,"Right",7,15,scalingFactor));
		
		// register observers of the ship
		for(Monster monster: monsters)
			chip.addObserver(monster);
		
		for (Door door: doors)
			chipsMap.setDoor(door);
		
		for (MoveableBlock block: blocks)
			block.setImageView();
		//set chips location and clear his pockets
		chip.clearPockets();
		chip.setChipLocation(23, 24);
		// call loadImages()
		loadImages();
	}
	
	private void loadImages(){
    	
    	Image chipImage = new Image("images\\chipFront.png",scalingFactor, scalingFactor, false, true);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLocation().x*scalingFactor);
		chipImageView.setY(chip.getChipLocation().y*scalingFactor);
		
		root.getChildren().add(chipImageView);
		
		for (MoveableBlock block: blocks)
			root.getChildren().add(block.getImageView());
		
		for (Key key: keys)
			root.getChildren().add(key.getImageView());
		
		for (Door door: doors)
			root.getChildren().add(door.getImageView());
		
		for (Monster monster: monsters)
			root.getChildren().add(monster.getImageView());
    }
}
