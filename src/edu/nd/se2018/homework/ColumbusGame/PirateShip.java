package edu.nd.se2018.homework.ColumbusGame;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer{
	
	Point pirateLocation = new Point();
	Point shipLocation;
	final int scalingFactor = 50;
	Image pirateImage;
	ImageView pirateImageView;
	int randomNum = ThreadLocalRandom.current().nextInt(0, 10);
	int randomNum2 = ThreadLocalRandom.current().nextInt(0, 10);
	OceanMap map;
	
	public PirateShip(OceanMap oceanMap) {
		map = oceanMap;
		do {
			pirateLocation.x = ThreadLocalRandom.current().nextInt(0, 10);
			pirateLocation.y = ThreadLocalRandom.current().nextInt(0, 10);
		} while (map.oceanGrid[pirateLocation.x][pirateLocation.y] != 0);
		pirateImage = new Image("images\\pirateship.gif",50,50,true,true);	
		pirateImageView = new ImageView(pirateImage);
	}
	
	public void setImageView() {
		pirateImageView.setX(pirateLocation.x*scalingFactor);
		pirateImageView.setY(pirateLocation.y*scalingFactor);
	}
	
	public ImageView getImageView(){
		return pirateImageView;
	}
	
	public void movePirate() {
		
		if (pirateLocation.x - shipLocation.x < 0 && map.oceanGrid[pirateLocation.x +1][pirateLocation.y] == 0 ) {
				pirateLocation.x++;
		}else if (pirateLocation.x - shipLocation.x > 0 && map.oceanGrid[pirateLocation.x -1][pirateLocation.y] == 0) {
				pirateLocation.x--;
		}else if (pirateLocation.y - shipLocation.y < 0 && map.oceanGrid[pirateLocation.x][pirateLocation.y+1] == 0) {
				pirateLocation.y++;
		}else if (pirateLocation.y - shipLocation.y > 0 && map.oceanGrid[pirateLocation.x][pirateLocation.y-1] == 0) {
				pirateLocation.y--;
		}
		setImageView();
	}
	
	@Override
	public void update(Observable s, Object arg) {
		if (s instanceof Ship){
			shipLocation = ((Ship)s).getShipLocation();
			movePirate();			
		}
		
	}
	
}
