package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;
import java.util.Observer;

import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 * @author jane
 *
 */
public class Car extends Observable implements IVehicle, Observer{
	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	private double leadCarY = -1;  // Current Y position of car directly infront of this one
	private double speed = 0.5;
	private boolean inJunction = false;	
	private CarFactory factory;
	
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y, CarFactory eastFactory){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
		this.factory = eastFactory;
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		boolean canMoveY = true;
		boolean canMoveX = false;
		
		if(inJunction)
			canMoveY = false;
		else{
			// First case.  Car is at the front of the stopping line.
			if (gateDown && getVehicleY() < 430 && getVehicleY()> 390)
				canMoveY = false;
			
			// Second case. Car is too close too other car.
			if (leadCarY != -1  && getDistanceToLeadCar() < 50)
				canMoveY = false;
		}
		
		// Third case, car can chose to go into junction
		if (!inJunction && currentX == 791.0 && currentY > 340 && currentY < 341.5 && Math.random() < 0.5){
			inJunction = true;
			
			// remove observer
			/*this.deleteObservers();
			
			// like in a linked list, connect loose pointers
			Car observed = null;
			Car observer = null;
			for(int i=0; i<factory.getCars().size(); i++){
				Car c = factory.getCars().get(i);
				if(c == this && i < factory.getCars().size()-1 && i > 0){
					observed = factory.getCars().get(i+1);
					observer = factory.getCars().get(i-1);
					System.out.println("found");
					break;
				}
			}
			if(observed != null)
				observed.addObserver(observer);
			*/
			// observe last car added to West road
			factory.getOtherCarFactory().getPreviousCar().addObserver(this);
			factory.getOtherCarFactory().setPreviousCar(this);
			factory.getOtherCarFactory().addCarToList(this);
		}
		
		// Forth case. Car in junction
		if (inJunction && currentX > 420)
			canMoveX = true;
		
		// Fifth case. Move out of junction
		if (inJunction && currentX < 420 && getDistanceToLeadCar() > 50){
			currentX = 391;
			ivCar.setX(currentX);
			setChanged();
			notifyObservers();
			inJunction = false;
		}
		
		if (canMoveY){
			currentY+=speed;
			ivCar.setY(currentY);
			setChanged();
			notifyObservers();
		}
		
		if (canMoveX){
			currentX-=speed;
			ivCar.setX(currentX);
			setChanged();
			notifyObservers();
		}
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public boolean offScreen(){
		if (currentY > 1020)
			return true;
		else
			return false;			
	}
		
	public void reset(){
		currentY = originalY;
	}
	
	public double getDistanceToLeadCar(){
		return leadCarY-getVehicleY();
	}
	
	public void removeLeadCar(){
		leadCarY = -1;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			leadCarY = (((Car)o).getVehicleY());
			
			if (((Car)o).isCarInJunction() || leadCarY > 1020)
				leadCarY = -1;
		}
			
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getTrafficCommand()=="STOP")			
				gateDown = true;
			else
				gateDown = false;
		}				
	}
	
	public boolean isCarInJunction()
	{
		return inJunction;
	}
}
