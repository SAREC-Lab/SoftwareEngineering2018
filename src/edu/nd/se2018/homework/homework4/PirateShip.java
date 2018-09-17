package edu.nd.se2018.homework.homework4;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@SuppressWarnings("deprecation")
public class PirateShip implements Observer {
	
	final int scale = 25;
	Point shipPosition;
	Point pirateShipPosition;
	Random rand = new Random();
	ImageView pirateShipImageView;
	Image pirateShipImage;
	
	public PirateShip(OceanMap map) {
		pirateShipPosition = new Point(rand.nextInt(25), rand.nextInt(25));
		while ((pirateShipPosition.x == 0 && pirateShipPosition.y == 0) || map.oceanGrid[pirateShipPosition.x][pirateShipPosition.y] != 0) {
			pirateShipPosition.x = rand.nextInt(25);
			pirateShipPosition.y = rand.nextInt(25);
		}
		pirateShipImage = new Image("file:/Users/danielburns/Documents/School/Software Engineering Principles/eclipse_workspace/ColumbusGame/src/Images/PirateShip.png", 25, 25, true, true);
		pirateShipImageView = new ImageView(pirateShipImage);
	}
	
	public ImageView getImageView() {
		return pirateShipImageView;
	}
	
	public void movePirateShip() {
		if (pirateShipPosition.x - shipPosition.x < 0)
			pirateShipPosition.x++;
		else
			pirateShipPosition.x--;
		
		if (pirateShipPosition.y - shipPosition.y < 0)
			pirateShipPosition.y++;
		else
			pirateShipPosition.y--;
		
		pirateShipImageView.setX(pirateShipPosition.x*scale);
		pirateShipImageView.setY(pirateShipPosition.y*scale);	
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Ship) {
			shipPosition = ((Ship)o).getShipLocation();
			movePirateShip();
		}
	}

}
