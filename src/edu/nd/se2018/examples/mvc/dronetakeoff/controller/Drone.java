package edu.nd.se2018.examples.mvc.dronetakeoff.controller;

import java.awt.Point;
import java.util.Observable;

import edu.nd.se2018.examples.mvc.dronetakeoff.model.Ascending;
import edu.nd.se2018.examples.mvc.dronetakeoff.model.DroneState;
import edu.nd.se2018.examples.mvc.dronetakeoff.model.Landing;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * Drone Manages the behavior of an individual drone
 * @author Jane
 *
 */
public class Drone extends Observable{
	ImageView droneImageView;
	Image droneImage;
	//Point droneCoordinates;
	int heightFromCeiling;
	int GroundLevel;
	DroneState droneState;	
		
	/**
	 * 
	 * @param startX xCoordinates
	 * @param startY yCoordinates (starting from top of screen)
	 * @param heightFromCeiling maximum height
	 * @param infoMessage handle for posting status messages
	 * @param GroundLevel ground level in terms of y coordinates
	 */
	public Drone(int startX, int startY, int heightFromCeiling, Text infoMessage, int GroundLevel){
		this.heightFromCeiling = heightFromCeiling;					
		this.GroundLevel = GroundLevel;
		droneState = new DroneState(infoMessage);
		droneState.initializeStates();
		droneState.setCoordinates(new Point(startX, startY));
	}
	
	public boolean isAscending(){
		if (droneState.getFlyingState() instanceof Ascending)
			return true;
		else
			return false;
	}
	
	public boolean isLanding(){
		if (droneState.getFlyingState() instanceof Landing)
			return true;
		else
			return false;
	}
	
	/**
	 * Takeoff event initiated by button press
	 */
	public void takeOff(){
		droneState.getFlyingState().takeoffPressed();
	}
	
	/**
	 * Land event initiated by button press
	 */
	public void land(){
		droneState.getFlyingState().landPressed();
	}
	
	/** 
	 * Hover event initiated by button press
	 */
	public void hover(){
		droneState.getFlyingState().hoverPressed();
	}
	
	
	/**
	 * Drone ascends.  Its position is modified
	 */
	public void ascend(){
		Point droneCoordinates = droneState.getCoordinates();
		if (droneCoordinates.getY() > heightFromCeiling){  // A bit unintuitive because y axis grows from the top down.
			droneCoordinates.setLocation(droneCoordinates.getX(), droneCoordinates.getY()-1);
			setChanged();
			notifyObservers();
		}
		else
			droneState.getFlyingState().reachedMaxHeight();
	}
	
	/**
	 * Drone descends.  Its position is modified
	 */
	public void descend(){
		Point droneCoordinates = droneState.getCoordinates();
		if (droneCoordinates.getY() < GroundLevel-50){
			droneCoordinates.setLocation(droneCoordinates.getX(), droneCoordinates.getY()+1);
			setChanged();
			notifyObservers();
		} 
		else
			droneState.getFlyingState().reachedGround();
	}
	
	public Point getCoordinates(){
		return droneState.getCoordinates();
	}
	
	/**
	 * 
	 * @return ImageView (needed by JavaFX)
	 */
	public ImageView getDroneImageView(){
		return droneImageView;
	}
	
}
