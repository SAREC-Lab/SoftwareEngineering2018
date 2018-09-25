package application.model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private boolean dir = true; // right direction
	
	public Train(int x, int y, boolean dir){
		this.dir = dir;
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		img = new Image("file:/Users/connorgreen/git/SoftwareEngineering2018/src/images/Train.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	public boolean getDir() {
		return dir;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		currentX-=2;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	public void moveB() {
		currentX+=2;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (currentX < -200 || currentX > 1400)
			return true;
		else
			return false;				
	}
	
	public void reset(){
		currentX = originalX;
	}
	public void resetL(){
		currentX =  -200;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}