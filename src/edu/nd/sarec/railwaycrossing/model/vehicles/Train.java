package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;

import edu.nd.sarec.railwaycrossing.model.infrastructure.Direction;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

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
	private Direction dir;
	
	public Train(int x, int y, Direction dir){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		
		if(dir == Direction.EAST)
			img = new Image("images/Train_flipped.png",120,trainLength,false,false);
		else
			img = new Image("images/Train.PNG",120,trainLength,false,false);
		
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
		
		this.dir = dir;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		if(dir == Direction.EAST)
			currentX+=2;
		else
			currentX-=2;
		
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if(dir == Direction.WEST)
		{
			if (currentX < -200)
				return true;
			else
				return false;		
		}
		else if(dir == Direction.EAST)
		{
			if (currentX > 1400)
				return true;
			else
				return false;
		}
		
		return false;
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
	
	public Direction getDirection(){
		return dir;
	}
}