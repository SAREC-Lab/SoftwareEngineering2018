package edu.nd.se2018.homework.chipsChallenge;

import javafx.scene.image.ImageView;

public class FirstLevel extends Level{
	
	private int[][] tileEnumsInit = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1},
			{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};
	
	public FirstLevel(Main main)
	{
		tileEnums = tileEnumsInit; // to initialize tileEnums as I did above (much easier) I have to do this little trick
		this.main = main;
		
		tiles = new ImageView[Level.NUM_TILE_ROWS][Level.NUM_TILE_COLS];
		for(int i=0; i<Level.NUM_TILE_ROWS; i++){
			for(int j=0; j<Level.NUM_TILE_COLS; j++){
				tiles[i][j] = new ImageView(TileInfo.getTileImage(tileEnums[i][j]));
				//if(i==0 || j==0 || i==Level.NUM_TILE_ROWS-1 || j==Level.NUM_TILE_COLS-1)
				//	tiles[i][j] = new ImageView(TileInfo.getTileImage(TileInfo.WALL_TILE));
				//else
				//	tiles[i][j] = new ImageView(TileInfo.getTileImage(TileInfo.BLANK_TILE));
			}
		}
		updateLevelPosition();
		
		hasBugs = true;
		bugFactory = new BugFactory();
		bugFactory.addStraightLineBug(1, 5, true, this);
		bugFactory.addStraightLineBug(23, 10, true, this);
		bugFactory.addStraightLineBug(4, 15, true, this);
		bugFactory.addStraightLineBug(23, 16, true, this);
		bugFactory.addStraightLineBug(23, 20, true, this);
	}
}
