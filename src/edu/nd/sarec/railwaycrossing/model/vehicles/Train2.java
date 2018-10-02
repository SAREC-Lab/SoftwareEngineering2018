package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train2 extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	
	public Train2(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		img = new Image("images\\Train2.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		currentX+=3;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (currentX > 1750)
			return true;
		else
			return false;
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}