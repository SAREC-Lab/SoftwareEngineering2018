package edu.nd.se2018.homework.chipsChallenge;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bug extends Observable implements Observer{

	private int x;
	private int y;
	private Level level;
	private ImageView bugImageView;
	private BugMovement movementStrategy;
	
	private Image bugRightImg;
	private Image bugLeftImg;
	private Image bugUpImg;
	private Image bugDownImg;
	
	public Bug(int x, int y, BugMovement strategy, Level level){
		this.x = x;
		this.y = y;
		this.movementStrategy = strategy;
		this.level = level;
		
		loadImages();
		bugImageView = new ImageView(bugRightImg);
		bugImageView.setX(x*Level.TILE_WIDTH);
		bugImageView.setY(y*Level.TILE_HEIGHT);
	}
	
	public void move(){
		int newX = movementStrategy.getNewX(x, y, level);
		if(newX == x+1)
			bugImageView.setImage(bugRightImg);
		else if(newX == x-1)
			bugImageView.setImage(bugLeftImg);
		this.x = newX;
		
		int newY = movementStrategy.getNewY(x, y, level);
		if(newY == y+1)
			bugImageView.setImage(bugUpImg);
		else if(newY == y-1)
			bugImageView.setImage(bugDownImg);
		this.y = newY;
		
		setChanged();
		notifyObservers();
		updateImageViewPos();
	}
	
	private void loadImages()
	{
		bugRightImg = new Image("images/chip/bugRight.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
		bugLeftImg = new Image("images/chip/bugLeft.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
		bugUpImg = new Image("images/chip/bugUp.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
		bugDownImg = new Image("images/chip/bugDown.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
	}

	public Point getPosition(){
		return new Point(x,  y);
	}
	
	public ImageView getImageView(){
		return bugImageView;
	}
	
	private void updateImageViewPos(){
		bugImageView.setX((x+level.globalX)*Level.TILE_WIDTH);
		bugImageView.setY((y+level.globalY)*Level.TILE_HEIGHT);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Level){
			updateImageViewPos();
		}
		else if(o instanceof Chip){
			if(level.chipAndBugColliding((Chip)o, this)){
				level.endGameBecauseOfBugCollision();
			}
		}
	}
	
}
