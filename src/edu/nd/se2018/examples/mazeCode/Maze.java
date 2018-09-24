/*
 *  Code for generating the maze is taken and modified from:
 *  ?? Searching for the source to attribute correct...!!
  ******************************************************************************
 */

package edu.nd.se2018.examples.mazeCode;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.shape.Line;

public class Maze {
	 private int N;         
	 boolean[][] north;     // true if a wall exists to north of cell i,j
	 boolean[][] east;  
	 boolean[][] south;
	 boolean[][] west;
	 private boolean[][] visited;
	 private ArrayList<Line> lines = new ArrayList<Line>();
	 Point winningCell;
	 
	 public Maze (int mazeSize){
		 N = mazeSize;
		 initMaze();
		 generate(1,1);
		 buildLines();
	 }
	 
	 // Stores lines into ArrayList. No scaling.
	 private void setLine(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY){
	    	Line line = new Line();
	    	line.setStartX(topLeftX);
	    	line.setStartY(topLeftY);
	    	line.setEndX(bottomRightX);
	    	line.setEndY(bottomRightY);
	    	lines.add(line);
	    }
	 
	 // Returns the array list of lines
	 // These will need to be scaled by the client
	 public ArrayList<Line> getLines(){
	  	return lines;
	 }

	 private void initMaze() {
	 // initialize border cells as already visited
	 visited = new boolean[N+2][N+2];
	 for (int x = 0; x < N+2; x++) {
	     visited[x][0] = true;
	     visited[x][N+1] = true;
	 }
	 for (int y = 0; y < N+2; y++) {
	     visited[0][y] = true;
	     visited[N+1][y] = true;
	 }

	 // initialize all walls as present
	 north = new boolean[N+2][N+2];
	 east  = new boolean[N+2][N+2];
	 south = new boolean[N+2][N+2];
	 west  = new boolean[N+2][N+2];
	 for (int x = 0; x < N+2; x++) {
	     for (int y = 0; y < N+2; y++) {
	        north[x][y] = true;
	        east[x][y]  = true;
	        south[x][y] = true;
	        west[x][y]  = true;
	     }
	 }    
   }
	    
   // generate the maze
   private void generate(int x, int y) {
	   
	  visited[x][y] = true;
	  Random rand = new Random();

	  // while there is an unvisited neighbor
	  while (!visited[x][y+1] || !visited[x+1][y] || !visited[x][y-1] || !visited[x-1][y]) {

	    // pick random neighbor 
	    while (true) {
	      double r =  rand.nextInt(4);
	      if (r == 0 && !visited[x][y+1]) {
	          north[x][y] = false;
	          south[x][y+1] = false;
	          generate(x, y + 1);
	          break;
	      }
	      else if (r == 1 && !visited[x+1][y]) {
	         east[x][y] = false;
	         west[x+1][y] = false;
	         generate(x+1, y);
	         break;
	      }
	      else if (r == 2 && !visited[x][y-1]) {
	         south[x][y] = false;
	         north[x][y-1] = false;
	         generate(x, y-1);
	         break;
	      }
	      else if (r == 3 && !visited[x-1][y]) {
	         west[x][y] = false;
	         east[x-1][y] = false;
	         generate(x-1, y);
	         break;
	      } 
	    }
	  }
   }

   // draw the maze
   public void buildLines() {
	    	     	 
	  for (int x = 1; x <= N; x++) {
	     for (int y = 1; y <= N; y++) {
	        if (south[x][y]) setLine(x, y, x + 1, y);
	           if (north[x][y]) setLine(x, y + 1, x + 1, y + 1);
	           if (west[x][y])  setLine(x, y, x, y + 1);
	           if (east[x][y])  setLine(x + 1, y, x + 1, y + 1);             
	        }
	     }
	  }
	     
	  public Point getTargetPoint(){
	    return new Point(N/2,N/2);
	  }
	     
	  public Point getStartPoint(){
	    return new Point(1,1);
	  }
}
