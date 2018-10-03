package edu.nd.se2018.homework.chipsChallenge;

import java.awt.Point;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chip {
	
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
		this.x = 0;
		this.y = 0;
		this.level = level;
		
		loadImages();
		chipImageView = new ImageView(chipRightImg);
		chipImageView.setX(x);
		chipImageView.setY(y);
	}
	
	private void loadImages()
	{
		chipRightImg = new Image("chip/textures/chipRight.png");
		chipLeftImg = new Image("chip/textures/chipLeft.png");
		chipUpImg = new Image("chip/textures/chipUp.png");
		chipDownImg = new Image("chip/textures/chipDown.png");
	}

	public Point getPosition()
	{
		return new Point(x,  y);
	}
	
	/*public void moveRight(){
		if(level.canMoveChip(x+1, y)){
			if(x != 0)
				moveChip(1, 0);
			else
				level.moveLeft(); // level moves left = chip moves right
		}
		
		chipImageView.setImage(chipRightImg);
    }
	
	public void moveLeft(){
		if(level.canMoveChip(x-1, y)){
			if(x != 0)
				moveChip(-1, 0);
			else
				level.moveRight();
		}
		
		chipImageView.setImage(chipLeftImg);		
	}
	
	public void moveUp(){
		if(level.canMoveChip(x, y-1)){
			if(y != 0)
				moveChip(0, -1);
			else
				level.moveDown();
		}
		
		chipImageView.setImage(chipUpImg);
	}
	
	public void moveDown(){
		if(level.canMoveChip(x, y+1)){
			if(y != 0)
				moveChip(0, 1);
			else if(level.moveUp() == false)
				moveChip(0, 1);
		}
		
		chipImageView.setImage(chipDownImg);
	}*/
	
	private void moveChip(int dx, int dy){
		x += dx;
		y += dy;
		chipImageView.setX(x*Level.TILE_WIDTH);
		chipImageView.setY(y*Level.TILE_WIDTH);
	}
	
	public ImageView getImageView(){
		return chipImageView;
	}
}
