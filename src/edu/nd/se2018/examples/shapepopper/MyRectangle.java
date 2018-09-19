package edu.nd.se2018.examples.shapepopper;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyRectangle implements MyShape{

	Point2D topLeft;
	int height;
	int width;
	Color rectangleColor;
	Rectangle rectangle = new Rectangle();
	List<MyShape> innerShapes = new ArrayList<MyShape>();
	RandomColorPicker colorPicker = new RandomColorPicker();
	
	public MyRectangle(Point2D topLeft, int height, int width){
		this.topLeft = topLeft;
		this.height = height;
		this.width = width;
		rectangle.setHeight(height);
		rectangle.setWidth(width);
		rectangle.setX(topLeft.getX());
		rectangle.setY(topLeft.getY());
		rectangle.setFill(null);
		setLineColor(colorPicker.pickRandomColor());		
		rectangle.setStrokeWidth(5);
		setPosition(topLeft);
	}
	
	
	public void setPosition(Point2D point){
		topLeft = point;
		System.out.println("Setting position");
	}
	
	public Rectangle getRectangle(){
		return rectangle;
	}
	
	@Override
	public boolean containsPoint(Point2D point) {
		boolean inRectangle = (point.getX() >= rectangle.getX() && point.getX() <= rectangle.getX()+rectangle.getWidth()
				&& point.getY()>= rectangle.getY() && point.getY() <= rectangle.getY()+rectangle.getHeight());
		return inRectangle;
		
	}
	
	public void addChild(MyShape shape){
		innerShapes.add(shape);
		shape.setLineColor(rectangleColor);
	}
	
	public void removeChild(MyShape shape){
		if(innerShapes.contains(shape)){
			innerShapes.remove(shape);
			shape.setLineColor(rectangleColor);
		}
	}

	@Override
	public void moveRelative(double X, double Y) {
		rectangle.setX(rectangle.getX()+X);
		rectangle.setY(rectangle.getY()+Y);	
		for(MyShape child: innerShapes){
			child.moveRelative(X,Y);
		}
	}


	@Override
	public void setLineColor(Color color) {
		rectangleColor = color;	
		rectangle.setStroke(rectangleColor);
	}	
}
