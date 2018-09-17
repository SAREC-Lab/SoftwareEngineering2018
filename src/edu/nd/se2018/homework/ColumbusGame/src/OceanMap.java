import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	
	public static int NUM_TILES = 25; // number of tiles in each row
	public static int SCALING_FACTOR = OceanExplorer.WIDTH/NUM_TILES;
	
	private int[][] map = new int[NUM_TILES][NUM_TILES];
	
	public void drawMap(ObservableList<Node> root, int numIslands)
	{
		for(int x=0; x<NUM_TILES; x++)
		{
			for(int y=0; y<NUM_TILES; y++)
			{
				Rectangle rect = new Rectangle(x*SCALING_FACTOR, y*SCALING_FACTOR, SCALING_FACTOR, SCALING_FACTOR);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				map[x][y] = 0;
			}
		}
		
		while(numIslands > 0)
		{
			int rx = (int)(Math.random()*NUM_TILES);
			int ry = (int)(Math.random()*NUM_TILES);
			if(map[rx][ry] == 0 && (rx != 0 || ry != 0)) // pirate starts at 0,0 so don't put and island there
			{
				Rectangle rect = new Rectangle(rx*SCALING_FACTOR, ry*SCALING_FACTOR, SCALING_FACTOR, SCALING_FACTOR);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.BEIGE);
				root.add(rect);
				map[rx][ry] = 1;
				numIslands--;
			}
		}
	}
	
	public int[][] getOceanMap()
	{
		return map;
	}

}
