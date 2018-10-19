package edu.nd.se2018.homework.chipsChallenge;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.ImageView;

public abstract class Level extends Observable{
	
	public static int NUM_TILE_ROWS = 25;
	public static int NUM_TILE_COLS = 25;
	public static int TILE_WIDTH = 64;
	public static int TILE_HEIGHT = 64;
	
	public ImageView[][] tiles;
	public int[][] tileEnums;
	public int globalX;
	public int globalY;
	
	public boolean hasBugs = false;
	public boolean hasKeys = false;
	
	public BugFactory bugFactory;
	
	public Main main; // instance of main so as to end game if chip/bug collision happens
	
	public boolean moveUp(){
		if(Math.abs(globalY) < Math.floor(((NUM_TILE_ROWS*TILE_HEIGHT)-(Main.WINDOW_HEIGHT))/TILE_HEIGHT)){
			globalY--;
			updateLevelPosition();
			return true;
		}
		return false;
	}
	
	public boolean moveDown(){
		if(globalY < 0){
			globalY++;
			updateLevelPosition();
			return true;
		}
		return false;
	}
	
	public boolean moveLeft(){
		if(Math.abs(globalX) < Math.floor(((NUM_TILE_COLS*TILE_WIDTH)-(Main.WINDOW_WIDTH))/TILE_WIDTH)){
			globalX--;
			updateLevelPosition();
			return true;
		}
		return false;
	}
	
	public boolean moveRight(){
		if(globalX < 0){
			globalX++;
			updateLevelPosition();
			return true;
		}
		return false;
	}
	
	public void updateLevelPosition(){
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[0].length; j++){
				tiles[i][j].setY((i+this.globalY)*TILE_HEIGHT); // index i = y position of tile
				tiles[i][j].setX((j+this.globalX)*TILE_WIDTH); // index j = x position of tile
			}
		}
		setChanged();
		notifyObservers();
	}
	
	public boolean canMoveChipTo(int x, int y){
		int adjustedX = x - globalX;
		int adjustedY = y - globalY;
		return canMoveTo(adjustedX, adjustedY);
	}
	
	public boolean canMoveTo(int x, int y){
		if(x < 0 || x >= tiles.length || y < 0 || y >= tiles[0].length)
			return false;
		
		// must index tileEnums[y][x] because of how it's initialized
		if(tileEnums[y][x] == TileInfo.WALL_TILE || tileEnums[y][x] == TileInfo.KEY_WALL_TILE)
			return false;
		
		return true;
	}
	
	public boolean chipAndBugColliding(Chip c, Bug b){
		int chipX = c.getPosition().x - globalX;
		int chipY = c.getPosition().y - globalY;
		if(chipX == b.getPosition().x && chipY == b.getPosition().y)
			return true;
		return false;
	}
	
	public boolean levelPassed(Chip c){
		return isChipAtTile(c, TileInfo.PORTAL_TILE);
	}
	
	public boolean collectedKey(Chip c){
		if(hasKeys){
			return isChipAtTile(c, TileInfo.KEY_TILE);
		}
		
		return false;
	}
	
	public boolean isChipAtTile(Chip c, int tileEnum){
		int chipX = c.getPosition().x - globalX;
		int chipY = c.getPosition().y - globalY;
		if(chipX < 0 || chipX >= tiles.length || chipY < 0 || chipY >= tiles[0].length)
			return false;
		if(tileEnums[chipY][chipX] == tileEnum) // must index tileEnums[y][x]
			return true;
		
		return false;
	}
	
	public void openKeyWall(){
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[0].length; j++){
				if(tileEnums[i][j] == TileInfo.KEY_WALL_TILE){
					tileEnums[i][j] = TileInfo.BLANK_TILE;
					tiles[i][j].setImage(TileInfo.getTileImage(tileEnums[i][j]));
					break;
				}
			}
		}
	}
	
	public void clearKeyImage(){
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[0].length; j++){
				if(tileEnums[i][j] == TileInfo.KEY_TILE){
					tileEnums[i][j] = TileInfo.BLANK_TILE;
					tiles[i][j].setImage(TileInfo.getTileImage(tileEnums[i][j]));
					break;
				}
			}
		}
	}
	
	public ImageView[][] getTileImageViews(){
		return tiles;
	}
	
	public void setBugsToObserve(Observable o){
		if(hasBugs)
			bugFactory.setBugsToObserve(o);
	}
	
	public void observeBugs(Observer o){
		if(hasBugs)
			bugFactory.observeBugs(o);
	}
	
	public void endGameBecauseOfBugCollision(){
		main.gameOver();
	}
}
