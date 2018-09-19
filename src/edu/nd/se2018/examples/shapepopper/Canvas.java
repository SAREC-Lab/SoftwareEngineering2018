package edu.nd.se2018.examples.shapepopper;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Canvas extends Application {

	AnchorPane root;
	Point2D clickPoint;
	MyShape currentShape;
	Scene scene;
	int temp = 0;
	List<MyShape> shapes = new ArrayList<MyShape>();
	Point2D oldPoint = null;
	boolean inDragMode = false;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		root = new AnchorPane();	
		
		scene = new Scene(root,500,500);
	    scene.setOnMouseClicked(mouseHandler);
	    scene.setOnMouseDragged(mouseHandler);
	    scene.setOnMouseEntered(mouseHandler);
	    scene.setOnMouseExited(mouseHandler);
	    scene.setOnMouseMoved(mouseHandler);
	    scene.setOnMousePressed(mouseHandler);
	    scene.setOnMouseReleased(mouseHandler);
	 	        
		primaryStage.setTitle("Shape Composer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {	 
        @Override
        public void handle(MouseEvent mouseEvent) {
        	
        	clickPoint = new Point2D(mouseEvent.getX(),mouseEvent.getY());        	
        	String eventName = mouseEvent.getEventType().getName(); 
       	
        	// Return shape if target of mouse click  (otherwise return null)
        	if(!inDragMode){
        		currentShape = getCurrentShape();
        	}
        	
        	switch(eventName){
        	case "MOUSE_RELEASED":
        		
        		// If current shape is a circle and mouse released inside rectangle
        		if(currentShape!=null && currentShape instanceof MyCircle){
        			for(MyShape container: shapes){
            			if (container instanceof MyRectangle && container.containsPoint(clickPoint)){
            				((MyRectangle)container).addChild(currentShape);
            				break;
            			}
            		} 
    			}
        		
        		// If mouse is released and not currently dragging a shape
        		if(currentShape==null){   
        			// Left mouse button.  Create a circle
         			if(mouseEvent.getButton() == MouseButton.PRIMARY) {
        				MyCircle circle = new MyCircle(clickPoint,20);
        				shapes.add(circle);
        				root.getChildren().add(circle.getCircle());
        			} else {  // Right mouse button.  Create a rectangle.
        				MyRectangle rect = new MyRectangle(clickPoint,200,200);
        				shapes.add(rect);
        				root.getChildren().add(rect.getRectangle());
        			}
        		}
        		else {
        			currentShape = null;  // Housekeeping as per state diagram
        		}
        		inDragMode = false;
        		break;
        		
        	case "MOUSE_DRAGGED":
        		// Move shape according to delta from last drag event
        		inDragMode = true;
        		if(currentShape!=null && oldPoint != null){
        			currentShape.moveRelative(clickPoint.getX()-oldPoint.getX(), clickPoint.getY()-oldPoint.getY());     				
        		}	
        		break;
        	}
        	// Needed by mouse dragged
        	oldPoint = clickPoint;
        }               
     };
	    
    private MyShape getCurrentShape(){
    	MyShape currentShape = null;
		for(MyShape myShape: shapes){
			if (myShape.containsPoint(clickPoint)){
				currentShape = myShape;
				break;
			}
		} 
		return currentShape;
    }
    
	public static void main(String args[]){
		launch(args);
	}
}
