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
	private boolean gateDown2 = false;
	private double leadCarY = -1;  // Current Y position of car directly infront of this one
	private double speed = 0.5;
	private boolean canMove = true;
	private boolean canTurn = false;
	private boolean turn = false;
	
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public boolean gateIsClosed2(){
		return gateDown2;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public void moveSouth(){
		canMove = true; 
		canTurn = false;
		
		//allows cars to cross onto the connecting road
		if (turn && getVehicleY() > 610 && getVehicleY() < 630) {
			canMove = false;
			canTurn = true;
		}
		
		if(canTurn && getVehicleX() > 360 && getVehicleX() < 390) {
			canTurn = false;
			canMove = true;
		}
		
		// First case.  Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 230 && getVehicleY()> 190) 
			canMove = false;
		
		//Checking the first case for the second set of gates
		if (gateDown2 && getVehicleY() < 460 && getVehicleY()> 420)
			canMove = false;
		
		// Second case. Car is too close too other car.
		if (leadCarY != -1  && getDistanceToLeadCar() < 50)
			canMove = false;
		
		if(leadCarY > 300 && leadCarY < 370 && getVehicleY() < 260 && getVehicleY() > 180 && gateDown2)
			canMove = false;
			
		if (canMove){
			currentY+=speed;
			ivCar.setY(currentY);
		}
		
		if (canTurn){
			currentX-=speed;
			ivCar.setX(currentX);
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
	
	public void setGateDownFlag2(boolean gateDown){
		this.gateDown2 = gateDown;
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

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			if(((Car)o).getTurn() && ((Car)o).getVehicleY() > 610)
				leadCarY = -1;
			else		
				leadCarY = (((Car)o).getVehicleY());
			
			if (leadCarY > 1020)
				leadCarY = -1;
		}
			
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getAnchorY() < 400) {
				if(gate.getTrafficCommand() == "STOP")
					gateDown = true;
				else
					gateDown = false;
			}else {
				if(gate.getTrafficCommand() == "STOP")
					gateDown2 = true;	
				else
					gateDown2 = false;
			}
		}	
	}

	@Override
	public void moveWest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveEast() {
		// TODO Auto-generated method stub
		
	}	
}
