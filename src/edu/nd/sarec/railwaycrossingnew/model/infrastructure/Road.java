package edu.nd.sarec.railwaycrossingnew.model.infrastructure;

import java.awt.Point;
import java.util.Collection;
import java.util.Vector;

import edu.nd.sarec.railwaycrossingnew.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossingnew.model.vehicles.CarFactory;

/**
 * Represents a single road
 * @author jane
 *
 */
public class Road {
	private int startX;
	private int endX;
	private int startY;
	private int endY;
	private CarFactory carFactory;
	Direction direction;
	Collection<CrossingGate> gates;
	boolean clearEnds = false;
	int roadSize;
	private String factoryName = "";
	public Road(){}
	private boolean gui = true;;
	
	public Road(Point start, Point end, Direction direction, boolean buildCarFactory, boolean clearEnds){
		startX = start.x;
		startY = start.y;
		endX = end.x;
		endY = end.y;
		roadSize = 18;
		
		this.direction = direction;
		gates = new Vector<CrossingGate>();
		this.clearEnds = clearEnds;
		
	}
	
	// Adds a gate to a road
	// In case a new gate is added after the factory is assigned, we reassign factory
	// The factory needs to know all gates on the road in order to register each car as an observer.
	public void assignGate(CrossingGate gate){
		gates.add(gate);
		if (carFactory != null)
			carFactory = new CarFactory(direction, new Point(startX-roadSize/2,startY), gates,factoryName,gui);  // allows additional gates.  Needs fixing
	}
	
	public void addCarFactory(String factoryName,boolean gui) {
		this.factoryName = factoryName;
		if (carFactory == null) // We only allow one
			carFactory = new CarFactory(direction, new Point(startX-roadSize/2,startY), gates, factoryName,gui);
		this.gui = gui;
	}
	
	public CarFactory getCarFactory(){
		return carFactory;
	}
	
	public int getStartX(){
		return startX;
	}
	
	public int getEndX(){
		return endX;
	}
	
	public int getStartY(){
		return startY;
	}
	
	public int getEndY(){
		return endY;
	} 
	
	public Direction getDirection(){
		return direction;
	}
	
	public boolean getClearEnds(){
		return clearEnds;
	}
	
	public int getRoadWidth(){
		return roadSize;
	}
}