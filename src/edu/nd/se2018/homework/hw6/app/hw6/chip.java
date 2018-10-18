package hw6;

import java.util.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class chip extends Observable{
	
	int xLocal = 300;
	int yLocal = 300;
	int scale = 25; // if time find a way to keep this throughout structure 
	int keys = 0;
	int nextLevel = 0; // if 1, then signal to main to load the next level of play
	public Image _im;
	public ImageView _chip;
	int newLevel;
	
	public chip(AnchorPane base) {
		_im = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipDown.png", 25, 25, true, true);	
		_chip = new ImageView(_im);
		_chip.setX(xLocal);
		_chip.setY(yLocal);
		base.getChildren().add(_chip);
	}
	
	public int getX() {
		return xLocal;
	}
	public int getY() {
		return yLocal;
	}
	public int getKey() {
		return keys;
	}
	public void playChips(AnchorPane base, int [][] grid, Scene scene,int level, Stage stage) {
		int previosLevel = level;
		int flag = 0;
		Image chipRight = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipRight.png",25, 25, true, true);
		Image chipLeft = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipLeft.png",25, 25, true, true);
		Image chipUp = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipUp.png",25, 25, true, true);
		Image chipDown = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipDown.png",25, 25, true, true);
	    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        @Override public void handle(KeyEvent keyStroke) {
	          switch (keyStroke.getCode()) {
	            case UP:    
	            	_chip.setImage(chipUp); 
	            	newLevel = goUp(grid,level,_chip);
	            	setChanged(); // update the alien class
	    			notifyObservers();
	    			if(newLevel != previosLevel) {
	    	    		levelChange(stage,base,newLevel);
	    	    	}
	            	break;
	            case RIGHT: 
	            	_chip.setImage(chipRight);
	            	newLevel= goRight(grid,level,_chip);
	            	setChanged(); // update  class
	    			notifyObservers();
	    			if(newLevel != previosLevel) {
	    	    		levelChange(stage,base,newLevel);
	    	    	}
	            	break;
	            case DOWN:  
	            	_chip.setImage(chipDown);
	            	newLevel= goDown(grid,level,_chip);
	            	setChanged(); // update  class
	    			notifyObservers();
	    			if(newLevel != previosLevel) {
	    	    		levelChange(stage,base,newLevel);
	    	    	}
	            	break;
	            case LEFT:  
	            	_chip.setImage(chipLeft);
	            	newLevel = goLeft(grid,level,_chip);
	            	setChanged(); // update  class
	    			notifyObservers();
	    			if(newLevel != previosLevel) {
	    	    		levelChange(stage,base,newLevel);
	    	    	}
	            	break;
	            case ESCAPE:
	            	
	            	stage.close();
	            default:
	            	
	            	break;
	          }
	        }
	    });
	    
	}
	
	public void levelChange(Stage stage, AnchorPane base,int level) {
		Text text = new Text();      
		text.setText("You have reached the portal congrats!"); 
	    System.out.println("You have reached the portal congrats!");
	    text.setX(100); 
	    text.setY(300);
	    text.setFont(Font.font ("Verdana", 20));
	    text.setFill(Color.RED);
	    base.getChildren().add(text);
	    if(level == 2) {
	    	// here we will want to switch to the second level of the game
	    	
	    }
	    if(level == 3) {
			System.out.print("you won!");
			stage.close();
			
		}
	   
	    
	}
	
	public int goUp(int [][] grid, int level,ImageView chip) {
		if(!checkMove(grid,xLocal/25,(yLocal-25)/scale)) {
			// we have a odd block, so lets check if it is a key or portal
			level = checkWall(grid,xLocal/25,(yLocal-25)/scale, level);
		}else {
			yLocal = yLocal - 25;
			chip.setY(yLocal);
		}
	return level;
	}
	public int goDown(int [][] grid, int level,ImageView chip) {
		if(!checkMove(grid,xLocal/25,(yLocal+25)/scale)){
			level = checkWall(grid,xLocal/25,(yLocal+25)/scale, level);
		}else {
			yLocal = yLocal + 25;
			chip.setY(yLocal);
		}
	return level;
	}
	public int goLeft(int [][] grid, int level, ImageView chip) {
		if(!checkMove(grid,(xLocal-25)/scale,yLocal/scale)) {
			level = checkWall(grid,(xLocal-25)/scale,yLocal/scale, level);
		}else {
			xLocal = xLocal - 25;
			chip.setX(xLocal);
		}
	return level;
	}
	public int goRight(int [][] grid, int level, ImageView chip) {
		if(!checkMove(grid,(xLocal+25)/scale,yLocal/scale)) {
			level = checkWall(grid,(xLocal+25)/scale,yLocal/scale, level);
		}else {
			xLocal = xLocal + 25;
			chip.setX(xLocal);
			}
	return level;
	}
	public boolean checkMove(int [][] grid, int x, int y) {
		System.out.println(grid[x][y]);
		System.out.println(x);
		System.out.println(y);
		
		if(grid[x][y] == 0) {
			return true;
		}else {
			return false;
		}
	}
	public int checkWall(int[][] grid, int x, int y,int level) {
		if(grid[x][y] == 2) {
			keys = keys + 1;
			grid[x][y] = 0;
		} else if(grid[x][y] == 3) {
			level = level+1;
			System.out.println("Winner");
		}else if((grid[x][y] == 4) && keys >= 1) {
			grid[x][y] = 0;
		}
	return level;	
	}

}
