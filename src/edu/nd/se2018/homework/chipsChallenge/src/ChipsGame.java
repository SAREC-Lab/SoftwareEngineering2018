package edu.nd.se2018.homework.chipsChallenge.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChipsGame extends Application {
	// locals
	Pane root;
	Scene scene;
	ChipMap chipMap;
	final int scalingFactor = 20;
	Image chipImage;
	Image chipLeft = new Image("images\\chipLeft.png", scalingFactor, scalingFactor, false, true);
	Image chipRight = new Image("images\\chipRight.png", scalingFactor, scalingFactor, false, true);
	Image chipUp = new Image("images\\chipUp.png", scalingFactor, scalingFactor, false, true);
	Image chipDown = new Image("images\\chipDown.png", scalingFactor, scalingFactor, false, true);
	Portal portal = new Portal(chipMap, 4, 0);
	ImageView chipImageView;
	List<Key> keys;
	List<Door> doors;
	Chip chip;
	FireShoe fireShoe;
	Stage mapStage;
	List<Bug> bugs;
	int winCount = 0;
	ArrayList<Key> keyDelete = new ArrayList<Key>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage chipStage) throws Exception {
		// TODO Auto-generated method stub
		
		chipMap = new ChipMap();
		chip = new Chip(chipMap);
		fireShoe = new FireShoe(chipMap, 17, 8);
		keys = new LinkedList<Key>();
		keys.add(new BlueKey(chipMap, 15, 24));
		keys.add(new GreenKey(chipMap, 1, 23));
		doors = new LinkedList<Door>();
		doors.add(new BlueDoor(chipMap, 2, 16));
		doors.add(new GreenDoor(chipMap, 24, 11));
		root = new AnchorPane();
		//obstacles = new LinkedList<Obstacle>();
		//obstacles.add(new Fire(chipMap));
		chipMap.drawMap(root.getChildren(), scalingFactor);
		chipMap.drawWalls(root.getChildren(), scalingFactor);
		chipMap.drawObsticles(root.getChildren(), scalingFactor);
		root.getChildren().add(fireShoe.getImageView());
		
		bugs = new LinkedList<Bug>();
		bugs.add(new Bug(chipMap, scalingFactor));
		
		// register observers of the ship
		for(Bug bug: bugs)
			chip.addObserver(bug);
		
		for(Bug bug: bugs) {
			bug.setImageView();
		}
		// load chip and keys on map
		loadChipImage();
		loadItems();
		
		// lock door
		for(Door door: doors)
			door.lockDoor();
		// set scene
		root.getChildren().add(portal.getImageView());
		scene = new Scene(root, 500, 500);
		chipStage.setTitle("Chips Challenge Game");
		chipStage.setScene(scene);
		chipStage.show();
		mapStage = chipStage;
		moveChip();
	}
	
	private void moveChip() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent ke) {
				// TODO Auto-generated method stub
				switch(ke.getCode()) {
					case RIGHT:
						chip.goEast();
						chipImageView.setImage(chipRight);
						chipImage = chipRight;
						chipImageView.setX(chip.getChipLocation().x*scalingFactor);
						chipImageView.setY(chip.getChipLocation().y*scalingFactor);
						break;
					case LEFT:
						chip.goWest();
						chipImageView.setImage(chipLeft);
						chipImage = chipLeft;
						chipImageView.setX(chip.getChipLocation().x*scalingFactor);
						chipImageView.setY(chip.getChipLocation().y*scalingFactor);
						break;
					case UP:
						chip.goNorth();
						chipImageView.setImage(chipUp);
						chipImage = chipUp;
						chipImageView.setX(chip.getChipLocation().x*scalingFactor);
						chipImageView.setY(chip.getChipLocation().y*scalingFactor);
						break;
					case DOWN:
						chip.goSouth();
						chipImageView.setImage(chipDown);
						chipImage = chipDown;
						chipImageView.setX(chip.getChipLocation().x*scalingFactor);
						chipImageView.setY(chip.getChipLocation().y*scalingFactor);
						break;
					// break if escape key is pressed	
					case ESCAPE:
						mapStage.close();
						break;	
					default:
						break;
				}
				
				// Handle Portal
				if(chip.getChipLocation().x - portal.getLocation().x == 0 && chip.getChipLocation().y - portal.getLocation().y == 0) {
					// if on first level go to next level
					if(winCount == 0) {
						nextLevel();
						winCount++;
					// if on second level exit game
					} else {
						mapStage.close();
					}
				}
				
				// Handle fire for level 1
				if(chipMap.killChip(chip.getChipLocation().x, chip.getChipLocation().y) == 2) 
					resetGame();
				
				// Handle fire for level 2
				if(chipMap.killChip(chip.getChipLocation().x, chip.getChipLocation().y) == 3)
					nextLevel();
	
				// pick up fire shoe
				if(chip.getChipLocation().x - fireShoe.getLocation().x == 0 && chip.getChipLocation().y - fireShoe.getLocation().y == 0) {
					chipMap.resetFloor(root.getChildren(), scalingFactor, fireShoe.getLocation().x, fireShoe.getLocation().y);
					resetChipImage();
					// walk on fire on Level 1
					if(winCount == 0)
						chipMap.walkOnFire(root.getChildren());
					// walk on fire on Level 2
					else
						chipMap.walkOnFire2(root.getChildren());
				}
				
				//HandleBug
				for(Bug key: bugs) {
					if(chip.getChipLocation().x - key.getBugLocation().x == 0 && chip.getChipLocation().y - key.getBugLocation().y == 0) {
						resetGame();
					}
				}
				
				// Handle Key
				for(Key key: keys) {
					if(chip.getChipLocation().x - key.getKeyLocation().x == 0 && chip.getChipLocation().y - key.getKeyLocation().y == 0) {
						keyDelete.add(key);
					}
				}
				
				for(Key key: keyDelete) {
					chipMap.resetFloor(root.getChildren(), scalingFactor, key.getKeyLocation().x, key.getKeyLocation().y);
					keys.remove(key);
					resetChipImage();
				}
				
				// Handle Door
				for(Key key: keyDelete) {
					for(Door door: doors) {
						if(key.getDoorId() == door.getDoorId()) {
							door.unlockDoor();
						}
					}
				}
				for(Door door: doors) {
					if(chip.getChipLocation().x - door.getDoorLocation().x == 0 && chip.getChipLocation().y - door.getDoorLocation().y == 0) {
						chipMap.resetFloor(root.getChildren(), scalingFactor, door.getDoorLocation().x, door.getDoorLocation().y);
						resetChipImage();
					}				
				}
			}
			
		});
	}
	
	// loads the image of chip
	private void loadChipImage() {
		Image chipLeft = new Image("images\\chipLeft.png", scalingFactor, scalingFactor, false, true);
			chipImageView = new ImageView(chipLeft);
			chipImageView.setX(chip.getChipLocation().x*scalingFactor);
			chipImageView.setY(chip.getChipLocation().y*scalingFactor);
			root.getChildren().add(chipImageView);
	}
	
	// generates images for all items
	private void loadItems() {
		for(Key key: keys) 
			root.getChildren().add(key.getKeyImageView());
		
		for(Door door: doors) 
			root.getChildren().add(door.getDoorImageView());
		
		for (Bug bug: bugs)
			root.getChildren().add(bug.getImageView());
	}
	
	private void resetChipImage() {
		root.getChildren().remove(chipImageView);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLocation().x*scalingFactor);
		chipImageView.setY(chip.getChipLocation().y*scalingFactor);
		root.getChildren().add(chipImageView);
	}
	
	
	private void resetGame() {
		// delete collected keys
		ArrayList<Key> keyDelete2 = new ArrayList<Key>();
		for(Key key: keyDelete) {
			keyDelete2.add(key);
		}
		for(Key key: keyDelete2) {
			keyDelete.remove(key);
		}
		
		// delete bugs
		ArrayList<Bug> bugsDelete = new ArrayList<Bug>();
		for(Bug key: bugs) {
			bugsDelete.add(key);
		}
		for(Bug key: bugsDelete) {
			chipMap.resetFloor(root.getChildren(), scalingFactor, key.getBugLocation().x, key.getBugLocation().y);
			bugs.remove(key);
		}
		
		root.getChildren().clear();
		
		// add bugs
		bugs.add(new Bug(chipMap, scalingFactor));
		for(Bug bug: bugs)
			chip.addObserver(bug);
		for(Bug bug: bugs) 
			bug.setImageView();
		
		
		// reset main map
		chipMap.drawMap(root.getChildren(), scalingFactor);
		chipMap.drawWalls(root.getChildren(), scalingFactor);
		chipMap.drawObsticles(root.getChildren(), scalingFactor);
		root.getChildren().add(portal.getImageView());
		root.getChildren().add(fireShoe.getImageView());
		
		// add chip
		chip.resetChip();
		loadChipImage();
		
		// add keys
		keys = new LinkedList<Key>();
		keys.add(new BlueKey(chipMap, 15, 24));
		keys.add(new GreenKey(chipMap, 1, 23));
		
		loadItems();
		
		// re-lock doors
		for(Door door: doors)
			door.lockDoor();
	}
	
	private void nextLevel() {
		// delete bugs
		ArrayList<Bug> bugsDelete = new ArrayList<Bug>();
		for(Bug key: bugs) {
			bugsDelete.add(key);
		}
		for(Bug bug: bugsDelete) {
			chipMap.resetFloor(root.getChildren(), scalingFactor, bug.getBugLocation().x, bug.getBugLocation().y);
			bugs.remove(bug);
		}
		
		// delete collected keys
		ArrayList<Key> keyDelete2 = new ArrayList<Key>();
		for(Key key: keyDelete) {
			keyDelete2.add(key);
		}
		for(Key key: keyDelete2) {
			keyDelete.remove(key);
		}
		
		// delete doors 
		ArrayList<Door> doorDelete = new ArrayList<Door>();
		for(Door door: doors) {
			doorDelete.add(door);
		}
		for(Door door: doorDelete) {
			doors.remove(door);
		}
		
		root.getChildren().clear();
		chipMap.drawMap(root.getChildren(), scalingFactor);
		chip.resetChip2();
		loadChipImage();
		chipMap.drawWalls2(root.getChildren(), scalingFactor);
		chipMap.drawObsticles2(root.getChildren(), scalingFactor);
		
		// add portal
		portal.setLocation2();
		Portal portal = new Portal(chipMap, 0, 0);
		root.getChildren().add(portal.getImageView());
		
		// add fire shoe
		fireShoe = new FireShoe(chipMap, 2, 17);
		root.getChildren().add(fireShoe.getImageView());
		
		// create keys
		keys = new LinkedList<Key>();
		keys.add(new BlueKey(chipMap, 8, 12));
		keys.add(new GreenKey(chipMap, 4, 6));
		keys.add(new RedKey(chipMap, 24, 15));
		keys.add(new YellowKey(chipMap, 0, 14));
		
		// create doors
		doors.add(new BlueDoor(chipMap, 24, 22));
		doors.add(new GreenDoor(chipMap, 5, 21));
		doors.add(new YellowDoor(chipMap, 23, 15));
		doors.add(new RedDoor(chipMap, 0, 1));
		loadItems();
	}
	
}
