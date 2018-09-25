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
	private boolean gate2Down = false;
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
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){ 
		canMove = true;
		canTurn = false;
		
		// First check if car is able to turn onto east road
		if (turn && getVehicleY() > 615 && getVehicleY() < 645 ) {
			canMove = false;
			canTurn = true;
		}
		// Car has switched to other road and now has to straighten out again
		if (turn && getVehicleY() > 615 && getVehicleY() < 645 && getVehicleX() > 370 && getVehicleX() < 390 ) {
			canMove = true;
			canTurn = false;
		}
		//   Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 290 && getVehicleY() > 250)
			canMove = false;
		
		if (gate2Down && getVehicleY() < 490 && getVehicleY() > 450)
			canMove = false;
		
		// Second case. Car is too close too other car.
		if (leadCarY != -1  && getDistanceToLeadCar() < 50)
			canMove = false;
		// First gate is open but second gate is closed and there isnt enough space to not get caught on track
		// *****Professor said it is okay I made a second pair of gates operate on the second train*************
		if (leadCarY > 360 && leadCarY < 410 && gate2Down && getVehicleY() < 320 && getVehicleY()> 250) {
			canMove = false;
		}
		
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
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public void setGate2DownFlag(boolean gateDown){
		this.gate2Down = gateDown;
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
			if(((Car)o).getTurn() && ((Car)o).getVehicleY() > 615)
				leadCarY = -1;
			else
				leadCarY = (((Car)o).getVehicleY());
			
			if (leadCarY > 1020)
				leadCarY = -1;
		}
			
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getAnchorY() < 360) {
				if(gate.getTrafficCommand()=="STOP")			
					gateDown = true;
				else
					gateDown = false;
			}else {
				if(gate.getTrafficCommand()=="STOP")			
					gate2Down = true;
				else
					gate2Down = false;
			}
		}				
	}	
}
