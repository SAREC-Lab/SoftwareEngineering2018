package edu.nd.se2018.homework.chipsChallenge;

import javafx.scene.image.ImageView;

public class FirstLevel extends Level{
	
	public FirstLevel(){
		for(int i=0; i<Level.NUM_TILE_ROWS; i++){
			for(int j=0; j<Level.NUM_TILE_COLS; i++){
				tiles[i][j] = new ImageView(TileInfo.getTileImage(TileInfo.BLANK_TILE));
				tiles[i][j].setX(i*Level.TILE_WIDTH);
				tiles[i][j].setY(i*Level.TILE_HEIGHT);
			}
		}
		updateLevelPosition();
	}

}
