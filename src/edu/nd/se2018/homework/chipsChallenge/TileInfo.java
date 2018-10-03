package edu.nd.se2018.homework.chipsChallenge;

import javafx.scene.image.Image;

public class TileInfo {
	
	// enumerating tiles
	public static int BLANK_TILE = 0;
	public static int WALL_TILE = 1;

	public static Image blankTileImage = new Image("chip/textures/BlankTile.png");
	public static Image wallTileImage = new Image("chip/textures/wallTile.png");
	
	public static Image getTileImage(int tileEnum){
		if(tileEnum == BLANK_TILE)
			return blankTileImage;
		else if(tileEnum == WALL_TILE)
			return wallTileImage;
		
		return null;
	}
}
