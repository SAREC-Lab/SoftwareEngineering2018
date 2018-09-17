import java.util.Observable;
import java.util.Observer;
import java.awt.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;
import java.lang.Math;

public class PirateShip implements Observer
{
	Point piratePosition;
	Point columbusPosition;
	Random rand = new Random();
	ImageView pirateImageView;
	Image pirateImage;
	int scale;
	
	public PirateShip(int Scale)
	{
		piratePosition = new Point(Math.floorDiv(rand.nextInt(625), 25), Math.floorDiv(rand.nextInt(625), 25));
		pirateImage = new Image("file:/Users/Dchao88/Documents/Software Engineering/ColumbusGame/src/Images/pirateship.gif", 25, 25, true, true);
		pirateImageView = new ImageView(pirateImage);
		pirateImageView.setX(24);
		pirateImageView.setY(24);
		scale = Scale;
	}
	
	public void setPosition(int x, int y)
	{
		pirateImageView.setX(x);
		piratePosition.x = x;
		pirateImageView.setY(y);
		piratePosition.y = y;
	}
	
	public ImageView getImageView()
	{
		return pirateImageView;
	}
	
	public void movePirate()
	{
		if (columbusPosition.getX() - piratePosition.getX() > 0)
			piratePosition.x += 1*scale;
		else
			piratePosition.x += 1*scale;		
		if (columbusPosition.getY() - piratePosition.getY() > 0)
			piratePosition.y += 1*scale;
		else
			piratePosition.y += 1*scale;
		
		pirateImageView.setX(piratePosition.getX());
		pirateImageView.setX(piratePosition.getY());
		
	}
	
	@Override
	public void update(Observable o, Object arg) 
	{
		// TODO Auto-generated method stub
		if (o instanceof Ship)
		{
			columbusPosition = ((Ship)o).getShipLocation();
			movePirate();
		}
	}
	
}
