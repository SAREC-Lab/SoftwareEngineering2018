import java.awt.Point;
import java.util.Arraylist;

public class Chip
{
	Point position = new Point();
	private int xPos;
	private int yPos;
	
	public Chip()
	{
		currentLocation.setLocation(12, 12);
	}

	public void goRight()
	{
		if (position.getX()+1 <= 24)
			position.setLocation(position.getX()+1, position.getY());
		xPos++;
	}
	
	public void goWest()
	{
		if (position.getX()-1 >= 0)
			position.setLocation(position.getX()-1, position.getY());
		xPos--;
	}
	
	public void goNorth()
	{
		if (position.getX()-1 >= 0)
			position.setLocation(position.getX(), position.getY()-1);
		yPos--;
	}
	
	public void goSouth()
	{
		if (position.getY()+1 <= 24)
			position.setLocation(position.getX(), position.getY()+1);
		yPos++;
	}
}
