import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pirate implements Observer{
	
	private int x;
	private int y;
	private int[][] oceanMap;
	
	private Image img;
	private ImageView imgView;
	
	public Pirate(int x, int y, int[][] oceanMap)
	{
		this.x = x;
		this.y = y;
		this.oceanMap = oceanMap;
		img = new Image("file:main/resources/pirateship.gif", 30, 30, true, true);
		imgView = new ImageView(img);
		setImageViewPos();
	}
	
	public Point getShipLocation()
	{
		return new Point(x, y);
	}
	
	public ImageView getImageView()
	{
		return imgView;
	}
	
	public void setImageViewPos()
	{
		imgView.setX(x*OceanMap.SCALING_FACTOR);
		imgView.setY(y*OceanMap.SCALING_FACTOR);
	}

	public void update(Observable o, Object arg) {
		Ship ship = (Ship)o;
		if(ship.getShipLocation().x > x && x < OceanMap.NUM_TILES-1 && oceanMap[x+1][y] != 1)
			x++;
		if(ship.getShipLocation().x < x && x > 0 && oceanMap[x-1][y] != 1)
			x--;
		if(ship.getShipLocation().y > y && y < OceanMap.NUM_TILES-1 && oceanMap[x][y+1] != 1)
			y++;
		if(ship.getShipLocation().y < y && y > 0 && oceanMap[x][y-1] != 1)
			y--;
	}

}
