package edu.nd.se2018.homework.chipsChallenge;

import javafx.scene.image.Image;

public abstract class TileInfo {
	
	// enumerating tiles
	public static int BLANK_TILE = 0;
	public static int WALL_TILE = 1;
	public static int PORTAL_TILE = 2;
	public static int KEY_TILE = 3;
	public static int KEY_WALL_TILE = 4;

	public static Image blankTileImage = new Image("images/chip/BlankTile.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
	public static Image wallTileImage = new Image("images/chip/wallTile.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
	public static Image portalTileImage = new Image("images/chip/portal.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
	public static Image keyTileImage = new Image("images/chip/yellowKey.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
	public static Image keyWallTileImage = new Image("images/chip/yellowKeyWall.png", Level.TILE_WIDTH, Level.TILE_HEIGHT, true, true);
	
	public static Image getTileImage(int tileEnum)
	{
		if(tileEnum == BLANK_TILE)
			return blankTileImage;
		else if(tileEnum == WALL_TILE)
			return wallTileImage;
		else if(tileEnum == PORTAL_TILE)
			return portalTileImage;
		else if(tileEnum == KEY_TILE)
			return keyTileImage;
		else if(tileEnum == KEY_WALL_TILE)
			return keyWallTileImage;
		
		return null;
	}
}
