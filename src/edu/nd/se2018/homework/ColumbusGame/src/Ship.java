import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable{
	
	private int x;
	private int y;
	private int[][] map;
	
	public Ship(int x, int y, int[][] m)
	{
		this.x = x;
		this.y = y;
		this.map = m;
	}
	
	public Point getShipLocation()
	{
		return new Point(x, y);
	}

	public void goEast(){
		if(x < OceanMap.NUM_TILES-1 && map[x+1][y] != 1){
			x++;
			setChanged();
			notifyObservers();
		}
	}
	public void goWest(){
		if(x > 0 && map[x-1][y] != 1){
			x--;
			setChanged();
			notifyObservers();
		}
	}
	public void goNorth(){
		if(y > 0 && map[x][y-1] != 1){
			y--;
			setChanged();
			notifyObservers();
		}
	}
	public void goSouth(){
		if(y < OceanMap.NUM_TILES-1 && map[x][y+1] != 1){
			y++;
			setChanged();
			notifyObservers();
		}
	}
	
	public void addPirate(Pirate p)
	{
		addObserver(p);
	}
}
