package edu.nd.se2018.homework.hwk4.model.vehicles;

import java.util.Observable;

import edu.nd.se2018.homework.hwk4.model.infrastructure.Direction;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	Direction direction;
	
	public Train(int x, int y, Direction d){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		this.direction = d;
		img = new Image("/images/Train.PNG" ,120,trainLength,false,false);
		imgView = new ImageView(img);
		if (d == Direction.EAST) {
			imgView.setScaleX(-1);
		}
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		if (direction == Direction.WEST) {
			currentX-=2;
		}
		else {
			currentX+=2;
		}
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (direction == Direction.WEST) {
			if (currentX < -200)
				return true;
			else
				return false;	
		}
		else {
			if (currentX > 1600)
				return true;
			else
				return false;	
			
		}
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}