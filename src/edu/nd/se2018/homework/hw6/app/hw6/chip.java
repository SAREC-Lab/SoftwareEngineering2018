package hw6;

import java.util.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
	
	public chip(AnchorPane base) {
		_im = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipDown.png", 25, 25, true, true);	
		_chip = new ImageView(_im);
		_chip.setX(xLocal);
		_chip.setY(yLocal);;
		base.getChildren().add(_chip);
		//grid[brickX][brickY] = 5;
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
	public void playChips(AnchorPane base, int [][] grid, Scene scene,int level) {
		Image chipRight = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipRight.png",25, 25, true, true);
		Image chipLeft = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipLeft.png",25, 25, true, true);
		Image chipUp = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipUp.png",25, 25, true, true);
		Image chipDown = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/chip/textures/chipDown.png",25, 25, true, true);
	    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        @Override public void handle(KeyEvent keyStroke) {
	          switch (keyStroke.getCode()) {
	            case UP:    
	            	_chip.setImage(chipUp); 
	            	goUp(grid,level,_chip);
	            	break;
	            case RIGHT: 
	            	_chip.setImage(chipRight);
	            	goRight(grid,level,_chip);
	            	break;
	            case DOWN:  
	            	_chip.setImage(chipDown);
	            	goDown(grid,level,_chip);
	            	break;
	            case LEFT:  
	            	_chip.setImage(chipLeft);
	            	goLeft(grid,level,_chip);
	            	break;
	            default:
	            	break;
	          }
	        }
	    });
	}
	
	public void goUp(int [][] grid, int level,ImageView chip) {
		if(!checkMove(grid,xLocal/25,(yLocal-25)/scale)) {
			// we have a odd block, so lets check if it is a key or portal
			checkWall(grid,xLocal/25,(yLocal-25)/scale, level);
		}else {
			yLocal = yLocal - 25;
			chip.setY(yLocal);
		}
	}
	public void goDown(int [][] grid, int level,ImageView chip) {
		if(!checkMove(grid,xLocal/25,(yLocal+25)/scale)){
			checkWall(grid,xLocal/25,(yLocal+25)/scale, level);
		}else {
			yLocal = yLocal + 25;
			chip.setY(yLocal);
		}
	}
	public void goLeft(int [][] grid, int level, ImageView chip) {
		if(!checkMove(grid,(xLocal-25)/scale,yLocal/scale)) {
			checkWall(grid,(xLocal-25)/scale,yLocal/scale, level);
		}else {
			xLocal = xLocal - 25;
			chip.setX(xLocal);
		}
	}
	public void goRight(int [][] grid, int level, ImageView chip) {
		if(!checkMove(grid,(xLocal+25)/scale,yLocal/scale)) {
			checkWall(grid,(xLocal+25)/scale,yLocal/scale, level);
		}else {
			xLocal = xLocal + 25;
			chip.setX(xLocal);
			}
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
	// FIX THIS ONE
	public void checkWall(int[][] grid, int x, int y,int level) {
		if(grid[x][y] == 2) {
			keys = keys + 1;
			grid[x][y] = 0;
		} else if(grid[x][y] == 3) {
			System.out.println("Winner");
		}else if((grid[x][y] == 4) && keys > 1) {
			grid[x][y] = 0;
		}
		
	}

}
