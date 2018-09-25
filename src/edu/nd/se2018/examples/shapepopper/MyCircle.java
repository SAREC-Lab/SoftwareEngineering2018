package edu.nd.se2018.examples.shapepopper;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle implements MyShape{

	Point2D center;
	int radius;
	Circle circle = new Circle();
	public MyCircle(Point2D point, int radius){
		center = point;
		this.radius = radius;
		setPosition(point);
	}
	
	public void setLineColor(Color color){
		circle.setStroke(color);
		circle.setFill(color);
	}
	
	public void setPosition(Point2D point){
		circle.setCenterX(point.getX());
		circle.setCenterY(point.getY());
		circle.setRadius(radius);
	}
	
	public Circle getCircle(){
		return circle;
	}
	
	@Override
	public boolean containsPoint(javafx.geometry.Point2D point) {
		return (circle.contains(point));				
	}

	@Override
	public void moveRelative(double X, double Y) {
		circle.setCenterX(circle.getCenterX()+X);
		circle.setCenterY(circle.getCenterY()+Y);
	
	}
}
