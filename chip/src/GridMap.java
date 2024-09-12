import javafx.collections.ObservableList;
import javafx.scene.Node;
//import java.util.Random;

public class GridMap 
{
	int[][] gridMap = new int[27][27];
	final int dimensions = 27;
	private int scale = 25;
	private ObservableList<Node> root;
	
	public void drawMap(ObservableList<Node> root, int scale, int Level)
	{
		this.root = root;
		if (Level == 1)
			buildLevel1();
		else if (Level == 2)
			buildLevel2();

		for (int x = 0; x < dimensions; x++)
		{
			for (int y = 0; y < dimensions; y++)
			{
				if (gridMap[x][y] == 0)
				{
					WallBlock wall = new WallBlock();
					wall.setPosition(x * scale, y * scale);
					root.add(wall.getImageView());
				}
				else if (gridMap[x][y] == 1)
				{
					blankBlock tile = new blankBlock();
					tile.setPosition(x * scale, y * scale);
					root.add(tile.getImageView());
				}
				else if (gridMap[x][y] == 2)
				{
					yellowKeyWall yellowLock = new yellowKeyWall();
					yellowLock.setPosition(x * scale, y * scale);
					root.add(yellowLock.getImageView());
				}
				else if (gridMap[x][y] == 3)
				{
					yellowKey yKey = new yellowKey();
					yKey.setPosition(x * scale, y * scale);
					root.add(yKey.getImageView());
				}
				else if (gridMap[x][y] == 4)
				{
					greenKeyWall greenLock = new greenKeyWall();
					greenLock.setPosition(x * scale, y * scale);
					root.add(greenLock.getImageView());
				}
				else if (gridMap[x][y] == 5)
				{
					greenKey gKey = new greenKey();
					gKey.setPosition(x * scale, y * scale);
					root.add(gKey.getImageView());
				}
				else if (gridMap[x][y] == 6)
				{
					blueKeyWall blueLock = new blueKeyWall();
					blueLock.setPosition(x * scale, y * scale);
					root.add(blueLock.getImageView());
				}
				else if (gridMap[x][y] == 7)
				{
					blueKey bKey = new blueKey();
					bKey.setPosition(x * scale, y * scale);
					root.add(bKey.getImageView());
				}
				else if (gridMap[x][y] == 8)
				{
					redKeyWall redLock = new redKeyWall();
					redLock.setPosition(x * scale, y * scale);
					root.add(redLock.getImageView());
				}
				else if (gridMap[x][y] == 9)
				{
					redKey rKey = new redKey();
					rKey.setPosition(x * scale, y * scale);
					root.add(rKey.getImageView());
				}
				else if (gridMap[x][y] == 10)
				{
					Portal portal = new Portal();
					portal.setPosition(x * scale, y * scale);
					root.add(portal.getImageView());
				}
			}
		}
	}
	
	public void buildLevel1()
	{
		for (int x = 0; x < dimensions; x++)
		{
			for (int y = 0; y < dimensions; y++)
			{
				if (x == 0 || y == 0 || x == 26 || y == 26)
					gridMap[x][y] = 0;
				else
					gridMap[x][y] = 1;
			}
		}
		
		for (int x = 1; x < 26; x++)
		{
			gridMap[x][3] = 0;
		}

		for (int x = 1; x < 4; x++)
		{
			gridMap[x][1] = 0;
			gridMap[x][3] = 0;
			gridMap[x][23] = 0;
			gridMap[x][25] = 0;
			gridMap[x+22][1] = 0;
			gridMap[x+22][3] = 0;
			gridMap[x+22][23] = 0;
			gridMap[x+22][25] = 0;
		}
	
		// Build inaccessible areas
		gridMap[1][2] = 0;
		gridMap[1][24] = 0;
		gridMap[3][24] = 0;
		gridMap[23][2] = 0;
		gridMap[25][2] = 0;
		gridMap[23][24] = 0;
		gridMap[25][24] = 0;
		
		// build lock pathways
		gridMap[2][3] = 2;
		gridMap[3][2] = 1;
		gridMap[2][23] = 4;
		gridMap[23][24] = 6;
		gridMap[24][3] = 8;
		
		// places keys
		gridMap[24][2] = 5;
		gridMap[2][24] = 7;
		gridMap[24][24] = 3;
		gridMap[3][5] = 9;
		
		// place portal
		gridMap[13][1] = 10;
	}
	
	public void buildLevel2()
	{
		for (int x = 0; x < dimensions; x++)
		{
			for (int y = 0; y < dimensions; y++)
			{
				if (x == 0 || y == 0 || x == 26 || y == 26)
					gridMap[x][y] = 0;
				else
					gridMap[x][y] = 1;
			}
		}
	}
	
	public int getStatus(int x, int y) 
	{
		return gridMap[x][y];
	}
	
	public void setStatus(int x, int y, int status)
	{
		gridMap[x][y] = status;
	}
	
	public void removeKey(int x, int y, int keyNum)
	{
		gridMap[x][y] = 1;
		drawMap(this.root, this.scale, 0);
	}
}
