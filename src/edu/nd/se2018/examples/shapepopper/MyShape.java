package edu.nd.se2018.examples.shapepopper;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;


public interface MyShape {
	public boolean containsPoint(Point2D point);
	public void setPosition(Point2D point);
	public void moveRelative(double X, double Y);
	public void setLineColor(Color color);
}
