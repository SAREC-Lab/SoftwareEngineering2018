package edu.nd.sarec.railwaycrossingnew.model.vehicles;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import edu.nd.sarec.railwaycrossingnew.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossingnew.view.CarView;
import javafx.scene.Node;


/**
 * Represents Car object
 * @author jane
 *
 */
public class Car extends Observable implements IVehicle, Observer{
	//private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	private double leadCarY = -1;  // Current Y position of car directly infront of this one
	private double speed = 0.5;
	private CarView carView;
	private String license = "";
		
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y, String license){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		this.license = license;
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
	
	public void attachCarView(CarView carView) {
		addObserver(carView);
		this.carView = carView;		
	}
	
	public void move(){
		boolean canMove = true; 
		
		// First case.  Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 430 && getVehicleY()> 390)
			canMove = false;
		
		// Second case. Car is too close too other car.
		if (leadCarY != -1  && getDistanceToLeadCar() < 50)
			canMove = false;
		
		if (canMove){
			currentY+=speed;
			// Refactored to separate model and view
			//if (gui)
			//	ivCar.setY(currentY);
			////////////////////////////////////////
			
			//setChanged();
			//notifyObservers();

		}
		setChanged();
		notifyObservers();
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
		return Math.abs(leadCarY-getVehicleY());
	}
	
	public void removeLeadCar(){
		leadCarY = -1;
	}
	
	public String getLicense() {
		return license;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			leadCarY = (((Car)o).getVehicleY());
			if (leadCarY > 1020)
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
	
	// Delegates this to the actual carView.
	// Currently breaks dependency inversion principle so I need to change
	// carView to be an interface!!
	public CarView getCarView() {
		return carView;
	}
	
	public Point getCarPosition() {
		Point position = new Point();
		position.x = (int)currentX;
		position.y = (int)currentY;
		return position;
	}
	
}
