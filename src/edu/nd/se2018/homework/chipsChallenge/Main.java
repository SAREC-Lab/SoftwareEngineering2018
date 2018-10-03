package edu.nd.se2018.homework.chipsChallenge;

import java.awt.Point;

import edu.nd.se2018.examples.mazeCode.Maze;
import edu.nd.se2018.examples.mazeCode.Seeker;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static int WINDOW_WIDTH = 1200;
	public static int WINDOW_HEIGHT = 800;
	
	Pane root;
	Scene scene;
	
	Chip chip;
	Level firstLevel;
	Level secondLevel;

	@Override
	public void start(Stage stage) throws Exception {
		// Generate the level
		firstLevel = new FirstLevel();
		
		// Create player
		/*chip = new Chip(firstLevel);
		
		// Add maze lines, seeker, and images to view
		root = new Pane();
		root.getChildren().add(chip.getImageView());
		
		// Setup 
		scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);	
		stage.setTitle("Chip's Challenge by Daniel Galvao Guerra");
		stage.setScene(scene);
		stage.show();
		
		// Start play
		startGame();*/
	}
	
	private void startGame(){
    	// Create a keypressed handler
        /*scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
    	
        @Override
    	public void handle(KeyEvent ke) {
    		if(!foundTarget)
    		// Delegate movement decisions and actions to the seeker
    			switch(ke.getCode()){
    				case RIGHT:
    					chip.moveRight();					
    					break;
    				case LEFT:
    					chip.moveLeft();
    					break;
    				case DOWN:
    					chip.moveDown();
    					break;
    				case UP:
    					chip.moveUp();
    					break;
    				default:
    					break;	
    			}
    			
    			// Check for "end of game" -- Target found!
    			if(seeker.getCurrentLocation().equals(maze.getTargetPoint())){	
    				setFoundTargetImage();
    				foundTarget = true;
    			}	
    		}						
        });*/
    }  

	public static void main(String[] args) {
     	launch(args);
    }
}
