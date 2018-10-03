package edu.nd.se2018.homework.chipsChallenge;

import javafx.scene.image.ImageView;

public abstract class Level {
	
	public static int NUM_TILE_ROWS = 25;
	public static int NUM_TILE_COLS = 25;
	public static int TILE_WIDTH = 64;
	public static int TILE_HEIGHT = 64;
	
	public ImageView[][] tiles;
	public int x;
	public int y;
	
	public boolean moveUp(){
		if(y > 0){
			y--;
			updateLevelPosition();
			return true;
		}
		return false;
	}
	
	private void setTile(int x, int y, int tileEnum){
		if(x >= 0 && x < tiles.length && y >= 0 && y < tiles.length)
			tiles[x][y].setImage(TileInfo.getTileImage(tileEnum));
	}
	
	public void updateLevelPosition(){
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[0].length; j++){
				tiles[i][j].setX(this.x*TILE_WIDTH);
				tiles[i][j].setY(this.y*TILE_HEIGHT);
			}
		}
	}
	
}
