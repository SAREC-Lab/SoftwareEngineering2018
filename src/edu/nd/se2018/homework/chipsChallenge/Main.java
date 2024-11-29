package edu.nd.se2018.homework.chipsChallenge;

import java.util.concurrent.TimeUnit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static int WINDOW_WIDTH = 1280;
	public static int WINDOW_HEIGHT = 768;
	
	Pane root;
	Scene scene;
	Stage mainStage;

	Chip chip;
	Level currentLevel;
	
	AnimationTimer animationTimer;
	
	boolean gameOver;
	Text gameOverText;
	Text youWinText;

	@Override
	public void start(Stage stage) throws Exception {
		mainStage = stage;
		gameOver = false;
		setupAndStartLevel(new FirstLevel(this));
	}
	
	private void setupAndStartLevel(Level level){
		currentLevel = level;
		root = new Pane();
		
		// Add images to root
		for(ImageView[] row : currentLevel.getTileImageViews()){
			for(ImageView imgView : row)
				root.getChildren().add(imgView);
		}
		
		// Create player
		chip = new Chip(currentLevel);
		root.getChildren().add(chip.getImageView());
		
		if(currentLevel.hasBugs){
			for(ImageView imgView : currentLevel.bugFactory.getBugImageViews())
				root.getChildren().add(imgView);
			currentLevel.observeBugs(chip);
			currentLevel.setBugsToObserve(chip);
		}
		
		// setup Game Over text
		gameOverText = new Text(200,480,"You Lose");
		gameOverText.setFont(Font.font(0));
		root.getChildren().add(gameOverText);
		
		// setup You Win text
		youWinText = new Text(200,480,"You Win!");
		youWinText.setFont(Font.font(0));
		root.getChildren().add(youWinText);
		
		// Setup 
		scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);	
		mainStage.setTitle("Chip's Challenge by Daniel Galvao Guerra");
		mainStage.setScene(scene);
		mainStage.show();
		
		startGame();
	}
	
	private void startGame(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
        @Override
    	public void handle(KeyEvent ke) {
        	if(!gameOver){
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
    				case ESCAPE:
    					mainStage.close();
    					break;
    				default:
    					break;	
    			}
    			if(currentLevel.levelPassed(chip)){
    				if(currentLevel instanceof FirstLevel){
    					animationTimer.stop();
    					setupAndStartLevel(new SecondLevel());
    				}
    				else if(currentLevel instanceof SecondLevel)
    					gameWon();
    			}
    			if(currentLevel.hasKeys && currentLevel.collectedKey(chip)){
    				currentLevel.openKeyWall();
    				currentLevel.clearKeyImage();
    			}
    		}
        }
        });
        
        if(currentLevel.hasBugs){
        	final LongProperty lastUpdateTime = new SimpleLongProperty(0);
        	animationTimer = new AnimationTimer(){
				public void handle(long now) {
					if(now - lastUpdateTime.get() > 100000000){
						currentLevel.bugFactory.moveBugs();
						lastUpdateTime.set(now);
					}
				}
			};
			animationTimer.start();
        }
    }
	
	public void gameOver(){
		gameOver = true;
		gameOverText.setFont(Font.font(200));
		animationTimer.stop();
		
		new Thread(){
			@Override
			public void run() {
				try {
					sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Platform.runLater(new Runnable() {
					public void run() {
						mainStage.close();
					}
				});
				super.run();
			}
		}.start();
	}
	
	public void gameWon(){
		youWinText.setFont(Font.font(200));
		animationTimer.stop();
		
		new Thread(){
			public void run() {
				try {
					sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Platform.runLater(new Runnable() {
					public void run() {
						mainStage.close();
					}
				});
				super.run();
			}
		}.start();
	}

	public static void main(String[] args) {
     	launch(args);
    }
}
