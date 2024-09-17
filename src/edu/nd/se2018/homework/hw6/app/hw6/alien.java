package hw6;

import java.util.Observable;
import java.util.Observer;
import hw6.chip;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class alien implements  Observer{

	
	int xLocal = 25;
	int yLocal = 500;
	int chipX;
	int chipY;
	int scale = 25; // if time find a way to keep this throughout structure 
	public Image _im;
	public ImageView _alien;
	 int[][] levelMap;
	
	public alien(AnchorPane base,int[][] level) {
		levelMap = level;
		_im = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/src/images/drone4.png", 25, 25, true, true);	
		_alien = new ImageView(_im);
		_alien.setX(xLocal);
		_alien.setY(yLocal);
		base.getChildren().add(_alien);
		
	}
	public void hunt() {
		if(xLocal/25 == chipX/25 && yLocal/25 == chipX/25) {
		      Text text = new Text();      
		      text.setText("The Alien Has Caught you, sorry you lose"); 
		      System.out.println("The Alien Has Caught you, sorry you lose");
		      text.setX(300); 
		      text.setY(300); 
		}else { // the alien has too easy of a time catching chip if I don't lower the size
			if (xLocal - chipX < 0) {
				if(resCheck(xLocal+5,yLocal)) {
					xLocal = xLocal+5;
				}
			}
			else {
				if(resCheck(xLocal-5,yLocal)) {
					xLocal = xLocal-5;
		
				}
			}
			if (yLocal - chipY < 0) {
				if(resCheck(xLocal,yLocal+5)) {
					yLocal = yLocal+5;
				}
			}
			else {
				if(resCheck(xLocal,yLocal-5)) {
					yLocal = yLocal-5;
				}
			}
		}
		System.out.print(xLocal/25);
		System.out.print(yLocal/25);
		_alien.setY(yLocal);
		_alien.setX(xLocal);
	}
	public boolean resCheck(int x, int y) { // check if the alien is going to be pushed into restrictive space
		if(levelMap[y/25][x/25] != 0){
			return false;
		}else {
			//System.out.println("Good Move");
			return true;
		}
	}

	@Override
	public void update(Observable c, Object arg) {
		if (c instanceof chip){ //update status of the observed class
			chipX = ((chip)c).getX();
			chipY = ((chip)c).getY();
			hunt();			
		}
		
	}
	
}
