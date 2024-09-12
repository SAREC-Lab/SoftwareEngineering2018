import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import java.util.Random;

public class OceanMap 
{
	int[][] oceanGrid = new int[25][25];
	final int dimensions = 25;
	
	public void drawMap(ObservableList<Node> root, int scale)
	{
		for (int z = 0; z < 10; z++)
		{
			Random rand = new Random();
			int x = rand.nextInt(dimensions);
			int y = rand.nextInt(dimensions);
			
			oceanGrid[x][y] = 1;
		}
		
		for (int x = 0; x < dimensions; x++)
		{
			for (int y = 0; y < dimensions; y++)
			{
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (oceanGrid[x][y] != 1)
				{
					oceanGrid[x][y] = 0;
					rect.setFill(Color.PALETURQUOISE);
				}
				else
					rect.setFill(Color.FORESTGREEN);
				
				root.add(rect);
			}
		}
	}
	
	public int getStatus(int x, int y) 
	{
		return oceanGrid[x][y];
	}
}
