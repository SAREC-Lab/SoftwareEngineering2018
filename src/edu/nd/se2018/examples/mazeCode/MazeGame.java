
package edu.nd.se2018.examples.mazeCode;

import java.awt.Point;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

// Maze Game
public class MazeGame extends Application{
	
	final private int cellSize = 20;  
	final private int mazeSize = 12;
	boolean foundTarget = false;
	Scene scene;
	ImageView seekImageView, foundImageView;
	Image seekImage, foundImage;
   
    Seeker seeker;
    Circle target;
    Maze maze;  
    Pane root;
    Point targetPoint;
       
    @Override
	public void start(Stage stage) throws Exception {

    	// Generate the Maze
		maze = new Maze(mazeSize);
		targetPoint = maze.getTargetPoint();
		Point startPosition = maze.getStartPoint();
		
		// Create the seeker
		seeker = new Seeker(startPosition.x, startPosition.y,cellSize,maze);
		seeker.setColor(Color.BLUE);		
		
		// Add maze lines, seeker, and images to view
		root = new Pane();
		root.getChildren().add(seeker.getCircle());
		drawLines(maze.getLines());  
		loadImages();
		
		// Setup 
		scene = new Scene(root,mazeSize*cellSize + cellSize*2,mazeSize*cellSize + cellSize*2);	
		stage.setTitle("aMAZing Fun");
		stage.setScene(scene);
		stage.show();
		
		// Start play
		startGame();
	}
    
    private void startGame(){
    	// Create a keypressed handler
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
    	
        @Override
    	public void handle(KeyEvent ke) {
    		if(!foundTarget)
    		// Delegate movement decisions and actions to the seeker
    			switch(ke.getCode()){
    				case RIGHT:
    					seeker.moveRight();					
    					break;
    				case LEFT:
    					seeker.moveLeft();
    					break;
    				case DOWN:
    					seeker.moveDown();
    					break;
    				case UP:
    					seeker.moveUp();
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
        });
    }    
    
    protected void setFoundTargetImage(){
    	if(root.getChildren().contains(seekImageView)){
			root.getChildren().remove(seekImageView);	
			root.getChildren().add(foundImageView);		
		}
    }
    
    public Scene getScene(){
    	return scene;
    }
    
    private void loadImages(){
    	
    	seekImage = new Image("images\\target.png",cellSize, cellSize, false, true);
		seekImageView = new ImageView(seekImage);
		seekImageView.setX(maze.getTargetPoint().x*cellSize);
		seekImageView.setY(maze.getTargetPoint().y*cellSize);
			
		// Load "found" target image
		foundImage = new Image("images\\win.gif",cellSize, cellSize, false, true);
		foundImageView = new ImageView(foundImage);
		foundImageView.setX(maze.getTargetPoint().x*cellSize);
		foundImageView.setY(maze.getTargetPoint().y*cellSize);
		
		// set current target image to "not found yet" image
		root.getChildren().add(seekImageView);
    }
     
    // Get lines from the maze and draw them according to current scale
    public void drawLines(ArrayList<Line> lines){
    	for(Line line: lines){
    		line.setStartX(line.getStartX()*cellSize);
    		line.setStartY(line.getStartY()*cellSize);
    		line.setEndX(line.getEndX()*cellSize);
    		line.setEndY(line.getEndY()*cellSize);
    		root.getChildren().add(line);
    		System.out.println("Stop here");
    	}
    }
    
    public static void main(String[] args) {
     	launch(args);
    }

}

