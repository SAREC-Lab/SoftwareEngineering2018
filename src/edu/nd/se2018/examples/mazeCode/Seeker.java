package edu.nd.se2018.examples.mazeCode;

import java.awt.Point;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Seeker {
	Circle circle;
	int xCell;
	int yCell;
	int unitSize;  // Scaling factor
	Maze maze;
	
	public Seeker(int x, int y, int unitSize, Maze maze){
		xCell = x;
		yCell = y;
		this.unitSize = unitSize;
		circle = new Circle(unitSize/2);
		circle.setCenterX(x*unitSize+unitSize/2);
		circle.setCenterY(y*unitSize+unitSize/2);
		//circle = new Circle(x*unitSize+unitSize/2, y*unitSize+unitSize/2, unitSize/2);
		this.maze = maze; // We need a reference to it so we can access the grids!
	}
	
	public void setColor(Color color){
		circle.setFill(color);
	}
	
	private void setCircleX(int x){
		circle.setCenterX(computeDisplayPosition(x));	
	}
	
	private void setCircleY(int y){
		circle.setCenterY(computeDisplayPosition(y));	
	}
	
	private int computeDisplayPosition(int gridCoordinate){
		return (gridCoordinate*unitSize+unitSize/2);
	}
	
	public void moveRight(){
		if (maze.east[xCell][yCell] == false){
			xCell++;
			setCircleX(xCell);
		}			
    }
	
	public void moveLeft(){
		if (maze.west[xCell][yCell] == false){
			xCell--;
			setCircleX(xCell);
		}		
	}
	
	public void moveUp(){
		if (maze.south[xCell][yCell] == false){
			yCell--;
			setCircleY(yCell);
		}	
	}
	
	public void moveDown(){
		if (maze.north[xCell][yCell] == false){
			yCell++;
			setCircleY(yCell);
		}	
	}
	
	public Circle getCircle(){
		return circle;
	}
	
	public Point getCurrentLocation(){
		return new Point(xCell,yCell);
	}
}
