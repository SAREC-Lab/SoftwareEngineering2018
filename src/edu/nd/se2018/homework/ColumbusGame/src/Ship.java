import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class Ship extends Observable
{
	Point currentLocation = new Point();
	
	public Ship()
	{
		currentLocation.setLocation(0, 0);;
	}
	
	public Point getShipLocation()
	{
		return currentLocation;
	}
	
	public void goEast()
	{
		if (currentLocation.getX()+1 <= 24)
			currentLocation.setLocation(currentLocation.getX()+1, currentLocation.getY());
		setChanged();
		notifyObservers();
	}
	
	public void goWest()
	{
		if (currentLocation.getX()-1 >= 0)
			currentLocation.setLocation(currentLocation.getX()-1, currentLocation.getY());
		setChanged();
		notifyObservers();
	}
	
	public void goNorth()
	{
		if (currentLocation.getY()-1 >= 0)
			currentLocation.setLocation(currentLocation.getX(), currentLocation.getY()-1);
		setChanged();
		notifyObservers();
	}
	
	public void goSouth()
	{
		if (currentLocation.getY()+1 <= 24)
			currentLocation.setLocation(currentLocation.getX(), currentLocation.getY()+1);
		setChanged();
		notifyObservers();
	}
}
