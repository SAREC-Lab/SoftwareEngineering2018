package edu.nd.se2018.homework.chipsChallenge;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chip extends Observable implements Observer {
	
	private int x;
	private int y;
	private Level level;
	private ImageView chipImageView;
	
	private Image chipRightImg;
	private Image chipLeftImg;
	private Image chipUpImg;
	private Image chipDownImg;
	
	public Chip(Level level)
	{
		this.x = 1;
		this.y = 1;
		this.level = level;
		
		loadImages();
		chipImageView = new ImageView(chipRightImg);
		moveChip(0,0); // updates chip ImageView position
		
		level.setBugsToObserve(this);
		level.observeBugs(this);
	}
	
	private void loadImages()
	{
		chipRightImg = new Image("images/chip/chipRight.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
		chipLeftImg = new Image("images/chip/chipLeft.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
		chipUpImg = new Image("images/chip/chipUp.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
		chipDownImg = new Image("images/chip/chipDown.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
	}

	public Point getPosition()
	{
		return new Point(x,  y);
	}
	
	public void moveRight(){
		if(level.canMoveChipTo(x+1, y)){
			 // if chip not in middle of the screen
			if(x != Math.floor((Main.WINDOW_WIDTH/2)/Level.TILE_WIDTH))
				moveChip(1, 0);
			else if(level.moveLeft() == false) // level moves left = chip moves right
				moveChip(1,0);
		}
		
		chipImageView.setImage(chipRightImg);
    }
	
	public void moveLeft(){
		if(level.canMoveChipTo(x-1, y)){
			if(x != Math.floor((Main.WINDOW_WIDTH/2)/Level.TILE_WIDTH))
				moveChip(-1, 0);
			else if(level.moveRight() == false)
				moveChip(-1,0);
		}
		
		chipImageView.setImage(chipLeftImg);		
	}
	
	public void moveUp(){
		if(level.canMoveChipTo(x, y-1)){
			if(y != Math.floor((Main.WINDOW_HEIGHT/2)/Level.TILE_HEIGHT))
				moveChip(0, -1);
			else if(level.moveDown() == false)
				moveChip(0, -1);
		}
		
		chipImageView.setImage(chipUpImg);
	}
	
	public void moveDown(){
		if(level.canMoveChipTo(x, y+1)){
			if(y != Math.floor((Main.WINDOW_HEIGHT/2)/Level.TILE_HEIGHT))
				moveChip(0, 1);
			else if(level.moveUp() == false)
				moveChip(0, 1);
		}
		
		chipImageView.setImage(chipDownImg);
	}
	
	private void moveChip(int dx, int dy){
		x += dx;
		y += dy;
		chipImageView.setX(x*Level.TILE_WIDTH);
		chipImageView.setY(y*Level.TILE_WIDTH);
		
		setChanged();
		notifyObservers();
	}
	
	public ImageView getImageView(){
		return chipImageView;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Bug){
			if(level.chipAndBugColliding(this, (Bug)o)){
				level.endGameBecauseOfBugCollision();
			}
		}
	}
}
