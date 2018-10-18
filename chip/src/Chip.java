import java.awt.Point;
import java.util.ArrayList;

public class Chip
{
	Point position = new Point();
	private int xPos;
	private int yPos;
	ArrayList<Integer> keys = new ArrayList<Integer>();
	
	public Chip()
	{
		position.setLocation(13, 13);
		xPos = 13;
		yPos = 13;
	}

	public void goRight()
	{
		if (position.getX()+1 <= 26)
			position.setLocation(position.getX()+1, position.getY());
		xPos++;
	}
	
	public void goLeft()
	{
		if (position.getX()-1 > 0)
			position.setLocation(position.getX()-1, position.getY());
		xPos--;
	}
	
	public void goUp()
	{
		if (position.getX()-1 > 0)
			position.setLocation(position.getX(), position.getY()-1);
		yPos--;
	}
	
	public void goDown()
	{
		if (position.getY()+1 <= 26)
			position.setLocation(position.getX(), position.getY()+1);
		yPos++;
	}
	
	public Point getPosition()
	{
		return this.position;
	}
	
	public ArrayList<Integer> getKeys()
	{
		return keys;
	}
	
	public void addKey(int key)
	{
		keys.add(key-1);
	}
}
