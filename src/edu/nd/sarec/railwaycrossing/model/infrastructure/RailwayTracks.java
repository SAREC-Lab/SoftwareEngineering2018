package edu.nd.sarec.railwaycrossing.model.infrastructure;

import java.awt.Point;

/**
 * Railway Tracks (Entity Object)
 * @author Jane Cleland-Huang
 *
 */
public class RailwayTracks {
	
	private int startX;
	private int endX;
	private int startY;
	private int endY;
	
	public RailwayTracks(){}
	
	public RailwayTracks(Point startPoint, Point endPoint){
		startX = startPoint.x;
		startY = startPoint.y;
		endX = endPoint.x;
		endY = endPoint.y;
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
	
	@Override 
	public String toString(){
		return "Tracks from (" + startX + "," + startY + ") to (" + endX + "," + endY + ")";
	}
}