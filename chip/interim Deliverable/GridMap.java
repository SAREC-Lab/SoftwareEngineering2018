import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import java.util.Random;

public class GridMap 
{
	int[][] gridMap = new int[25][25];
	final int dimensions = 25;
	
	public void drawMap(ObservableList<Node> root, int scale)
	{
		for (int x = 0; x < dimensions; x++)
		{
			for (int y = 0; y < dimensions; y++)
			{
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				oceanGrid[x][y] = 0;
				rect.setFill(Color.DARKGREY);
				root.add(rect);
			}
		}
	}
	
	public int getStatus(int x, int y) 
	{
		return gridMap[x][y];
	}
	
	public void setLevel(int lvl)
	{
		// a block with value '1' will be an untraversable block
		// note that this could be a water block, in which case 
		// if a sand block is pushed over it, its value will flip
		
		if (lvl == 1)
		{
			
		}
		else if (lvl == 2)
		{
			
		}
		else
		{
			
		}
	}
}
