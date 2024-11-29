package edu.nd.sarec.railwaycrossing.model.infrastructure;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;

/**
 * Creates all infrastructure for the simulation
 * @author jane
 *
 */
public class MapBuilder {
	HashMap<String, Road> roads;
	HashMap<String, CrossingGate> gates;
	HashMap<String, RailwayTracks> tracks;
	
	public MapBuilder(){
		roads = new HashMap<String,Road>();	
		gates = new HashMap<String,CrossingGate>();
		tracks = new HashMap<String,RailwayTracks>();
		buildRoads();
		buildCrossingGates();
		buildTracks();
		assignGatesToRoads();
		buildCarFactories();
	}

	private void buildRoads(){
		roads.put("Western Highway",new Road(new Point(800,0),new Point (800,1000),Direction.SOUTH,true,false));
		roads.put("Skyway",new Road(new Point(400,0),new Point (400,1000),Direction.SOUTH,true,false));		
		roads.put("EastWest",new Road(new Point(415,630),new Point (785,630),Direction.EAST,true,true));	
	}
	
	private void buildCrossingGates(){
		gates.put("Gate1", new CrossingGate(780,340, "Gate1"));
		gates.put("Gate2", new CrossingGate(380,340, "Gate2"));
		gates.put("Gate3", new CrossingGate(780,540, "Gate3"));
		gates.put("Gate4", new CrossingGate(380,540, "Gate4"));	
	}
	
	private void buildTracks(){
		tracks.put("Royal", new RailwayTracks(new Point(0,360),new Point(1200,360)));
		tracks.put("Magenta", new RailwayTracks(new Point(0,560),new Point(1200,560)));
	}
	
	private void assignGatesToRoads(){
		roads.get("Western Highway").assignGate(gates.get("Gate1"));
		roads.get("Skyway").assignGate(gates.get("Gate2"));
		roads.get("Western Highway").assignGate(gates.get("Gate3"));
		roads.get("Skyway").assignGate(gates.get("Gate4"));
	}
	
	private void buildCarFactories(){
		roads.get("Western Highway").addCarFactory();
		roads.get("Skyway").addCarFactory();
	}
	
	public Collection<CrossingGate> getAllGates(){
		return gates.values();
	}
	
	public CrossingGate getGate(String gate){
		return gates.get(gate);
	}
	
	public Collection<RailwayTracks> getTracks(){
		return tracks.values();
	}
	
	public Collection<Road> getRoads(){
		return roads.values();
	}
	
	public Road getRoad(String road){
		return roads.get(road);
	}
	
	public RailwayTracks getTrack(String name){
		return tracks.get(name);
	}
}
