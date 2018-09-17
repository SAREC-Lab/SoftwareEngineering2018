package application;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class pirateShip implements Observer {
	
	public int pirateX = 0;
	public int pirateY = 0;
	public int [][]restricted;
	int sailorX = 0;
	int sailorY = 0;
	Random rand = new Random();
	int scale = 24;
	Image pImage;
	public ImageView pShip;
	
	public pirateShip(int [][] oceanGrid){
		restricted = oceanGrid;
		pirateX = rand.nextInt(24) * scale;
		pImage = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/src/edu/nd/se2018/homework/hwk4/src/application/pirateship.gif", 25, 25, true, true);	
		pShip = new ImageView(pImage);		
		oceanGrid[0][pirateX/24] = 2; // set the pirate in motion on the board
	}
	
	public ImageView getImageView(){
		return pShip;
	}
	public int getX() {
		return pirateX;
	}
	public int getY() {
		return pirateY;
	}
	
	public void hunt() {
		if (pirateX - sailorX < 0) {
			if(resCheck(pirateX+24,pirateY)) {
				pirateX = pirateX+24;
			}
		}
		else {
			if(resCheck(pirateX-24,pirateY)) {
				pirateX = pirateX-24;
	
			}
			System.out.println(pirateX + "go left but didnt");
		}
		if (pirateY - sailorY < 0) {
			if(resCheck(pirateX,pirateY+24)) {
				pirateY = pirateY+24;
			}
		}
		else {
			if(resCheck(pirateX,pirateY-24)) {
				pirateY = pirateY-24;
			}
		}
		pShip.setX(pirateX);
		pShip.setY(pirateY);
	}
	public boolean resCheck(int x, int y) {
		if(restricted[y/24][x/24] == 1 || restricted[y/24][x/24] == 2 || (( x<0 || x > 600 )|| (y < 0 || y > 600))) {
			return false;
		}else {
			System.out.println("Good Move");
		return true;
		}
	}
	
	public void defineRes(int [][] res) {
		restricted = res;
	}
	@Override
	public void update(Observable s, Object arg) {
		if (s instanceof Ship){
			sailorX = ((Ship)s).getX();
			sailorY = ((Ship)s).getY();
			hunt();			
		}
		
	}

}
